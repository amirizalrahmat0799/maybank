package my.com.mbb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static my.com.mbb.constant.UrlConstant.API_V1;
import static my.com.mbb.constant.UrlConstant.CUSTOMER_ACCOUNT_BASE_URL;

@Slf4j
@RestController
@RequestMapping(API_V1 + CUSTOMER_ACCOUNT_BASE_URL)
public class CustomerAccountController {

    @GetMapping
    public String getApi() {
        return null;
    }

    @GetMapping
    public String getApis() {
        return null;
    }

    @PostMapping
    public String insertApi() {
        return null;
    }

    @PutMapping
    public String updateApi() {
        return null;
    }

    @DeleteMapping
    public String deleteApi() {
        return null;
    }
}
