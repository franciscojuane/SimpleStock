package com.francisco.springmvcboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.francisco.springmvcboot.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Transactional
	User findUserByUsername(String Username) throws UsernameNotFoundException;

}
