package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private TabPane tabPane;
    private double sgTee = 0, sgApp = 0, sgAtg = 0, sgGrn = 0, sgTotal = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Initial setup.
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
        primaryStage.show();

        // Set up for all shot info for each hole.
        String[] locOpt = {"Tee", "Fairway", "Rough", "Sand", "Green"};
        TextField[][] holeDists = new TextField[19][8];
        ChoiceBox[][] holeLocs = new ChoiceBox[19][8];
        for (int j = 1; j <= 18; j++) {
            for (int i = 0; i < 8; i++) {
                holeDists[j][i] = new TextField();
                holeDists[j][i].setMaxWidth(60);
                holeLocs[j][i] = new ChoiceBox();
                holeLocs[j][i].getItems().addAll(locOpt);
            }
        }

        // Scene and grid setup for each hole screen.
        GridPane[] holeGrids = new GridPane[19];
        Scene[] holeScenes = new Scene[19];
        Button[] nextHoleBtn = new Button[19];
        Button[] previousHoleBtn = new Button[19];
        Button[] calculateHole = new Button[19];
        Label[] holeNums = new Label[19];
        Label[] scoreLab = new Label[19];
        Label[] distLab = new Label[19];
        Label[] holeSGTot = new Label[19];
        Label[] holeSGTee = new Label[19];
        Label[] holeSGApp = new Label[19];
        Label[] holeSGAtg = new Label[19];
        Label[] holeSGGrn = new Label[19];
        for (int i = 0; i <= 18; i++) {
            holeGrids[i] = new GridPane();
            holeGrids[i].setAlignment(Pos.TOP_CENTER);
            holeGrids[i].setHgap(10);
            holeGrids[i].setVgap(10);
            holeGrids[i].setPadding(new Insets(25, 25, 25, 25));
            holeScenes[i] = new Scene(holeGrids[i], 750, 500);
            previousHoleBtn[i] = new Button("Previous Hole");
            nextHoleBtn[i] = new Button("Hole " + (i + 1));
            calculateHole[i] = new Button("Calculate Strokes Gained");
            int finalI = i + 1;
            if (i < 18) {
                nextHoleBtn[i].setOnAction(e -> primaryStage.setScene(holeScenes[finalI]));
            }
            previousHoleBtn[i].setOnAction(e -> primaryStage.setScene(holeScenes[finalI - 2]));
            holeNums[i] = new Label("Hole " + i);
            scoreLab[i] = new Label("Enter shot location");
            distLab[i] = new Label("Enter shot distance");
            holeSGTee[i] = new Label("Off the tee: ");
            holeSGApp[i] = new Label("Approach: ");
            holeSGAtg[i] = new Label("Around the green: ");
            holeSGGrn[i] = new Label("Putting: ");
            holeSGTot[i] = new Label("Total: ");
            holeGrids[i].add(holeNums[i], 0, 2);
            if (i != 9 && i < 18)
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
        Button finishHome = new Button("Go Home");
        finishHome.setOnAction(e -> primaryStage.setScene(scene));
        totalGrid.add(finishHome, 0, 5);

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
        eighteenBtn.setOnAction((e -> {
            primaryStage.setScene(holeScenes[1]);
            holeGrids[9].add(nextHoleBtn[10], 2, 0);
        }));
        nineBtn.setOnAction((event) -> {
            primaryStage.setScene(holeScenes[1]);
            holeGrids[9].add(goToTotal, 2, 0);
        });
        Button home = new Button("Home");
        home.setOnAction(e -> primaryStage.setScene(scene));
        holeGrids[1].add(home, 1, 0);

        Label title = new Label("Storm Golf Statistics");
        title.setFont(Font.font(20));
        Label instructions = new Label("Select to enter shots for 9 holes or 18 holes.");
        grid.add(title, 1, 0);
        grid.add(instructions, 1, 1);
        grid.add(nineBtn, 0, 3);
        grid.add(eighteenBtn, 2, 3);

        // Setup for all of the calculate hole buttons on each hole screen.
        for (int i = 1; i <= 18; i++) {
            int finalI = i;
            calculateHole[i].setOnAction((event) -> {
                double sg1 = 0, sg2 = 0, sg3 = 0, sg4 = 0, sg5 = 0, sg6 = 0, sg7 = 0, tee = 0, app = 0, atg = 0, grn = 0;

                if (holeDists[finalI][1] != null) {
                    sg1 = UtilityFunctions.calculateHole(Integer.parseInt(holeDists[finalI][0].getText()), Integer.parseInt(holeDists[finalI][1].getText()),
                            "Tee", (String) holeLocs[finalI][0].getValue());
                    sgTee += sg1;
                    tee += sg1;
                }
                if (!holeDists[finalI][2].getText().equals("")) {
                    sg2 = UtilityFunctions.calculateHole(Integer.parseInt(holeDists[finalI][1].getText()), Integer.parseInt(holeDists[finalI][2].getText()),
                            (String) holeLocs[finalI][0].getValue(), (String) holeLocs[finalI][1].getValue());
                    if ((holeLocs[finalI][0].getValue()).equals("Green")) {
                        sgGrn += sg2;
                        grn += sg2;
                    }
                    else if (Integer.parseInt(holeDists[finalI][1].getText()) <= 30) {
                        sgAtg += sg2;
                        atg += sg2;
                    }
                    else {
                        sgApp += sg2;
                        app += sg2;
                    }
                }
                if (!holeDists[finalI][3].getText().equals("")) {
                    sg3 = UtilityFunctions.calculateHole(Integer.parseInt(holeDists[finalI][2].getText()), Integer.parseInt(holeDists[finalI][3].getText()),
                            (String) holeLocs[finalI][1].getValue(), (String) holeLocs[finalI][2].getValue());
                    if ((holeLocs[finalI][1].getValue()).equals("Green")) {
                        sgGrn += sg3;
                        grn += sg3;
                    }
                    else if (Integer.parseInt(holeDists[finalI][2].getText()) <= 30) {
                        sgAtg += sg3;
                        atg += sg3;
                    }
                    else {
                        sgApp += sg3;
                        app += sg3;
                    }
                }
                if (!holeDists[finalI][4].getText().equals("")) {
                    sg4 = UtilityFunctions.calculateHole(Integer.parseInt(holeDists[finalI][3].getText()), Integer.parseInt(holeDists[finalI][4].getText()),
                            (String) holeLocs[finalI][2].getValue(), (String) holeLocs[finalI][3].getValue());
                    if ((holeLocs[finalI][2].getValue()).equals("Green")) {
                        sgGrn += sg4;
                        grn += sg4;
                    }
                    else if (Integer.parseInt(holeDists[finalI][3].getText()) <= 30) {
                        sgAtg += sg4;
                        atg += sg4;
                    }
                    else {
                        sgApp += sg4;
                        app += sg4;
                    }
                }
                if (!holeDists[finalI][5].getText().equals("")) {
                    sg5 = UtilityFunctions.calculateHole(Integer.parseInt(holeDists[finalI][4].getText()), Integer.parseInt(holeDists[finalI][5].getText()),
                            (String) holeLocs[finalI][3].getValue(), (String) holeLocs[finalI][4].getValue());
                    if ((holeLocs[finalI][3].getValue()).equals("Green")) {
                        sgGrn += sg5;
                        grn += sg5;
                    }
                    else if (Integer.parseInt(holeDists[finalI][4].getText()) <= 30) {
                        sgAtg += sg5;
                        atg += sg5;
                    }
                    else {
                        sgApp += sg5;
                        app += sg5;
                    }
                }
                if (!holeDists[finalI][6].getText().equals("")) {
                    sg6 = UtilityFunctions.calculateHole(Integer.parseInt(holeDists[finalI][5].getText()), Integer.parseInt(holeDists[finalI][6].getText()),
                            (String) holeLocs[finalI][4].getValue(), (String) holeLocs[finalI][5].getValue());
                    if ((holeLocs[finalI][4].getValue()).equals("Green")) {
                        sgGrn += sg6;
                        grn += sg6;
                    }
                    else if (Integer.parseInt(holeDists[finalI][5].getText()) <= 30) {
                        sgAtg += sg6;
                        atg += sg6;
                    }
                    else {
                        sgApp += sg6;
                        app += sg6;
                    }
                }
                if (!holeDists[finalI][7].getText().equals("")) {
                    sg7 = UtilityFunctions.calculateHole(Integer.parseInt(holeDists[finalI][6].getText()), Integer.parseInt(holeDists[finalI][7].getText()),
                            (String) holeLocs[finalI][5].getValue(), (String) holeLocs[finalI][6].getValue());
                    if ((holeLocs[finalI][5].getValue()).equals("Green")) {
                        sgGrn += sg7;
                        grn += sg7;
                    }
                    else if (Integer.parseInt(holeDists[finalI][6].getText()) <= 30) {
                        sgAtg += sg7;
                        atg += sg7;
                    }
                    else {
                        sgApp += sg7;
                        app += sg7;
                    }
                }

                double total = sg1 + sg2 + sg3 + sg4 + sg5 + sg6 + sg7;
                sgTotal += total;
                holeSGTot[finalI].setText("Strokes Gained on hole: " + String.format("%.2f" , total));
                holeSGTee[finalI].setText("Off the tee: " + String.format("%.2f" , tee));
                holeSGApp[finalI].setText("Approach: " + String.format("%.2f" , app));
                holeSGAtg[finalI].setText("Around the green: " + String.format("%.2f" , atg));
                holeSGGrn[finalI].setText("Putting: " + String.format("%.2f" , grn));
                finalTeeRes.setText(String.format("%.2f" , sgTee));
                finalAppRes.setText(String.format("%.2f" , sgApp));
                finalAtgRes.setText(String.format("%.2f" , sgAtg));
                finalGrnRes.setText(String.format("%.2f" , sgGrn));
                finalTotRes.setText(String.format("%.2f" , sgTotal));
            });
        }

        // Adding all the items to each hole screen grid.
        for (int i = 1; i <= 18; i++) {
            holeGrids[i].add(holeDists[i][0], 1, 2);
            holeGrids[i].add(holeDists[i][1], 1, 3);
            holeGrids[i].add(holeLocs[i][0], 2, 3);
            holeGrids[i].add(holeDists[i][2], 1, 4);
            holeGrids[i].add(holeLocs[i][1], 2, 4);
            holeGrids[i].add(holeDists[i][3], 1, 5);
            holeGrids[i].add(holeLocs[i][2], 2, 5);
            holeGrids[i].add(holeDists[i][4], 1, 6);
            holeGrids[i].add(holeLocs[i][3], 2, 6);
            holeGrids[i].add(holeDists[i][5], 1, 7);
            holeGrids[i].add(holeLocs[i][4], 2, 7);
            holeGrids[i].add(holeDists[i][6], 1, 8);
            holeGrids[i].add(holeLocs[i][5], 2, 8);
            holeGrids[i].add(holeDists[i][7], 1, 9);
            holeGrids[i].add(holeLocs[i][6], 2, 9);
            holeGrids[i].add(calculateHole[i], 1, 11);
            holeGrids[i].add(holeSGTee[i], 3, 3);
            holeGrids[i].add(holeSGApp[i], 3, 4);
            holeGrids[i].add(holeSGAtg[i], 3, 5);
            holeGrids[i].add(holeSGGrn[i], 3, 6);
            holeGrids[i].add(holeSGTot[i], 3, 7);
        }
    }
}
