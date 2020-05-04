package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.springmvcboot.Entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	User findUserByUsername(String username);
	
}
