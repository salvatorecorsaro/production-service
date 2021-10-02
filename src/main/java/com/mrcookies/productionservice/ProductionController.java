package com.mrcookies.productionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/production")
public class ProductionController {

    @Autowired
    @Qualifier("production")
    ProductionService productionService;

    @GetMapping("/{amountToProduce}")
    public List<FortuneCookies> getCookiesByNumber(@PathVariable int amountToProduce){
        return productionService.produceCookiesByNumber(amountToProduce);
    }

}
