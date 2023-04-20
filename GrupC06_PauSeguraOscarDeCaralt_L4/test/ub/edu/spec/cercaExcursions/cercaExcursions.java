package ub.edu.spec.cercaExcursions;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class cercaExcursions {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public Iterable<String> cercaExcursions() {
        return controlador.cercaExcursions();
    }

    public void afegirEspecies() {

    }

}
