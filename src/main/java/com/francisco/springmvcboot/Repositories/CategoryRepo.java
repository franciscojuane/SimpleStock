package com.francisco.springmvcboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francisco.springmvcboot.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Category findCategoryByName(String name);
}
