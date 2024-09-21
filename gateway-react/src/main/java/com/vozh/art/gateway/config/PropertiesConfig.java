package com.vozh.art.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("gateway-config")
@Getter
@Setter
public class PropertiesConfig {
    private String property1;
}