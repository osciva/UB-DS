package ub.edu.controller;

import ub.edu.model.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private CarteraSocis carteraSocis;   // Model
    private Map<String, Excursio> excursionsMap;
    private Map<String, Especie> especiesMap;
    private Map<String, Pagament> pagamentMap;
    //private Map<String, Activitat> activitatsMap;
    //private Map<String, Comentari> comentarisActMap;


    public Controller() {
        iniCarteraSocis();
        iniExcursionsMap();
        especiesMap = new HashMap<>();
        iniPagamentsMap();
        //iniActivitatMap();
        //iniComentarisActMap();
    }

    public void iniCarteraSocis()  {
        List<Soci> listSocis = new ArrayList<>();
        listSocis.add(new Soci("ajaleo@gmail.com", "ajaleoPassw7", "1234"));
        listSocis.add( new Soci("dtomacal@yahoo.cat", "Qwertyft5", " 1342"));
        listSocis.add(new Soci("heisenberg@gmail.com", "the1whoknocks", "7648"));
        listSocis.add(new Soci("rick@gmail.com", "wabalabadapdap22", "2389"));
        listSocis.add( new Soci("nietolopez10@gmail.com", "pekFD91m2a", "8456"));
        listSocis.add(new Soci("nancyarg10@yahoo.com", "contra10LOadc","6434"));
        listSocis.add( new Soci("CapitaCC@gmail.com", "Alistar10","3546"));
        listSocis.add( new Soci("nauin2@gmail.com", "kaynJGL20","7771"));
        listSocis.add( new Soci("juancarlos999@gmail.com", "staIamsA12","6163"));
        listSocis.add( new Soci("judit121@gmail.com", "Ordinador1","9999"));

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
    }
    public void iniPagamentsMap() {
        pagamentMap = new HashMap<>();
        addPagament("ajaleo@gmail.com", 21, "1/10/2021", true);
        addPagament("dtomacal@yahoo.cat", 22, "2/10/2021", true);
        addPagament("heisenberg@gmail.com", 23, "3/10/2021", false);
        addPagament("heisenberg@gmail.com", 24, "4/10/2021", true);
        addPagament("nancyarg10@yahoo.com", 25, "5/10/2021", true);
        addPagament("juancarlos999@gmail.com", 26, "6/10/2021", false);
        addPagament("juancarlos999@gmail.com", 27, "7/10/2021", false);
        addPagament("dtomacal@yahoo.cat", 28, "8/10/2021", true);
        addPagament("nauin2@gmail.com", 29, "9/10/2021", false);
    }

   /* public void iniActivitatMap(){
        activitatsMap = new HashMap<>();
        addActivitat("Castell de Cardona", "Muntar a Cavall", "1");
        addActivitat("Museu Miró",  "Taller de pintura", "2");
        addActivitat("La Foradada", "Dibuixar paisatge", "3");
        addActivitat("El camí des Correu", "Collir bolets", "4");
        addActivitat("Delta de l'Ebre", "Ruta en bici", "5");
        addActivitat("El PedraForca", "Observació d'aus", "6");
        addActivitat("Colònia Güell", "Xerrada amb historiadors", "7");
        addActivitat("Aiguamolls de l'Empordà", "Buscar granotes", "8");
        addActivitat("Cap de Creus i Cadaqués", "Casa de Dalí", "9");
        addActivitat("Aigüestortes i Sant Maurici", "Observar marmotes", "10");
    }
    */

    /*
    public void iniComentarisActMap(){
        comentarisActMap = new HashMap<>();
        addComentariAct("Muntar a Cavall", "1", "M'ha agradat molt aquesta experiència");
        addComentariAct("Muntar a Cavall", "1", "No apte per porucs");
        addComentariAct("Muntar a Cavall", "1", "L'instructor era un maleducat");
        addComentariAct("Ruta en bici", "5", "Moltes caigudes, no la recomano, una estafa!!!!!");
        addComentariAct("Ruta en bici", "5", "Masses kilometres");


    }*/

   private void addExcursio(String nom, String dataText){
        excursionsMap.put(nom, new Excursio(nom, dataText));
    }

   private void addActivitat(String excursio, String activitat,String idAct){
        Excursio e = excursionsMap.get(excursio);
        Activitat a = new Activitat(e.getNom(),e.getDataText(),idAct,activitat);
        e.addActivitat(a);

   }
   /*private void addComentariAct(String activitat, String idAct, String comentari){
        Activitat a = activitatsMap.get(idAct);
        Comentari c = new Comentari(comentari);
        a.addComentariAct(c);

   }*/
    private List<Excursio> getExcursionsList(){
        return new ArrayList<>(excursionsMap.values());
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

    public String validateRegisterSoci(String username, String password) {
        if (isMail(username) && isPasswordSegur(password)) {
            Soci Soci = carteraSocis.find(username);
            if (Soci != null) {
                return "Soci Duplicat";
            } else return "Soci Validat";
        } else return "Format incorrecte";
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

        excursionsMap.get(nomExcursio).addEspecie(especie);

    }
    private void addPagament(String nom, float preu, String dataText, boolean pagat){
        pagamentMap.put(nom, new Pagament(dataText, preu));
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
    public String pagarExcursio(String soci, String compte) {
        Soci soci1 = carteraSocis.find(soci);
        if(soci1 == null){
            return "Error en el pagament";
        }
        String socinom = soci1.getName();
        if(!soci1.getCompte().equals(compte)){
            return "Error en el pagament";
        }else{
            return Pagament.comanda(socinom, compte);
        }





    }/*
    public String visualitzar(int idAct,String nomExcursio){
        Activitat a = activitatsMap.get(idAct);

        if(a.getLlistaComentaris().isEmpty()){
            return "No hi ha comemtaris disponibles";
        }
        String comentaris = "";
        for(Comentari c : a.getLlistaComentaris() ){
            comentaris = comentaris + idAct + ": " + c.getComentari() + "\n";
        }

        return comentaris;


    }*/


    public Pagament findPagament(String preu) {
        for (Pagament p : pagamentMap.values()) {
            if ((p.getExcursio().equals(preu))) return p;
        }
        return null;
    }

    public String llistarPagaments(String excursio){
        if(findPagament(excursio) == null){
            return "No hi ha cap pagament disponible";
        }
        Pagament p = findPagament(excursio);
        return p.llistarPagaments();
    }



    public Excursio findExcursio(String id) {
        for (Excursio e : excursionsMap.values()) {
            if (e.getNom().equals(id)) return e;
        }
        return null;
    }

    public String visualitzar(String excursio){
        if(findExcursio(excursio) == null){
            return "Excursió inexistent";
        }
        Excursio e = findExcursio(excursio);
        return e.llistarComentaris();
    }

    public String comentar(String excursio,String text,boolean pagat) {
        Excursio e = excursionsMap.get(excursio);
        if (text.isEmpty()) {
            return "No has escrit res";
        }
        else if (!pagat) {
            return "No es pot penjar el comentari perquè no has pagat l'excursió";

        }else {
            e.addComentari(text);

        }
        return text;
    }






/*
    public String llistarActivitats() {
        ;
        String activitats = "";
        if(Activitat.getActivitatsMesComentades().size() < 1){
            return "No hi ha activitats comentades";
        }
        else{
            for (int i = 0; i < Activitat.getActivitatsMesComentades().size(); i++) {
                activitats = activitats + Activitat.toString()+"\n";
            }
            return activitats;
        }

    }
   */
    /*public Iterable<String> llistarPagaments(Soci soci) {
        SortedSet<String> pagaments = new TreeSet<>();

        if (pagamentsMap.size() == 0){
            pagaments.add("No hi han cap pagament");
            return pagaments;
        }

        for (Pagament pagament : pagamentsMap.values()){
            pagaments.add(Soci.getLlistarPagaments() + "\n " );
        }

        return pagaments;
    }
}*/

}