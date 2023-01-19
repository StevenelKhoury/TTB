package com.miage.ttb.ttb.application.ports.in;

import com.miage.ttb.ttb.adapters.in.dto.CreateBakeryRequest;
import com.miage.ttb.ttb.adapters.in.dto.CreateBakeryResponse;

public interface CreateBakeryPort {
    CreateBakeryResponse createBakery(CreateBakeryRequest createBakeryRequest);
}
