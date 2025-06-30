package TascaS1_01.Ejercicio_01;

public class StringInstrument extends Instrument {
    public StringInstrument(String name, double price) {
        super(name, price);

    }
    @Override
    public String play() {
        return "A string instrument is playing ";
    }
}

