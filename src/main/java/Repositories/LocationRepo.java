package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.springmvcboot.Entities.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {

	Location findLocationByName(String name);
}
