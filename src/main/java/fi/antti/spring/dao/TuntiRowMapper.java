package fi.antti.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.antti.spring.bean.Tunti;


public class TuntiRowMapper implements RowMapper<Tunti> {

	public Tunti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tunti t = new Tunti();
		
		t.setWork_date(rs.getString("work_date"));
		t.setStart_time(rs.getString("start_time"));
		t.setEnd_time(rs.getString("end_time"));
		t.setInfo(rs.getString("info"));
		t.setId(rs.getInt("id"));
		
		return t;
	}
}
