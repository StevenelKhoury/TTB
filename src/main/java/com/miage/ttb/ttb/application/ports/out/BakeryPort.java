package com.miage.ttb.ttb.application.ports.out;

import com.miage.ttb.ttb.adapters.in.dto.GetBakeryAddressRequest;
import com.miage.ttb.ttb.adapters.in.dto.UpdateBakeryRequest;
import com.miage.ttb.ttb.adapters.in.dto.UpdateBakeryResponse;
import com.miage.ttb.ttb.domain.Bakery;

import java.util.Optional;
import java.util.UUID;

public interface BakeryPort {
    Optional<Bakery> findById(UUID uuid);
    Bakery save(Bakery bakery);
    Bakery getBakeryByAddress(GetBakeryAddressRequest bakeryAddress);
    UpdateBakeryResponse updateBakeryByID(UpdateBakeryRequest newBakery, UUID uuid);
}
