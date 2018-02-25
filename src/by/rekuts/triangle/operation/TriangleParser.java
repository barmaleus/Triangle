package by.rekuts.triangle.operation;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.rekuts.triangle.exception.TriangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleParser {
    private static final Logger logger = LogManager.getLogger(TriangleParser.class.getName());

    private static int COORDINATES_QUANTITY_MINIMUM = 6;

    public static ArrayList<Double[]> createDoublesList(ArrayList<String> coordinatesStringsList) {
        ArrayList<String> stringsList = new ArrayList<>(coordinatesStringsList);
        ArrayList<Double[]> doublesList = new ArrayList<>();

        for (String s : stringsList) {
            Double[] doublesArray = createDoublesArray(s);
            if (doublesArray != null) {
                doublesList.add(doublesArray);
            }
        }
        return doublesList;
    }

    public static Double[] createDoublesArray(String stringData) {
        String[] stringsArray = stringData.split("\\s");
        Double[] doublesArray = new Double[stringsArray.length];

        if (
                stringsArray.length >= COORDINATES_QUANTITY_MINIMUM
                        && stringsArray.length > 0
                        && validateParsingArray(stringsArray)) {

            for (int i = 0; i < stringsArray.length; i++) {
                double doubleTmp = Double.parseDouble(stringsArray[i]);
                doublesArray[i] = doubleTmp;
            }
            logger.log(Level.INFO, "Coordinates have been added.");
            return doublesArray;
        } else {
            try {
                throw new TriangleException();
            } catch (TriangleException e) {
                logger.log(Level.WARN, e.getClass().getName() + " It is impossible to read coordinates.");
            }
            return null;
        }
    }

    public static boolean validateParsingArray(String[] stringsToParse) {
        boolean booleanKeeper = true;
        for (String stringToParse : stringsToParse) {
            Pattern p = Pattern.compile("^[-+]?([0-9]*[.])?[0-9]+$");
            Matcher m = p.matcher(stringToParse);
            if (!m.matches()) {
                return booleanKeeper = false;
            }
        }
        return booleanKeeper;
    }
}
