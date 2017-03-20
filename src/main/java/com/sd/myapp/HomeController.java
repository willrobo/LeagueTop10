package com.sd.myapp;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.data.Player;
import com.sd.data.LeagueDAO;

@Controller
public class HomeController {
	
	@Autowired
	private LeagueDAO leagueDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "GetInfo.do", method = RequestMethod.GET)
	public ModelAndView getInfo() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", leagueDAO.getRoster());
		
		return mv;
	}
	
	@RequestMapping(value = "GetInfo.do", params="summoner", method = RequestMethod.GET)
	public ModelAndView getPlayerBySummonerName(@RequestParam("summoner") String s) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("player", leagueDAO.getPlayerBySummonerName(s));
		
		return mv;
	}
	@RequestMapping(value = "CreateNew.do", method = RequestMethod.GET)
	public ModelAndView createNew(Player player) {
		leagueDAO.addPlayer(player);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("player", new Player());
		mv.addObject("playerList", leagueDAO.getRoster());
		
		return mv;
	}
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("Delete") String summonerName) {
		leagueDAO.removePlayer(summonerName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", leagueDAO.getRoster());
		
		return mv;
	}
	@RequestMapping(value = "editPlayer.do", method = RequestMethod.GET)
	public ModelAndView editPlayer(@RequestParam("Edit") String summonerName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", leagueDAO.getRoster());
		mv.addObject("player", leagueDAO.getPlayerBySummonerName(summonerName));
		
		return mv;
	}
	@RequestMapping(value = "edit.do", method = RequestMethod.GET)
	public ModelAndView edit(Player player) {
		System.out.println(player);
		leagueDAO.editPlayer(player);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("playerList", leagueDAO.getRoster());
		mv.addObject("player", new Player());
		
		return mv;
	}
	
}