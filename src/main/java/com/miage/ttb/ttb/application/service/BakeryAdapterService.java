package com.miage.ttb.ttb.application.service;import com.fasterxml.jackson.databind.JsonNode;

import com.miage.ttb.ttb.application.ports.out.BakeryAdapter;
import com.miage.ttb.ttb.domain.Bakery;

public class BakeryAdapterService implements BakeryAdapter {
    @Override
    public Bakery toBakery(JsonNode node) {
        return null;
    }
}
