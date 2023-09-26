import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerDesktop implements Initializable{
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private VBox yPane;

    @FXML
    private AnchorPane info;

    String opcions[] = { "Personatges", "Jocs", "Consoles" };

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        // Agrego las opciones al Choicebox
        choiceBox.getItems().addAll(opcions);
        //seleccionamos la primera opción
        choiceBox.setValue(opcions[0]);
        //
        choiceBox.setOnAction((event) -> { loadList(); });
        loadList();
    }

    public void loadList() {

        // Obtenir l'opció seleccionada
        String opcio = choiceBox.getValue();
    
        // Obtenir una referència a AppData que gestiona les dades
        AppData appData = AppData.getInstance();
    
        // Mostrar el missatge de càrrega
        showLoading();
    
        // Demanar les dades
        appData.load(opcio, (result) -> {
          if (result == null) {
              System.out.println("ControllerDesktop: Error loading.");
            } else {
              showList();
            }
          });
        }
        
    
    public void showList() throws Exception {

        String opcioSeleccionada = choiceBox.getValue();
    
        // Obtenir una referència a l'ojecte AppData que gestiona les dades
        AppData appData = AppData.getInstance();
    
        // Obtenir les dades de l'opció seleccionada
        JSONArray dades = appData.getData(opcioSeleccionada);

        // Esborrar la llista actual
        yPane.getChildren().clear();

        // Carregar la llista amb les dades
        for (int i = 0; i < dades.length(); i++) {
        JSONObject consoleObject = dades.getJSONObject(i);
            if (consoleObject.has("nom")) {
                String nom = consoleObject.getString("nom");
                Label label = new Label(nom);
                yPane.getChildren().add(label);
            }
        }
    }

}

