package TascaS1_01.Exercici_1;

public class Motorcycle extends News {
    private final String team;

    public Motorcycle(String headline, String text, String team) {
        super(headline, text);
        this.team = team;
    }

    @Override
    public void calculatePrice() {
        price = 100;
        if ("Honda".equalsIgnoreCase(team) || "Yamaha".equalsIgnoreCase(team)){
            price += 50;
        }
    }

    @Override
    public void calculatePoints() {
        points = 3;
        if ("Honda".equalsIgnoreCase(team) || "Yamaha".equalsIgnoreCase(team)){
            points += 3;
        }
    }

    public static String setTeam(String headline) {
        if (headline.toLowerCase().contains("honda")) {
            return "Honda";
        }
        if (headline.toLowerCase().contains("yamaha")) {
            return "Yamaha";
        }
        else{
            return "No relevant team";
        }
    }
}
