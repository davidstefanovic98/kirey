package kirey.entity;

import kirey.entity.domain.RecordStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Auditable implements Serializable {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name = "record_status")
    @Enumerated(EnumType.ORDINAL)
    private RecordStatus recordStatus;
}
