package ub.edu.model;

import javafx.util.Pair;
import ub.edu.controller.SociStatus;

import java.time.LocalDate;
import java.util.*;


public class Cextrem {

    private CarteraSocis carteraSocis;   // Model
    private LlistaExcursions llistaExcursions;
    private LlistaPagaments llistaPagaments;
    private LlistaComentaris llistaComentaris;
    private Login login;
    private Top10 top10;


    private Map<String, Especie> especiesMap;

    public Cextrem(CarteraSocis carteraSocis, LlistaExcursions llistaExcursions, LlistaPagaments llistaPagaments,
                   Map<String,Especie> especiesMap, Login login,Top10 top10) {
            this.carteraSocis = carteraSocis;
            this.llistaExcursions = llistaExcursions;
            this.llistaPagaments = llistaPagaments;
            this.especiesMap = especiesMap;
            this.login = login;
            this.top10 = top10;

    }











    public Iterable<String> llistarCatalegExcursionsPerNom() {
        return llistaExcursions.llistarCatalegExcursionsPerNom();
    }

    public Iterable<String> llistarCatalegExcursionsPerData(){
        return llistaExcursions.llistarCatalegExcursionsPerData();
    }

    public String findSoci(String username) {return carteraSocis.findSoci(username);}

    public String validatePassword(String b) {
       return login.validatePassword(b);
    }
    public boolean isPasswordSegur(String password){
        return login.isPasswordSegur(password);
    }
    public boolean isMail(String correu){
        return login.isMail(correu);
    }


    public String validateUsername(String b) {
        return login.validateUsername(b);
    }
    public SociStatus registrarSoci(String username,String password){
        return login.RegistrarSoci(username,password);
    }
    public SociStatus loguejarSociStatus(String username, String password){
        return login.loguejarSociStatus(username,password);
    }





    public String recuperarContrassenya(String username){
        return login.recuperarContrassenya(username);
    }
    public LocalDate getDataExcursio(String excursio){
         return llistaExcursions.getExcursionsMap().get(excursio).getData();
    }
    public Iterable<Pair<String, Integer>> cercaExcursionsPair (){
        ArrayList<Pair<String, Integer>> especies = new ArrayList<>();

        if (especiesMap.size() == 0){
            return especies;
        }

        for (Especie especie : especiesMap.values()){
            especies.add(new Pair<>(especie.getNom(), comptarExcursionsEspecie(especie)));
        }

        return especies;
    }
    public Iterable<String> cercaExcursions(){
        SortedSet<java.lang.String> especies = new TreeSet<>();

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
        for (Excursio excursio : llistaExcursions.getExcursionsMap().values()){
            if(excursio.containsEspecie(especie)) count++;
        }
        return count;
    }
    public Excursio getExcursio(String nomExcursio){
        for(Excursio exc : llistaExcursions.getExcursionsMap().values()){
            if(exc.getNom().equals(nomExcursio))
                return exc;
        }
        return null;
    }
    public String findActivitat(String activitat,String excursio){
        Excursio exc = getExcursio(excursio);
        for(Activitat act : exc.getActivitatsMap().values()){
            if(act.getNom().equals(activitat)){
                return String.valueOf(act.getPreu());
            }

        }
        return null;

    }
    public String getLinkLocalitzacio(String nomExcursio){
        return getExcursio(nomExcursio).getLink();

    }
    public List<String> especies(String nomExcursio){
        return getExcursio(nomExcursio).especies();
    }


    public void apuntarseActivitat(String nomExcursio,String nomActivitat,String nomUsuari){
        llistaPagaments.apuntarseActivitat(nomExcursio,nomActivitat,nomUsuari);

    }
    public String[][] mostraReservades(){
        return top10.mostraReservades();
    }
    public String[][] mostraPagades(){
        return top10.mostraPagades();
    }
    public void pagarBizum(String act, String exc, String soci){
        llistaPagaments.pagament(act,exc,soci);
    }
    public void pagarCompteBancaria(String act, String exc, String soci){
        llistaPagaments.pagament(act,exc,soci);
    }
    public void pagarPayPal(String act, String exc, String soci){
        llistaPagaments.pagament(act,exc,soci);
    }


    public boolean isVisa(String visa){
        return login.isVisa(visa);
    }
    public boolean isCodi(String codi) {
        return login.isCodi(codi);
    }
    public boolean isCad(String cad) {
        return login.isCad(cad);
    }

    /*
    public Especie afegirEspecie(String nomEspecie){
        return llistaEspecies.afegirEspecie(nomEspecie);
    }

    public void afegirEspecieExcursio(String nomEspecie, String nomExcursio){
        llistaEspecies.afegirEspecieExcursio(nomEspecie,nomExcursio);

    }

    public Iterable<String> cercaExcursions(){
        return llistaEspecies.cercaExcursions();
    }



    public void afegirBizum(String nomSoci, String telefon){carteraSocis.afegirBizum(nomSoci, telefon);}

    public String afegirCompteBancari(String nomSoci, String iban){
        return carteraSocis.afegirCompteBancari(nomSoci,iban,"","");
    }

    public String pagarActivitat(String nomSoci, String nomExcursio, String nomActivitat) {
     return llistaPagaments.pagarActivitat(nomSoci,nomExcursio,nomActivitat);
    }

    public Iterable<String> llistarPagaments(String nomSoci) {
        return llistaPagaments.llistarPagaments(nomSoci);
    }

    public String comentarActivitat(String nomSoci, String nomExcursio, String nomActivitat, String comentari) {
        return llistaComentaris.comentarActivitat(nomSoci,nomExcursio,nomActivitat,comentari);
    }

    public ArrayList<String> llistarComentaris(String nomExcursio, String nomActivitat) {
        return llistaComentaris.llistarComentaris(nomExcursio,nomActivitat);
    }

    public ArrayList<String> top10ActivitatsPerComentaris() {
        return llistaComentaris.top10ActivitatsPerComentaris();
    }
    public String stats(){return llistaPagaments.stats();
    }
    public String pagaments(String nomSoci) {
        return llistaPagaments.pagaments(nomSoci);
    }
*/
}
