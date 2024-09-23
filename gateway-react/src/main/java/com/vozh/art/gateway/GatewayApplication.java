package com.vozh.art.gateway;

import com.vozh.art.gateway.config.PropertiesConfig;
import io.dekorate.docker.annotation.DockerBuild;
import io.dekorate.kubernetes.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@DockerBuild(name = "gateway-react", version = "1.0-SNAPSHOT")

@KubernetesApplication(

        ingress = @Ingress(expose = true),
        configMapVolumes = @ConfigMapVolume(
                configMapName = "gateway-config",
                volumeName = "gateway-config-volume",
                optional = true,
                defaultMode = 0644), // Octal literal for lifestream permissions
        mounts = @Mount(
                name = "gateway-config-volume",
                path = "/etc/config/"),
        envVars = @Env(
                name = "SPRING_CONFIG_IMPORT",
                value = "configtree:/etc/config/"),
//        serviceType = ServiceType.ClusterIP,
        ports = @Port(name = "http", containerPort = 8080)
)
@Slf4j


//@EnableDiscoveryClient
public class GatewayApplication {


    public static void main(String[] args) {
        log.info("Gateway starting with property from config/default {}, {}", System.getProperty("config.default.property1") );
        SpringApplication.run(GatewayApplication.class);
        log.info("Gateway started with property from config/default {}, {}", System.getProperty("config.default.property1") );
    }


}