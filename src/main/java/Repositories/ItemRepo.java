package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.springmvcboot.Entities.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
