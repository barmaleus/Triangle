package by.rekuts.triangle.warehouse;

import by.rekuts.triangle.entity.Triangle;
import by.rekuts.triangle.parameter.TriangleAction;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class TriangleWarehouse implements Observer{
    private final static TriangleWarehouse TRIANGLE_WAREHOUSE = new TriangleWarehouse();

    private Map<Long, Observable> observableMap = new HashMap<>();
    private Map<Long, Double> squareMap = new HashMap();
    private Map<Long, Double> perimeterMap = new HashMap<>();

    private TriangleWarehouse() {
    }
    public static TriangleWarehouse getInstance() {
        return TRIANGLE_WAREHOUSE;
    }

    @Override
    public void update(Observable o, Object arg) {
        Triangle triangle = (Triangle) arg;
            observableMap.put(triangle.getId(), triangle);
            squareMap.put(triangle.getId(), TriangleAction.calculateSquare(triangle));
            perimeterMap.put(triangle.getId(), TriangleAction.calculatePerimeter(triangle));
    }

    public Map<Long, Observable> getObservableMap() {
        return observableMap;
    }

    public Map<Long, Double> getSquareMap() {
        return squareMap;
    }

    public Map<Long, Double> getPerimeterMap() {
        return perimeterMap;
    }
}