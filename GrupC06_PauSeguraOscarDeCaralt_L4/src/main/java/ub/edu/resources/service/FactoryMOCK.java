package ub.edu.resources.service;

import ub.edu.model.Activitat;
import ub.edu.model.Excursio;
import ub.edu.resources.dao.DAOActivitat;
import ub.edu.resources.dao.DAOEspecie;
import ub.edu.resources.dao.DAOSoci;
import ub.edu.resources.dao.DAOExcursio;

import ub.edu.resources.dao.MOCK.DAOEspecieMOCK;
import ub.edu.resources.dao.MOCK.DAOExcursioMOCK;
import ub.edu.resources.dao.MOCK.DAOSociMOCK;
import ub.edu.resources.dao.MOCK.DAOActivitatMOCK;
import java.util.List;
import java.util.Optional;


public class FactoryMOCK implements AbstractFactoryData {

    @Override
    public DAOSoci createDAOSoci() {
        return new DAOSociMOCK();
    }

    @Override
    public DAOExcursio createDAOExcursio() {
        return new DAOExcursioMOCK();
    }

    // TO DO crear els altres DAOs de les altres classes
    @Override
    public DAOEspecie createDAOEspecie(List<Excursio> llista) {
        return new DAOEspecieMOCK(llista);
    }
    @Override
    public DAOActivitat createDAOActivitat(List<Excursio> llista){
        return new DAOActivitatMOCK(llista);

    }

}
