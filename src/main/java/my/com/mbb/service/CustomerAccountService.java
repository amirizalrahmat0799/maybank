package my.com.mbb.service;

import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import my.com.mbb.model.dto.CustomerAccountRequestDto;
import my.com.mbb.model.dto.CustomerAccountResponseDto;
import my.com.mbb.model.entity.CustomerAccount;
import my.com.mbb.model.mapper.CustomerAccountMapper;
import my.com.mbb.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerAccountService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    public Page<CustomerAccount> getCustomerAccounts(Integer page, Integer rowPerPage) {
        PageRequest pageable = PageRequest.of(page, rowPerPage);
        return customerAccountRepository.findAll(pageable);
    }

    @Transactional
    public CustomerAccountResponseDto addNewCustomerAccount(CustomerAccountRequestDto request) {
        CustomerAccount customerAccount =
                customerAccountRepository.saveAndFlush(CustomerAccountMapper.INSTANCE.of(request));
        return CustomerAccountMapper.INSTANCE
                .success(customerAccount, HttpStatus.CREATED.value(), "Successfully Created!");
    }

    @Transactional
    @SneakyThrows
    public CustomerAccountResponseDto updateCustomerAccount(UUID id, CustomerAccountRequestDto request) {
        Optional<CustomerAccount> opt = customerAccountRepository.findById(id);

        if (opt.isEmpty()) { throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "User Not Found!"); }

        CustomerAccount entity = opt.get();
        updateCommonField(entity);
        updateNonNullFields(entity, request);
        CustomerAccount customerAccount = customerAccountRepository.saveAndFlush(entity);
        return CustomerAccountMapper.INSTANCE
                .success(customerAccount, HttpStatus.OK.value(), "Successfully Updated!");
    }

    @Transactional
    public CustomerAccountResponseDto deleteCustomerAccount(UUID id) {
        Optional<CustomerAccount> opt = customerAccountRepository.findById(id);
        if (opt.isEmpty()) { throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "User Not Found!"); }
        CustomerAccount customerAccount = opt.get();
        customerAccountRepository.delete(customerAccount);
        return CustomerAccountMapper.INSTANCE
                .success(customerAccount, HttpStatus.OK.value(), "Successfully Deleted!");
    }


    public static void updateNonNullFields(Object target, Object source) throws IllegalAccessException {
        Field[] fields = source.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(source);

            if (value != null) {
                try {
                    Field targetField = target.getClass().getDeclaredField(field.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, value);
                } catch (NoSuchFieldException e) {
                    continue;
                }
            }
        }
    }

    private void updateCommonField(CustomerAccount entity) {
        entity.setUpdatedBy("SYSTEM");
        entity.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
    }


}
