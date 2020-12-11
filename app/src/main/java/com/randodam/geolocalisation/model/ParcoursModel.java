package com.randodam.geolocalisation.model;

import java.util.Date;

public class ParcoursModel {

    String nomParcours;
    String dateParcours;
    String descriptifParcours;

    public ParcoursModel(String nomParcours, String dateParcours, String descriptifParcours) {
        this.nomParcours = nomParcours;
        this.dateParcours = dateParcours;
        this.descriptifParcours = descriptifParcours;
    }

    public ParcoursModel() {
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public String getDateParcours() {
        return dateParcours;
    }

    public String getDescriptifParcours() {
        return descriptifParcours;
    }

    public void setNomParcours(String nomParcours) {
        this.nomParcours = nomParcours;
    }

    public void setDateParcours(String dateParcours) {
        this.dateParcours = dateParcours;
    }

    public void setDescriptifParcours(String descriptifParcours) {
        this.descriptifParcours = descriptifParcours;
    }
}



