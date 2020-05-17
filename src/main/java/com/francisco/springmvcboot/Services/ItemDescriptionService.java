package com.francisco.springmvcboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.springmvcboot.Entities.Item;
import com.francisco.springmvcboot.Entities.ItemDescription;
import com.francisco.springmvcboot.Repositories.ItemDescriptionRepo;
import com.francisco.springmvcboot.Repositories.ItemRepo;

@Service
public class ItemDescriptionService implements GenericService<ItemDescription> {

	@Autowired
	ItemDescriptionRepo itemDescriptionRepo;
	
	@Autowired
	ItemRepo itemRepo;
	
	@Override
	public ItemDescription create(ItemDescription t) {
		// TODO Auto-generated method stub
		return itemDescriptionRepo.save(t);
	}

	@Override
	public ItemDescription read(int id) {
		// TODO Auto-generated method stub
		ItemDescription itd;
		try {
			itd = itemDescriptionRepo.findById(id).get();
		}catch(Exception e) {
			throw new GenericException("Item Description not found with id : " + id);
		}
		return itd;
		
	}

	@Override
	public ItemDescription update(ItemDescription t) {
		// TODO Auto-generated method stub
		return itemDescriptionRepo.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ItemDescription itemdesc = itemDescriptionRepo.getOne(id);
		List<Item> listItems = itemdesc.getItems();
		for(Item i: listItems) {
			itemRepo.delete(i);
		}
		itemDescriptionRepo.delete(itemdesc);
	}

	@Override
	public List<ItemDescription> getAll() {
		// TODO Auto-generated method stub
		return itemDescriptionRepo.findAll();
	}

}
