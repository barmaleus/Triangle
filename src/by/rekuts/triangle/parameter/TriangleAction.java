package by.rekuts.triangle.parameter;

import by.rekuts.triangle.entity.Triangle;

public class TriangleAction {
    public static double calculatePerimeter(Triangle triangle) {
        double aX = triangle.getFirstPoint().getX();
        double aY = triangle.getFirstPoint().getY();
        double bX = triangle.getSecondPoint().getX();
        double bY = triangle.getSecondPoint().getY();
        double cX = triangle.getThirdPoint().getX();
        double cY = triangle.getThirdPoint().getY();

        double firstSide = Math.hypot(bX - aX, bY - aY);
        double secondSide = Math.hypot(cX - bX, cY - bY);
        double thirdSide = Math.hypot(aX - cX, aY - cY);

        return firstSide + secondSide + thirdSide;
    }

    public static double calculateSquare(Triangle triangle) {
        double aX = triangle.getFirstPoint().getX();
        double aY = triangle.getFirstPoint().getY();
        double bX = triangle.getSecondPoint().getX();
        double bY = triangle.getSecondPoint().getY();
        double cX = triangle.getThirdPoint().getX();
        double cY = triangle.getThirdPoint().getY();

        double squareTriangle = Math.abs((aX - cX) * (bY - cY) - (bX - cX) * (aY - cY))/2;

        return squareTriangle;
    }
}
