package ub.edu.resources.dao.MOCK;

import ub.edu.model.Especie;
import ub.edu.model.Excursio;
import ub.edu.resources.dao.DAOEspecie;
import ub.edu.resources.dao.DAOExcursio;

import java.util.*;

public class DAOEspecieMOCK implements DAOEspecie {

    private Map<String, Especie> llistaEspecies = new HashMap<>();

    public DAOEspecieMOCK(List<Excursio> llista) {
        // TO DO Inicialitzar especies
        addEspecie("Llúdriga");
        addEspecie("Milà Reial");
        addEspecie("Turó europeu");
        addEspecie("Velociraptor");
        afegirEspecieExcursio("Velociraptor", "Delta de l'Ebre", llista);
        afegirEspecieExcursio("Llúdriga", "Museu Miró", llista);
        afegirEspecieExcursio("Llúdriga", "La Foradada", llista);
        afegirEspecieExcursio("Llúdriga", "El camí des Correu", llista);
        afegirEspecieExcursio("Milà Reial", "Aiguamolls de l'Empordà",llista);
        afegirEspecieExcursio("Turó europeu", "Museu Miró", llista);
        afegirEspecieExcursio("Turó europeu", "La Foradada", llista);

    }

    private void addEspecie(String nom){
        llistaEspecies.put(nom, new Especie(nom));
    }
    private void afegirEspecieExcursio(String nom, String nomExcursio,List<Excursio> llista){

    Especie especie;
        if(llistaEspecies.containsKey(nom)){
        especie = llistaEspecies.get(nom);
    }else{
        especie = new Especie(nom);
        llistaEspecies.put(nom, especie);
    }
        for(Excursio e : llista){
        if(e.getNom()==nomExcursio){
            e.addEspecie(especie);
            break;
        }
    }
}




    @Override
    public List<Especie> getAll() {
        return new ArrayList<>(llistaEspecies.values());
    }

    @Override
    public Optional<Especie> getById(String id) {
        return Optional.ofNullable(llistaEspecies.get(id));
    }

    @Override
    public boolean add(final Especie especie) {

        if (getById(especie.getNom()).isPresent()) {
            return false;
        }
        llistaEspecies.put(especie.getNom(), especie);
        return true;
    }

    @Override
    public boolean update(final Especie especie, String[] params) {
        especie.setNom(Objects.requireNonNull(
                params[0], "Title cannot be null"));
        return llistaEspecies.replace(especie.getNom(), especie) != null;
    }

    @Override
    public boolean delete(final Especie especie) {
        return llistaEspecies.remove(especie.getNom()) != null;
    }
}
