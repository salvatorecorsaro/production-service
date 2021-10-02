package com.mrcookies.productionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProductionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductionServiceApplication.class, args);
    }


//    1 - enable the eureka client annotation x
//    2 - file the application properties: server port and name x

//    get cookies by number x

//    get cookies by theme

//    define a cookies pojo x

//    controller x

//    connect to a fortune-message-service and retrieve the message x
//    create a webclient and a discoveryclient and use them to fire the request <- inside a service x

//    add openfeign-starter dependency x
//    add enable feign client annotation to main method x
//    create a proxy to another service
//    use the proxy to do the request


}
