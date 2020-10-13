package com.sbm.dealer.model;

import com.sbm.dealer.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dealer extends BaseEntity {

    private String dealerName;

    private String dealerCode;

    private String language;

    private String preferredDealer;

    private String salesPartner;

    private String usedCategory;
}
