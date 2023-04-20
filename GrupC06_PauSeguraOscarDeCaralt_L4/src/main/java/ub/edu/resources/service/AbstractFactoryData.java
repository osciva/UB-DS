package ub.edu.resources.service;

import ub.edu.model.Excursio;
import ub.edu.resources.dao.DAOActivitat;
import ub.edu.resources.dao.DAOEspecie;
import ub.edu.resources.dao.DAOSoci;
import ub.edu.resources.dao.DAOExcursio;

import java.util.List;

public interface AbstractFactoryData {
     DAOSoci createDAOSoci();
     DAOExcursio createDAOExcursio();

    DAOEspecie createDAOEspecie(List<Excursio> llista);

    DAOActivitat createDAOActivitat(List<Excursio> llista);
}
