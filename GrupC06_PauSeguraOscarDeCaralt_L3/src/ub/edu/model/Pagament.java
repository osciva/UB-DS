package ub.edu.model;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Pagament {

    private final String nomExcursio;
    private final String nomActivitat;
    private boolean pendent;
    private boolean pagat = false;
    CarteraSocis carteraSocis;
    Activitat activitat;
    Scanner sc = new Scanner(System.in);
    Bizum bizum;
    PayPal paypal;
    CompteBancaria comptebnc;

    public Pagament(String nomExcursio, String nomActivitat, MetodePagament metodePagament) {
        this.nomExcursio = nomExcursio;
        this.nomActivitat = nomActivitat;
        this.pendent = metodePagament.hasDelay();
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









/*
    public void triaMetode(Scanner sc, Soci soci){
        String tria;
        System.out.println("Quin mètode de pagament vols utilitzar per pagar" + activitat.getPreu() + "€ ? Bizum, Compte Bancari o PayPal?");
        tria = sc.nextLine();
        if(tria.equalsIgnoreCase("Bizum")){
            //soci.setMetodePagament(bizum.completar());


        }if(tria.equalsIgnoreCase("PayPal")){
            //soci.setMetodePagament(paypal.completar());


        }if(tria.equalsIgnoreCase("Compte Bancari")) {
            soci.setMetodePagament(comptebnc.completar());
        }

        }
*/





}
