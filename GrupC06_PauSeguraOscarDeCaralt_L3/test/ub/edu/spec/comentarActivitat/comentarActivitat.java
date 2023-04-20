package ub.edu.spec.comentarActivitat;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class comentarActivitat {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
        controlador.addActivitat("Delta de l'Ebre", "Ciclisme", (float) 35.4);
        controlador.addActivitat("Delta de l'Ebre", "Kayak", (float) 50);
        controlador.addActivitat("La Foradada", "Escalada", (float) 61.3);
    }

    public void initUser(String nomSoci) {
        controlador.afegirCompteBancari(nomSoci, "ES66 6666 6666 6666");
        controlador.pagarActivitat(nomSoci, "Delta de l'Ebre", "Ciclisme");
    }

    public String comentarActivitat(String user, String excursio, String activitat, String comentari) {
        return controlador.comentarActivitat(user, excursio, activitat, comentari);
    }
}
