package org.techtown.hackathon.network.client;

import org.techtown.hackathon.Utils;
import org.techtown.hackathon.network.interfaces.LocationService;
import org.techtown.hackathon.network.request.LocationRequest;

import io.reactivex.Single;

public class LocationClient extends NetworkClient {
    private LocationService service;

    public LocationClient() {
        service = Utils.RETROFIT.create(LocationService.class);
    }

    public Single<String> postLocation(String latitude, String longitude) {
        return service.postLocation(new LocationRequest(latitude, longitude)).map(response -> {
            return response.getMessage();
        });
    }
}
