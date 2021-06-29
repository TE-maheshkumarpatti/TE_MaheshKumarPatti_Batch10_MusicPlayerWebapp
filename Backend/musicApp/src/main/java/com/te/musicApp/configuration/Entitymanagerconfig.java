package com.te.musicApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class Entitymanagerconfig {
	@Bean
	public LocalEntityManagerFactoryBean getEMFO() {
		
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("music_db");
		return factoryBean;
		
	}

}
