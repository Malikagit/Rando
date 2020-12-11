package com.randodam.geolocalisation.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.randodam.geolocalisation.R;
import com.randodam.geolocalisation.utils.gol;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link criteres_recherche#newInstance} factory method to
 * create an instance of this fragment.
 */
public class criteres_recherche extends Fragment {

    private static final String TAG = "Cycle de vie";
    private static final String emplacment = criteres_recherche.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public criteres_recherche() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment criteres_recherche.
     */
    // TODO: Rename and change types and number of parameters
    public static criteres_recherche newInstance(String param1, String param2) {
        criteres_recherche fragment = new criteres_recherche();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        gol.addlog(TAG, emplacment, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    gol.addlog(TAG,emplacment,"onCreate");
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        gol.addlog(TAG, emplacment, "onCreateView");
        return inflater.inflate(R.layout.fragment_download_parcour, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gol.addlog(TAG, emplacment, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        gol.addlog(TAG, emplacment, "onStart");
    }

}