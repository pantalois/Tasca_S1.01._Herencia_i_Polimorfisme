package TascaS1_01.Ejercicio_01;

public class PercussionInstrument extends Instrument {
    public PercussionInstrument(String name, double price) {
        super(name, price);

    }
    @Override
    public String play() {
        return "A percussion instrument is playing ";
    }
}

