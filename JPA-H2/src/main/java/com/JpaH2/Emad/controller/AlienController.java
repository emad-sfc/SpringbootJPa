package com.JpaH2.Emad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.JpaH2.Emad.Repository.AlienRepository;
import com.JpaH2.Emad.model.Alien;
import com.ctc.wstx.shaded.msv_core.driver.textui.ReportErrorHandler;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepository alienRepo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		alienRepo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView();
		//we can also pass the view name in constructor also
		//ModelAndView mv = new ModelAndView("getAlien.jsp");   see line no 38.
		
		Alien alien = alienRepo.findById(aid).orElse(new Alien()); 
		
		System.out.println(alienRepo.findByTech("Java"));
		System.out.println(alienRepo.findByaidGreaterThan(aid));
		
		System.out.println(alienRepo.findByTechSortedByName("Java"));
		
		mv.addObject(alien);
		mv.setViewName("getAlien.jsp");
		return mv;
	}
	
	@RequestMapping(path="/aliens")	
	public List<Alien> getAliens() {
		
		return alienRepo.findAll();
	}
	
	@PostMapping(path="alien",consumes = {"application/json"})	
	public Alien getAliens(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}
	
	@RequestMapping("/aliens/{aid}")	
	public Optional<Alien> getAliens(@PathVariable("aid") int aid) {
		
		return alienRepo.findById(aid);
	}
	
	@DeleteMapping("/aliens/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		alienRepo.deleteById(aid);
		return "deleted";
	}

	@PutMapping(path="alien",consumes = {"application/json"})	
	public Alien saveOrUpdateAliens(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}

}
