package com.pager.repo;

import org.springframework.data.repository.CrudRepository;

import com.pager.entities.Developer;

public interface DeveloperRepo extends CrudRepository<Developer, Long> {

}
