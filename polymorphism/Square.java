package polymorphism;

public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public void getSquare() {
        System.out.println("S = " + side * side);
    }
}
