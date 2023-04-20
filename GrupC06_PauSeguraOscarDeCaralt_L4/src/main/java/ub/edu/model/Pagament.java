package ub.edu.model;

import java.util.Scanner;


public class Pagament {

    private final String nomExcursio;
    private final String nomActivitat;
    private boolean pendent;
    private boolean pagat = false;



    public Pagament(String nomExcursio, String nomActivitat) {
        this.nomExcursio = nomExcursio;
        this.nomActivitat = nomActivitat;

    }

    public boolean isPendent() {
        return pendent;
    }

    public void setPaid() {
        this.pendent = false;
    }

    public void setEstatPagat(){
        this.pagat = true;
    }

    public String getNomActivitat() {
        return nomActivitat;
    }

    public String getNomExcursio() {
        return nomExcursio;
    }













}
