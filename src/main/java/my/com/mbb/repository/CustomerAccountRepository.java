package my.com.mbb.repository;

import my.com.mbb.model.entity.CustomerAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, UUID> {
    @Query("SELECT a FROM CustomerAccount a WHERE (:customerId is null or a.customerId = :customerId)")
    Page<CustomerAccount> getCustomerAccounts(String customerId, Pageable pageable);

    Page<CustomerAccount> findAll(Pageable pageable);
}
