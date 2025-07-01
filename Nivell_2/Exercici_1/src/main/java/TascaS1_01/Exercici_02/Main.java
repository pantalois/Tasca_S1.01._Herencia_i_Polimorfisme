package TascaS1_01.Exercici_02;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Smartphone smartphone = new Smartphone("Oppo", "5");
        smartphone.call("123456789");
        smartphone.alarm();
        smartphone.photograph();
    }
}