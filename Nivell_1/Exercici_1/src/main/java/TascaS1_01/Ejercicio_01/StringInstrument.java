package TascaS1_01.Ejercicio_01;

public class StringInstrument extends Instrument {
    public StringInstrument(String name, double price) {
        super(name, price);

    }

    static void staticMethod(){
        System.out.println("This is a static method inside the StringInstrument class.");
    }
    @Override
    public String play() {
        return "A string instrument is playing ";
    }
}

