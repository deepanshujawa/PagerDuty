package com.pager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pager.dao.PagerService;
import com.pager.entities.Developer;
import com.pager.entities.Team;

@RestController
public class PagerController {
	
	@Autowired
	private PagerService pagerService;
	
	@PostMapping(path="/team")
	public String addTeam(@RequestBody Team team) {
		pagerService.addTeam(team);
		return "Success";
	}

	@GetMapping(path="/team")
	public List<Team> getTeam() {
		return pagerService.getTeams();
		
	}
	
	@GetMapping(path="/developers")
	public List<Developer> getDeveloper() {
		return pagerService.getDeveloper();
		
	}
	
}
