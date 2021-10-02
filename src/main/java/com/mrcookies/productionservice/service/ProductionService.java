package com.mrcookies.productionservice.service;

import com.mrcookies.productionservice.dto.FortuneCookies;

import java.util.List;

public interface ProductionService {

    List<FortuneCookies> produceCookiesByNumber(int amountToProduce);
}
