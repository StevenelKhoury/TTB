package com.miage.ttb.ttb.application.converter;

import com.miage.ttb.ttb.adapters.in.dto.GetBakeryInfoResponse;
import com.miage.ttb.ttb.domain.Bakery;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface MapperTool {
    GetBakeryInfoResponse bakeryToGetBakeryInfoResponse(Bakery bakery);
}
