package com.miage.ttb.ttb.adapters.in.dto;

import lombok.Data;

@Data
public class GetLocationRequest {
    String word;
    int radius;
    double x;
    double y;
}
