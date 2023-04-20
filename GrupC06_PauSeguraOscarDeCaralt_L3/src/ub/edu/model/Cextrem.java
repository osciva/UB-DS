package ub.edu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Cextrem {

    private CarteraSocis carteraSocis;   // Model
    private LlistaExcursions llistaExcursions;
    private LlistaPagaments llistaPagaments;
    private LlistaComentaris llistaComentaris;
    private LlistaEspecies llistaEspecies;
    private Login login;

    private Map<String, Excursio> excursionsMap;

    public Cextrem() {
        iniCarteraSocis();
        iniExcursionsMap();
        iniPagaments();
        iniComentaris();
        iniEspecies();
        iniLogin();

    }



    public void iniCarteraSocis()  {
        List<Soci> listSocis = new ArrayList<>();
        listSocis.add(new Soci("ajaleo@gmail.com", "ajaleoPassw7"));
        listSocis.add( new Soci("dtomacal@yahoo.cat", "Qwertyft5"));
        listSocis.add(new Soci("heisenberg@gmail.com", "the1whoknocks"));
        listSocis.add(new Soci("rick@gmail.com", "wabalabadapdap22"));
        listSocis.add( new Soci("nietolopez10@gmail.com", "pekFD91m2a"));
        listSocis.add(new Soci("nancyarg10@yahoo.com", "contra10LOadc"));
        listSocis.add( new Soci("CapitaCC@gmail.com", "Alistar10"));
        listSocis.add( new Soci("nauin2@gmail.com", "kaynJGL20"));
        listSocis.add( new Soci("juancarlos999@gmail.com", "staIamsA12"));
        listSocis.add( new Soci("judit121@gmail.com", "Ordinador1"));

        carteraSocis = new CarteraSocis(listSocis);
    }

    public void iniExcursionsMap() {
        excursionsMap = new HashMap<>();
        addExcursio("Museu Miró", "29/09/2021");
        addExcursio( "La Foradada", "04/10/2021");
        addExcursio( "El camí des Correu", "10/10/2021");
        addExcursio("Delta de l'Ebre", "11/10/2021");
        addExcursio("El PedraForca", "13/10/2021");
        addExcursio("Colònia Güell", "22/10/2021");
        addExcursio("Castell de Cardona", "24/10/2021");
        addExcursio("Aiguamolls de l'Empordà", "27/10/2021");
        addExcursio("Cap de Creus i Cadaqués", "01/11/2021");
        addExcursio("Aigüestortes i Sant Maurici", "03/11/2021");
        llistaExcursions = new LlistaExcursions(excursionsMap);


    }
    public void iniComentaris(){
        llistaComentaris = new LlistaComentaris(llistaExcursions,carteraSocis);

    }
    public void iniEspecies(){
        llistaEspecies = new LlistaEspecies(llistaExcursions);
    }
    public void iniPagaments(){
        llistaPagaments = new LlistaPagaments(llistaExcursions,carteraSocis);
    }
    public void iniLogin(){
        login = new Login(carteraSocis);
    }


    public void addExcursio(String nom, String dataText){
        excursionsMap.put(nom, new Excursio(nom, dataText));
    }


    public void addActivitat(String nomExcursio, String nomActivitat, float preu) throws IllegalArgumentException {
                llistaExcursions.addActivitat(nomExcursio,nomActivitat,preu);
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


    public String validateUsername(String b) {
        return login.validateUsername(b);
    }

    public String validateRegisterSoci(String username, String password) {
        return login.validateRegisterSoci(username,password);
    }

    public String loguejarSoci(String username, String password){
        return login.loguejarSoci(username,password);
    }

    public String recuperarContrassenya(String username){
        return login.recuperarContrassenya(username);
    }


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

}
