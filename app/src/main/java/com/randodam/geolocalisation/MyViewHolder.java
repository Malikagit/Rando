package com.randodam.geolocalisation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomParcours, dateParcours, descriptifParcours;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomParcours = itemView.findViewById(R.id.tvNomParcours);
            dateParcours = itemView.findViewById(R.id.tvDateParcours);
            descriptifParcours = itemView.findViewById(R.id.tvDescriptifParcours);
        }


    }

