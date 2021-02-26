package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

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
        dao.deleteAllHighscores();
        hsListView.getItems().clear();
    }
}
