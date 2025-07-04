package TascaS1_01.Exercici_1.model;

public class Basketball extends News {
    private final String competition;
    private final String club;

    public Basketball(String headline, String text, String competition, String club) {
        super(headline, text);
        this.competition = competition;
        this.club = club;
    }

    @Override
    public void calculatePrice() {
        int calculatedPrice = 250;
        if ("NBA".equalsIgnoreCase(this.competition)){
            calculatedPrice += 75;
        }
        if ("Barça".equalsIgnoreCase(this.club) || "Lakers".equalsIgnoreCase(this.club)){
            calculatedPrice += 50;
        }
        this.price = calculatedPrice;
    }

    @Override
    public void calculatePoints() {
        int calculatedPoints = 4;
        if ("NBA".equalsIgnoreCase(this.competition)){
            calculatedPoints += 3;
        }
        if ("Euroliga".equalsIgnoreCase(this.competition)){
            calculatedPoints += 2;
        }
        if ("Barça".equalsIgnoreCase(this.club) || "Lakers".equalsIgnoreCase(this.club)){
            calculatedPoints += 1;
        }
        this.points = calculatedPoints;
    }

    public static String setTournament(String headline) {
        if (headline.toLowerCase().contains("euroleague")) {
            return "Euroleague";
        }
        return "No relevant tournament";
    }

    public static String setClub(String headline) {
        if (headline.toLowerCase().contains("barça")) {
            return "Barça";
        } else if (headline.toLowerCase().contains("madrid")) {
            return "Madrid";
        } else {
            return "No relevant Club";
        }
    }
}