package com.thehecklers.sburrestdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thehecklers.sburrestdemo.thirdparty.Droid;

@Configuration
public class ThirdPartyConfig {

    @Bean
    @ConfigurationProperties(prefix = "droid")
    public Droid createDroid() {
        return new Droid();
    }
}
