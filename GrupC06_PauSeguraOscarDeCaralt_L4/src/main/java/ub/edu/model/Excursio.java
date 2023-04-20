package ub.edu.model;

import javafx.scene.chart.Axis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Excursio {
    private String nom;
    private LocalDate data;
    private String link;
    private Set<Especie> llistaEspecies;
    private Map<String, Activitat> activitatsMap;

    public Excursio(String titol, String dataText, String link) {
        this.nom = titol;
        this.link = link;
        setData(dataText);
        llistaEspecies = new HashSet<>();
        activitatsMap = new HashMap<>();
    }

    public Excursio(String titol, String dataText, String link, List<Especie> especies) {
        this.nom = titol;
        setData(dataText);
        this.link = link;
        llistaEspecies = new HashSet<>(especies);
        activitatsMap = new HashMap<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(String dataText) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = LocalDate.parse(dataText, formatter);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void addEspecie(Especie especie) {
        llistaEspecies.add(especie);
    }

    public boolean containsEspecie(Especie especie) {
        return llistaEspecies.contains(especie);
    }

    public List<Especie> getEspecies() {
        return new ArrayList<Especie>(llistaEspecies);
    }

    public void addActivitat(String nom, float preu) {
        activitatsMap.put(nom, new Activitat(this.nom, nom, preu));
    }

    public Map<String, Activitat> getActivitatsMap() {
        return activitatsMap;
    }
    public List<String> activitats(){
        Collection<Activitat> values = getActivitatsMap().values();
        ArrayList<Activitat> listOfValues = new ArrayList<>(values);
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < listOfValues.size();i++){
            String a = listOfValues.get(i).getNom();
            System.out.println(a);
            llista.add(a);

        }




        return llista;

    }
    public List<String> especies(){

        List<String> llista = new ArrayList<>();
        Iterator<Especie> it = llistaEspecies.iterator();
        while (it.hasNext()){

            llista.add(it.next().getNom());

        }





        return llista;

    }
    public Activitat getActivitat(String nomActivitat) {
        return activitatsMap.getOrDefault(nomActivitat, null);

    }
}