package com.francisco.springmvcboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.francisco.springmvcboot.Entities.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {

	@Transactional
	Location findLocationByName(String name);
}
