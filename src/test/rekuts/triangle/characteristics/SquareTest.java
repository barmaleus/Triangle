package test.rekuts.triangle.characteristics;

import by.rekuts.triangle.entity.Point;
import by.rekuts.triangle.entity.Triangle;
import by.rekuts.triangle.parameter.TriangleAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {
    Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(0.0, 4.0), new Point(5.0, 0.0));
    Triangle triangleLine = new Triangle(new Point(0.0, 0.0), new Point(0.0, 4.0), new Point(0.0, 0.0));

    @Test
    public void calculateSquareTestTrue() {
        Assert.assertEquals(TriangleAction.calculateSquare(triangle), 10.0);
    }

    @Test
    public void calculateSquareTestFalse() {
        Assert.assertNotEquals(TriangleAction.calculateSquare(triangle), 11.0);
    }

    @Test
    public void calculateSquareTestNullSquare() {
        Assert.assertEquals(TriangleAction.calculateSquare(triangleLine), 0.0);
    }
}
