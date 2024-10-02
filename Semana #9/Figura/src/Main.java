import models.Circle;
import models.Square;
import models.Triangle;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(7);
        System.out.println("Square area: " + square1.calculateArea());
        System.out.println("Square perimeter " + square1.calculatePerimeter());
        Triangle triangle1  = new Triangle(9, 5, 7, 4);
        System.out.println("Triangle area: " + triangle1.calculateArea());
        System.out.println("Triangle perimeter: " + triangle1.calculatePerimeter());
        Circle circle1 = new Circle(3);
        System.out.println("Circle area: " + circle1.calculateArea());
        System.out.println("Circle circumference " + circle1.calculatePerimeter());
    }
}