package ub.edu.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Activitat extends Excursio{

    private static List<Activitat> activitatsMesComentades;
    private static List<Comentari> llistaComentaris;
    private static String idAct;
    private static String activitat;


    public Activitat (String titol,String dataText, String idAct, String activitat) {
        super(titol, dataText);
        this.idAct = idAct;
        this.activitat = activitat;
        activitatsMesComentades = new ArrayList<>();
        llistaComentaris = new ArrayList<>();
    }


    public String toString() {
        return "Activitat{" +
                "idAct='" + idAct + '\'' +
                ", activitat='" + activitat + '\'' +
                '}';
    }

    public static List<Activitat> getActivitatsMesComentades() {
        return activitatsMesComentades;
    }

    public void setActivitatsMesComentades(List<Activitat> activitatsMesComentades) {
        this.activitatsMesComentades = activitatsMesComentades;
    }

    public void addActivitat(Activitat activitat){ activitatsMesComentades.add(activitat); }

    public String tostring(){
        String info = "L'activitat " + super.getNom();
        return info;
    }

    public static List<Comentari> getLlistaComentaris() {
        return llistaComentaris;
    }

    public static void setLlistaComentaris(List<Comentari> llistaComentaris) {
        Activitat.llistaComentaris = llistaComentaris;
    }
    public static void addComentariAct(Comentari c){
        llistaComentaris.add(c);
    }

}


