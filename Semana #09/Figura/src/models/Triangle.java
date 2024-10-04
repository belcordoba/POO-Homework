package models;

public class Triangle implements IShape {
    private int base;
    private int height;
    private int side2;
    private int side3;

    public Triangle(int base, int height, int side2, int side3) {
        this.base = base;
        this.height = height;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public float calculateArea() {
        return (float) (0.5 * base * height);
    }

    @Override
    public float calculatePerimeter() {
        return base+side2+side3;
    }
}
