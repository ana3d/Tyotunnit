package fi.antti.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.antti.spring.bean.Tunti;
import fi.antti.spring.dao.TuntiDAO;

 
@Controller
@RequestMapping("/")
public class TuntiController {
	
	final static Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Inject
	private TuntiDAO dao;
	
	public TuntiDAO getDao() {
		return dao;
	}

	public void setDao(TuntiDAO dao) {
		this.dao = dao;
	}
	
	
 
	@RequestMapping(method = RequestMethod.GET)
	public String etusivu(ModelMap model) {
		
		return "index";
	}

	@RequestMapping(value = "/tunnit", method = RequestMethod.GET)
	public String naytaKaikki(Model model) {
		List<Tunti> tunnit = dao.haeKaikki();
		model.addAttribute("tunnit", tunnit);
		logger.info("Haettu kaikki painot tietokannasta");
		
		
		Tunti placeHolder = new Tunti();
		placeHolder.setWork_date("0000-00-00");	
		placeHolder.setStart_time("00:00");
		placeHolder.setEnd_time("00:00");
		model.addAttribute("tunti", placeHolder);
		logger.info("Laitettu placeholder arvo formille");
		
		return "tunnit";
	}
	
	@RequestMapping(value = "/tulosta", method = RequestMethod.GET)
	public String tulostaKaikki(Model model) {
		List<Tunti> tunnit = dao.haeKaikki();
		model.addAttribute("tunnit", tunnit);
		logger.info("Haettu kaikki painot tietokannasta");

		return "tulosta";
	}

	
	@RequestMapping(value="/tunnit", method=RequestMethod.POST)
	public String save( @ModelAttribute(value="tunti") @Valid Tunti tunti, BindingResult result, Model model) {
				
		if (result.hasErrors()) {
			List<Tunti> tunnit = dao.haeKaikki();
			model.addAttribute("tunnit", tunnit);
			return "/tunnit";
		} else {
			dao.talleta(tunti);
			logger.info("Lis‰‰ uusi paino nappia on painettu. Tuupataan tietokantaan");
			return "redirect:/tunnit";
		}
	}
	
	
	
	
 
}