package com.francisco.springmvcboot.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;

	@ManyToOne
	@JoinColumn(name="ItemDescription_id")
	@NotNull
	private ItemDescription itemDescription;
	
	@ManyToOne
	@JoinColumn(name="Location_id")
	@NotNull
	private Location location;
	
	
	
	public ItemDescription getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(ItemDescription itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Item() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + "]";
	}
	
	
}
