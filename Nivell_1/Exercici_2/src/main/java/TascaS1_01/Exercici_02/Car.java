package TascaS1_01.Exercici_02;

public class Car{
    static final String brand = " Citroen";
    private static String model = " Picasso";
    private final String power;


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