package com.pager.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pager.entities.Developer;
import com.pager.entities.Team;
import com.pager.repo.DeveloperRepo;
import com.pager.repo.TeamRepo;

@Service
public class PagerService {
	@Autowired
	private TeamRepo teamRepo;
	@Autowired
	private DeveloperRepo developerRepo;
	
	public boolean addTeam(Team team) {
		System.out.println(team.getName());
		
		
		System.out.println(teamRepo.save(team));
		team.getDevelopers().forEach(de -> {
			developerRepo.save(de);
		});
		return true;
	}
	
	public List<Team> getTeams() {
		// return teamRepo.findAll();
		List<Team> teams = new ArrayList<>();
		teamRepo.findAll().forEach(teams::add);
		return teams;
	}
	
	public List<Developer> getDeveloper() {
		List<Developer> developers = new ArrayList<>();
		developerRepo.findAll().forEach(developers::add);
		return developers;
	}
	
	public void sendSMS(Long id) {
		Team team = teamRepo.findById(id).get();
		List<Developer> developers = team.getDevelopers();
		int randomNumber = (int) Math.random() * team.getDevelopers().size();
		Developer developer = developers.get(randomNumber);
		System.out.println("SMS Sent to phone " + developer);
	}

}
