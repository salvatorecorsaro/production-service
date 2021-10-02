package com.mrcookies.productionservice;

import java.util.List;

public interface ProductionService {

    List<FortuneCookies> produceCookiesByNumber(int amountToProduce);
}
