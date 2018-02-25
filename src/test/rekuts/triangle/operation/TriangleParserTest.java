package test.rekuts.triangle.operation;

import by.rekuts.triangle.operation.TriangleParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TriangleParserTest {
    static ArrayList<Double[]> expectedListOfDoubles = new ArrayList<>();

    @DataProvider
    public Object[][] parseTriangleData() {
        return new Object[][] {
                {"", null},
                {"-5.6 2.4 0.0 1.0 5.0 -9.6 -4.8", new Double[] {-5.6, 2.4, 0.0, 1.0, 5.0, -9.6, -4.8}},
                {"-5.6 2.4dfgs 0.0 1.0 5.0 -9.6 -4.8", null},
                {"-5.6 2.4 0.0 1 5.0 -9.6 -4.8", new Double[] {-5.6, 2.4, 0.0, 1.0, 5.0, -9.6, -4.8}},
                {"-5.6 2.4 .0 1.0 5.0 -9.6 -4.8", new Double[] {-5.6, 2.4, 0.0, 1.0, 5.0, -9.6, -4.8}},
                {"-5.6 2.4 0. 1.0 5.0 -9.6 -4.8", null},
                {"-5.6 2.4 0.0 1.0 5.0", null}
        };
    }

    @Test (dataProvider = "parseTriangleData")
    public void createDoublesListTestDataProvider(String doublesData, Double[] expected) {

        Double[] doublesActual = TriangleParser.createDoublesArray(doublesData);
        Assert.assertEquals(doublesActual, expected);
    }

    @BeforeClass
    public void beforeClass() {
        Double[] doublesFirstString = {-5.6, 2.4, 0.0, 1.0, 5.0, -9.6, -4.8};
        Double[] doublesSecondString = {8.2, 4.1, 0.7, 5.6, 8.0, 1.0};
        expectedListOfDoubles.add(doublesFirstString);
        expectedListOfDoubles.add(doublesSecondString);
    }

    @Test
    public void createDoublesListTestTrue() {
        ArrayList<String> stringsList = new ArrayList<>();
        stringsList.add("-5.6 2.4 0.0 1.0 5.0 -9.6 -4.8");
        stringsList.add("8.2 4.1 0.7 5.6 8.0 1.0");
        ArrayList<Double[]> doublesList = TriangleParser.createDoublesList(stringsList);
        Assert.assertEquals(expectedListOfDoubles, doublesList);
    }

    @Test
    public void createDoublesListTestTrueWithAddedStrings() {
        ArrayList<String> stringsList = new ArrayList<>();
        stringsList.add("-5.6 2.4 0.0 1.0 5.0 -9.6 -4.8");
        stringsList.add("8.2 4.1 .7 5.6 8 1.0");
        stringsList.add("8.2 4.1 0.7 8.0 1.0");
        stringsList.add("8.2 4.1 0.7svf 5.6 8.0 1.0");
        ArrayList<Double[]> doublesList = TriangleParser.createDoublesList(stringsList);
        Assert.assertEquals(expectedListOfDoubles, doublesList);
    }

    @Test
    public void createDoublesListTestFalseOne() {
        ArrayList<String> stringsList = new ArrayList<>();
        stringsList.add("-5.6 2.4 0.0 1.0 5.0 -9.6 -4.8");
        stringsList.add("8.2 4.1 0.7 8.0 1.0");
        ArrayList<Double[]> doublesList = TriangleParser.createDoublesList(stringsList);
        Assert.assertNotEquals(expectedListOfDoubles, doublesList);
    }

    @Test
    public void createDoublesListTestFalseTwo() {
        ArrayList<String> stringsList = new ArrayList<>();
        stringsList.add("-5.6 2.4 0.0 1.0 5.0 -9.6 -4.8");
        stringsList.add("8.2ss 4.1 sv0.7 5.6 8.0 1.0");
        ArrayList<Double[]> doublesList = TriangleParser.createDoublesList(stringsList);
        Assert.assertNotEquals(expectedListOfDoubles, doublesList);
    }

    @Test
    public void validateListTestFalse() {
        String[] strings = "8.2 4.1 0.7svf 5.6 8.0 1.0".split("\\s");
            Assert.assertFalse(TriangleParser.validateParsingArray(strings));
    }

    @Test
    public void validateListTestTrue() {
        String[] strings = "8.2 4.1 0.7 5.6 8.0 1.0".split("\\s");
        Assert.assertTrue(TriangleParser.validateParsingArray(strings));
    }

    //валидатор не пропускает числа типа 7. (семь_точка)


}
