package ub.edu.resources.service;

import ub.edu.resources.dao.DAOCarteraSocis;
import ub.edu.resources.dao.DAOSoci;
import ub.edu.resources.dao.DAOExcursio;
import ub.edu.resources.dao.DAOEspecie;


public interface AbstractFactoryData {
     DAOSoci createDAOSoci();
     DAOExcursio createDAOExcursio();
     DAOEspecie createDAOEspecie();


}
