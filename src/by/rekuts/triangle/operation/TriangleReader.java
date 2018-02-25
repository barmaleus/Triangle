package by.rekuts.triangle.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleReader {
    private static final Logger logger = LogManager.getLogger(TriangleParser.class.getName());
    public static final String FILENAME = "data/Triangle.txt";

    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> list;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName)))  {
                    list = (ArrayList<String>) bufferedReader.lines().collect(Collectors.toList());
                    logger.log(Level.INFO, "File has been read.\n");
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getClass().getName() + " Can't read the file. The application will be closed.");
            throw new RuntimeException();
        }

        return list;
    }
}
