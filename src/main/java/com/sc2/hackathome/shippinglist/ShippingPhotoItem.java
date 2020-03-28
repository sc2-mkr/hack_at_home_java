package com.sc2.hackathome.shippinglist;

import lombok.Data;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("photo")
public class ShippingPhotoItem extends ShippingItem {
    @Column(name = "PHOTO")
    private String photo;
}
