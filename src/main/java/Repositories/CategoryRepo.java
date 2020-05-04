package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.springmvcboot.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Category findCategoryByName(String name);
}
