package TascaS1_01.Exercici_1;

public class Tennis extends News {
    private final String player;

    public Tennis(String headline, String text, /*String tournament,*/ String player) {
        super(headline, text);
        this.player = player;
    }

    @Override
    public void calculatePrice() {
        price = 150;
        if ("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)) price += 100;
    }

    @Override
    public void calculatePoints() {
        points = 4;
        if ("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)) points += 3;
    }

    public static String setPlayer(String headline) {
        if (headline.contains("Federer")){
            return "Federer";
        }
        else if (headline.contains("Nadal")){
            return "Nadal";
        }
        else if (headline.contains("Djokovic")){
            return "Djokovic";
        }
        else{
            return "No relevant player";
        }
    }
}

