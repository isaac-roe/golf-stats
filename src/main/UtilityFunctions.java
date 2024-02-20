package main;

import java.util.NavigableMap;
import java.util.TreeMap;

public class UtilityFunctions {
    // Set up for a hash map to store expected strokes to hole out for
    // a position of off the tee.
    private static final NavigableMap<Integer, Double> sgTee = new TreeMap<>();
    static {
        sgTee.put(10, 2.20);
        sgTee.put(15, 2.30);
        sgTee.put(20, 2.40);
        sgTee.put(25, 2.45);
        sgTee.put(30, 2.50);
        sgTee.put(35, 2.55);
        sgTee.put(40, 2.60);
        sgTee.put(45, 2.62);
        sgTee.put(50, 2.65);
        sgTee.put(55, 2.67);
        sgTee.put(60, 2.70);
        sgTee.put(70, 2.73);
        sgTee.put(75, 2.74);
        sgTee.put(80, 2.75);
        sgTee.put(85, 2.77);
        sgTee.put(90, 2.78);
        sgTee.put(95, 2.79);
        sgTee.put(100, 2.80);
        sgTee.put(105, 2.81);
        sgTee.put(110, 2.83);
        sgTee.put(115, 2.84);
        sgTee.put(120, 2.85);
        sgTee.put(125, 2.86);
        sgTee.put(130, 2.88);
        sgTee.put(135, 2.90);
        sgTee.put(140, 2.91);
        sgTee.put(145, 2.93);
        sgTee.put(150, 2.95);
        sgTee.put(155, 2.97);
    }

    public static double calculateHole(int holeLength, int strokes)
    {
        double gained = 0;
        double strokeGained = getExpectedStrokes(holeLength);
        gained = strokeGained - strokes;

        return gained;
    }

    public static double getExpectedStrokes(int holeLength)
    {
        double expectedStrokes = 0;



        if (holeLength <= 10) expectedStrokes = 2.20;
        else if (holeLength >= 60) expectedStrokes = 2.70;

        return expectedStrokes;
    }

    public static Long nearestKey(TreeMap<Long, Object> map, Long target) {
        double minDiff = Double.MAX_VALUE;
        Long nearest = null;
        for (long key : map.keySet()) {
            double diff = Math.abs((double) target - (double) key);
            if (diff < minDiff) {
                nearest = key;
                minDiff = diff;
            }
        }
        return nearest;
    }
}
