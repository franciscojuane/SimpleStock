package com.francisco.springmvcboot;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.francisco.springmvcboot.Entities.Category;
import com.francisco.springmvcboot.Entities.User;
import com.francisco.springmvcboot.Repositories.CategoryRepo;
import com.francisco.springmvcboot.Repositories.UserRepo;

@Service
@ComponentScan
public class UserDetails implements UserDetailsService {

	UserRepo userRepo;
	

	CategoryRepo categoryRepo;
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User u = new User() ;
		try {
		u = userRepo.findUserByUsername(username);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (u==null) {
			throw new UsernameNotFoundException("Not found");
		}else {
			return new Principal(u);
		}
				
	}

	@Autowired
	public UserDetails(UserRepo userRepo, CategoryRepo categoryRepo) {
		super();
		this.userRepo = userRepo;
		this.categoryRepo = categoryRepo;
	}

}
