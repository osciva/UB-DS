package ub.edu.resources.dao.MOCK;

import ub.edu.model.Excursio;
import ub.edu.resources.dao.DAOExcursio;

import java.util.*;

public class DAOExcursioMOCK implements DAOExcursio {

    private Map<String, Excursio> idexcursio = new HashMap<>();

    public DAOExcursioMOCK() {
        addExcursio("Museu Miró", "29/09/2021", "https://g.page/FundacioMiro?share");
        addExcursio( "La Foradada", "04/10/2021","https://goo.gl/maps/tGxKAHoz8igeXzgU6");
        addExcursio( "El camí des Correu", "10/10/2021","https://goo.gl/maps/be6ig7sAD5QMyc2X6");
        addExcursio("Delta de l'Ebre", "11/10/2021","https://goo.gl/maps/fVRavpUevidip3sH8");
        addExcursio("El PedraForca", "13/10/2021","https://goo.gl/maps/qgiX3HJ1NYqzbPhW6");
        addExcursio("Colònia Güell", "22/10/2021", "https://goo.gl/maps/vKCg5GaEMox8LHr38");
        addExcursio("Castell de Cardona", "24/10/2021","https://goo.gl/maps/SaaoyKhTNjS1biMV6");
        addExcursio("Aiguamolls de l'Empordà", "27/10/2021","https://goo.gl/maps/7TRFVfpvHhmWN9a59");
        addExcursio("Cap de Creus i Cadaqués", "01/11/2021", "https://goo.gl/maps/NBVF9MQuH8ZLt247A");
        addExcursio("Aigüestortes i Sant Maurici", "03/11/2021","https://goo.gl/maps/mmbuhevCFG78ZgP19");

    }

    private void addExcursio(String nom, String dataText,String link){
        idexcursio.put(nom, new Excursio(nom, dataText,link));
    }



    @Override
    public List<Excursio> getAll() {
        return new ArrayList<>(idexcursio.values());
    }

    @Override
    public Optional<Excursio> getById(String id) {
        return Optional.ofNullable(idexcursio.get(id));
    }

    @Override
    public boolean add(final Excursio excursio) {

        if (getById(excursio.getNom()).isPresent()) {
            return false;
        }
        idexcursio.put(excursio.getNom(), excursio);
        return true;
    }

    @Override
    public boolean update(final Excursio excursio, String[] params) {
        excursio.setNom(Objects.requireNonNull(
                params[0], "Title cannot be null"));
        return idexcursio.replace(excursio.getNom(), excursio) != null;
    }

    @Override
    public boolean delete(final Excursio excursio) {
        return idexcursio.remove(excursio.getNom()) != null;
    }
}
