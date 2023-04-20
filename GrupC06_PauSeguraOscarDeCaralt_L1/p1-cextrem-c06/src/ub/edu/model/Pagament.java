package ub.edu.model;

import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class Pagament {
    private Excursio excursio;
    private Soci soci;
    private String data;
    private float preu;
    private static boolean pagat;
    Scanner sc = new Scanner(System.in);

    public Pagament(String data, float preu) {
        this.data = data;
        this.preu = preu;
    }

    public Pagament(Excursio excursio, Soci soci, String data) {
        this.excursio = excursio;
        this.soci = soci;
        this.data = data;
    }

    public Excursio getExcursio() {
        return excursio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setExcursio(Excursio excursio) {
        this.excursio = excursio;
    }

    public Soci getSoci() {
        return soci;
    }

    public void setSoci(Soci soci) {
        this.soci = soci;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public static boolean isPagat() {
        return pagat;
    }

    public void setPagat(boolean pagat) {
        this.pagat = pagat;
    }

    public static String comanda(String soci,  String compte){
        return "Pagament correcte";

    }

    public String llistarPagaments() {
        String payment = "";
        TreeMap<String, Pagament> tree = (new TreeMap<String, Pagament>() {});


        if (!tree.isEmpty()) {
            for (Pagament x : tree.values()) {
                payment += (x.getPreu());
            }


            return payment;
        } else {
            return "No hi ha cap Pagament";
        }

    }


}


