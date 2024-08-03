package com.app.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {


    @Bean
    public ObjectMapper getMapper()
    {
        return  new ObjectMapper();
    }


    @Bean
    public ModelMapper mapper()
    {
        return  new ModelMapper();
    }

}
