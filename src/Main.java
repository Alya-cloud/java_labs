import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Triangle t = new Triangle(3, 4, 5, "Треугольник: ");
        Triangle.P(t.a, t.b, t.c);
        Triangle.P(t);
        System.out.println(t.toString());
        System.out.println("p = " + t.P());
        Triangle.S(t.a, t.b, t.c);
        Triangle.S(t);
        System.out.println("s = " + t.S());
        Rectangle r = new Rectangle(3, 4, "Четырехугольник: ");
        Rectangle.P(r.a, r.b);
        Rectangle.P(r);
        System.out.println(r.toString());
        System.out.println("p = " + r.P());
        Rectangle.S(r.a, r.b);
        Rectangle.S(r);
        System.out.println("s = " + r.S());
    }
}