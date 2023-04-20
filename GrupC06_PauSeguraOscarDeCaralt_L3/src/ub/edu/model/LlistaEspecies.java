package ub.edu.model;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LlistaEspecies {

     private LlistaExcursions llistaExcursions;
     private Map<String, Especie> especiesMap;


    public LlistaEspecies(LlistaExcursions llistaExcursions){
        this.llistaExcursions = llistaExcursions;
        especiesMap = new HashMap<>() ;



    }
    public Especie afegirEspecie(String nomEspecie){
        Especie especie;
        if(especiesMap.containsKey(nomEspecie)){
            especie = especiesMap.get(nomEspecie);
        }else{
            especie = new Especie(nomEspecie);
            especiesMap.put(nomEspecie, especie);
        }
        return especie;
    }
    public void afegirEspecieExcursio(String nomEspecie, String nomExcursio){
        Especie especie = afegirEspecie(nomEspecie);

        llistaExcursions.getExcursionsMap().get(nomExcursio).addEspecie(especie);



    }
    public Iterable<String> cercaExcursions(){
        SortedSet<String> especies = new TreeSet<>();

        if (especiesMap.size() == 0){
            especies.add("No hi han espècies enregistrades");
            return especies;
        }

        for (Especie especie : especiesMap.values()){
            especies.add(especie.getNom() + " " + comptarExcursionsEspecie(especie));
        }

        return especies;
    }
    public int comptarExcursionsEspecie(Especie especie){
        int count = 0;
        for (Excursio excursio : llistaExcursions.getExcursionsMap().values()){
            if(excursio.containsEspecie(especie)) count++;
        }
        return count;
    }



}
