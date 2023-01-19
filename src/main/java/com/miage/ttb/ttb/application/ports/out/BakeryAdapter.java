package com.miage.ttb.ttb.application.ports.out;

import com.fasterxml.jackson.databind.JsonNode;
import com.miage.ttb.ttb.domain.Bakery;

public interface BakeryAdapter {
    Bakery toBakery(JsonNode node);
}
