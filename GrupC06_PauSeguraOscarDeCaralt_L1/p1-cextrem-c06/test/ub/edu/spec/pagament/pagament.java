package ub.edu.spec.pagament;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class pagament {
    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String comanda(String soci, String compte){
        return controlador.pagarExcursio(soci, compte);
    }
}