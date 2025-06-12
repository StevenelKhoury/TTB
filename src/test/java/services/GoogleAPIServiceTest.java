package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.miage.ttb.ttb.application.service.BakeryAdapterService;
import com.miage.ttb.ttb.application.service.GoogleAPIService;
import com.miage.ttb.ttb.domain.Bakery;
import com.miage.ttb.ttb.domain.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class GoogleAPIServiceTest {

    @Mock
    private OkHttpClient client;
    @Mock
    private Request request;
    @Mock
    private Response response;
    @Mock
    private BakeryAdapterService adapterService;

    private GoogleAPIService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new GoogleAPIService();
        service.setClient(client);
        service.setBakeryAdapterService(adapterService);
    }

    @Test
    void proximitySearchByWordAndRadiusTest() throws Exception {
        String word = "pâtisserie";
        int radius = 1000;
        Coordinates coordinates = new Coordinates(45.5231, -122.6765);
        String json = "{\"results\": [{\"name\": \"Boulangerie\", \"geometry\": {\"location\": {\"lat\": 45.5231, \"lng\": -122.6765}}}]}";
        List<Bakery> expectedBakeries = List.of(new Bakery("Boulangerie", coordinates));

        when(client.newCall(request).execute()).thenReturn(response);
        when(response.body().string()).thenReturn(json);
        when(adapterService.toBakery(json)).thenReturn(expectedBakeries);

        when(request.url()).thenReturn("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+coordinates.x()+"%2C"+coordinates.y()+"&radius="+radius+"&type=bakery&keyword="+word+"&key=AIzaSyCP7fhRbzhXhDlXv5b6EIuUclaEpGEK2ok");
        when(request.get()).thenReturn(request);
        when(client.newBuilder()).thenReturn(client);
        when(client.build()).thenReturn(client);

        List<Bakery> bakeries = service.proximitySearchByWordAndRadius(word, radius, coordinates);
        assertEquals(expectedBakeries, bakeries);
    }
}
