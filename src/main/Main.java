package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private TabPane tabPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("Golf App");
        primaryStage.setScene(new Scene((Parent) root, 750, 750));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 750, 500);
        primaryStage.setScene(scene);

        TextField test = new TextField();

        Label l = new Label("Enter score");

        // action event
        EventHandler<ActionEvent> testEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l.setText(test.getText());
            }
        };

        // when enter is pressed
        test.setOnAction(testEvent);

        grid.add(test, 5, 5);
        grid.add(l, 5, 6);

        Button btn = new Button("Test");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        primaryStage.show();

        btn.setOnAction((calculate) -> {
            double ans = UtilityFunctions.calculateHole(70, 2);
            System.out.println(ans);
        });


        //Scene 2
        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to scene 1");
        button2.setOnAction(e -> primaryStage.setScene(scene));
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        Scene sceneTwo = new Scene(layout2,750,500);


        Button btnTwo = new Button("Test");
        HBox hbBtnTwo = new HBox(10);
        hbBtnTwo.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnTwo.getChildren().add(btnTwo);
        grid.add(hbBtnTwo, 2, 4);

        Button b3 = new Button("Go to scene 2");
        b3.setOnAction(e -> primaryStage.setScene(sceneTwo));
        grid.add(b3, 6, 6);

        btnTwo.setOnAction((event) -> {
            try {
                SceneController.switchToScene2(event);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
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
