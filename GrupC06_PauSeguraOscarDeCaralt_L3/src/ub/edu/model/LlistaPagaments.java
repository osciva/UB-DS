package ub.edu.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class LlistaPagaments {

private LlistaExcursions llistaExcursions;
private CarteraSocis carteraSocis;
private Pagament pagament;
Bizum bizum;
CompteBancaria compteBancaria;
PayPal paypal;
Scanner sc = new Scanner(System.in);

    public LlistaPagaments(LlistaExcursions llistaExcursions, CarteraSocis carteraSocis) {
        this.llistaExcursions = llistaExcursions;
        this.carteraSocis = carteraSocis;

    }
    public String pagarActivitat(String nomSoci, String nomExcursio, String nomActivitat) {


        Soci soci = carteraSocis.find(nomSoci);
        if (soci == null) {
            return "Correu inexistent";
        }
        //pagament.triaMetode(sc,soci);
        Excursio excursio = llistaExcursions.getExcursionsMap().getOrDefault(nomExcursio, null);
        if (excursio == null) {
            return "Excursio no existent";
        }
        Activitat activitat = excursio.getActivitat(nomActivitat);
        if (activitat == null) {
            return "Activitat no existent";
        }
        if (soci.getMetodePagament() == null) {
            return "No hi ha metode de pagament registrat";
        }
        Pagament pagament = soci.addActivitatComprada(nomExcursio, nomActivitat);
        if (pagament.isPendent()) {
            return "Pagament pendent";
        } else {
            return "Pagament complert";
        }
    }

    public String pagaments(String nomSoci) {
        bizum.imprimir(carteraSocis.find(nomSoci).getActivitatsComprades().get(0), llistaExcursions);
        paypal.imprimir(carteraSocis.find(nomSoci).getActivitatsComprades().get(0), llistaExcursions);
        compteBancaria.imprimir(carteraSocis.find(nomSoci).getActivitatsComprades().get(0), llistaExcursions);
        return stats();


    }






    public Iterable<String> llistarPagaments(String nomSoci) {
        ArrayList<String> pagaments = new ArrayList<>();

        Soci soci = carteraSocis.find(nomSoci);
        if(soci == null){
            pagaments.add("Correu inexistent");
            return pagaments;
        }
        ArrayList<Pagament> activitatsComprades = soci.getActivitatsComprades();
        if (activitatsComprades.size() == 0) {
            pagaments.add("No hi ha pagaments");
            return pagaments;
        }

        for (Pagament pagament : activitatsComprades){
            String isPendentMessage;
            if (pagament.isPendent()) {
                isPendentMessage = "(Pendent)";
            } else {
                isPendentMessage = "(Pagat)";
            }
            pagaments.add(pagament.getNomExcursio() + " - " + pagament.getNomActivitat() + " " + isPendentMessage);
        }

        return pagaments;
    }


    public String stats() {
        double total = bizum.comptador() + paypal.comptador() + compteBancaria.comptador();
        String estadistiques;
        estadistiques = "Estadistiques metodes de pagament: "
                + " Compte Bancaria: " + (compteBancaria.comptador())
                + " Bizum: " + (bizum.comptador())
                + " Paypal: " + (paypal.comptador());


        return estadistiques;
    }


}


