package org.thisdote.innerjoinus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InnerjoinusStudygroupSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InnerjoinusStudygroupSourceApplication.class, args);
    }

}
