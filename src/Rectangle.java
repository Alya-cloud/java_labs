class Rectangle extends Figure {
    double a;
    double b;

    public Rectangle(double a, double b, String name) {
        super(name);
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return super.toString() + "a = " + a + ", b = " + b;
    }

    public double P() {
        return 2 * (a + b);
    }

    public static double P(double a, double b) {
        return (a + b) * 2;
    }

    public static double P(Rectangle r) {
        return r.P();
    }

    public double S() {
        return a * b;
    }

    public static double S(double a, double b) {
        return a * b;
    }

    public static double S(Rectangle r) {
        return r.S();
    }
}