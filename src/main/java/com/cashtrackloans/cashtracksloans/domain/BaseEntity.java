package com.cashtrackloans.cashtracksloans.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    private LocalDateTime inputDate;
    private LocalDateTime updateDate;

}
