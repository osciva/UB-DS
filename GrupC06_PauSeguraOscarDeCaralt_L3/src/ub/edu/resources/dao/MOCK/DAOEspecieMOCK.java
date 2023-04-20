package ub.edu.resources.dao.MOCK;

import ub.edu.controller.Controller;
import ub.edu.model.Especie;
import ub.edu.resources.dao.DAOEspecie;

import java.util.*;

public class DAOEspecieMOCK implements DAOEspecie {

    private Map<String, Especie> llistaEspecies =  new HashMap<>();
    Controller controlador;

    public DAOEspecieMOCK() {
        addEspecie("Milà Reial");
        addEspecie("Llúdriga");
        addEspecie("Turó europeu");
        afegirEspecieExcursio("Llúdriga", "Museu Miró");
        afegirEspecieExcursio("Llúdriga", "La Foradada");
        afegirEspecieExcursio("Llúdriga", "El camí des Correu");
        afegirEspecieExcursio("Turó europeu", "Museu Miró");
        afegirEspecieExcursio("Turó europeu", "La Foradada");
    }

    @Override
    public void addEspecie(String nom) {
        llistaEspecies.put(nom, new Especie(nom));

    }

    public void afegirEspecieExcursio(String nom, String excursio){
        try {
           // controlador.afegirEspecieExcursio(nom,excursio);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void afegirEspecies(String nomEspecie) {
        try {
            llistaEspecies.put(nomEspecie,new Especie(nomEspecie));
        } catch (Exception e) {
            e.printStackTrace();
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

