package com.randodam.geolocalisation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.randodam.geolocalisation.utils.gol;


public class AutourMoi extends AppCompatActivity implements LocationListener {
    ImageView location;
    Button rechercherParcours;
    //FragmentManager fragmentManager;
    TextView currentPosition;
    LocationManager locationManager;
    ProgressBar progressBar_dinevele;


    private static final String TAG = "Cycle de vie";
    private static final String emplacement = AutourMoi.class.getSimpleName();

    public void titreApp() {
        //Ici on déclare le nom de l'app car c'est la première page qui s'affiche
        String titre = "Autour de moi";
        // On fait le lien avec la ressource et on la modifiee
        setTitle(titre);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autour_moi);
        //fragmentManager = getSupportFragmentManager();

/** recuperer position actuelle  **/
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);


/** code appeler un fragment dans une activity
 *
 */
    /*    appelFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // addFragment();

            }
        });
    */
        gol.addlog(TAG, emplacement, "onStart");
        titreApp();
        initUI();
    }


    private void initUI() {
        rechercherParcours = findViewById(R.id.btnRechercherParcours);
        location = findViewById(R.id.imgvGpsFixed);
    }

// cycle de vie de l'activité


    @Override
    protected void onStart() {
        super.onStart();
        gol.addlog(TAG, emplacement, "onStart");
    }

    // methode d'ajout du fragment
    /* public void addFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(this.getTaskId(),new criteres_recherche());
       fragmentTransaction.replace(R.id.nav_detail_parcours_fragment, new criteres_recherche());
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/

    @Override
    public void onLocationChanged(@NonNull Location location) {

        currentPosition = (TextView) findViewById(R.id.tv_CurrentPosition);
        currentPosition.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
        Log.i(TAG, "onLocationChanged: " + "Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        Log.d("Latitude", "enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }

    //appeler l'activité listParcours

    public void chargerParcours(View view) {
        Intent intent = new Intent(this, listParcours.class);
        startActivity(intent);
    }


}

