package ub.edu.spec.llistaPagaments;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class llistaPagaments {
    private Controller controlador;


    @BeforeExample
    private void init() {
        controlador = new Controller();
    }
    public String listPagaments(String excursio) {
        return controlador.llistarPagaments(excursio);
    }

    public Iterable<String> listCatalegExcursionsPerData() {
        return controlador.llistarCatalegExcursionsPerData();
    }

}
