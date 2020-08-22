package com.ampersand.ebanca.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ampersand"})
public class Webs implements WebMvcConfigurer{
	
	@Autowired
	@Bean
	public InternalResourceViewResolver views() {
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/");
		r.setSuffix(".jsp");
		return r;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry r) {
        r.addResourceHandler("/src/**")
                .addResourceLocations("/src/");
    }
	

}
