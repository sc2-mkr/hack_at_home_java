package com.sc2.hackathome.shippinglist.dto;

import com.sc2.hackathome.shippinglist.ShippingItem;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ShippingListDto {
    private String address;
    private String city;
}
