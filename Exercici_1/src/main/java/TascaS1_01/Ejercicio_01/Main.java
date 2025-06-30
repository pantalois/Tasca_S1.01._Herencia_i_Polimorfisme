package TascaS1_01.Ejercicio_01;

import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean loopStart = true;
        Scanner scanner = new Scanner(System.in);
        while (loopStart)
        {
            System.out.println("Choose a type of instrument: Wind, String or Percussion ");
            System.out.println("If you want to exit the program write 'exit'");
            String instrument = scanner.nextLine();
            switch (instrument) {
                case "Wind", "wind" -> {
                    WindInstrument wind = new WindInstrument("Clarinet", 299.99);
                    System.out.println(wind.play());
                    System.out.println("Sounds good, right? That´s an " + wind.getName() + " and only costs " + wind.getPrice());
                }
                case "String","string" -> {
                    StringInstrument string = new StringInstrument("Guitar", 499.99);
                    System.out.println(string.play());
                    System.out.println("Sounds good, right? That´s an " + string.getName() + " and only costs " + string.getPrice());
                }
                case "Percussion", "percussion" -> {
                    PercussionInstrument percussion = new PercussionInstrument("Drums", 799.99);
                    System.out.println(percussion.play());
                    System.out.println("Sounds good, right? That´s an " + percussion.getName() + " and only costs " + percussion.getPrice());

                }
                case "exit" ->{
                    loopStart = false;
                }
                default -> {
                    System.out.println("You wrote " + instrument + " please, choose between Wind/wind, String/string or Percussion/percussion");
                    System.out.println("If you want to exit the program write 'exit'");
                    instrument = scanner.nextLine();
                    if (instrument.equals("exit")) {
                        loopStart = false;
                    }
                }
            }


        }
    }
}


