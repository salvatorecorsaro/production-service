package com.mrcookies.productionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("production")
public class ProductionServiceExternal implements ProductionService {


    private static final String TARGET_SERVICE = "fortune-message-service";

    public ProductionServiceExternal(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        createClient();
    }


    final DiscoveryClient discoveryClient;

    WebClient client;

    @Override
    public List<FortuneCookies> produceCookiesByNumber(int amountToProduce) {

        List<FortuneCookies> production = new ArrayList<>();
        for (int i = 0; i < amountToProduce; i ++){
            getCookiesWithMessage(production);
        }
        return production;
    }

    private void getCookiesWithMessage(List<FortuneCookies> production) {
        var fortuneMessage = client.get()
                .uri("/fortune-messages/chuck")
                .retrieve().bodyToMono(FortuneMessage.class)
                .block();
        production.add(new FortuneCookies(fortuneMessage.getMessage()));
    }

    void createClient(){
        var serviceInstanceList = discoveryClient.getInstances(TARGET_SERVICE);
        String clientURI = serviceInstanceList.get(0).getUri().toString();
        client = WebClient.create(clientURI);
    }
}
