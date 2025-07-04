package TascaS1_01.Exercici_1;

public class Soccer extends News {
    private final String tournament;
    private final String club;
    private final String player;

    public Soccer(String headline, String text, String tournament, String club, String player) {
        super(headline, text);
        this.tournament = tournament;
        this.club = club;
        this.player = player;
    }

    @Override
    public void calculatePrice() {
        int calculatedPrice = 300;
        if ("Champions".equalsIgnoreCase(this.tournament)){
            calculatedPrice += 100;
        }
        if ("Barça".equalsIgnoreCase(this.club) || "Madrid".equalsIgnoreCase(this.club)){
            calculatedPrice += 100;
        }
        if ("Ferran Torres".equalsIgnoreCase(this.player) || "Benzema".equalsIgnoreCase(this.player)){
            calculatedPrice += 50;
        }
        this.price = calculatedPrice;
    }

    @Override
    public void calculatePoints() {
        int calculatedPoints = 5;
        if ("Champions".equalsIgnoreCase(this.tournament)){
            calculatedPoints += 3;
        }
        else if ("League".equalsIgnoreCase(this.tournament)){
            calculatedPoints += 2;
        }
        if ("Barça".equalsIgnoreCase(this.club) || "Madrid".equalsIgnoreCase(this.club)){
            calculatedPoints += 1;
        }
        if ("Ferran Torres".equalsIgnoreCase(this.player) || "Benzema".equalsIgnoreCase(this.player)){
            calculatedPoints += 1;
        }
        this.points = calculatedPoints;
    }

    public static String setTournament(String headline) {
        if (headline.toLowerCase().contains("champions")){
            return "Champions";
        }
        if (headline.toLowerCase().contains("league")){
            return "League";
        }
        return "No relevant tournament";
    }

    public static String setClub(String headline) {
        if (headline.toLowerCase().contains("barça")){
            return "Barça";
        }
        else if (headline.toLowerCase().contains("madrid")){
            return "Madrid";
        }
        else{
            return "No relevant club";
        }
    }

    public static String setPlayer(String headline) {
        if (headline.contains("Ferran Torres")){
            return "Ferran Torres";
        }
        else if (headline.contains("Benzema")){
            return "Benzema";
        }
        else{
            return "No relevant player";
        }
    }
}