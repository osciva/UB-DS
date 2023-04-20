package ub.edu.controller;

import ub.edu.model.Excursio;
import ub.edu.model.CarteraSocis;
import ub.edu.model.Soci;
import ub.edu.model.Especie;

import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Controller {

    private AbstractFactoryData factory;      // Origen de les dades
    private DataService dataService;         // Connexio amb les dades


    private CarteraSocis carteraSocis;       // Model
    private Map<String, Excursio> excursionsMap;
    private Map<String, Especie> especiesMap;

    public Controller() {
        factory = new FactoryMOCK();
        dataService = new DataService(factory);

        try {
            iniCarteraSocis();
            iniLlistaExcursions();
            especiesMap = new HashMap<>();
            //iniEspecies(); //ens dona error al test one
        } catch (Exception e) {
        }

    }

    public boolean iniCarteraSocis() throws Exception {
        List<Soci> l = dataService.getAllSocis();
        if (l != null) {
            carteraSocis = new CarteraSocis(l);
            return true;
        } else return false;
    }

    public boolean iniLlistaExcursions() throws Exception {

        excursionsMap  = (dataService.getAllExcursions().stream()
                .collect(Collectors.toMap(Excursio::getNom, Function.identity())));
        if (excursionsMap != null)
            return true;
         else return false;
    }
    public boolean iniEspecies() throws Exception{
        especiesMap  = (dataService.getAllEspecies().stream()
                .collect(Collectors.toMap(Especie::getNom, Function.identity())));
        if (especiesMap != null)
            return true;
        else return false;
    }

    
    // Validem el Soci a la capa de persistencia i no a memoria, per seguretat en les possibles sincronitzacions
    public String validateRegisterSoci (String username, String password) {
        if  (dataService.getSociByUsername(username).isPresent() )
                return "Soci Duplicat";
        else if (isMail(username) && isPasswordSegur(password))
             return "Soci Validat";
        else return "Format incorrecte";
}

    public boolean isPasswordSegur(String password) {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public boolean isMail(String correu) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correu);
        return matcher.find();
    }

    public Iterable<String> llistarCatalegExcursionsPerNom() {
        SortedSet<String> excursionsDisponibles = new TreeSet<>();
        if (excursionsMap.isEmpty()) {
            excursionsDisponibles.add("No hi ha excursions disponibles");
        } else {
            List<Excursio> llista = excursionsMap.values().stream().collect(Collectors.toList());
            for (Excursio s : llista) {
                excursionsDisponibles.add(s.getNom());
            }
        }
        return excursionsDisponibles;
    }

    public Iterable<String> llistarCatalegExcursionsPerData(){
        List<Excursio> sortedList = excursionsMap.values().stream().collect(Collectors.toList());
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
    public Iterable<String> llistarEspecies(){
        List<Especie> sortedList = especiesMap.values().stream()
                .collect(Collectors.toList());


        List<String> especies = new ArrayList<>();
        for (Especie s : sortedList) {
            especies.add(s.getNom());
        }

        return especies;
    }

    public String findSoci(String username) {
        Soci Soci = carteraSocis.find(username);
        if (Soci!=null) return "Soci existent";
        else return "Soci Desconegut";
    }


    public String validatePassword(String b) {
        if (!isPasswordSegur(b)) {
            return "Contrassenya no segura";
        } else
            return "Contrassenya segura";
    }


    public String validateUsername(String b) {
        if (!isMail(b))
            return "Correu en format incorrecte";
        else
            return "Correu en format correcte";
    }



    public String loguejarSoci(String username, String password){
        Soci soci = carteraSocis.find(username);
        if(soci == null){
            return "Correu inexistent";
        }
        if(soci.getPwd().equals(password)){
            return "Login correcte";
        }else{
            return "Contrassenya incorrecta";
        }
    }

    public String recuperarContrassenya(String username){
        Soci soci = carteraSocis.find(username);
        if(soci == null){
            return "Correu inexistent";
        }
        return soci.getPwd();
    }


    public Especie afegirEspecie(String nomEspecie) throws Exception {
        Especie especie;
        if(dataService.getEspecieByName(nomEspecie).isPresent()){
            especie = especiesMap.get(nomEspecie);
        }else{
            especie = new Especie(nomEspecie);
            especiesMap.put(nomEspecie, especie);
        }
        return especie;
    }

    public void afegirEspecieExcursio(String nomEspecie, String nomExcursio) throws Exception {

        if(dataService.getExcursioByName(nomExcursio).isPresent()) {
            Especie especie = afegirEspecie(nomEspecie);
            excursionsMap.get(nomExcursio).addEspecie(especie);
        }





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

    private int comptarExcursionsEspecie(Especie especie){
        int count = 0;
        for (Excursio excursio : excursionsMap.values()){
            if(excursio.containsEspecie(especie)) count++;
        }
        return count;
    }

    public String isValidNameSoci(String username) {
        Soci Soci = carteraSocis.find(username);
        if (Soci!=null) return "Soci Validat";
        else return "Soci Desconegut";
    }





}
