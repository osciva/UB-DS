package ub.edu.controller;

import ub.edu.model.*;

import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {


    private Cextrem cextrem;
    private DataService dataService;





    public Controller() {

        cextrem = new Cextrem();
        AbstractFactoryData abstractFactoryData = new FactoryMOCK();
        dataService = new DataService(abstractFactoryData);

    }


    /**------------------------------------Mètodes Data Service----------------------------------------**/

    public Optional<Soci> getSociByUsername(String usuari) {

        return dataService.getSociByUsername(usuari);
    }

    public List<Soci> getAllSocis() throws Exception {
        return dataService.getAllSocis();
    }

    public List<Excursio> getAllExcursions() throws Exception {
        return dataService.getAllExcursions();
    }
    public Optional<Excursio> getExcursioByName(String nom) throws Exception{
        return dataService.getExcursioByName(nom);

    }
    public Optional<Especie> getEspecieByName(String nom) throws Exception{
        return dataService.getEspecieByName(nom);
    }
    public List<Especie> getAllEspecies() throws Exception{
        return dataService.getAllEspecies();
    }







   /**----------------------------------Mètodes CeXtrem------------------------------------------------**/
    public void addExcursio(String nom, String dataText){
        cextrem.addExcursio(nom,dataText);
    }


    public void addActivitat(String nomExcursio, String nomActivitat, float preu) throws IllegalArgumentException {
                cextrem.addActivitat(nomExcursio,nomActivitat,preu);
    }



    public Iterable<String> llistarCatalegExcursionsPerNom() {
        return cextrem.llistarCatalegExcursionsPerNom();
    }

    public Iterable<String> llistarCatalegExcursionsPerData(){
        return cextrem.llistarCatalegExcursionsPerData();
    }

    public String findSoci(String username) {return cextrem.findSoci(username);}


    public String validatePassword(String b) {
       return cextrem.validatePassword(b);
    }


    public String validateUsername(String b) {
        return cextrem.validateUsername(b);
    }

    public String validateRegisterSoci(String username, String password) {
        return cextrem.validateRegisterSoci(username,password);
    }

    public String loguejarSoci(String username, String password){
        return cextrem.loguejarSoci(username,password);
    }

    public String recuperarContrassenya(String username){
        return cextrem.recuperarContrassenya(username);
    }


    public Especie afegirEspecie(String nomEspecie){
        return cextrem.afegirEspecie(nomEspecie);
    }

    public void afegirEspecieExcursio(String nomEspecie, String nomExcursio){
        cextrem.afegirEspecieExcursio(nomEspecie,nomExcursio);

    }

    public Iterable<String> cercaExcursions(){
        return cextrem.cercaExcursions();
    }



    public void afegirBizum(String nomSoci, String telefon){cextrem.afegirBizum(nomSoci, telefon);}

    public String afegirCompteBancari(String nomSoci, String iban){
        return cextrem.afegirCompteBancari(nomSoci,iban);
    }

    public String pagarActivitat(String nomSoci, String nomExcursio, String nomActivitat) {
     return cextrem.pagarActivitat(nomSoci,nomExcursio,nomActivitat);
    }

    public Iterable<String> llistarPagaments(String nomSoci) {
        return cextrem.llistarPagaments(nomSoci);
    }

    public String comentarActivitat(String nomSoci, String nomExcursio, String nomActivitat, String comentari) {
        return cextrem.comentarActivitat(nomSoci,nomExcursio,nomActivitat,comentari);
    }

    public ArrayList<String> llistarComentaris(String nomExcursio, String nomActivitat) {
        return cextrem.llistarComentaris(nomExcursio,nomActivitat);
    }

    public ArrayList<String> top10ActivitatsPerComentaris() {
        return cextrem.top10ActivitatsPerComentaris();
    }
    public String stats(){return cextrem.stats();
    }
    public String pagaments(String nomSoci) {
        return cextrem.pagaments(nomSoci);
    }


}
