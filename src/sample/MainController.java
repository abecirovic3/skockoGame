package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MainController {

    public void startGameAction(ActionEvent actionEvent) throws IOException {
        GameController ctrl = new GameController(new GameModel());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
        loader.setController(ctrl);

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Game");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();

        Node node = (Node) actionEvent.getSource();
        Stage currStage = (Stage) node.getScene().getWindow();
        currStage.close();
    }

    public void closeGameAction(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage currStage = (Stage) node.getScene().getWindow();
        currStage.close();
    }

    public void viewHighscoresAction(ActionEvent actionEvent) throws IOException {
        HighscoreController ctrl = new HighscoreController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/highscores.fxml"));
        loader.setController(ctrl);

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Najbolji rezultati");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();

        Node node = (Node) actionEvent.getSource();
        Stage currStage = (Stage) node.getScene().getWindow();
        currStage.close();
    }
}
