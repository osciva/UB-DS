package ub.edu.resources.service;

import ub.edu.model.Excursio;
import ub.edu.model.Soci;
import ub.edu.model.Especie;
import ub.edu.resources.dao.DAOCarteraSocis;
import ub.edu.resources.dao.DAOEspecie;
import ub.edu.resources.dao.DAOExcursio;
import ub.edu.resources.dao.DAOSoci;

import java.util.List;
import java.util.Optional;

public class DataService {
    private DAOExcursio daoExcursio;
    private DAOSoci daoSoci;
    private DAOEspecie daoEspecie;
    private DAOCarteraSocis daoCarteraSocis;


    public DataService(AbstractFactoryData factory) {

        this.daoSoci = factory.createDAOSoci();
        this.daoExcursio = factory.createDAOExcursio();
        this.daoEspecie = factory.createDAOEspecie();



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
    public Optional<Excursio> getExcursioByName(String nom) throws Exception{
        return daoExcursio.getById(nom);

    }
    public Optional<Especie> getEspecieByName(String nom) throws Exception{
        return daoEspecie.getById(nom);
    }
    public List<Especie> getAllEspecies() throws Exception{
        return daoEspecie.getAll();
    }

}