package models;

public class Circle implements IShape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public float calculateArea() {
        return (float) (3.14 * (radius * radius));
    }

    @Override
    public float calculatePerimeter() {
        return (float) (2 * 3.1 * radius);
    }
}
