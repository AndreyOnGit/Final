package polymorphism;

public class Triangle implements Shape {
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void getSquare() {
        System.out.println("S = " + base * height / 2);
    }
}
