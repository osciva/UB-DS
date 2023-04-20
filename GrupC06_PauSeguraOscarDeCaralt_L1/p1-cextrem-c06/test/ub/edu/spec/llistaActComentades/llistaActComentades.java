package ub.edu.spec.llistaActComentades;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class llistaActComentades {
    private Controller controlador;


    @BeforeExample
    private void init() {
        controlador = new Controller();
    }
    /*public String comentades() {
        return controlador.llistarActivitats();


    }
*/
}
