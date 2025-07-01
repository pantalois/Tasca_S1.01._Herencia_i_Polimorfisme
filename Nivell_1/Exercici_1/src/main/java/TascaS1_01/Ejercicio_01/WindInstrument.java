package TascaS1_01.Ejercicio_01;

public class WindInstrument extends Instrument {
    public WindInstrument(String name, double price) {
        super(name, price);

    }
    @Override
    public String play() {
        return "A wind instrument is playing ";
    }
}

