package dev.vinicissilva.springapi.configs.feign;

import feign.Logger;

import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignCustomConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public GsonDecoder feignDecoder() {
        return new GsonDecoder();
    }

    @Bean
    public GsonEncoder feignEncoder() {
        return new GsonEncoder();
    }
}