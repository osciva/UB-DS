package ub.edu.resources.dao;

import ub.edu.model.Soci;

import java.util.List;
import java.util.Optional;

public interface DAOSoci extends DAO<Soci> {
    Soci findSociByUserNameAndPassword(String usuari, String pwd) throws Exception;

    public List<Soci> getAll();


    public Optional<Soci> getById(String id);

    public boolean add(final Soci soci);


    public boolean update(final Soci soci, String[] params);


    public boolean delete(final Soci soci);
}
