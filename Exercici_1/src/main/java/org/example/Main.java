package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean chooseInstrument = false;
        Scanner scanner = new Scanner(System.in);
      //  while (valor){
            //1.Gestión de la lógica de las clases (¿Dentro de bucle while?)
        System.out.println("Choose a kind of instrument: Wind, String or Percussion ");
        String instrument = scanner.nextLine();
        System.out.println(instrument);
        while (!chooseInstrument)
        {
            switch (instrument) {
                case "Wind", "wind", "String", "string", "Percussion", "percussion":
                    System.out.println(instrument);
                    chooseInstrument = true;
                default:
                    System.out.println("You wrote " + instrument + "please, choose between Wind/wind, String/string or Percussion/percussion");
                    instrument = scanner.nextLine();
            }


        }
        System.out.println("That instrument is amazing! ");

        //2.Crear clase instrumento, la cual tiene los atributos de nombre y precio.
        //3.De esta clase instrumento se hereda la estructura de nombre y precio.
        //4.Pedir por terminal que se toque un instrumento para que por pantalla salga que intrumento se está tocando.
    }
}


