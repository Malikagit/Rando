package com.randodam.geolocalisation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.gms.maps.MapFragment;
import com.randodam.geolocalisation.fragment.CarteParcours;
import com.randodam.geolocalisation.fragment.criteres_recherche;

public class DetailsParcours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_parcours);
        Fragment fragment1 = new CarteParcours();
        addFragment();

    }





    /** Appel du Maps fragment  **/
     public void addFragment() {

         FragmentManager fragmentManager;
         fragmentManager = getSupportFragmentManager();

         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(this.getTaskId(),new criteres_recherche());
       fragmentTransaction.replace(R.id.nav_carteParcours, new CarteParcours());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}