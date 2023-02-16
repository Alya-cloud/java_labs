abstract class Figure {
    public abstract double P();

    public abstract double S();

    String name;

    public Figure(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
