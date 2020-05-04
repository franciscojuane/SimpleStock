package com.francisco.springmvcboot.Services;

import java.util.List;

public interface GenericService<T> {

	public T create(T t);
	public T read(int id);
	public T update(T t);
	public void delete(int id);
	public List<T> getAll();
	
}
