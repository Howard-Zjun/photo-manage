package pers.howard.personalspace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;

@Configuration
public class ConverterConfig {

    @Bean
    public BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }
}
