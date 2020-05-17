package com.francisco.springmvcboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.springmvcboot.Entities.Item;
import com.francisco.springmvcboot.Entities.Location;
import com.francisco.springmvcboot.Repositories.ItemRepo;
import com.francisco.springmvcboot.Repositories.LocationRepo;

@Service
public class LocationService implements GenericService<Location> {

	@Autowired
	LocationRepo locationRepo;

	@Autowired
	ItemRepo itemRepo;

	@Override
	public Location create(Location t) {
		// TODO Auto-generated method stub
		return locationRepo.save(t);
	}

	@Override
	public Location read(int id) {
		// TODO Auto-generated method stub
		Location l;
		try {
			l = locationRepo.findById(id).get();
		} catch (Exception e) {
			throw new GenericException("Location not found with id : " + id);
		}
		return l;
	}

	@Override
	public Location update(Location t) {
		// TODO Auto-generated method stub
		return locationRepo.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Location location = locationRepo.getOne(id);
		List<Item> listItems = location.getItems();
		for (Item i : listItems) {
			itemRepo.delete(i);
			;
		}
		locationRepo.delete(location);
	}

	@Override
	public List<Location> getAll() {
		// TODO Auto-generated method stub
		return locationRepo.findAll();
	}

}
