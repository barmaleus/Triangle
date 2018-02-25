package test.rekuts.triangle.operation;

import by.rekuts.triangle.entity.Point;
import by.rekuts.triangle.entity.Triangle;
import by.rekuts.triangle.operation.TriangleCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TriangleCreatorTest {
    static ArrayList<Triangle> expectedTriangles = new ArrayList<>();
    static ArrayList<Double[]> expectedListOfDoubles = new ArrayList<>();

    @BeforeClass
    public void beforeClass() {
        Triangle one = new Triangle(new Point(-5.6, 2.4), new Point(0.0, 1.0), new Point(5.0, -9.6));
        Triangle two = new Triangle(new Point(8.2, 4.1), new Point(0.7, 5.6), new Point(8.0, 1.0));
        expectedTriangles.add(one);
        expectedTriangles.add(two);

        Double[] doublesFirstString = {-5.6, 2.4, 0.0, 1.0, 5.0, -9.6, -4.8};
        Double[] doublesSecondString = {8.2, 4.1, 0.7, 5.6, 8.0, 1.0};
        expectedListOfDoubles.add(doublesFirstString);
        expectedListOfDoubles.add(doublesSecondString);
    }

    @Test
    public void createTrianglesTestTrue() {
        ArrayList<Triangle> listOfTriangles = TriangleCreator.createTriangles(expectedListOfDoubles);
        Assert.assertEquals(listOfTriangles, expectedTriangles);
    }

    @Test
    public void createTrianglesTestPointsOnOneLine() {
        ArrayList<Double[]> doubles = new ArrayList<>();
        Double[] doublesArr = {0.0, 5.2, 0.0, 1.0, 0.0, -6.0};
        doubles.add(doublesArr);
        ArrayList<Triangle> list = TriangleCreator.createTriangles(doubles);
        Assert.assertTrue(list.size() == 0);
    }
}
