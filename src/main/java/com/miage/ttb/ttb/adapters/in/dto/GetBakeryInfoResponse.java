package com.miage.ttb.ttb.adapters.in.dto;

import com.miage.ttb.ttb.domain.Address;
import lombok.Data;

@Data
public class GetBakeryInfoResponse {
    private String name;
    private Address address;
    private String phoneNumber;
}
