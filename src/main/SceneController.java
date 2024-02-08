package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class SceneController {

    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//
//        .setTitle("Hello World");
//        stage.setScene(new Scene((Parent) root, 750, 750));
//        stage.show();
    }

    public static void switchToScene2(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(SceneController.class.getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
