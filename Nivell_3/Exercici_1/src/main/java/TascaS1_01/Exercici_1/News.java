package TascaS1_01.Exercici_1;

import java.util.Scanner;

public class News{
    public final String headline;
    public String text;
    public final int price;
    public final int points;
    public String category;

    public News(String headline, String text, int price, int points, String category) {
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.points = points;
        this.category = category;
    }

    public static News createNews(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the choosen Sport:" +
                "1: Soccer" +
                "2: Basketball" +
                "3: Tennis" +
                "4: F1" +
                "5: Motorcycle");
        int category = scanner.nextInt();
        //Separar switch en método selector.
        News.setCategory(category);
        return new News();
    }

    public static void setCategory(int category){
        switch (category){
            case 1 ->{
                //calculate price soccer

            }
            case 2 ->{

            }
            case 3->{

            }
            case 4->{

            }
            case 5->{

            }
            default -> {
                System.out.println("You did not write 1, 2, 3, 4 or 5, please, try again");
            }

        }

    }













}
