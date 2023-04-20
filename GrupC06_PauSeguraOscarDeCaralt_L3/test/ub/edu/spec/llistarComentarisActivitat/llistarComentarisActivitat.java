package ub.edu.spec.llistarComentarisActivitat;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

import java.util.ArrayList;
import java.util.List;

@RunWith(ConcordionRunner.class)
public class llistarComentarisActivitat {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
        controlador.addActivitat("Delta de l'Ebre", "Ciclisme", (float) 35.4);
        controlador.addActivitat("Delta de l'Ebre", "Kayak", (float) 50);
        controlador.addActivitat("La Foradada", "Escalada", (float) 61.3);
    }

    public void initComentaris(String excursio, String activitat) {
        String[][] comentaris = {
                {"ajaleo@gmail.com", "Molt divertit!"},
                {"dtomacal@yahoo.cat", "Increible"},
                {"heisenberg@gmail.com", "Una mica esgotador..."}
        };
        for (String[] comentari : comentaris) {
            controlador.afegirCompteBancari(comentari[0], "ES66 6666 6666 6666");
            controlador.pagarActivitat(comentari[0], excursio, activitat);
            controlador.comentarActivitat(comentari[0], excursio, activitat, comentari[1]);
        }
    }

    public ArrayList<String> llistarComentaris(String excursio, String activitat) {
        return controlador.llistarComentaris(excursio, activitat);
    }
}
