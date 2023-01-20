package com.miage.ttb.ttb.application.ports.out;

import com.fasterxml.jackson.databind.JsonNode;
import com.miage.ttb.ttb.domain.Bakery;
import okhttp3.ResponseBody;

import java.util.List;

public interface BakeryAdapter {
    List<Bakery> toBakery(String response);


}
