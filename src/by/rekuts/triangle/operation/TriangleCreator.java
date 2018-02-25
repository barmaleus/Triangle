package by.rekuts.triangle.operation;

import by.rekuts.triangle.exception.TriangleException;
import by.rekuts.triangle.entity.Point;
import by.rekuts.triangle.entity.Triangle;
import by.rekuts.triangle.parameter.TriangleAction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class TriangleCreator {
    private static final Logger logger = LogManager.getLogger(TriangleParser.class.getName());

    public static ArrayList<Triangle> createTriangles(ArrayList<Double[]> coordinatesDoubleList) {
        ArrayList<Triangle> triangleList = new ArrayList<>();
        ArrayList<Double[]> doublesList = new ArrayList<>(coordinatesDoubleList);

        for (Double[] doubles : doublesList) {
            Point a = new Point(doubles[0], doubles[1]);
            Point b = new Point(doubles[2], doubles[3]);
            Point c = new Point(doubles[4], doubles[5]);

            Triangle triangle = new Triangle(a, b, c);
            if (validateTriangle(triangle)) {
                triangleList.add(triangle);
                logger.log(Level.INFO, "The triangle №" + (doublesList.indexOf(doubles) + 1) + " is created.");
            } else {
                try {
                    throw new TriangleException();
                } catch (TriangleException e) {
                    logger.log(Level.WARN, "All points lay on one line.");
                }

            }
        }
        return triangleList;
    }

    private static boolean validateTriangle(Triangle triangle) {
        if (TriangleAction.calculateSquare(triangle) != 0) {
            return true;
        } else {
            return false;
        }
    }
}
