package com.francisco.springmvcboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.springmvcboot.Entities.Item;
import com.francisco.springmvcboot.Repositories.ItemRepo;

@Service
public class ItemService implements GenericService<Item> {

	ItemRepo itemRepo;

	@Autowired
	public ItemService(ItemRepo itemRepo) {
		super();
		this.itemRepo = itemRepo;
	}

	@Override
	public Item create(Item t) {
		// TODO Auto-generated method stub
		return itemRepo.save(t);
	}

	@Override
	public Item read(int id) {
		// TODO Auto-generated method stub
		Item it;
		try {
			System.out.println("intentado");
			it = itemRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("tirada");
			// throw new GenericException("Item not found with id : " + id);
			return null;
		}
		return it;
	}

	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return itemRepo.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		itemRepo.delete(itemRepo.getOne(id));
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return itemRepo.findAll();
	}

}
