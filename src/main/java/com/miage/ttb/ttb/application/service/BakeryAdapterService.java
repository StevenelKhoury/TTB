package com.miage.ttb.ttb.application.service;import com.fasterxml.jackson.databind.JsonNode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.miage.ttb.ttb.application.ports.out.BakeryAdapter;
import com.miage.ttb.ttb.domain.Address;
import com.miage.ttb.ttb.domain.Bakery;
import com.miage.ttb.ttb.domain.Coordinates;
import okhttp3.ResponseBody;
import org.apache.coyote.Response;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BakeryAdapterService implements BakeryAdapter {

    private static BakeryAdapterService instance = null;

    private BakeryAdapterService() {
    }
    public static BakeryAdapterService getInstance() {
        if(instance==null){
          instance = new BakeryAdapterService();
        }
        return instance;
    }

    @Override
    public List<Bakery> toBakery(String response) {

        List<Bakery> bakeries= new ArrayList<>();

        Gson gson = new Gson();

        JsonObject jsonElement = gson.fromJson(response,JsonObject.class);

       /* String name = jsonElement.get("name").getAsString();
        float lat = jsonElement.get("location").get("lat").getAsFloat();
        float lng = jsonElement.get("location").get("lng").getAsFloat();
        float rating = jsonElement.get("rating").get("rating").getAsFloat();
        String address = jsonElement.get("vicinity").getAsString();*/

        Iterator<JsonElement> iterator = jsonElement.get("results").getAsJsonArray().iterator();
        while(iterator.hasNext()){
            //Get Bakery object
            JsonObject bakery = iterator.next().getAsJsonObject();

            String name = bakery.get("name").getAsString();
            //Get Geometry object that contains location info
            JsonObject geometry = bakery.get("geometry").getAsJsonObject();
            //Get Bakery's location
            JsonObject coordinates = geometry.get("location").getAsJsonObject();
            //Get Lat and Lng from coordinates
            Coordinates coord = new Coordinates(coordinates.get("lat").getAsDouble(),coordinates.get("lng").getAsDouble());
            //Get Address
            Address vicinity = new Address(bakery.get("vicinity").getAsString());
            //Get Rating
            float rating = bakery.get("rating").getAsFloat();

           Bakery bakery1 = new Bakery(name,vicinity, rating, coord);
           System.out.println("bakery1 :"+ bakery1.getName());
           bakeries.add(bakery1);
        }
        return bakeries;
    }

}
