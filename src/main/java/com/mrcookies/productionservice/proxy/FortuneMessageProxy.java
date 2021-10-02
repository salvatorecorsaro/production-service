package com.mrcookies.productionservice.proxy;

import com.mrcookies.productionservice.dto.FortuneMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("FORTUNE-MESSAGE-SERVICE")
public interface FortuneMessageProxy {

    @GetMapping("/fortune-messages/chuck")
    FortuneMessage getChuckMessages();
}
