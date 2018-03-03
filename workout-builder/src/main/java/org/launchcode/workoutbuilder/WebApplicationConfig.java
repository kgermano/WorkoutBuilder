package org.launchcode.workoutbuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInterceptor loginInterceptor() { return new LoginInterceptor();}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor() );
    }
}
