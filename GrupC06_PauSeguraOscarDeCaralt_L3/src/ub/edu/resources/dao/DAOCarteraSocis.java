package ub.edu.resources.dao;
import ub.edu.model.CarteraSocis;
import ub.edu.model.Soci;

import java.util.List;
import java.util.Optional;

public interface DAOCarteraSocis extends DAO<CarteraSocis> {


    public void addCarteraSocis(List<Soci> carteraSocis);

    public Optional<CarteraSocis> getById(String id);

    public List<CarteraSocis> getAll();

    public boolean add(final CarteraSocis carteraSocis);

    public boolean update(final CarteraSocis carteraSocis, String[] params);

    public boolean delete(final CarteraSocis carteraSocis)throws Exception;


}
