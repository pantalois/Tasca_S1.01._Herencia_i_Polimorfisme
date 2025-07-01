package TascaS1_01.Exercici_02;

public class Car{
    static final String brand = " Citroen";
    static String model = " Picasso";
    final String power;


    public Car(String power){
        this.power = power;
    }
    public static String brake(){
        return " is braking ";
    }

    public String accelerate(){
        return " is accelerating ";
    }

}