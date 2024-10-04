package models;

public class Square implements IShape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public float calculateArea() {
        return this.side * side;
    }

    @Override
    public float calculatePerimeter() {
        return this.side * 4;
    }
}