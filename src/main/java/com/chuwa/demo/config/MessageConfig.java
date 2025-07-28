package com.chuwa.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
