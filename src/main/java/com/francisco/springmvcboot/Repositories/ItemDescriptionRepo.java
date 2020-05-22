package com.francisco.springmvcboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.springmvcboot.Entities.ItemDescription;

public interface ItemDescriptionRepo extends JpaRepository<ItemDescription, Integer> {

	ItemDescription findItemDescriptionByName(String name);

}
