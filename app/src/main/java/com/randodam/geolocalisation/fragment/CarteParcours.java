package com.randodam.geolocalisation.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.randodam.geolocalisation.R;

public class CarteParcours extends Fragment {

    //private LocationViewModel locationViewModel;
    private GoogleMap gMap;
    private MapView mapView;
    private Location currentLocation;
    private int LOCATION_PERMISSION_REQUEST_CODE = 1234;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carte_parcours, container, false);
        //initialiser le fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        // Asynchrone map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {

            /** when map is loaded **/
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    /** when clicked on map **/
                    @Override
                    public void onMapClick(LatLng latLng) {
/** initialiser marker options **/
                        MarkerOptions markerOptions = new MarkerOptions();
                        /** initialiser la position du marqueur **/
                        markerOptions.position(latLng);
                        /** initialiser le titre du marqueur **/
                        markerOptions.title(latLng.latitude + ":" + latLng.longitude);
                        /** remeove all markers **/
                        googleMap.clear();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                        googleMap.addMarker(markerOptions);
                    }
                });
            }

        });

        return view;
    }

}