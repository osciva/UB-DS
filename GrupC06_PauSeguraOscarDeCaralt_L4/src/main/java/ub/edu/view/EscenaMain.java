package ub.edu.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EscenaMain extends Escena {
    private static final double ESPAI_ENTRE_BOTONS = 30;

    public Button excursio_btn;
    public AnchorPane excursions_pane;
    public TableColumn excursioFetaColumn;
    public TableView tableTop10Fetes;
    public TableColumn activitatFetaColumn;
    public TableColumn vegadesFetaColumn;
    public TableView tableTop10Valorades;
    public TableColumn excursioValColumn;
    public TableColumn activitatValColumn;
    public TableColumn valoracioValColumn;

    public void start(){
        popularExcursionsPerNom();
        popularTopActivitatsFetes();
        popularTopActivitatsValorades();
    }

    /*
    * Aquesta inner Class la associarem als items de la taula en el mètode popularTopActivitatsFetes
    * Seguir aquesta estructura per popular taules
    * */
    public static class ActivitatTop {
        //Cal deixar aquests atributs com finals per poder popular la taula en el mètode popularTopActivitatsFetes
        private final SimpleStringProperty nomExcursio;
        private final SimpleStringProperty nomActivitat;
        private final SimpleStringProperty puntuacio;
        ActivitatTop(String nomExcursio, String nomActivitat, Integer puntuacio){
            this.nomExcursio = new SimpleStringProperty(nomExcursio); //Excursió a la qual pertany l'activitat
            this.nomActivitat = new SimpleStringProperty(nomActivitat);
            this.puntuacio = new SimpleStringProperty(puntuacio.toString());
        }

        public String getNomExcursio() {
            return nomExcursio.get();
        }

        public String getNomActivitat() {
            return nomActivitat.get();
        }

        public String getPuntuacio() {
            return puntuacio.get();
        }
    }
    private void popularTopActivitatsFetes() {
        //Aquí posem a quins atributs de la classe EspecieVista correspon cada columna de la taula:
        excursioFetaColumn.setCellValueFactory(new PropertyValueFactory<ActivitatTop, String>("nomExcursio"));
        activitatFetaColumn.setCellValueFactory(new PropertyValueFactory<ActivitatTop, String>("nomActivitat"));
        vegadesFetaColumn.setCellValueFactory(new PropertyValueFactory<ActivitatTop, String>("puntuacio"));
        String[][] array = controller.mostraReservades();
        // TODO: Fer canvis per no mostrar dades dummy
        for (int i = 0; i < 10; i++){
            int val = Integer.parseInt(array[i][2]);

            tableTop10Fetes.getItems().add(new ActivitatTop(array[i][0], array[i][1],val));
        }
    }

    private void popularTopActivitatsValorades() {
        //Aquí posem a quins atributs de la classe EspecieVista correspon cada columna de la taula:
        excursioValColumn.setCellValueFactory(new PropertyValueFactory<ActivitatTop, String>("nomExcursio"));
        activitatValColumn.setCellValueFactory(new PropertyValueFactory<ActivitatTop, String>("nomActivitat"));
        valoracioValColumn.setCellValueFactory(new PropertyValueFactory<ActivitatTop, String>("puntuacio"));
        String [][] array = controller.mostraPagades();
        // TODO: Fer canvis per no mostrar dades dummy
        for (int i = 0; i < 10; i++){
            int val = Integer.parseInt(array[i][2]);
            tableTop10Valorades.getItems().add(new ActivitatTop(array[i][0], array[i][1], val));
        }
    }

    private void popularExcursionsPerNom(){
        // TODO: Aquest mètode únicament mostra la llista d'excursions sense ordenar.
        // Cal modificar el mètode llistarCatalegExcursionsPerNom del controlador
        Iterable<String> excursions = controller.llistarCatalegExcursionsPerNom();
        popularExcursions(excursions);
    }

    private void popularExcursionsPerData(){
        // TODO: Aquest mètode únicament mostra la llista d'excursions sense ordenar.
        // Cal modificar el mètode llistarCatalegExcursionsPerData del controlador
        Iterable<String> excursions = controller.llistarCatalegExcursionsPerData();
        popularExcursions(excursions);
    }

    private void popularExcursions(Iterable<String> iterableExcursions){
        List<Node> excursionsPaneChildren = excursions_pane.getChildren();

        double width = excursio_btn.getWidth();
        double height = excursio_btn.getHeight();
        double layoutX = excursio_btn.getLayoutX();
        double layoutY = excursio_btn.getLayoutY();
        //Instanciem un botó per cada excursió
        for (String excursio : iterableExcursions){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String data = controller.getDataExcursio(excursio).format(formatter);
            Button new_btn = createExcursioButton(excursio, data + " | " + excursio, width, height, layoutX, layoutY);
            excursionsPaneChildren.add(new_btn);
            layoutY += ESPAI_ENTRE_BOTONS;
        }
        //Actualitzem la mida del pane que conté els botons perque es pugui fer scroll cap abaix si hi ha més botons dels que caben al pane
        excursions_pane.setPrefHeight(layoutY);
        //Esborrem excursio_btn, que l'utilitzavem únicament com a referència per la mida dels botons
        excursionsPaneChildren.remove(excursio_btn);
    }

    /*
    * Crea un botó de dimensions width x height, colocat a la posició (layoutX, layoutY)
    * */
    private Button createExcursioButton(String excursio, String text, double width, double height, double layoutX, double layoutY){
        Button new_btn = new Button();
        new_btn.setPrefWidth(width);
        new_btn.setPrefHeight(height);
        new_btn.setText(text);
        new_btn.setLayoutX(layoutX);
        new_btn.setLayoutY(layoutY);
        new_btn.setAlignment(Pos.BASELINE_LEFT);
        new_btn.setOnMouseClicked(event ->
        {
            if (event.getButton() == MouseButton.PRIMARY)
            {
                try {
                    mostrarFinestraExcursio(excursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (event.getButton() == MouseButton.SECONDARY)
            {
                try {
                    mostrarFinestraActivitatsExcursio(excursio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return new_btn;
    }

    private void mostrarFinestraExcursio(String excursio) throws IOException {
        //Nova finestra
        Escena escena = EscenaFactory.INSTANCE.creaEscena("excursio-view", excursio);
        EscenaExcursio escenaExcursio = ((EscenaExcursio)escena);
        escenaExcursio.setController(controller);
        escenaExcursio.setExcursio(excursio);
    }

    private void mostrarFinestraActivitatsExcursio(String excursio) throws IOException {
        //Nova finestra
        Escena escena = EscenaFactory.INSTANCE.creaEscena("activitatsexcursio-view", excursio);
        EscenaActivitatsExcursio escenaActExcursio = ((EscenaActivitatsExcursio)escena);
        escenaActExcursio.setController(controller);
        escenaActExcursio.setExcursio(excursio);
    }

    public void onOrdenarPerNomButtonClick(ActionEvent actionEvent) {
        buidarExcursions();
        popularExcursionsPerNom();
    }

    public void onOrdenarPerDataButtonClick(ActionEvent actionEvent) {
        buidarExcursions();
        popularExcursionsPerData();
    }

    private void buidarExcursions(){
        List<Node> excursionsPaneChildren = excursions_pane.getChildren();
        for (int i = 0; i < excursionsPaneChildren.size(); i++){
            excursionsPaneChildren.remove(excursionsPaneChildren.get(i));
        }
    }

}
