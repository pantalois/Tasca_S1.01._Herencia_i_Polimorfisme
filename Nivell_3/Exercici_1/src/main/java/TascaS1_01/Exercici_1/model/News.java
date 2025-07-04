package TascaS1_01.Exercici_1.model;

import java.util.Scanner;


import java.util.Scanner;

public abstract class News {
    protected String headline;
    protected String text;
    protected int price;
    protected int points;

    public News(String headline, String text) {
        this.headline = headline;
        this.text = text;

    }

    public abstract void calculatePrice();
    public abstract void calculatePoints();


    public String getHeadline() {
        return headline;
    }
    public int getPrice() {
        return price;
    }
    public int getPoints() {
        return points;
    }
    public String getText() {
        return text;
    }


    public static News createNews() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the sport category:");
        System.out.println("1: Soccer, 2: Basketball, 3: Tennis, 4: F1, 5: Motorcycling");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the headline of the news item:");
        String headline = scanner.nextLine();

        String text = "This is what the editor would have written ";

        switch (categoryChoice) {
            case 1:
                String soccerClub = Soccer.setClub(headline);
                String player = Soccer.setPlayer(headline);
                String soccerTournament = Soccer.setTournament(headline);
                return new Soccer(headline, text, soccerTournament, soccerClub, player);

            case 2:
                String basketballTournament = Basketball.setTournament(headline);
                String basketballClub = Basketball.setClub(headline);
                return new Basketball(headline, text, basketballTournament, basketballClub);

            case 3:
                String tennisPlayer = Tennis.setPlayer(headline);
                return new Tennis(headline, text, tennisPlayer);

            case 4:
                String f1Team = F1.setTeam(headline);
                return new F1(headline, text, f1Team);

            case 5:
                String motorcycleTeam = Motorcycle.setTeam(headline);
                return new Motorcycle(headline, text, motorcycleTeam);

            default:
                System.out.println("Invalid category. The news item has not been created.");
                return null;
        }

    }
}

