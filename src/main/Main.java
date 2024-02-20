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

        // Scene 2 textfield and label setup
        Label scoreLab = new Label("Enter score for the hole");
        Label distLab = new Label("Enter distance for the hole");
        Label hole1 = new Label("Hole 1");
        Label hole2 = new Label("Hole 2");
        Label hole3 = new Label("Hole 3");
        Label hole4 = new Label("Hole 4");
        Label hole5 = new Label("Hole 5");
        Label hole6 = new Label("Hole 6");
        Label hole7 = new Label("Hole 7");
        Label hole8 = new Label("Hole 8");
        Label hole9 = new Label("Hole 9");

        TextField h1Dist = new TextField();
        h1Dist.setMaxWidth(60);
        TextField h2Dist = new TextField();
        h2Dist.setMaxWidth(60);
        TextField h3Dist = new TextField();
        h3Dist.setMaxWidth(60);
        TextField h4Dist = new TextField();
        h4Dist.setMaxWidth(60);
        TextField h5Dist = new TextField();
        h5Dist.setMaxWidth(60);
        TextField h6Dist = new TextField();
        h6Dist.setMaxWidth(60);
        TextField h7Dist = new TextField();
        h7Dist.setMaxWidth(60);
        TextField h8Dist = new TextField();
        h8Dist.setMaxWidth(60);
        TextField h9Dist = new TextField();
        h9Dist.setMaxWidth(60);

        TextField h1Score = new TextField();
        h1Score.setMaxWidth(60);
        TextField h2Score = new TextField();
        h2Score.setMaxWidth(60);
        TextField h3Score = new TextField();
        h3Score.setMaxWidth(60);
        TextField h4Score = new TextField();
        h4Score.setMaxWidth(60);
        TextField h5Score = new TextField();
        h5Score.setMaxWidth(60);
        TextField h6Score = new TextField();
        h6Score.setMaxWidth(60);
        TextField h7Score = new TextField();
        h7Score.setMaxWidth(60);
        TextField h8Score = new TextField();
        h8Score.setMaxWidth(60);
        TextField h9Score = new TextField();
        h9Score.setMaxWidth(60);

        //Scene 2
        GridPane gridTwo = new GridPane();
        gridTwo.setAlignment(Pos.TOP_CENTER);
        gridTwo.setHgap(10);
        gridTwo.setVgap(10);
        gridTwo.setPadding(new Insets(25, 25, 25, 25));

        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to scene 1");
        button2.setOnAction(e -> primaryStage.setScene(scene));

        gridTwo.add(label2, 1, 0);
        gridTwo.add(button2, 2, 0);
        gridTwo.add(distLab, 1, 1);
        gridTwo.add(scoreLab, 2, 1);

        gridTwo.add(hole1, 0, 2);
        gridTwo.add(h1Dist, 1, 2);
        gridTwo.add(h1Score, 2, 2);

        gridTwo.add(hole2, 0, 3);
        gridTwo.add(h2Dist, 1, 3);
        gridTwo.add(h2Score, 2, 3);

        gridTwo.add(hole3, 0, 4);
        gridTwo.add(h3Dist, 1, 4);
        gridTwo.add(h3Score, 2, 4);

        gridTwo.add(hole4, 0, 5);
        gridTwo.add(h4Dist, 1, 5);
        gridTwo.add(h4Score, 2, 5);

        gridTwo.add(hole5, 0, 6);
        gridTwo.add(h5Dist, 1, 6);
        gridTwo.add(h5Score, 2, 6);

        gridTwo.add(hole6, 0, 7);
        gridTwo.add(h6Dist, 1, 7);
        gridTwo.add(h6Score, 2, 7);

        gridTwo.add(hole7, 0, 8);
        gridTwo.add(h7Dist, 1, 8);
        gridTwo.add(h7Score, 2, 8);

        gridTwo.add(hole8, 0, 9);
        gridTwo.add(h8Dist, 1, 9);
        gridTwo.add(h8Score, 2, 9);

        gridTwo.add(hole9, 0, 10);
        gridTwo.add(h9Dist, 1, 10);
        gridTwo.add(h9Score, 2, 10);

//        VBox layout2= new VBox(20);
//        layout2.getChildren().addAll(label2, button2, h1Dist, h1Score, h2Dist, h2Score);
        Scene sceneTwo = new Scene(gridTwo,750,500);

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
