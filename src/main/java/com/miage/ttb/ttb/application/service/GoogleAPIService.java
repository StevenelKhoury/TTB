package com.miage.ttb.ttb.application.service;

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
    @SneakyThrows
    @Override
    public List<Bakery> proximitySearchByWordAndRadius(String word, int radius, Coordinates coordinates) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+coordinates.x()+""+coordinates.y()+"&radius="+radius+"&type=restaurant&keyword=cruise&key=AIzaSyCP7fhRbzhXhDlXv5b6EIuUclaEpGEK2ok")
                .get()
                .build();
        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());
        return Collections.emptyList();
    }
}
