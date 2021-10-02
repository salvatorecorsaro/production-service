package com.mrcookies.productionservice.service;

import com.mrcookies.productionservice.dto.FortuneCookies;
import com.mrcookies.productionservice.proxy.FortuneMessageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("feign")
public class ProductionServiceFeign implements ProductionService {

    @Autowired
    FortuneMessageProxy fortuneMessageProxy;


    @Override
    public List<FortuneCookies> produceCookiesByNumber(int amountToProduce) {
        List<FortuneCookies> production = new ArrayList<>();
        for (int i = 0; i < amountToProduce; i ++){
            var cookies = new FortuneCookies();
            String message = fortuneMessageProxy.getChuckMessages().getMessage();
            cookies.setMessage(message);
            production.add(cookies);
        }
        return production;
    }
}
