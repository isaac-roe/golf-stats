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
import javafx.scene.layout.Priority;
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
        TextField test2 = new TextField();

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
        grid.add(test2, 7, 7);
        grid.add(l, 5, 6);

        Button btn = new Button("Test");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 4);

        primaryStage.show();

        btn.setOnAction((calculate) -> {
//            double ans = UtilityFunctions.calculateHole(Integer.parseInt(test.getText()), Integer.parseInt(test2.getText()), );
//            System.out.println(ans);
        });

        // Scene 2 textfield and label setup
        Label scoreLab = new Label("Enter score for the hole");
        Label distLab = new Label("Enter distance to the hole");
        Label hole1 = new Label("Hole 1");
        Label hole2 = new Label("Hole 2");
        Label hole3 = new Label("Hole 3");
        Label hole4 = new Label("Hole 4");
        Label hole5 = new Label("Hole 5");
        Label hole6 = new Label("Hole 6");
        Label hole7 = new Label("Hole 7");
        Label hole8 = new Label("Hole 8");
        Label hole9 = new Label("Hole 9");
        Label hole10 = new Label("Hole 10");
        Label hole11 = new Label("Hole 11");
        Label hole12 = new Label("Hole 12");
        Label hole13 = new Label("Hole 13");
        Label hole14 = new Label("Hole 14");
        Label hole15 = new Label("Hole 15");
        Label hole16 = new Label("Hole 16");
        Label hole17 = new Label("Hole 17");
        Label hole18 = new Label("Hole 18");

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
        TextField h10Dist = new TextField();
        h10Dist.setMaxWidth(60);
        TextField h11Dist = new TextField();
        h11Dist.setMaxWidth(60);
        TextField h12Dist = new TextField();
        h12Dist.setMaxWidth(60);
        TextField h13Dist = new TextField();
        h13Dist.setMaxWidth(60);
        TextField h14Dist = new TextField();
        h14Dist.setMaxWidth(60);
        TextField h15Dist = new TextField();
        h15Dist.setMaxWidth(60);
        TextField h16Dist = new TextField();
        h16Dist.setMaxWidth(60);
        TextField h17Dist = new TextField();
        h17Dist.setMaxWidth(60);
        TextField h18Dist = new TextField();
        h18Dist.setMaxWidth(60);

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
        TextField h10Score = new TextField();
        h10Score.setMaxWidth(60);
        TextField h11Score = new TextField();
        h11Score.setMaxWidth(60);
        TextField h12Score = new TextField();
        h12Score.setMaxWidth(60);
        TextField h13Score = new TextField();
        h13Score.setMaxWidth(60);
        TextField h14Score = new TextField();
        h14Score.setMaxWidth(60);
        TextField h15Score = new TextField();
        h15Score.setMaxWidth(60);
        TextField h16Score = new TextField();
        h16Score.setMaxWidth(60);
        TextField h17Score = new TextField();
        h17Score.setMaxWidth(60);
        TextField h18Score = new TextField();
        h18Score.setMaxWidth(60);

        TextField h1s1 = new TextField(); h1s1.setMaxWidth(50);
        ChoiceBox h1s1loc = new ChoiceBox();
        h1s1loc.getItems().addAll("Tee", "Fairway", "Rough", "Green");
        ChoiceBox h1s2loc = new ChoiceBox();
        h1s2loc.getItems().addAll("Tee", "Fairway", "Rough", "Green");
        TextField h1s2 = new TextField(); h1s2.setMaxWidth(50);
        ChoiceBox h1s3loc = new ChoiceBox();
        h1s3loc.getItems().addAll("Tee", "Fairway", "Rough", "Green");
        TextField h1s3 = new TextField(); h1s3.setMaxWidth(50);
        ChoiceBox h1s4loc = new ChoiceBox();
        h1s4loc.getItems().addAll("Tee", "Fairway", "Rough", "Green");
        TextField h1s4 = new TextField(); h1s4.setMaxWidth(50);
        ChoiceBox h1s5loc = new ChoiceBox();
        h1s5loc.getItems().addAll("Tee", "Fairway", "Rough", "Green");
        TextField h1s5 = new TextField(); h1s5.setMaxWidth(50);
        ChoiceBox h1s6loc = new ChoiceBox();
        h1s6loc.getItems().addAll("Tee", "Fairway", "Rough", "Green");
        TextField h1s6 = new TextField(); h1s6.setMaxWidth(50);
        ChoiceBox h1s7loc = new ChoiceBox();
        h1s7loc.getItems().addAll("Tee", "Fairway", "Rough", "Green");
        TextField h1s7 = new TextField(); h1s7.setMaxWidth(50);


        //Scene 2
        GridPane gridTwo = new GridPane();
        gridTwo.setAlignment(Pos.TOP_CENTER);
        gridTwo.setHgap(10);
        gridTwo.setVgap(10);
        gridTwo.setPadding(new Insets(25, 25, 25, 25));

        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to main screen");
        button2.setOnAction(e -> primaryStage.setScene(scene));

        Button button3 = new Button("Indianola");
        button3.setOnAction((event) -> {
            h1Dist.setText("607"); h2Dist.setText("380"); h3Dist.setText("560");
            h4Dist.setText("187"); h5Dist.setText("560"); h6Dist.setText("360");
            h7Dist.setText("175"); h8Dist.setText("341"); h9Dist.setText("160");
            h10Dist.setText("348"); h11Dist.setText("340"); h12Dist.setText("363");
            h13Dist.setText("564"); h14Dist.setText("356"); h15Dist.setText("348");
            h16Dist.setText("120"); h17Dist.setText("330"); h18Dist.setText("205");
        });

        Label result = new Label("Strokes Gained: ");

        Button buttonCalculate9 = new Button("Calculate strokes gained.");
        buttonCalculate9.setOnAction((event) -> {

//            for (int i = Integer.parseInt(h1Score.getText()); i > 0; i--) {
//
//            }
            double sg1 = UtilityFunctions.calculateHole(Integer.parseInt(h1Dist.getText()), Integer.parseInt(h1s1.getText()),
                    "Tee", (String) h1s1loc.getValue());
            double sg2 = UtilityFunctions.calculateHole(Integer.parseInt(h1s1.getText()), Integer.parseInt(h1s2.getText()),
                    (String) h1s1loc.getValue(), (String) h1s2loc.getValue());
            double sg3 = UtilityFunctions.calculateHole(Integer.parseInt(h1s2.getText()), Integer.parseInt(h1s3.getText()),
                    (String) h1s2loc.getValue(), (String) h1s3loc.getValue());
            double sg4 = UtilityFunctions.calculateHole(Integer.parseInt(h1s3.getText()), Integer.parseInt(h1s4.getText()),
                    (String) h1s3loc.getValue(), (String) h1s4loc.getValue());
            double sg5 = UtilityFunctions.calculateHole(Integer.parseInt(h1s4.getText()), Integer.parseInt(h1s5.getText()),
                    (String) h1s4loc.getValue(), (String) h1s5loc.getValue());
//            double sg1 = UtilityFunctions.calculateHole(Integer.parseInt(h1Dist.getText()), Integer.parseInt(h1Score.getText()));
//            double sg2 = UtilityFunctions.calculateHole(Integer.parseInt(h2Dist.getText()), Integer.parseInt(h2Score.getText()));
//            double sg3 = UtilityFunctions.calculateHole(Integer.parseInt(h3Dist.getText()), Integer.parseInt(h3Score.getText()));
//            double sg4 = UtilityFunctions.calculateHole(Integer.parseInt(h4Dist.getText()), Integer.parseInt(h4Score.getText()));
//            double sg5 = UtilityFunctions.calculateHole(Integer.parseInt(h5Dist.getText()), Integer.parseInt(h5Score.getText()));
//            double sg6 = UtilityFunctions.calculateHole(Integer.parseInt(h6Dist.getText()), Integer.parseInt(h6Score.getText()));
//            double sg7 = UtilityFunctions.calculateHole(Integer.parseInt(h7Dist.getText()), Integer.parseInt(h7Score.getText()));
//            double sg8 = UtilityFunctions.calculateHole(Integer.parseInt(h8Dist.getText()), Integer.parseInt(h8Score.getText()));
//            double sg9 = UtilityFunctions.calculateHole(Integer.parseInt(h9Dist.getText()), Integer.parseInt(h9Score.getText()));
            System.out.println(sg1);

////            System.out.printf("%.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f",
////                    sg1, sg2, sg3, sg4, sg5, sg6, sg7, sg8, sg9);
//            double total = sg1 + sg2 + sg3 + sg4 + sg5 + sg6 + sg7 + sg8 + sg9;
            result.setText("Strokes Gained: " + String.format("%.2f, %.2f, %.2f, %.2f, %.2f", sg1, sg2, sg3, sg4, sg5));
            });

        gridTwo.add(label2, 1, 0);
        gridTwo.add(button2, 2, 0);
        gridTwo.add(distLab, 1, 1);
        gridTwo.add(scoreLab, 2, 1);
        gridTwo.add(button3, 3, 0);

        gridTwo.add(hole1, 0, 2);
        gridTwo.add(h1Dist, 1, 2);
        gridTwo.add(h1Score, 2, 2);

        gridTwo.add(h1s1, 1, 3);
        gridTwo.add(h1s1loc, 2, 3);
        gridTwo.add(h1s2, 1, 4);
        gridTwo.add(h1s2loc, 2, 4);
        gridTwo.add(h1s3, 1, 5);
        gridTwo.add(h1s3loc, 2, 5);
        gridTwo.add(h1s4, 1, 6);
        gridTwo.add(h1s4loc, 2, 6);
        gridTwo.add(h1s5, 1, 7);
        gridTwo.add(h1s5loc, 2, 7);
        gridTwo.add(h1s6, 1, 8);
        gridTwo.add(h1s6loc, 2, 8);
        gridTwo.add(h1s7, 1, 9);
        gridTwo.add(h1s7loc, 2, 9);

//        gridTwo.add(hole2, 0, 3);
//        gridTwo.add(h2Dist, 1, 3);
//        gridTwo.add(h2Score, 2, 3);
//
//        gridTwo.add(hole3, 0, 4);
//        gridTwo.add(h3Dist, 1, 4);
//        gridTwo.add(h3Score, 2, 4);
//
//        gridTwo.add(hole4, 0, 5);
//        gridTwo.add(h4Dist, 1, 5);
//        gridTwo.add(h4Score, 2, 5);
//
//        gridTwo.add(hole5, 0, 6);
//        gridTwo.add(h5Dist, 1, 6);
//        gridTwo.add(h5Score, 2, 6);
//
//        gridTwo.add(hole6, 0, 7);
//        gridTwo.add(h6Dist, 1, 7);
//        gridTwo.add(h6Score, 2, 7);
//
//        gridTwo.add(hole7, 0, 8);
//        gridTwo.add(h7Dist, 1, 8);
//        gridTwo.add(h7Score, 2, 8);
//
//        gridTwo.add(hole8, 0, 9);
//        gridTwo.add(h8Dist, 1, 9);
//        gridTwo.add(h8Score, 2, 9);
//
//        gridTwo.add(hole9, 0, 10);
//        gridTwo.add(h9Dist, 1, 10);
//        gridTwo.add(h9Score, 2, 10);
//
//        gridTwo.add(hole10, 0, 12);
//        gridTwo.add(h10Dist, 1, 12);
//        gridTwo.add(h10Score, 2, 12);
//
//        gridTwo.add(hole11, 0, 13);
//        gridTwo.add(h11Dist, 1, 13);
//        gridTwo.add(h11Score, 2, 13);

//        gridTwo.add(hole12, 0, 14);
//        gridTwo.add(h12Dist, 1, 14);
//        gridTwo.add(h12Score, 2, 14);
//
//        gridTwo.add(hole13, 0, 15);
//        gridTwo.add(h13Dist, 1, 15);
//        gridTwo.add(h13Score, 2, 15);
//
//        gridTwo.add(hole14, 0, 16);
//        gridTwo.add(h14Dist, 1, 16);
//        gridTwo.add(h14Score, 2, 16);
//
//        gridTwo.add(hole15, 0, 17);
//        gridTwo.add(h15Dist, 1, 17);
//        gridTwo.add(h15Score, 2, 17);
//
//        gridTwo.add(hole16, 0, 18);
//        gridTwo.add(h16Dist, 1, 18);
//        gridTwo.add(h16Score, 2, 18);
//
//        gridTwo.add(hole17, 0, 19);
//        gridTwo.add(h17Dist, 1, 19);
//        gridTwo.add(h17Score, 2, 19);
//
//        gridTwo.add(hole18, 0, 20);
//        gridTwo.add(h18Dist, 1, 20);
//        gridTwo.add(h18Score, 2, 20);

        gridTwo.add(buttonCalculate9, 1, 11);
        gridTwo.add(result, 2, 11);

//        ScrollPane sp = new ScrollPane(gridTwo);
//        gridTwo.add(sp, 0, 1);
//        GridPane.setHgrow(sp, Priority.ALWAYS);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridTwo);

//        root.getChildren().addAll(scrollPane);
//        scene.setRoot(root);


//        VBox layout2= new VBox(20);
//        layout2.getChildren().addAll(label2, button2, h1Dist, h1Score, h2Dist, h2Score);
        Scene sceneTwo = new Scene(scrollPane,750,500);

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
