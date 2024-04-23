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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private TabPane tabPane;
    private double sgTee = 0, sgApp = 0, sgAtg = 0, sgGrn = 0, sgTotal = 0;

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

//        TextField test = new TextField();
//        TextField test2 = new TextField();
//
//        Label l = new Label("Enter score");
//
//        // action event
//        EventHandler<ActionEvent> testEvent = new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent e)
//            {
//                l.setText(test.getText());
//            }
//        };

        // when enter is pressed
//        test.setOnAction(testEvent);
//
//        grid.add(test, 5, 5);
//        grid.add(test2, 7, 7);
//        grid.add(l, 5, 6);
//
//        Button btn = new Button("Test");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 4);

        primaryStage.show();

//        btn.setOnAction((calculate) -> {
////            double ans = UtilityFunctions.calculateHole(Integer.parseInt(test.getText()), Integer.parseInt(test2.getText()), );
////            System.out.println(ans);
//        });

        // Set up for all shot info for each hole.
        String[] locOpt = {"Tee", "Fairway", "Rough", "Sand", "Green"};
        TextField[] hole1Dists = new TextField[8];
        TextField[] hole2Dists = new TextField[8];
        ChoiceBox[] hole1Locs = new ChoiceBox[8];
        ChoiceBox[] hole2Locs = new ChoiceBox[8];
        for (int i = 0; i < 8; i++) {
            hole1Dists[i] = new TextField();
            hole1Dists[i].setMaxWidth(60);
            hole1Locs[i] = new ChoiceBox();
            hole1Locs[i].getItems().addAll(locOpt);
            hole2Dists[i] = new TextField();
            hole2Dists[i].setMaxWidth(60);
            hole2Locs[i] = new ChoiceBox();
            hole2Locs[i].getItems().addAll(locOpt);
        }

        // Scene and grid setup for each hole screen.
        GridPane[] holeGrids = new GridPane[19];
        Scene[] holeScenes = new Scene[19];
        Button[] nextHoleBtn = new Button[19];
        Button[] previousHoleBtn = new Button[19];
        Label[] holeNums = new Label[19];
        Label[] scoreLab = new Label[19];
        Label[] distLab = new Label[19];
        for (int i = 0; i <= 18; i++) {
            holeGrids[i] = new GridPane();
            holeGrids[i].setAlignment(Pos.TOP_CENTER);
            holeGrids[i].setHgap(10);
            holeGrids[i].setVgap(10);
            holeGrids[i].setPadding(new Insets(25, 25, 25, 25));
            holeScenes[i] = new Scene(holeGrids[i], 750, 500);
            previousHoleBtn[i] = new Button("Previous Hole");
            nextHoleBtn[i] = new Button("Hole " + (i + 1));
            int finalI = i + 1;
            if (i < 18) {
                nextHoleBtn[i].setOnAction(e -> primaryStage.setScene(holeScenes[finalI]));
            }
            previousHoleBtn[i].setOnAction(e -> primaryStage.setScene(holeScenes[finalI - 2]));
            holeNums[i] = new Label("Hole " + i);
            scoreLab[i] = new Label("Enter shot location");
            distLab[i] = new Label("Enter shot distance");
            holeGrids[i].add(holeNums[i], 0, 2);
            if (i < 18)
                holeGrids[i].add(nextHoleBtn[i], 2, 0);
            holeGrids[i].add(distLab[i], 1, 1);
            holeGrids[i].add(scoreLab[i], 2, 1);
            if (i > 1)
                holeGrids[i].add(previousHoleBtn[i], 1, 0);
        }

        // Set up for total results screen.
        GridPane totalGrid = new GridPane();
        totalGrid.setAlignment(Pos.TOP_CENTER);
        totalGrid.setHgap(10);
        totalGrid.setVgap(10);
        totalGrid.setPadding(new Insets(25, 25, 25, 25));
        Scene totalScene = new Scene(totalGrid, 750, 500);
        Button goToTotal = new Button("Finish");
        goToTotal.setOnAction(e -> primaryStage.setScene(totalScene));
        holeGrids[18].add(goToTotal, 2, 0);

        Label finalTee = new Label("Off the tee: ");
        Label finalApp = new Label("Approach: ");
        Label finalAtg = new Label("Around the green: ");
        Label finalGrn = new Label("Putting: ");
        Label finalTot = new Label("Total: ");
        finalTee.setFont(Font.font(20));
        finalApp.setFont(Font.font(20));
        finalAtg.setFont(Font.font(20));
        finalGrn.setFont(Font.font(20));
        finalTot.setFont(Font.font(20));
        Label finalTeeRes = new Label();
        Label finalAppRes = new Label();
        Label finalAtgRes = new Label();
        Label finalGrnRes = new Label();
        Label finalTotRes = new Label();
        finalTeeRes.setFont(Font.font(20));
        finalAppRes.setFont(Font.font(20));
        finalAtgRes.setFont(Font.font(20));
        finalGrnRes.setFont(Font.font(20));
        finalTotRes.setFont(Font.font(20));

        totalGrid.add(finalTee, 0, 0);
        totalGrid.add(finalApp, 0, 1);
        totalGrid.add(finalAtg, 0, 2);
        totalGrid.add(finalGrn, 0, 3);
        totalGrid.add(finalTot, 0, 4);
        totalGrid.add(finalTeeRes, 1, 0);
        totalGrid.add(finalAppRes, 1, 1);
        totalGrid.add(finalAtgRes, 1, 2);
        totalGrid.add(finalGrnRes, 1, 3);
        totalGrid.add(finalTotRes, 1, 4);

        // Set up for start screen.
        Button nineBtn = new Button("Nine Holes");
        Button eighteenBtn = new Button("Eighteen Holes");
        eighteenBtn.setOnAction((e -> primaryStage.setScene(holeScenes[1])));
        Button home = new Button("Home");
        home.setOnAction(e -> primaryStage.setScene(scene));

        Label title = new Label("Storm Golf Statistics");
        title.setFont(Font.font(20));
        Label instructions = new Label("Select to enter shots for 9 holes or 18 holes.");
        grid.add(title, 1, 0);
        grid.add(instructions, 1, 1);
        grid.add(nineBtn, 0, 3);
        grid.add(eighteenBtn, 2, 3);

        //Scene 2
        GridPane gridTwo = new GridPane();
        gridTwo.setAlignment(Pos.TOP_CENTER);
        gridTwo.setHgap(10);
        gridTwo.setVgap(10);
        gridTwo.setPadding(new Insets(25, 25, 25, 25));

        GridPane hole2Grid = new GridPane();
        hole2Grid.setAlignment(Pos.CENTER);
        hole2Grid.setHgap(10);
        hole2Grid.setVgap(10);
        hole2Grid.setPadding(new Insets(25, 25, 25, 25));

        Scene hole2Scene = new Scene(hole2Grid, 750, 500);
        Button hole2But = new Button("Hole 2");
        hole2But.setOnAction(e -> primaryStage.setScene(hole2Scene));
        Button button2= new Button("Home Screen");
        button2.setOnAction(e -> primaryStage.setScene(scene));

        // Hole 2 calculations.
        Label result = new Label("Strokes Gained: ");
        Label h1res = new Label();
        Label h2Tee = new Label("Off the tee: ");
        Label h2App = new Label("Approach: ");
        Label h2Atg = new Label("Around the green: ");
        Label h2Grn = new Label("Putting: ");
        Label h2Tot = new Label("Total: ");

        Button calculateH2 = new Button("Calculate strokes gained.");
        calculateH2.setOnAction((event) -> {
            double sg1 = 0, sg2 = 0, sg3 = 0, sg4 = 0, sg5 = 0, tee = 0, app = 0, atg = 0, grn = 0;

            if (hole2Dists[1] != null) {
                sg1 = UtilityFunctions.calculateHole(Integer.parseInt(hole2Dists[0].getText()), Integer.parseInt(hole2Dists[1].getText()),
                        "Tee", (String) hole2Locs[0].getValue());
                tee += sg1;
                sgTee += sg1;
            }
            if (hole2Dists[2] != null && hole2Dists[1] != null) {
                sg2 = UtilityFunctions.calculateHole(Integer.parseInt(hole2Dists[1].getText()), Integer.parseInt(hole2Dists[2].getText()),
                        (String) hole2Locs[0].getValue(), (String) hole2Locs[1].getValue());
                app += sg2;
                sgApp += sg2;
            }
            if (hole2Dists[3] != null && hole2Dists[2] != null) {
                sg3 = UtilityFunctions.calculateHole(Integer.parseInt(hole2Dists[2].getText()), Integer.parseInt(hole2Dists[3].getText()),
                        (String) hole2Locs[1].getValue(), (String) hole2Locs[2].getValue());
                app += sg3;
                sgApp += sg3;
            }
            if (hole2Dists[4] != null && hole2Dists[3] != null) {
                sg4 = UtilityFunctions.calculateHole(Integer.parseInt(hole2Dists[3].getText()), Integer.parseInt(hole2Dists[4].getText()),
                        (String) hole2Locs[2].getValue(), (String) hole2Locs[3].getValue());
                grn += sg4;
                sgGrn += sg4;
            }
            if (!(hole2Dists[5].toString()).equals("")) { //&& hole1Dists[4] != null
                sg5 = 0;
            }
            else {
                sg5 = UtilityFunctions.calculateHole(Integer.parseInt(hole2Dists[4].getText()), Integer.parseInt(hole2Dists[5].getText()),
                        (String) hole2Locs[3].getValue(), (String) hole2Locs[4].getValue());
                grn += sg5;
                sgGrn += sg5;
            }
            double total = sg1 + sg2 + sg3 + sg4 + sg5;
            sgTotal += total;
            h2Tot.setText("Strokes Gained on hole: " + String.format("%.2f" , total));
            h2Tee.setText("Off the tee: " + String.format("%.2f" , tee));
            h2App.setText("Approach: " + String.format("%.2f" , app));
            h2Atg.setText("Around the green: " + String.format("%.2f" , atg));
            h2Grn.setText("Putting: " + String.format("%.2f" , grn));
            finalTeeRes.setText(String.format("%.2f" , sgTee));
            finalAppRes.setText(String.format("%.2f" , sgApp));
            finalAtgRes.setText(String.format("%.2f" , sgAtg));
            finalGrnRes.setText(String.format("%.2f" , sgGrn));
            finalTotRes.setText(String.format("%.2f" , sgTotal));
        });

        // Hole 1 calculations
        Button buttonCalculate9 = new Button("Calculate strokes gained.");
        buttonCalculate9.setOnAction((event) -> {
            double sg1 = 0, sg2 = 0, sg3 = 0, sg4 = 0, sg5 = 0;

            if (hole1Dists[1] != null) {
                sg1 = UtilityFunctions.calculateHole(Integer.parseInt(hole1Dists[0].getText()), Integer.parseInt(hole1Dists[1].getText()),
                        "Tee", (String) hole1Locs[0].getValue());
                sgTee += sg1;
            }
            if (hole1Dists[2] != null && hole1Dists[1] != null) {
                sg2 = UtilityFunctions.calculateHole(Integer.parseInt(hole1Dists[1].getText()), Integer.parseInt(hole1Dists[2].getText()),
                        (String) hole1Locs[0].getValue(), (String) hole1Locs[1].getValue());
                sgApp += sg2;
            }
            if (hole1Dists[3] != null && hole1Dists[2] != null) {
                sg3 = UtilityFunctions.calculateHole(Integer.parseInt(hole1Dists[2].getText()), Integer.parseInt(hole1Dists[3].getText()),
                        (String) hole1Locs[1].getValue(), (String) hole1Locs[2].getValue());
                sgAtg += sg3;
            }
            if (hole1Dists[4] != null && hole1Dists[3] != null) {
                sg4 = UtilityFunctions.calculateHole(Integer.parseInt(hole1Dists[3].getText()), Integer.parseInt(hole1Dists[4].getText()),
                        (String) hole1Locs[2].getValue(), (String) hole1Locs[3].getValue());
                sgGrn += sg4;
            }
            if (!(hole1Dists[5].toString()).equals("")) { //&& hole1Dists[4] != null
                sg5 = 0;
            }
            else {
                sg5 = UtilityFunctions.calculateHole(Integer.parseInt(hole1Dists[4].getText()), Integer.parseInt(hole1Dists[5].getText()),
                        (String) hole1Locs[3].getValue(), (String) hole1Locs[4].getValue());
                sgGrn += sg5;
            }

            System.out.println(sg1);

////            System.out.printf("%.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f",
////                    sg1, sg2, sg3, sg4, sg5, sg6, sg7, sg8, sg9);
//            double total = sg1 + sg2 + sg3 + sg4 + sg5 + sg6 + sg7 + sg8 + sg9;
            result.setText("Strokes Gained: " + String.format("%.2f, %.2f, %.2f, %.2f, %.2f", sg1, sg2, sg3, sg4, sg5));
            double total = sg1 + sg2 + sg3 + sg4 + sg5;
            sgTotal += total;
            h1res.setText("Strokes Gained on hole: " + String.format("%.2f" , total));
            });

        gridTwo.add(button2, 1, 0);
        gridTwo.add(hole2But, 2, 0);

        holeGrids[1].add(h1res, 3, 4);
        ;
        holeGrids[1].add(hole1Dists[0], 1, 2);
//        gridTwo.add(h1Score, 2, 2);

        holeGrids[1].add(hole1Dists[1], 1, 3);
        holeGrids[1].add(hole1Locs[0], 2, 3);
        holeGrids[1].add(hole1Dists[2], 1, 4);
        holeGrids[1].add(hole1Locs[1], 2, 4);
        holeGrids[1].add(hole1Dists[3], 1, 5);
        holeGrids[1].add(hole1Locs[2], 2, 5);
        holeGrids[1].add(hole1Dists[4], 1, 6);
        holeGrids[1].add(hole1Locs[3], 2, 6);
        holeGrids[1].add(hole1Dists[5], 1, 7);
        holeGrids[1].add(hole1Locs[4], 2, 7);
        holeGrids[1].add(hole1Dists[6], 1, 8);
        holeGrids[1].add(hole1Locs[5], 2, 8);
        holeGrids[1].add(hole1Dists[7], 1, 9);
        holeGrids[1].add(hole1Locs[6], 2, 9);

        holeGrids[2].add(hole2Dists[0], 1, 2);
//        gridTwo.add(h1Score, 2, 2);

        holeGrids[2].add(hole2Dists[1], 1, 3);
        holeGrids[2].add(hole2Locs[0], 2, 3);
        holeGrids[2].add(hole2Dists[2], 1, 4);
        holeGrids[2].add(hole2Locs[1], 2, 4);
        holeGrids[2].add(hole2Dists[3], 1, 5);
        holeGrids[2].add(hole2Locs[2], 2, 5);
        holeGrids[2].add(hole2Dists[4], 1, 6);
        holeGrids[2].add(hole2Locs[3], 2, 6);
        holeGrids[2].add(hole2Dists[5], 1, 7);
        holeGrids[2].add(hole2Locs[4], 2, 7);
        holeGrids[2].add(hole2Dists[6], 1, 8);
        holeGrids[2].add(hole2Locs[5], 2, 8);
        holeGrids[2].add(hole2Dists[7], 1, 9);
        holeGrids[2].add(hole2Locs[6], 2, 9);
        holeGrids[2].add(calculateH2, 1, 11);
        holeGrids[2].add(h2Tee, 3, 3);
        holeGrids[2].add(h2App, 3, 4);
        holeGrids[2].add(h2Atg, 3, 5);
        holeGrids[2].add(h2Grn, 3, 6);
        holeGrids[2].add(h2Tot, 3, 7);

        holeGrids[1].add(buttonCalculate9, 1, 11);
        holeGrids[1].add(result, 2, 11);

//        ScrollPane sp = new ScrollPane(gridTwo);
//        gridTwo.add(sp, 0, 1);
//        GridPane.setHgrow(sp, Priority.ALWAYS);

//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setContent(gridTwo);

//        root.getChildren().addAll(scrollPane);
//        scene.setRoot(root);


//        VBox layout2= new VBox(20);
//        layout2.getChildren().addAll(label2, button2, h1Dist, h1Score, h2Dist, h2Score);
//        Scene sceneTwo = new Scene(scrollPane,750,500);
//
//        Button btnTwo = new Button("Test");
//        HBox hbBtnTwo = new HBox(10);
//        hbBtnTwo.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtnTwo.getChildren().add(btnTwo);
//        grid.add(hbBtnTwo, 2, 4);
//
//        Button b3 = new Button("Go to scene 2");
//        b3.setOnAction(e -> primaryStage.setScene(sceneTwo));
//        grid.add(b3, 6, 6);
//
//        btnTwo.setOnAction((event) -> {
//            try {
//                SceneController.switchToScene2(event);
//            } catch (IOException exception) {
//                exception.printStackTrace();
//            }
//        });
    }

//    public void changeScene(String fxml){
//        Parent pane = null;
//        try {
//            pane = FXMLLoader.load(
//                    getClass().getResource(fxml));
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//
//        primaryStage.getScene().setRoot(pane);
//    }
}
