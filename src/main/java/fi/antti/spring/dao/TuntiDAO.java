package fi.antti.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.antti.spring.bean.Tunti;
@Repository
public class TuntiDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	/**
	 * Tallettaa parametrina annetun henkilön tietokantaan.
	 * Tietokannan generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Tunti t) {
		final String sql = "insert into tunnit(work_date, start_time, end_time, info) values(?,?,?,?)";
		
		//anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		//jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä. 
		final String work_date = t.getWork_date();
		final String start_time = t.getStart_time();
		final String end_time = t.getEnd_time();
		final String info = t.getInfo();
		
		//jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
	    	            ps.setString(1, work_date);
	    	            ps.setString(2, start_time);
	    	            ps.setString(3, end_time);
	    	            ps.setString(4, info);;
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		//tallennetaan id takaisin beaniin, koska
		//kutsujalla pitäisi olla viittaus samaiseen olioon
	    t.setId(idHolder.getKey().intValue());

	}
	

	public Tunti etsi(int id) throws Exception {
		String sql = "select * from tunnit where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Tunti> mapper = new TuntiRowMapper();
		
		Tunti t;
	    try { 
	    t = jdbcTemplate.queryForObject(sql , parametrit, mapper);
	    } catch(IncorrectResultSizeDataAccessException e) {
	    	throw new Exception(e);
	    }
	    return t;
	                                  

	}
	

	public List<Tunti> haeKaikki() {
		
		String sql = "select * from tunnit";
		RowMapper<Tunti> mapper = new TuntiRowMapper();
		List<Tunti> tunnit = jdbcTemplate.query(sql,mapper);

		return tunnit;
	}

}
