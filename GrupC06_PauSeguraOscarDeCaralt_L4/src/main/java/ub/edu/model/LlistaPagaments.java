package ub.edu.model;

import java.lang.reflect.Array;
import java.util.*;


public class LlistaPagaments implements LlistaObservated {

private LlistaExcursions llistaExcursions;
private ArrayList observers = new ArrayList();
private CarteraSocis carteraSocis;
private Pagament pagament;


Scanner sc = new Scanner(System.in);

    public LlistaPagaments(LlistaExcursions llistaExcursions, CarteraSocis carteraSocis) {
        this.llistaExcursions = llistaExcursions;
        this.carteraSocis = carteraSocis;


    }/*
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
    }*/

    @Override
    public void registerObserver(LlistaObserver o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(LlistaObserver o) {
        int i = this.observers.indexOf(o);
        if (i >= 0) {
            this.observers.remove(i);
        }

    }

    public void notifyObservers(){
        for (int i = 0; i < observers.size(); i++) {
            LlistaObserver observer = (LlistaObserver) observers.get(i);
            observer.update();
        }



    }
    public void apuntatsChanged(){
        notifyObservers();
    }
    public void apuntarseActivitat(String nomExcursio,String nomActivitat, String soci) {
        Soci socio = carteraSocis.find(soci);
        Excursio excursio = llistaExcursions.getExcursionsMap().getOrDefault(nomExcursio, null);
        Activitat activitat = excursio.getActivitat(nomActivitat);
        activitat.apuntarse();
        apuntatsChanged();
        socio.addActivitatReservada(nomExcursio, nomActivitat);


    }


    public void pagament(String act, String exc, String soci){
        Soci socio = carteraSocis.find(soci);
        Excursio excursio = llistaExcursions.getExcursionsMap().getOrDefault(exc, null);
        Activitat activitat = excursio.getActivitat(act);
        activitat.pagarBizum();
        socio.addActivitatPagada(exc, act);



    }






/*
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
    }*/





}


