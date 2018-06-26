package com.everest.amcu.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBoot {

	private static AnnotationConfigApplicationContext context;

	public static boolean init() {
		try {
			context = new AnnotationConfigApplicationContext(AppConfig.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static AnnotationConfigApplicationContext getContext() {
		return context;
	}

}
