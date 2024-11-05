package my.com.mbb.model.mapper;

import my.com.mbb.model.dto.CustomerAccountRequestDto;
import my.com.mbb.model.dto.CustomerAccountResponseDto;
import my.com.mbb.model.entity.CustomerAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(imports = {UUID.class, Timestamp.class, LocalDateTime.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerAccountMapper {
    CustomerAccountMapper INSTANCE = getMapper(CustomerAccountMapper.class);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "createdBy", constant = "SYSTEM")
    @Mapping(target = "createdDate", expression = "java(Timestamp.valueOf(LocalDateTime.now()))")
    CustomerAccount of(CustomerAccountRequestDto request);

    CustomerAccountResponseDto success(CustomerAccount customerAccount, Integer statusCode, String statusMessage);
}

