package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene((javafx.scene.Parent) root, 750, 750));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 750, 500);
        primaryStage.setScene(scene);

        Button btn = new Button("Test");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        primaryStage.show();

        btn.setOnAction((event) -> {
            double ans = UtilityFunctions.calculateHole(70, 2);
            System.out.println(ans);
        });

//        MenuItem menuItem1 = new MenuItem("Action 1");
//        MenuItem menuItem2 = new MenuItem("Action 2");
//        MenuItem menuItem3 = new MenuItem("Action 3");
//
//        menuItem1.setOnAction((event) -> { System.out.println("MenuItem1 activated"); });
//        menuItem2.setOnAction((event) -> { System.out.println("MenuItem2 activated"); });
//        menuItem3.setOnAction((event) -> { System.out.println("MenuItem3 activated"); });
//
//        MenuButton menuButton = new MenuButton("Actions", null, menuItem1, menuItem2, menuItem3);
//
//
//        //second, more elaborate example of how a MenuButton can be created, and configured via setter methods
//        MenuButton menuButton2 = new MenuButton();
//        menuButton2.setText("More Actions");
//
//        MenuItem menuItem2_1 = new MenuItem("Action 1");
//        MenuItem menuItem2_2 = new MenuItem("Action 2");
//        MenuItem menuItem2_3 = new MenuItem("Action 3");
//
//        menuItem2_1.setOnAction((event) -> { System.out.println("MenuItem2_1 activated"); });
//        menuItem2_2.setOnAction((event) -> { System.out.println("MenuItem2_2 activated"); });
//        menuItem2_3.setOnAction((event) -> { System.out.println("MenuItem2_3 activated"); });
//
//        menuButton2.getItems().add(menuItem2_1);
//        menuButton2.getItems().add(menuItem2_2);
//        menuButton2.getItems().add(menuItem2_3);
//
//        VBox vbox = new VBox(menuButton, menuButton2);
//        Scene scene = new Scene(vbox);
//        primaryStage.setScene(scene);
//        primaryStage.setWidth (300);
//        primaryStage.setHeight(300);
//        primaryStage.show();
    }

    public void changeScene(String fxml){
        Parent pane = null;
        try {
            pane = FXMLLoader.load(
                    getClass().getResource(fxml));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        primaryStage.getScene().setRoot(pane);
    }
}
