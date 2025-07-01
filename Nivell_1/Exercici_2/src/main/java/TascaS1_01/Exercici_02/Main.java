package TascaS1_01.Exercici_02;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("100Cv");

        System.out.println("The car" + Car.brand + Car.model + car.accelerate());
        System.out.println("The car" + Car.brand + Car.model + Car.brake());
        System.out.println("It´s power is " + car.power);
    }
}