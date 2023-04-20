package ub.edu.model;

import java.util.ArrayList;

public class Soci {
    private String pwd;
    private String nom;
    private MetodePagament metodePagament;
    private final ArrayList<Pagament> activitatsComprades;

    public Soci(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        this.metodePagament = null;
        this.activitatsComprades = new ArrayList<>();
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

    public MetodePagament getMetodePagament() {
        return metodePagament;
    }

    public void setMetodePagament(MetodePagament metodePagament) {
        this.metodePagament = metodePagament;
    }

    public ArrayList<Pagament> getActivitatsComprades() {
        return activitatsComprades;
    }

    public Pagament addActivitatComprada(String nomExcursio, String nomActivitat) {
        Pagament pagament = new Pagament(nomExcursio, nomActivitat, getMetodePagament());
        activitatsComprades.add(pagament);
        return pagament;
    }
}
