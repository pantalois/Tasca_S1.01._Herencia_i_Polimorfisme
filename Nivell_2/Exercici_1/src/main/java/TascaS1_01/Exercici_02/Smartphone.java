package TascaS1_01.Exercici_02;


public class Smartphone extends Phone implements Camera, Clock{

    public Smartphone(String brand, String model){
        super(brand, model);
    }

    @Override
    public void photograph(){
        System.out.println("You are taking a picture with your " + getBrand() + getModel());
    }

    @Override
    public void alarm(){
        System.out.println("The alarm of your " + getBrand() + " " + getModel() + " is ringing");
    }
}