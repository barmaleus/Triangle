package test.rekuts.triangle.operation;

import by.rekuts.triangle.operation.TriangleReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class TriangleReaderTest {
    @Test
    public void readFileTestTrue() {
        ArrayList<String> list;
        list = TriangleReader.readFile(TriangleReader.FILENAME);
        Assert.assertTrue(!list.isEmpty());
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void readFileTestFalse() {
        TriangleReader.readFile("data/FileNotExist.txt");
    }

}
