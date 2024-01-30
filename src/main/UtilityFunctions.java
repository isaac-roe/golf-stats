package main;

public class UtilityFunctions {
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
}
