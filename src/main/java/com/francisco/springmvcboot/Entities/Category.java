package com.francisco.springmvcboot.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="name")
	private String name;

	@OneToMany(mappedBy="category")
	private List<ItemDescription> itemDescriptions;

	public Category() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<ItemDescription> getItemDescriptions() {
		return itemDescriptions;
	}


	public void setItemDescriptions(List<ItemDescription> itemDescriptions) {
		this.itemDescriptions = itemDescriptions;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	

}