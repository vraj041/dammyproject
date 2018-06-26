package com.everest.amcu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = HibernateJpaConfig.class)
public class AppConfig {

}