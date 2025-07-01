package TascaS1_01.Exercici_02;

import utils
public class Main {
    public static void main(String[] args) {


        Phone phone = new Phone("Iphone", "12");
        phone.call("111");
        Smartphone smartphone = new Smartphone("Oppo", "5");
        smartphone.call("1234");
        smartphone.alarm();
        smartphone.photograph();
    }
}