package ub.edu.model;

import java.util.ArrayList;
import java.util.List;

public class LlistaComentaris {
  private LlistaExcursions llistaExcursions;
  private CarteraSocis carteraSocis;



    public LlistaComentaris(LlistaExcursions llistaExcursions, CarteraSocis carteraSocis) {
        this.llistaExcursions = llistaExcursions;
        this.carteraSocis = carteraSocis;

    }
    public String comentarActivitat(String nomSoci, String nomExcursio, String nomActivitat, String comentari) {
        Soci soci = carteraSocis.find(nomSoci);
        if(soci == null){
            return "Correu inexistent";
        }
        Excursio excursio = llistaExcursions.getExcursionsMap().getOrDefault(nomExcursio, null);
        if (excursio == null) {
            return "Excursio no existent";
        }
        Activitat activitat = excursio.getActivitat(nomActivitat);
        if (activitat == null) {
            return "Activitat no existent";
        }

        Pagament compraActivitat = null;
        for (Pagament pagament : soci.getActivitatsComprades()) {
            if (pagament.getNomExcursio().equals(nomExcursio) && pagament.getNomActivitat().equals(nomActivitat)) {
                compraActivitat = pagament;
                break;
            }
        }
        if (compraActivitat == null) {
            return "L'activitat encara no ha estat comprada";
        }

        if (comentari.isEmpty()) {
            return "El text del comentari no pot ser buit";
        }
        activitat.addComentari(new Comentari(nomSoci, comentari));
        return "Comentari publicat";
    }
    public ArrayList<String> llistarComentaris(String nomExcursio, String nomActivitat) {
        ArrayList<String> comentarisOutput = new ArrayList<>();

        Excursio excursio = llistaExcursions.getExcursionsMap().getOrDefault(nomExcursio, null);
        if (excursio == null) {
            comentarisOutput.add("Excursio no existent");
            return comentarisOutput;
        }
        Activitat activitat = excursio.getActivitat(nomActivitat);
        if (activitat == null) {
            comentarisOutput.add("Activitat no existent");
            return comentarisOutput;
        }
        ArrayList<Comentari> comentaris = activitat.getComentaris();
        if (comentaris.size() == 0) {
            comentarisOutput.add("No hi ha comentaris");
            return comentarisOutput;
        }

        for (Comentari comentari : comentaris){
            comentarisOutput.add(comentari.getAutor() + ": " + comentari.getComentari());
        }

        return comentarisOutput;
    }
    public ArrayList<String> top10ActivitatsPerComentaris() {
        ArrayList<String> top10 = new ArrayList<>();

        List<Activitat> activitats = new ArrayList<>();
        for (Excursio excursio : llistaExcursions.getExcursionsMap().values()) {
            activitats.addAll(excursio.getActivitatsMap().values());
        }

        if (activitats.size() == 0) {
            top10.add("No hi ha activitats");
            return top10;
        }

        activitats.sort((a1, a2) -> a2.getComentaris().size() - a1.getComentaris().size());
        activitats = activitats.subList(0, Integer.min(activitats.size(),10));
        for (Activitat activitat : activitats) {
            String numComentaris;
            if (activitat.getComentaris().size() == 0) {
                numComentaris = "Sense";
            } else {
                numComentaris = Integer.toString(activitat.getComentaris().size());
            }

            top10.add(activitat.getNomExcursio() + " - " + activitat.getNom() + " - "
                    + numComentaris + " comentaris");
        }

        return top10;
    }







}
