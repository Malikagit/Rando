package com.randodam.geolocalisation.model;

import java.util.Date;

public class ParcoursModel {

    String nomParcours;
    String dateParcours;
    String descriptifParcours;
    float denivele;
    String dureeParcours;
    String locomotion;

    public ParcoursModel(String nomParcours, String dateParcours, String descriptifParcours, float denivele, String dureeParcours, String locomotion) {
        this.nomParcours = nomParcours;
        this.dateParcours = dateParcours;
        this.descriptifParcours = descriptifParcours;
        this.denivele = denivele;
        this.dureeParcours = dureeParcours;
        this.locomotion = locomotion;
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

    public float getDenivele() {
        return denivele;
    }

    public String getDureeParcours() {
        return dureeParcours;
    }

    public String getLocomotion() {
        return locomotion;
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

    public void setDenivele(float denivele) {
        this.denivele = denivele;
    }

    public void setDureeParcours(String dureeParcours) {
        this.dureeParcours = dureeParcours;
    }

    public void setLocomotion(String locomotion) {
        this.locomotion = locomotion;
    }
}



