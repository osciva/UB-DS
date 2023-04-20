package ub.edu.resources.dao;

import ub.edu.model.Excursio;

import java.util.List;
import java.util.Optional;

public interface DAOExcursio extends DAO<Excursio> {
    // Metodes especifics de excursions si es el cas

    public void addExcursio(String nom, String dataText);

    public List<Excursio> getAll();


    public Optional<Excursio> getById(String id);


    public boolean add(final Excursio excursio);


    public boolean update(final Excursio excursio, String[] params);


    public boolean delete(final Excursio excursio);

}
