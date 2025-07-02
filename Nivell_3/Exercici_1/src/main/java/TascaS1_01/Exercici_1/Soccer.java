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

    // EXPERT-NOTE: ¡CORRECCIÓN! El método 'calculatePrice' no debe recibir parámetros
    // y debe usar la anotación @Override para asegurar que está implementando
    // correctamente el método abstracto de la clase News.
    // Utiliza las variables de la instancia (this.headline, this.club, etc.).
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
        this.price = calculatedPrice; // Asignamos el resultado a la variable 'price' heredada.
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
        this.points = calculatedPoints; // Asignamos el resultado a la variable 'points' heredada.
    }

    // EXPERT-NOTE: Estos métodos estáticos son útiles como "helpers" para extraer
    // información del titular. Los he mantenido porque es un buen enfoque.
    public static String setTournament(String headline) {
        if (headline.toLowerCase().contains("champions")){
            return "Champions";
        }
        if (headline.toLowerCase().contains("league")){
            return "League";
        }
        else{
            return "No relevant tournament";
        }
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