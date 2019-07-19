package com.test.config;

import java.util.List;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.test.filter.ErrorHandleFilter;
import com.test.interceptor.CSRFInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.test")
public class SpringConfig extends WebMvcConfigurerAdapter{ //WebMvcConfigurationSupport
	
/*	 @Override
	    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	        argumentResolvers.add(new WelcomeMessageResolver());
	    }*/
	 
	 @Override
		public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(new CSRFInterceptor());
		}
	 
		protected Filter[] getServletFilters() {
			return new Filter[]{new ErrorHandleFilter()};
		}

		@Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	 
	        return viewResolver;
	    }
	
}
