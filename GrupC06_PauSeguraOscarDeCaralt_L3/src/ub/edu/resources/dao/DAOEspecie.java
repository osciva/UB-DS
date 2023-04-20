package ub.edu.resources.dao;

import ub.edu.model.Especie;

import java.util.List;
import java.util.Optional;

public interface DAOEspecie extends DAO<Especie>
{
    public void addEspecie(String nom);

    public void afegirEspecieExcursio(String nom,String excursio);

    public void afegirEspecies(String nom);


    public List<Especie> getAll();


    public Optional<Especie> getById(String id);


    public boolean add(final Especie especie);


    public boolean update(final Especie especie, String[] params);


    public boolean delete(final Especie especie);

}
