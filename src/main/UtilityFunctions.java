package main;

import java.util.NavigableMap;
import java.util.TreeMap;

public class UtilityFunctions {
    // Set up for a hash map to store expected strokes to hole out for
    // a position of off the tee.
    private static final TreeMap<Integer, Double> sgTee = new TreeMap<>();
    static {
        sgTee.put(0, 0.00);
        sgTee.put(100, 2.92);
        sgTee.put(105, 2.93);
        sgTee.put(110, 2.95);
        sgTee.put(115, 2.95);
        sgTee.put(120, 2.95);
        sgTee.put(125, 2.95);
        sgTee.put(130, 2.97);
        sgTee.put(135, 2.97);
        sgTee.put(140, 2.97);
        sgTee.put(145, 2.97);
        sgTee.put(150, 2.99);
        sgTee.put(155, 2.99);
        sgTee.put(160, 2.99);
        sgTee.put(165, 3.01);
        sgTee.put(170, 3.02);
        sgTee.put(175, 3.04);
        sgTee.put(180, 3.05);
        sgTee.put(185, 3.07);
        sgTee.put(190, 3.09);
        sgTee.put(195, 3.11);
        sgTee.put(200, 3.12);
        sgTee.put(210, 3.14);
        sgTee.put(220, 3.17);
        sgTee.put(230, 3.21);
        sgTee.put(240, 3.25);
        sgTee.put(250, 3.35);
        sgTee.put(260, 3.45);
        sgTee.put(270, 3.55);
        sgTee.put(280, 3.65);
        sgTee.put(290, 3.68);
        sgTee.put(300, 3.71);
        sgTee.put(320, 3.79);
        sgTee.put(340, 3.86);
        sgTee.put(360, 3.92);
        sgTee.put(380, 3.96);
        sgTee.put(400, 3.99);
        sgTee.put(420, 4.02);
        sgTee.put(440, 4.08);
        sgTee.put(460, 4.17);
        sgTee.put(480, 4.28);
        sgTee.put(500, 4.41);
        sgTee.put(520, 4.54);
        sgTee.put(540, 4.65);
        sgTee.put(560, 4.74);
        sgTee.put(580, 4.79);
        sgTee.put(600, 4.82);
    }

    private static final TreeMap<Integer, Double> sgApp = new TreeMap<>();
    static {
        sgApp.put(0, 0.00);
        sgApp.put(10, 2.20); sgApp.put(15, 2.30); sgApp.put(20, 2.40);
        sgApp.put(25, 2.45); sgApp.put(30, 2.50); sgApp.put(35, 2.55);
        sgApp.put(40, 2.60); sgApp.put(45, 2.62); sgApp.put(50, 2.65);
        sgApp.put(55, 2.67); sgApp.put(60, 2.70); sgApp.put(65, 2.72);
        sgApp.put(70, 2.73); sgApp.put(75, 2.74); sgApp.put(80, 2.75);
        sgApp.put(85, 2.77); sgApp.put(90, 2.78); sgApp.put(95, 2.79);
        sgApp.put(100, 2.80); sgApp.put(105, 2.81); sgApp.put(110, 2.83);
        sgApp.put(115, 2.84);
        sgApp.put(120, 2.85);
        sgApp.put(125, 2.86);
        sgApp.put(130, 2.88);
        sgApp.put(135, 2.90);
        sgApp.put(140, 2.91);
        sgApp.put(145, 2.93);
        sgApp.put(150, 2.95);
        sgApp.put(155, 2.97);
        sgApp.put(160, 2.98);
        sgApp.put(165, 3.00);
        sgApp.put(170, 3.03);
        sgApp.put(175, 3.06);
        sgApp.put(180, 3.08);
        sgApp.put(185, 3.11);
        sgApp.put(190, 3.13);
        sgApp.put(195, 3.16);
        sgApp.put(200, 3.19);
        sgApp.put(210, 3.26);
        sgApp.put(220, 3.32);
        sgApp.put(230, 3.39);
        sgApp.put(240, 3.45);
        sgApp.put(250, 3.52);
        sgApp.put(260, 3.58);
        sgApp.put(270, 3.63);
        sgApp.put(280, 3.69);
        sgApp.put(290, 3.74);
        sgApp.put(300, 3.78);
        sgApp.put(320, 3.84);
        sgApp.put(340, 3.88);
        sgApp.put(360, 3.95);
        sgApp.put(380, 4.03);
        sgApp.put(400, 4.11);
        sgApp.put(420, 4.15);
        sgApp.put(440, 4.20);
        sgApp.put(460, 4.29);
        sgApp.put(480, 4.40);
        sgApp.put(500, 4.53);
        sgApp.put(520, 4.85);
        sgApp.put(540, 4.97);
        sgApp.put(560, 5.05);
        sgApp.put(580, 5.10);
        sgApp.put(600, 5.13);
    }

    private static final TreeMap<Integer, Double> sgAtg = new TreeMap<>();
    static {
//        sgAtg.put();
    }

    private static final TreeMap<Integer, Double> sgPutt = new TreeMap<>();
    static {
        sgPutt.put(0, 0.00);
        sgPutt.put(3, 1.04);
        sgPutt.put(4, 1.13);
        sgPutt.put(5, 1.23);
        sgPutt.put(6, 1.34);
        sgPutt.put(7, 1.42);
        sgPutt.put(8, 1.50);
        sgPutt.put(9, 1.57);
        sgPutt.put(10, 1.60);
        sgPutt.put(11, 1.67);
        sgPutt.put(12, 1.70);
        sgPutt.put(13, 1.74);
        sgPutt.put(15, 1.77);
        sgPutt.put(17, 1.83);
        sgPutt.put(20, 1.88);
        sgPutt.put(21, 1.89);
        sgPutt.put(24, 1.92);
        sgPutt.put(27, 1.95);
        sgPutt.put(30, 1.98);
        sgPutt.put(33, 2.00);
        sgPutt.put(36, 2.03);
        sgPutt.put(39, 2.05);
        sgPutt.put(42, 2.08);
        sgPutt.put(45, 2.10);
        sgPutt.put(48, 2.12);
        sgPutt.put(51, 2.15);
        sgPutt.put(54, 2.17);
        sgPutt.put(57, 2.19);
        sgPutt.put(60, 2.22);
        sgPutt.put(63, 2.23);
        sgPutt.put(66, 2.24);
        sgPutt.put(69, 2.25);
        sgPutt.put(72, 2.27);
        sgPutt.put(75, 2.29);
    }

    public static double calculateHole(int start, int finish, String startLoc, String finishLoc)
    {
        double gained = 0;
        double startSG = 0;
        double finishSG = 0;

        switch (startLoc) {
            case "Tee":
                startSG = nearestKey(sgTee, start);
                break;
            case "Fairway":
                startSG = nearestKey(sgApp, start);
                break;
            case "Green":
                startSG = nearestKey(sgPutt, start);
                break;
        }
        switch (finishLoc) {
            case "Tee":
                finishSG = nearestKey(sgTee, finish);
                break;
            case "Fairway":
                finishSG = nearestKey(sgApp, finish);
                break;
            case "Green":
                finishSG = nearestKey(sgPutt, finish);
                break;
        }

        gained = startSG - finishSG - 1;

        return gained;
    }

    public static double getExpectedStrokes(int holeLength)
    {
        double expectedStrokes = 0;

        if (holeLength <= 10) expectedStrokes = 2.20;
        else if (holeLength >= 60) expectedStrokes = 2.70;

        return expectedStrokes;
    }

    public static Double nearestKey(TreeMap<Integer, Double> map, Integer target) {
        double minDiff = Double.MAX_VALUE;
        Double gained = null;
        for (int key : map.keySet()) {
            double diff = Math.abs((double) target - (double) key);
            if (diff < minDiff) {
                gained = map.get(key);
                minDiff = diff;
            }
        }
        return gained;
    }
}
