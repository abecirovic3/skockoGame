package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.desktop.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MainController {

    public void startGameAction(ActionEvent actionEvent) throws IOException {
        GameController ctrl = new GameController(new GameModel());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
        loader.setController(ctrl);

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Skočko");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
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
        stage.setResizable(false);
        stage.show();

        Node node = (Node) actionEvent.getSource();
        Stage currStage = (Stage) node.getScene().getWindow();
        currStage.close();
    }

    public void viewInstructionsAction(ActionEvent actionEvent) throws IOException {
        InstructionController ctrl = new InstructionController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/instructions.fxml"));
        loader.setController(ctrl);

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Uputsva");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

        Node node = (Node) actionEvent.getSource();
        Stage currStage = (Stage) node.getScene().getWindow();
        currStage.close();
    }

    public void openLinkAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        String link;
        if (button.getId().equals("btnGithub"))
            link = "https://github.com/abecirovic3";
        else if (button.getId().equals("btnLinkedin"))
            link = "https://www.linkedin.com/in/ajdin-be%C4%8Dirovi%C4%87-bb83b6208/";
        else
            link = "https://www.facebook.com/ajdin.becirovic.1";

        try {
            URL url = new URL(link);
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(url.toURI());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
