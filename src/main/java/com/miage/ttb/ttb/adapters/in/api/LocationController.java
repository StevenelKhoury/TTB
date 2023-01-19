package com.miage.ttb.ttb.adapters.in.api;

import com.miage.ttb.ttb.adapters.in.dto.GetBakeryInfoResponse;
import com.miage.ttb.ttb.adapters.in.dto.GetLocationRequest;
import com.miage.ttb.ttb.application.converter.MapperTool;
import com.miage.ttb.ttb.application.service.GoogleAPIService;
import com.miage.ttb.ttb.domain.Coordinates;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {
    private final GoogleAPIService googleAPIService;
    private final MapperTool mapperTool;

    @PostMapping(value = "bakery")
    @ResponseStatus(HttpStatus.OK)
    public List<GetBakeryInfoResponse> getBakeryFromProximity(@RequestBody GetLocationRequest getLocationRequest) {
        return googleAPIService.proximitySearchByWordAndRadius(getLocationRequest.getWord(),
                getLocationRequest.getRadius(),
                new Coordinates(getLocationRequest.getX(), getLocationRequest.getY()))
                .stream().map(mapperTool::bakeryToGetBakeryInfoResponse)
                .toList();
    }
}
