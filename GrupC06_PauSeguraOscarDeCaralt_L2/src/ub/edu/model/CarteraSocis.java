package ub.edu.model;

import java.util.List;

public class CarteraSocis {
    private List<Soci> llista;
    private String username;   // no existeix

    public CarteraSocis(List<Soci> allSocis) {
        llista = allSocis;
    }

    public Soci find(String username) {

        for (Soci c: llista) {
            if (c.getName().equals(username)) return c;
        }
        return null;

    }

    public List<Soci> getLlista() {
        return llista;
    }

    public void setLlista(List<Soci> llista) {
        this.llista = llista;
    }

    public String getUsername() {return username;}  // no existeix

    public void setUsername(String username) {  // tampoc existeix
        this.username = username;
    }
}
