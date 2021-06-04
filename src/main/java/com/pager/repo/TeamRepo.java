package com.pager.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pager.entities.Team;

public interface TeamRepo extends CrudRepository<Team, Long> {

	public Team findByName(String name);
	public Optional<Team> findById(Long id);
}
