package org.thisdote.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InnerjoinusGatewaySourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InnerjoinusGatewaySourceApplication.class, args);
    }

}
