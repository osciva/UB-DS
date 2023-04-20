package ub.edu.model;


import java.util.ArrayList;
import java.util.Map;


public class Activitat {

    private String nomExcursio;
    private String nom;
    private float preu;
    private int apuntats = 0;
    private int pagaments = 0;
    private ArrayList<Comentari> comentaris;


    public Activitat(){

    }


    public Activitat(String nomExcursio, String nom, float preu) {
        this.nomExcursio = nomExcursio;
        this.nom = nom;
        this.preu = preu;
        this.apuntats = apuntats;
        this.pagaments = pagaments;
        this.comentaris = new ArrayList<>();




    }


    public String getNomExcursio() {
        return nomExcursio;
    }

    public String getNom() {
        return nom;
    }

    public void setNomExcursio(String nomExcursio) {
        this.nomExcursio = nomExcursio;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    public ArrayList<Comentari> getComentaris() {
        return comentaris;
    }
    public void apuntarse(){
        apuntats += 1;
    }
    public int getApuntats(){
        return apuntats;
    }
    public void pagarBizum(){
        pagaments +=1;
    }
    public int getPagaments(){
        return pagaments;
    }


    public void addComentari(Comentari comentari) {
        comentaris.add(comentari);
    }
    public void addActivitat(String nomExcursio, String nomActivitat, float preu, Map<String,Excursio> excursionsMap) throws IllegalArgumentException{

        Excursio excursio = excursionsMap.get(nomExcursio);
        if (excursio == null) {throw new IllegalArgumentException("La excursio no existeix");}

        //excursio.addActivitat(nomActivitat, preu);
    }


}
