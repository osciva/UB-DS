package ub.edu.model;


import java.util.ArrayList;

public class Soci {
    private String pwd;
    private String nom;
    private final ArrayList<Pagament> activitatsReservades;
    private final ArrayList<Pagament> activitatsPagades;


    public Soci(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        this.activitatsReservades = new ArrayList<>();
        this.activitatsPagades = new ArrayList<>();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }


    public void addActivitatReservada(String nomExcursio, String nomActivitat) {
        Pagament pagament = new Pagament(nomExcursio, nomActivitat);

        activitatsReservades.add(pagament);



    }
    public void addActivitatPagada(String nomExcursio, String nomActivitat){
        Pagament pagament = new Pagament(nomExcursio,nomActivitat);
        pagament.setEstatPagat();
        activitatsPagades.add(pagament);
    }

    public ArrayList<Pagament> getActivitatsReservades() {
        return activitatsReservades;
    }
}
