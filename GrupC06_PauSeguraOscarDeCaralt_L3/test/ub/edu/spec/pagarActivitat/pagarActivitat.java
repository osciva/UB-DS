package ub.edu.spec.pagarActivitat;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class pagarActivitat {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
        controlador.addActivitat("Delta de l'Ebre", "Ciclisme", (float) 35.4);
        controlador.addActivitat("Delta de l'Ebre", "Kayak", (float) 50);
        controlador.addActivitat("La Foradada", "Escalada", (float) 61.3);
    }

    public void afegirBizum(String nomSoci, String telefon) {
        controlador.afegirBizum(nomSoci, telefon);
    }

    public void afegirCompteBancari(String nomSoci, String iban) {
        controlador.afegirCompteBancari(nomSoci, iban);
    }

    public String pagarActivitat(String nomSoci, String nomExcursio, String nomActivitat) {
        return controlador.pagarActivitat(nomSoci, nomExcursio, nomActivitat);
    }



}
