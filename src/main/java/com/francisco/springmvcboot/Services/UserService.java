package com.francisco.springmvcboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.francisco.springmvcboot.Entities.User;
import com.francisco.springmvcboot.Repositories.UserRepo;

@Service
public class UserService implements GenericService<User> {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder pwdenc;
	
	@Override
	public User create(User t) {
		// TODO Auto-generated method stub
		t.setPassword(pwdenc.encode(t.getPassword()));
		return userRepo.save(t);
	}

	@Override
	public User read(int id) {
		// TODO Auto-generated method stub
		return userRepo.getOne(id);
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return userRepo.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepo.delete(userRepo.getOne(id));
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
