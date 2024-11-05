package my.com.mbb.model.dto;

import lombok.Data;

@Data
public class CustomerAccountRequestDto {
    private String customerId;
    private String accountType;
    private String accountNo;
    private String currencyCode;
    private String cardNo;
    private Boolean isSalaryAccount;
}
