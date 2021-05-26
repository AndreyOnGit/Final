import polymorphism.Shape;
import polymorphism.Square;
import polymorphism.Triangle;
import polymorphism.Сircle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
         * 1. Создать builder для класса Person со следующими полями: String firstName, String lastName,
         * String middleName, String country, String address, String phone, int age, String gender.
         * package builder;
         */

        /*  2. Описать ошибки в коде и предложить варианты оптимизации:
         *    interface Moveable {
         *        void move();
         *    }
         *    interface Stopable {
         *        void stop();
         *    }
         *    abstract class Car {
         *        public Engine engine;  //todo public заменить на privet, это обосунет getEngine()
         *        private String color;
         *        private String name;
         *        protected void start() { System.out.println("Car starting");} //todo пропущен глагол
         *        abstract void open();
         *        public Engine getEngine() {return engine;}
         *        public void setEngine(Engine engine) {this.engine = engine;}
         *        public String getColor() {return color;}
         *        public void setColor(String color) {this.color = color;}
         *        public String getName() {return name;}
         *        public void setName(String name) {this.name = name;}
         *    }
         *    class LightWeightCar extends Car implements Moveable{
         *        @Override
         *        void open() {System.out.println("Car is open");}
         *        @Override
         *        public void move() {System.out.println("Car is moving");}
         *    }
         *    0 //todo опечатка
         *    class Lorry extends Car, Moveable, Stopable{ todo экстендится Car, но Moveable и Stopable имплементятся
         *        public void move(){System.out.println("Car is moving");} //todo для читальбельности добавить @Override
         *        public void stop(){System.out.println("Car is stop");} //todo для читальбельности добавить @Override
         *        //todo  @Override void open() {}
         *    }
         * //todo странное разделение функционала на класс и интерефейсы move и stop в разных интерфейсах,
         *    LightWeightCar без Stopable;
         * //todo абстракный класс в настоящем случае мог бы имплементить один Moveable;
         * //todo при условии, что все авто должны выполнять все вышеупомянутые методы, сделать один абстрактный класс с
         *    абстрактными методами;
         * //todo open() логично сделать public

         */

        /*
         * 3. Написать пример кода, который реализует принцип полиморфизма, на примере фигур — круг, квадрат,
    треугольник.
         * package polymorphism;
         */
    }

}

