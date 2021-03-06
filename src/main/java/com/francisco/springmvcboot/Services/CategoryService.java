package com.francisco.springmvcboot.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.springmvcboot.Entities.Category;
import com.francisco.springmvcboot.Entities.Item;
import com.francisco.springmvcboot.Entities.ItemDescription;
import com.francisco.springmvcboot.Repositories.CategoryRepo;
import com.francisco.springmvcboot.Repositories.ItemDescriptionRepo;
import com.francisco.springmvcboot.Repositories.ItemRepo;

@Service
public class CategoryService implements GenericService<Category> {

	CategoryRepo categoryRepo;
	ItemDescriptionRepo itemDescriptionRepo;
	ItemRepo itemRepo;

	@Autowired
	public CategoryService(CategoryRepo categoryRepo, ItemDescriptionRepo itemDescriptionRepo, ItemRepo itemRepo) {
		super();
		this.categoryRepo = categoryRepo;
		this.itemDescriptionRepo = itemDescriptionRepo;
		this.itemRepo = itemRepo;
	}

	@Override
	public Category create(Category t) {
		// TODO Auto-generated method stub
		return categoryRepo.save(t);
	}

	@Override
	public Category read(int id) {
		// TODO Auto-generated method stub
		Category cat;
		try {
			cat = categoryRepo.findById(id).get();
		} catch (Exception e) {
			// throw new GenericException("Category not found with id : " + id);
			return null;
		}
		return cat;
	}

	@Override
	public Category update(Category t) {
		// TODO Auto-generated method stub
		return categoryRepo.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		List<Item> listItems = new ArrayList<>();
		List<ItemDescription> listItemDescriptions = new ArrayList<>();
		Category category = categoryRepo.getOne(id);
		listItemDescriptions = category.getItemDescriptions();
		for (ItemDescription i : listItemDescriptions) {
			listItems.addAll(i.getItems());
		}
		for (Item i : listItems) {
			itemRepo.delete(i);
		}
		for (ItemDescription i : listItemDescriptions) {
			itemDescriptionRepo.delete(i);
		}
		categoryRepo.delete(category);
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

}
