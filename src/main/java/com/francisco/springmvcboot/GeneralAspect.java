package com.francisco.springmvcboot;

import java.sql.Timestamp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GeneralAspect {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	Logger logger = LoggerFactory.getLogger(GeneralAspect.class);
	

	@Before("execution(* com.francisco.springmvcboot.Services.*.*(..))")
	public void add(JoinPoint jp) {
		String method = jp.getSignature().getName().toString();
		String entity = jp.getSignature().getDeclaringType().getSimpleName().replace("Service", "");
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("* Entity " + entity + " Operation: " + method + " made by the user " + user);
		jdbcTemplate.execute("INSERT INTO logs (operation,entity,datetime,user) VALUES ('" + method + "','" + entity + "','" + new Timestamp(System.currentTimeMillis()) + "','" + user + "')");
	}

}
