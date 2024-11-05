package my.com.mbb.controller;

import lombok.extern.slf4j.Slf4j;
import my.com.mbb.model.dto.CustomerAccountRequestDto;
import my.com.mbb.model.dto.CustomerAccountResponseDto;
import my.com.mbb.model.entity.CustomerAccount;
import my.com.mbb.service.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static my.com.mbb.constant.UrlConstant.API_V1;
import static my.com.mbb.constant.UrlConstant.CUSTOMER_ACCOUNT_BASE_URL;

@Slf4j
@RestController
@RequestMapping(API_V1 + CUSTOMER_ACCOUNT_BASE_URL)
public class CustomerAccountController {

    @Autowired
    private CustomerAccountService customerAccountService;

    @GetMapping
    public Page<CustomerAccount> getCustomerAccounts(@RequestParam(defaultValue = "0") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer rowPerPage) {
        log.debug("[getCustomerAccounts] - request: page {}, rowPerPage: {}", page, rowPerPage);
        Page<CustomerAccount> response = customerAccountService.getCustomerAccounts(page, rowPerPage);
        log.debug("[getCustomerAccounts] - response: {}", response);
        return response;
    }

    @PostMapping
    public CustomerAccountResponseDto addNewCustomerAccount(@RequestBody CustomerAccountRequestDto request) {
        log.debug("[addNewCustomerAccount] - request: {}", request);
        CustomerAccountResponseDto response = customerAccountService.addNewCustomerAccount(request);
        log.debug("[addNewCustomerAccount] - respponse: {}", response);
        return response;
    }

    @PutMapping
    public CustomerAccountResponseDto updateCustomerAccount(@RequestParam UUID id,
                                        @RequestBody CustomerAccountRequestDto request) {
        log.debug("[updateCustomerAccount] request - id: {}, data: {}", id, request);
        CustomerAccountResponseDto response = customerAccountService.updateCustomerAccount(id, request);
        log.debug("[updateCustomerAccount] - respponse: {}", response);
        return response;
    }

    @DeleteMapping
    public CustomerAccountResponseDto deleteCustomerAccount(@RequestParam UUID id) {
        log.debug("[deleteCustomerAccount] request - id: {}", id);
        CustomerAccountResponseDto response = customerAccountService.deleteCustomerAccount(id);
        log.debug("[deleteCustomerAccount] - respponse: {}", response);
        return response;
    }
}
