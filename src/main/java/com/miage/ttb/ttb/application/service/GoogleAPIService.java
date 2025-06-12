package com.miage.ttb.ttb.application.service;

import com.google.gson.Gson;
import com.miage.ttb.ttb.application.ports.out.GoogleApiPort;
import com.miage.ttb.ttb.domain.Bakery;
import com.miage.ttb.ttb.domain.Coordinates;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GoogleAPIService implements GoogleApiPort {
    @Override
    public List<Bakery> proximitySearchByWordAndRadius(String word, int radius, Coordinates coordinates) {
        Gson gson = new Gson();
        List<Bakery> bakeries= null ;
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        BakeryAdapterService bakeryAdapterService = BakeryAdapterService.getInstance();

        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+coordinates.x()+"%2C"+coordinates.y()+"&radius="+radius+"&type=bakery&keyword="+word+"&key="+API_KEY)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
        //System.out.println(response.body().string());
        bakeries = bakeryAdapterService.toBakery(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bakeries;
    }
}
