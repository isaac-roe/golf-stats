package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Controller {

//    public void start(Stage outStage) throws IOException {
//// Setting title to screen
//        outStage.setTitle("FXML Controller Button with CSS Styles");
//// Creating FXML Loader instance
//        FXMLLoader loader = new FXMLLoader();
//// FXML path
//        String fxmlActualPath = "C://Users//paramesh//Desktop//Desktop//Verinon Purpose//FXMLController//src//com//fxml//controller/FXMLLabelAddingButtonController.fxml";
//// Setting FXML path
//        FileInputStream fxmlStream = new FileInputStream(fxmlActualPath);
//// Creating VBox to add FXML label and text fields
//        VBox vBox = (VBox) loader.load(fxmlStream);
//// Creating scene
//        Scene screen = new Scene(vBox, 500, 500);
//// Setting screen stage
//        outStage.setScene(screen);
//// Showing the screen
//        outStage.show();
//    }
//    public static void main(String[] args) {
//// inside JVM launch method calls start method
//        Application.launch(args);
//    }

    public static void buttonFunctions(ActionEvent actionEvent) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btnTwo = new Button("Test");
        HBox hbBtnTwo = new HBox(10);
        hbBtnTwo.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnTwo.getChildren().add(btnTwo);
        grid.add(hbBtnTwo, 2, 4);

        btnTwo.setOnAction((event) -> {
            try {
                SceneController.switchToScene1(event);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }
}
