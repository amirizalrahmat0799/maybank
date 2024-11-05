package my.com.mbb.service;

import lombok.extern.slf4j.Slf4j;
import my.com.mbb.model.entity.CustomerAccount;
import my.com.mbb.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerAccountService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    public Page<CustomerAccount> getCustomerAccount() {
        return customerAccountRepository.findAll(Pageable.ofSize(5));
    }
}
