package my.com.mbb.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import my.com.mbb.model.entity.CustomerAccount;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class CustomerAccountResponseDto {
    private CustomerAccount customerAccount;
    private Integer statusCode;
    private String statusMessage;
}
