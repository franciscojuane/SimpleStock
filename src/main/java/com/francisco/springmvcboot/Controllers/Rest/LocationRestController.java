package com.francisco.springmvcboot.Controllers.Rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.springmvcboot.Entities.Location;
import com.francisco.springmvcboot.Services.GenericService;

@RestController
@RequestMapping("/api/Location")
public class LocationRestController extends GenericRestController<Location> {

	public LocationRestController(GenericService<Location> gs) {
		super(gs);
		// TODO Auto-generated constructor stub
	}

}
