package ub.edu.resources.service;

import ub.edu.resources.dao.DAOCarteraSocis;
import ub.edu.resources.dao.DAOEspecie;
import ub.edu.resources.dao.DAOSoci;
import ub.edu.resources.dao.DAOExcursio;


import ub.edu.resources.dao.MOCK.DAOEspecieMOCK;
import ub.edu.resources.dao.MOCK.DAOExcursioMOCK;
import ub.edu.resources.dao.MOCK.DAOSociMOCK;


public class FactoryMOCK implements AbstractFactoryData {

    @Override
    public DAOSoci createDAOSoci() {
        return new DAOSociMOCK();
    }

    @Override
    public DAOExcursio createDAOExcursio() {
        return new DAOExcursioMOCK();
    }

    @Override
    public DAOEspecie createDAOEspecie() { return new DAOEspecieMOCK();}

    }


    // TO DO crear els altres DAOs de les altres classes

