package ub.edu.resources.service;

import ub.edu.model.Especie;
import ub.edu.model.Excursio;
import ub.edu.model.Soci;
import ub.edu.resources.dao.DAOActivitat;
import ub.edu.resources.dao.DAOEspecie;
import ub.edu.resources.dao.DAOExcursio;
import ub.edu.resources.dao.DAOSoci;

import java.util.List;
import java.util.Optional;

public class DataService {
    private DAOExcursio daoExcursio;
    private DAOSoci daoSoci;
    private DAOEspecie daoEspecie;
    private DAOActivitat daoActivitat;


    public DataService(AbstractFactoryData factory) {

        this.daoSoci = factory.createDAOSoci();
        this.daoExcursio = factory.createDAOExcursio();
        // TO DO: Crear el DAOEspecie
        try {
            this.daoEspecie = factory.createDAOEspecie(daoExcursio.getAll());
            this.daoActivitat = factory.createDAOActivitat(daoExcursio.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TO DO: Crear els altres DAO de les altres estructures
    }


    public Optional<Soci> getSociByUsername(String usuari) {
        try {
            return daoSoci.getById(usuari);
        } catch (Exception e) {
            //TODO
        }
        return null;
    }

    public List<Soci> getAllSocis() throws Exception {
        return daoSoci.getAll();
    }

    public List<Excursio> getAllExcursions() throws Exception {
        return daoExcursio.getAll();
    }

    public List<Especie> getAllEspecies() throws Exception {
        return daoEspecie.getAll();
    }
}