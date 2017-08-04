package com.niit.ekartback;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {
	@Autowired
	static AnnotationConfigApplicationContext context;

	
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		
	}
	@Test
	public void createProductTest() {
		
		
	}
}
