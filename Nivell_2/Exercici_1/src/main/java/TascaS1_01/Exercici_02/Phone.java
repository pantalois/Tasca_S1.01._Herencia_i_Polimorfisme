package TascaS1_01.Exercici_02;

public class Phone{
    private final String brand;
    private final String model;

    public Phone(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public void call(String phoneNumber){
        System.out.println("You are calling to " + phoneNumber + " with your " + getBrand() + " " + getModel());
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
