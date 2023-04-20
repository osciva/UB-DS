package ub.edu.model;

import java.util.List;

public class CarteraSocis {
    private List<Soci> llista;

    public CarteraSocis(List<Soci> allSocis) {
        llista = allSocis;
    }

    public void addSoci (Soci soci){
        llista.add(soci);
    }

    public Soci find(String username) {

        for (Soci c: llista) {
            if (c.getName().equals(username)) return c;
        }
        return null;

    }
    public String findSoci(String username){

        Soci a = find(username);
        if (a!=null) return "Soci existent";
        else return "Soci Desconegut";
    }

    }


