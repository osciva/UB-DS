package ub.edu.model;


public class Soci {
    private String pwd;
    private String nom;
    private String compte;


    public Soci(String nom, String pwd, String compte) {
        this.pwd = pwd;
        this.nom = nom;
        this.compte = compte;
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

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }
}
