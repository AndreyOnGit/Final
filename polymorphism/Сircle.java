package polymorphism;

public class Сircle implements Shape {
    private int radius;

    public Сircle(int radius) {
        this.radius = radius;
    }

    @Override
    public void getSquare() {
        System.out.println("S = " + radius * radius * Math.PI);
    }
}
