package ub.edu.spec.comentarExcursio;


import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class comentarExcursio {

    private Controller controlador;


    @BeforeExample
    private void init() {
        controlador = new Controller();
    }

    public String comentar(String excursio, String text, boolean pagat) {
        return controlador.comentar(excursio, text, pagat);

    }
}