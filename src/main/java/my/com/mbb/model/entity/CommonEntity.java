package my.com.mbb.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@Data
public class CommonEntity implements Serializable {
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "create_date")
    private Timestamp createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
}
