package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HighscoreController {

    public ListView hsListView;
    private DAO dao = DAO.getInstance();

    @FXML
    public void initialize() {
        hsListView.setItems(dao.getHighscores());
    }

    public HighscoreController() {}

    public void backAction(ActionEvent actionEvent) throws IOException {
        MainController ctrl = new MainController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setController(ctrl);

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Main");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();

        Node node = (Node) actionEvent.getSource();
        Stage currStage = (Stage) node.getScene().getWindow();
        currStage.close();
    }

    public void deleteHighScoresAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Upozorenje");
        alert.setHeaderText("Jeste li sigurni da želite obrisati sve rezultate?");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Da");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Odustani");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            dao.deleteAllHighscores();
            hsListView.getItems().clear();
        }
    }
}
