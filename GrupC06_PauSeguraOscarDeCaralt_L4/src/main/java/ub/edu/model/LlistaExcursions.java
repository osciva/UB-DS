package ub.edu.model;

import java.util.*;

public class LlistaExcursions {
    private Map<String,Excursio> excursionsMap;

    public LlistaExcursions(Map<String,Excursio> excursionsMap){
                    this.excursionsMap = excursionsMap;
    }

    public void addExcursio(String nom, String dataText,String link){

        excursionsMap.put(nom, new Excursio(nom, dataText,link));
    }
    public Map<String,Excursio> getExcursionsMap(){

        return this.excursionsMap;
    }

    public List<Excursio> getExcursionsList(){
        return new ArrayList<>(excursionsMap.values());

    }
    public Iterable<String> llistarCatalegExcursionsPerNom(){
        SortedSet<String> excursionsDisponibles = new TreeSet<>();
        if (getExcursionsList().isEmpty()) {
            excursionsDisponibles.add("No hi ha excursions disponibles");
        } else {
            for (Excursio s : getExcursionsList()) {
                excursionsDisponibles.add(s.getNom());
            }
        }
        return excursionsDisponibles;
    }
    public Iterable<String> llistarCatalegExcursionsPerData(){
        List<Excursio> sortedList = getExcursionsList();
        sortedList.sort(new Comparator<Excursio>() {
            public int compare(Excursio a1, Excursio a2) {
                return a1.getData().compareTo(a2.getData());
            }
        });

        List<String> excursionsDisponibles = new ArrayList<>();
        for (Excursio s : sortedList) {
            excursionsDisponibles.add(s.getNom());
        }

        return excursionsDisponibles;
    }
    public void addActivitat(String nomExcursio, String nomActivitat, float preu) throws IllegalArgumentException{

        Excursio excursio = excursionsMap.get(nomExcursio);
        if (excursio == null) {throw new IllegalArgumentException("La excursio no existeix");}

        excursio.addActivitat(nomActivitat, preu);
    }

}
