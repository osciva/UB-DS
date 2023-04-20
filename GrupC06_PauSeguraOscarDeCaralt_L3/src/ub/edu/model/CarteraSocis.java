package ub.edu.model;

import java.util.List;

public class CarteraSocis {
    private List<Soci> llista;

    public CarteraSocis(List<Soci> allSocis) {
        llista = allSocis;
    }

    public Soci find(String username) {
        String result = username;

        for (Soci c: llista) {
            if (c.getName().equals(result)) return c;
        }
        return null;

    }

    public String afegirBizum(String nomSoci, String telefon){

        Soci soci = find(nomSoci);
        if(soci == null){
            return "Correu inexistent";
        }
        soci.setMetodePagament(new Bizum(telefon, ""));
        return "Success";
    }
    public String findSoci(String username) {
        Soci Soci = find(username);
        if (Soci!=null) return "Soci existent";
        else return "Soci Desconegut";
    }

    public String afegirCompteBancari(String nomSoci, String visa,String cad, String codi){
        Soci soci = find(nomSoci);
        if(soci == null){
            return "Correu inexistent";
        }
        soci.setMetodePagament(new CompteBancaria(visa,cad,codi));
        return "Success";
    }



}
