package ub.edu.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Excursio {
    private String nom;
    private LocalDate data;
    private Set<Especie> llistaEspecies;
    private List<String> comentaris;
    private List<Activitat> llistaActivitats;
    private boolean pagat;
    private float preu;
    private String date;
    private String dataText;
    private Soci soci;
    private Map<String, Comentari> LlistaComentaris;



    public Excursio(String titol, String dataText) {
        this.nom = titol;
        this.comentaris = new ArrayList<>();
        setData(dataText);
        llistaEspecies = new HashSet<>();
        pagat = false;
        this.preu = preu;
        this.llistaActivitats = new ArrayList<>();
        //this.llistarComentaris() = new HashMap<>();
    }
    public Excursio(String date, float preu) {
        this.date = date;
        this.preu = preu;
    }

    public Excursio(String titol, String dataText, List<Especie> especies) {
        this.nom = titol;
        setData(dataText);
        llistaEspecies = new HashSet<>(especies);
        comentaris = new ArrayList<>();
        pagat = false;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getData(){
        return this.data;
    }

    public void setData(String dataText){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = LocalDate.parse(dataText, formatter);
    }
    public String getDataText(){
        return this.dataText;
    }
    public void setDataText(String dataText){
        this.dataText = dataText;
    }

    public void addEspecie(Especie especie){
        llistaEspecies.add(especie);
    }

    public boolean containsEspecie(Especie especie){
        return llistaEspecies.contains(especie);
    }

    public void addComentari(String text){comentaris.add(text);}
    public void addActivitat(Activitat a) {llistaActivitats.add(a);}

    public String llistarComentaris() {
        String comment = "";
        TreeMap<String, Comentari> tree = (new TreeMap<String, Comentari>() {});


        if (!tree.isEmpty()) {
            for (Comentari x : tree.values()) {
                comment += (x.getComentari());
            }


            return comment;
        } else {
            return "No hi ha comentaris disponibles";
        }

    }


}