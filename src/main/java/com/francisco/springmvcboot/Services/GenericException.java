package com.francisco.springmvcboot.Services;

import java.time.LocalDateTime;

public class GenericException extends RuntimeException {

	public GenericException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public GenericException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public GenericException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public GenericException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
