package com.quizapu.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.onboarding.pos.spring.controller" })
public class MvcConfig extends WebMvcConfigurerAdapter {

	private static final String VIEW_CONTROLLER = "/inicioDeSesion.htm";
	private static final String VIEW_NAME = "/view/inicioDeSesion.jsp";

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController(VIEW_CONTROLLER).setViewName(VIEW_NAME);
	}

	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
