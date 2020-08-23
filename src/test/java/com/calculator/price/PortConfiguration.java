package com.calculator.price;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.contract.wiremock.WireMockConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortConfiguration {

    @Bean
    public WireMockConfigurationCustomizer wireMockConfigurationCustomizer(@Value("${configuration.port}")
                                                                                   int port) {
        return config -> config.port(port);
    }
}
