package com.grimrezso.dynamicpropertyreader.controller.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource("file:/${property.file.location}")
@EnableScheduling
public class PropertyConfig {

    public static Properties customProperty;

    @Value("${property.file.location}")
    String propertyFileLocation;

    @Scheduled(fixedRateString = "${property.loader.delay}") // Refresh interval in milliseconds (e.g., 1000ms = 1 second)
    public void refreshProperties() {
        Properties properties = loadProperties();
        customProperty = properties;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private Properties loadProperties() {
        try (FileInputStream fis = new FileInputStream(propertyFileLocation)) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from external file", e);
        }
    }

}
