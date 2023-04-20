package ub.edu.controller;

import javafx.util.Pair;
import ub.edu.model.*;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

import java.time.LocalDate;
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
    private LlistaExcursions llistaExcursions;
    private LlistaPagaments llistaPagaments;
    private Login login;
    private String nom;
    private Cextrem cextrem;
    private Top10 top10;

    public List<String> getEspeciesExcursio(String excursio) {
        List<String> llistaEspecies = new ArrayList<>();
        for(Especie especie : excursionsMap.get(excursio).getEspecies()){
            llistaEspecies.add(especie.toString());
        }
        return llistaEspecies;
    }

    public Controller() {
        factory = new FactoryMOCK();
        dataService = new DataService(factory);
        this.nom = nom;

        try {
            iniCarteraSocis();
            iniLlistaExcursions();
            iniLlistEspecies();
            iniLlistaPagaments();
            iniLogin(carteraSocis);
            especiesMap = new HashMap<>();
            cextrem = new Cextrem(carteraSocis,llistaExcursions,llistaPagaments,especiesMap,login,top10);

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
        if (excursionsMap != null){
            llistaExcursions = new LlistaExcursions(excursionsMap);
            return true;
        }
         else return false;
    }
    public boolean iniLlistEspecies() throws Exception {
        especiesMap  = (dataService.getAllEspecies().stream()
                .collect(Collectors.toMap(Especie::getNom, Function.identity())));
        if (excursionsMap != null)
            return true;
        else return false;
    }
    public void iniLlistaPagaments() {
        llistaPagaments = new LlistaPagaments(llistaExcursions,carteraSocis);
        top10 = new Top10(llistaExcursions,carteraSocis);

    }
    public void iniLogin(CarteraSocis carteraSocis){
          login = new Login(carteraSocis);

    }

    // Validem el Soci a la capa de persistencia i no a memoria, per seguretat en les possibles sincronitzacions
    public String validateRegisterSoci (String username, String password) {
        return RegistrarSoci(username, password).toString();
    }

    public SociStatus RegistrarSoci(String username, String password) {
        return cextrem.registrarSoci(username, password);
    }



    // TODO: Cal canviar aquest codi per a la pràctica 3
    public Iterable<String> llistarCatalegExcursionsPerNom() {
        List<String> excursionsDisponibles = new ArrayList<>();
        List<Excursio> excursionsList = excursionsMap.values().stream()
                .collect(Collectors.toList());
        for (Excursio s : excursionsList) {
            excursionsDisponibles.add(s.getNom());
        }
        excursionsDisponibles.sort(String.CASE_INSENSITIVE_ORDER);

        return excursionsDisponibles;

    }

    // TODO: Cal canviar aquest codi per a la pràctica 3
    public Iterable<String> llistarCatalegExcursionsPerData(){
        List<String> excursionsDisponibles = new ArrayList<>();
        List<Excursio> excursionsList = excursionsMap.values().stream()
                .collect(Collectors.toList());
        excursionsList.sort(new Comparator<Excursio>() {
            public int compare(Excursio a1, Excursio a2) {
                return a1.getData().compareTo(a2.getData());
            }
        });

        for (Excursio s : excursionsList) {
            excursionsDisponibles.add(s.getNom());
        }

        return excursionsDisponibles;


    }


    public String findSoci(String username) {
        return cextrem.findSoci(username);
    }



    public String validatePassword(String b) {
        return cextrem.validatePassword(b);
    }


    public String validateUsername(String b) {
        return cextrem.validateUsername(b);
    }

    public String loguejarSoci(String username, String password){
        return loguejarSociStatus(username, password).toString();
    }

    public SociStatus loguejarSociStatus(String username, String password){
        return cextrem.loguejarSociStatus(username,password);
    }

    public String recuperarContrassenya(String username){
        return  cextrem.recuperarContrassenya(username);

    }



    public LocalDate getDataExcursio(String excursio) {

        return cextrem.getDataExcursio(excursio);
    }




    public Iterable< Pair<String, Integer> > cercaExcursionsPair (){
        return cextrem.cercaExcursionsPair();
    }

    public Iterable<String> cercaExcursions() {
        return cextrem.cercaExcursions();
    }



    public String isValidNameSoci(String username) {
        Soci Soci = carteraSocis.find(username);
        if (Soci!=null) return "Soci Validat";
        else return "Soci Desconegut";
    }
    public Excursio getExcursio(String nomExcursio){
       return cextrem.getExcursio(nomExcursio);
    }


    public String findActivitat(String activitat,String excursio){
      return cextrem.findActivitat(activitat,excursio);

    }
    public String getLinkLocalitzacio(String nomExcursio){
        return cextrem.getLinkLocalitzacio(nomExcursio);

    }
    public List<String> especies(String nomExcursio){
        return cextrem.especies(nomExcursio);
    }

    public void apuntarseActivitat(String nomExcursio,String nomActivitat,String nomUsuari){
        cextrem.apuntarseActivitat(nomExcursio,nomActivitat,nomUsuari);

    }
    public void guardaString(String nom1){
        this.nom = nom1;
    }
    public String recuperaString(){
       return this.nom;

    }
    public String[][] mostraReservades(){
        return cextrem.mostraReservades();
    }

    public String[][] mostraPagades(){return cextrem.mostraPagades();}

    public void pagarBizum(String act,String exc,String soci){
        cextrem.pagarBizum(act,exc,soci);
    }
    public void pagarCompteBancaria(String act, String exc, String soci){cextrem.pagarCompteBancaria(act,exc,soci);}
    public void pagarPayPal(String act, String exc, String soci){cextrem.pagarPayPal(act,exc,soci);}

    public boolean isVisa(String visa){
        return cextrem.isVisa(visa);
    }
    public boolean isCodi(String codi) {
        return cextrem.isCodi(codi);
    }
    public boolean isCad(String cad) {
        return cextrem.isCad(cad);
    }













































}

