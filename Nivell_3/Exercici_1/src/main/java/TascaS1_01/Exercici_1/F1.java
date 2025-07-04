// Ejemplo con F1.java (aplica el mismo cambio a Tennis y Motorcycle)
package TascaS1_01.Exercici_1;

public class F1 extends News {
    private final String team;

    public F1(String headline, String text, String team) {
        super(headline, text);
        this.team = team;
    }

    @Override
    public void calculatePrice() {
        price = 100;
        if ("Ferrari".equalsIgnoreCase(team) || "Mercedes".equalsIgnoreCase(team)){
            price += 50;
        }
    }

    @Override
    public void calculatePoints() {
        points = 4;
        if ("Ferrari".equalsIgnoreCase(team) || "Mercedes".equalsIgnoreCase(team)){
            points += 2;
        }
    }

    public static String setTeam(String headline) {
        if (headline.toLowerCase().contains("ferrari")) {
            return "Ferrari";
        }
        else if (headline.toLowerCase().contains("mercedes")) {
            return "Mercedes";
        }
        else {
            return "No relevant team";
        }
    }
}