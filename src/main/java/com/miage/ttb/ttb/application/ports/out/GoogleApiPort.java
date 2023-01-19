package com.miage.ttb.ttb.application.ports.out;

import com.miage.ttb.ttb.domain.Bakery;
import com.miage.ttb.ttb.domain.Coordinates;

import java.util.List;

public interface GoogleApiPort {
    List<Bakery> proximitySearchByWordAndRadius(String word, int radius, Coordinates coordinates);
}
