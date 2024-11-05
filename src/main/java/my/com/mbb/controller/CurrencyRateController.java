package my.com.mbb.controller;

import lombok.extern.slf4j.Slf4j;
import my.com.mbb.model.dto.CurrencyCheckDto;
import my.com.mbb.service.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static my.com.mbb.constant.UrlConstant.API_V1;
import static my.com.mbb.constant.UrlConstant.CURRENCY_BASE_URL;

@Slf4j
@RestController
@RequestMapping(API_V1 + CURRENCY_BASE_URL)
public class CurrencyRateController {

    @Autowired
    private CurrencyRateService currencyRateService;

    @PostMapping("/rate-enquiry")
    public String currencyRateEnquiry(@RequestBody CurrencyCheckDto request) {
        log.debug("[currencyRateEnquiry] - request: {})", request);
        String response = currencyRateService.getRates(request);
        log.debug("[currencyRateEnquiry] - response: {}", response);
        return response;
    }
}
