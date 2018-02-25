package by.rekuts.triangle.entity;

import by.rekuts.triangle.warehouse.TriangleWarehouse;

import java.io.*;
import java.util.Observable;

public class Triangle extends Observable implements Serializable {

    private static long count = 1000;
    private long id;
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.id = ++count;
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        addObserver(TriangleWarehouse.getInstance());
        setChanged();
        notifyObservers(this);
    }

    public long getId() {
        return id;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
        setChanged();
        notifyObservers(this);
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
        setChanged();
        notifyObservers(this);
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
        setChanged();
        notifyObservers(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return firstPoint.equals(triangle.firstPoint) &&
                secondPoint.equals(triangle.secondPoint) &&
                thirdPoint.equals(triangle.thirdPoint);
    }

    @Override
    public int hashCode() {
        int result = firstPoint.hashCode();
        result = 31 * result + secondPoint.hashCode();
        result = 31 * result + thirdPoint.hashCode();
        return result;
    }

    public String toString() {
        return "\nid " + id + "\nfirstPoint " + firstPoint
                + "\nsecondPoint " + secondPoint + "\nthirdPoint " + thirdPoint;
    }

    public void serializeTriangle() {
            File fw = new File("output/serializedTriangle.txt");
            try {
                ObjectOutputStream ostream =
                        new ObjectOutputStream(
                                new FileOutputStream(fw));
                ostream.writeObject(this);  //this or triangle
                ostream.close();

                //log4j
            } catch (IOException e) {
                System.err.println(e);

                //log4j
            }
    }

    public void deserializeTriangle() {
        File fr = new File("output/serializedTriangle.txt");
        try {
            ObjectInputStream istream =
                    new ObjectInputStream(
                            new FileInputStream(fr));
            Triangle unknown =
                    (Triangle)istream.readObject();
            istream.close();
            System.out.println(unknown);
            //log4j
        } catch (ClassNotFoundException ce) {
            System.err.println(ce);
            System.err.println("Класс не существует");
            //log4g
        } catch (FileNotFoundException fe) {
            System.err.println(fe);
            System.err.println("Файл не найден");
            //log4j
        } catch (IOException ioe) {
            System.err.println(ioe);
            System.err.println("Ошибка доступа");
            //log4j
        }
    }
}
