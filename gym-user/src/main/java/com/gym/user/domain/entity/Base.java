package com.gym.user.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class Base implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Temporal(TemporalType.TIMESTAMP)
    public Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    public Date updateDate;

    @PrePersist
    public void prePersist() {
        this.creationDate = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate = new Date();
    }
}
