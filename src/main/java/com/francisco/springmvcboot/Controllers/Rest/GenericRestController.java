package com.francisco.springmvcboot.Controllers.Rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.francisco.springmvcboot.Services.GenericException;
import com.francisco.springmvcboot.Services.GenericService;

public abstract class GenericRestController<T> {

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ExceptionResponse> manageException(GenericException e) {
		ExceptionResponse er = new ExceptionResponse();
		er.setExceptionName(e.getClass().getSimpleName());
		er.setTime(LocalDateTime.now());
		er.setDetails(e.getMessage());
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.OK);
	}

	GenericService<T> gs;

	public GenericRestController(GenericService<T> gs) {
		super();
		this.gs = gs;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public T read(@PathVariable(name = "id") Integer id) {
		return gs.read(id);

	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<T> list() {
		return gs.getAll();
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public T save(@RequestBody T t) {
		return gs.create(t);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public T update(@RequestBody T t, @PathVariable(name = "id") Integer id) {
		T t2 = gs.read(id);
		BeanUtils.copyProperties(t, t2, "id");
		return gs.update(t2);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Boolean> delete(@PathVariable(name = "id") Integer id) {
		HashMap<String, Boolean> hm = new HashMap<>();
		try {
			gs.delete(id);
			hm.put("success", true);
		} catch (Exception e) {
			hm.put("success", false);
		}
		return hm;
	}

}
