package com.mrcookies.productionservice.service;

import com.mrcookies.productionservice.dto.FortuneCookies;
import com.mrcookies.productionservice.service.ProductionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("dummy")
public class ProductionServiceDummy implements ProductionService {



    public List<FortuneCookies> produceCookiesByNumber(int amountToProduce){
        List<FortuneCookies> production = new ArrayList<>();
        for (int i = 0; i < amountToProduce; i ++){
            production.add(new FortuneCookies("Message " + i));
        }
        return production;
    }
}
