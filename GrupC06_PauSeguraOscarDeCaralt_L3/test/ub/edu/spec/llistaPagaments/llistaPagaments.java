package ub.edu.spec.llistaPagaments;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.Pagament;
import ub.edu.model.Soci;

import java.util.SortedSet;
import java.util.TreeSet;

@RunWith(ConcordionRunner.class)
public class llistaPagaments {

    private Controller controlador;

    @BeforeExample
    private void init() {
        controlador = new Controller();
        controlador.addActivitat("Delta de l'Ebre", "Ciclisme", (float) 35.4);
        controlador.addActivitat("Delta de l'Ebre", "Kayak", (float) 50);
        controlador.addActivitat("La Foradada", "Escalada", (float) 61.3);
    }

    public void initUser(String nomSoci) {
        controlador.afegirBizum(nomSoci, "666 666 666");
        controlador.pagarActivitat(nomSoci, "Delta de l'Ebre", "Ciclisme");
        controlador.pagarActivitat(nomSoci, "La Foradada", "Escalada");
        controlador.afegirCompteBancari(nomSoci, "ES66 6666 6666 6666");
        controlador.pagarActivitat(nomSoci, "Delta de l'Ebre", "Kayak");
    }

    public Iterable<String> llistarPagaments(String nomSoci) {
        return controlador.llistarPagaments(nomSoci);
    }

}
