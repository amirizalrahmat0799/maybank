package my.com.mbb.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cust_acct", schema = "dbo")
public class CustomerAccount extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID id;

    @Column(name = "cust_id")
    private String customerId;

    @Column(name = "acct_type")
    private String accountType;

    @Column(name = "acct_no")
    private String accountNo;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "is_salary_acct")
    private Boolean isSalaryAccount;
}
