package com.sbm.dealer.common.model;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEALER_SEQ")
    @SequenceGenerator(sequenceName = "DEALER_SEQ", allocationSize = 1, name = "DEALER_SEQ")
    private Long id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof BaseEntity))
            return false;

        BaseEntity other = (BaseEntity)obj;
        if (getId() == null || other.getId() == null)
            return false;

        return getId().equals(other.getId());
    }
}
