package my.com.mbb.controller;

import lombok.extern.slf4j.Slf4j;
import my.com.mbb.model.entity.CustomerAccount;
import my.com.mbb.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static my.com.mbb.constant.UrlConstant.API_V1;
import static my.com.mbb.constant.UrlConstant.CUSTOMER_ACCOUNT_BASE_URL;

@Slf4j
@RestController
@RequestMapping(API_V1 + CUSTOMER_ACCOUNT_BASE_URL)
public class CustomerAccountController {

    @Autowired
    private CustomerAccountService customerAccountService;

    @GetMapping
    public Page<CustomerAccount> getCustomer() {
        return customerAccountService.getCustomerAccount();
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
