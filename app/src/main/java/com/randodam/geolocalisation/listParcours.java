package com.randodam.geolocalisation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.randodam.geolocalisation.model.ParcoursModel;


public class listParcours extends AppCompatActivity {

    /**
     * Attributs RecycleView
     **/
    ProgressBar progressBar;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    /**
     * Connexion à la Firebase
     **/

    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter adapter;

    /**
     * Attribut pour la gestion du linearlayout du recyclerview
     **/

    /**
     * Méthode pour l'initialisation de l'interface utilisateur
     **/

    private void initUI() {
        progressBar = (ProgressBar) findViewById(R.id.pb_loading);
        recyclerView = (RecyclerView) findViewById(R.id.rvListParcours);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fabCommencerParcours);
    }

    private void init() {
        LinearLayoutManager linearLayoutManager;
        db = FirebaseFirestore.getInstance();
        // initialisation du linear layout qui va contenir le recycler view
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

     /*try {
                // Initialisation du recyclerView avec le linearLayout

    } catch (Exception e) {

       //  Log.i("listParcours","--------------------------------------------pb initialisation layoutManagerRecycleView");
          }*/
    }


    public void titreApp() {
        //Ici on déclare le nom de l'app car c'est la première page qui s'affiche
        String titre = "liste Parcours";
        // On fait le lien avec la ressource et on la modifiee
        setTitle(titre);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_parcours);
        initUI();
        init();
        titreApp();
        getDataFromFirestore();
    }

    private void getDataFromFirestore() {
        // requette sur la collection que l'on veut appeler
      CollectionReference parcoursRef = db.collection("parcours");
      /**  faire des séléctions dans la base en utilisant des requètes composées
       * pas encore fini
       * **/
 Query query = parcoursRef.whereEqualTo("locomotion","vélo");

        // On utilise le model pour faire l'acquisition des données dans Firestore
        FirestoreRecyclerOptions<ParcoursModel> parcours = new FirestoreRecyclerOptions.Builder<ParcoursModel>()
                .setQuery(query, ParcoursModel.class).build();
        /** on prépare l'adapter pour afficher les datas récupérées **/

        adapter = new FirestoreRecyclerAdapter<ParcoursModel, MyViewHolder>(parcours) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull ParcoursModel model) {
                progressBar.setVisibility(View.GONE);
                holder.nomParcours.setText(model.getNomParcours());
                holder.dateParcours.setText(model.getDateParcours());
                holder.descriptifParcours.setText(model.getDescriptifParcours());

                holder.itemView.setOnClickListener(v -> {
                    //A programmer pou listner holder
                    Snackbar.make(recyclerView, model.getNomParcours()
                                    + ", "
                                    + model.getDateParcours()
                                    + ", "
                                    + model.getDescriptifParcours()
                            , Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show();
                });
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item, parent, false);
                return new MyViewHolder(view);
            }

            public void onError(FirebaseFirestoreException e) {
                Log.e("error", e.getMessage());
            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    //Methode commencer un parcours
    public void commencerParcour(View view) {
        Intent intent = new Intent(this, Navigation.class);
        startActivity(intent);

    }
    /**
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_parcours, menu);

        MenuItem search = menu.findItem(R.id.search);
           /* SearchView searchView = (SearchView) search.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        return listParcours.super.onCreateOptionsMenu(menu);
    } **/





}

