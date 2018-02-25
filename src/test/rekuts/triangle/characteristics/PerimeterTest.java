package test.rekuts.triangle.characteristics;

import by.rekuts.triangle.entity.Point;
import by.rekuts.triangle.entity.Triangle;
import by.rekuts.triangle.parameter.TriangleAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PerimeterTest {
    Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(0.0, 4.0), new Point(3.0, 0.0));

    @Test
    public void calculatePerimeterTestTrue() {
        Assert.assertEquals(TriangleAction.calculatePerimeter(triangle), 12.0);
    }

    @Test
    public void calculatePerimeterTestFalse() {
        Assert.assertNotEquals(TriangleAction.calculatePerimeter(triangle), 12.1);
    }
}
