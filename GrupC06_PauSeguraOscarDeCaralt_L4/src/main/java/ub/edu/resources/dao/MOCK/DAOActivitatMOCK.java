package ub.edu.resources.dao.MOCK;

import javafx.scene.chart.Axis;
import ub.edu.model.Activitat;
import ub.edu.model.Especie;
import ub.edu.model.Excursio;
import ub.edu.resources.dao.DAOActivitat;

import java.nio.channels.AcceptPendingException;
import java.util.*;

public class DAOActivitatMOCK implements DAOActivitat {
    private Map<String, Activitat> llistaActivitat = new HashMap<>();

     public DAOActivitatMOCK(List<Excursio> llista){
         addActivitat("Delta de l'Ebre", "Ciclisme", (float) 35.4,llista);
         addActivitat("Delta de l'Ebre", "Kayak", (float) 50,llista);
         addActivitat("La Foradada", "Escalada", (float) 61.3,llista);
         addActivitat("Castell de Cardona", "Muntar a Cavall",(float) 23,llista);
         addActivitat("Museu Miró",  "Taller de pintura", (float) 14,llista);
         addActivitat("La Foradada", "Dibuixar paisatge", (float) 7.67,llista);
         addActivitat("El camí des Correu", "Collir bolets", (float) 10,llista);
         addActivitat("Delta de l'Ebre", "Ruta en bici", (float) 40,llista);
         addActivitat("El PedraForca", "Observació d'aus", (float) 15,llista);
         addActivitat("Colònia Güell", "Xerrada amb historiadors", (float) 10,llista);
         addActivitat("Aiguamolls de l'Empordà", "Buscar granotes", (float) 8,llista);
         addActivitat("Cap de Creus i Cadaqués", "Casa de Dalí", (float) 25,llista);
         addActivitat("Aigüestortes i Sant Maurici", "Observar marmotes",(float) 18,llista);
     }
    private void addActivitat(String nomExcursio,String activitat, float preu, List<Excursio> llista){
         for(Excursio exc : llista){
             if(exc.getNom().equals(nomExcursio)){
                 exc.addActivitat(activitat,preu);
                 llistaActivitat.put(nomExcursio,new Activitat(nomExcursio,activitat,preu));
             }
         }
     }
    @Override
    public List<Activitat> getAll() {
        return new ArrayList<>(llistaActivitat.values());
    }
    @Override
    public Optional<Activitat> getById(String id) {
        return Optional.ofNullable(llistaActivitat.get(id));
    }

    @Override
    public boolean add(final Activitat activitat) {

        if (getById(activitat.getNom()).isPresent()) {
            return false;
        }
        llistaActivitat.put(activitat.getNomExcursio(), activitat);
        return true;
    }

    @Override
    public boolean update(final Activitat activitat, String[] params) {
        activitat.setNom(Objects.requireNonNull(
                params[0], "Title cannot be null"));
        return llistaActivitat.replace(activitat.getNomExcursio(), activitat) != null;
    }

    @Override
    public boolean delete(final Activitat activitat) {
        return llistaActivitat.remove(activitat.getNom()) != null;
    }
}





