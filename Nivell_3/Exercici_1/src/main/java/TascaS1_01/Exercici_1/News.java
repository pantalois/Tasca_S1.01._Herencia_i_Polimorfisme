package TascaS1_01.Exercici_1;

import java.util.Scanner;

public abstract class News {
    // EXPERT-NOTE: 'protected' es una buena elección aquí. Permite que las clases hijas
    // accedan a estas variables directamente, lo cual es útil en este caso.
    protected String headline;
    protected String text;
    protected int price;
    protected int points;

    public News(String headline, String text) {
        this.headline = headline;
        this.text = text;
        // EXPERT-NOTE: El precio y los puntos no se inicializan aquí,
        // porque es responsabilidad de cada subclase calcularlos.
    }

    // EXPERT-NOTE: ¡CORRECCIÓN CRÍTICA! Estos métodos deben ser abstractos y no estar comentados.
    // Al declararlos 'abstract', obligamos a TODAS las subclases (Soccer, Basketball, etc.)
    // a que implementen su propia lógica para calcular el precio y los puntos.
    // Este es el "contrato" que una clase abstracta impone a sus herederos.
    public abstract void calculatePrice();
    public abstract void calculatePoints();

    // --- Getters (Métodos para obtener datos) ---
    // EXPERT-NOTE: Los getters son públicos para que cualquier otra clase pueda leer los datos
    // de una noticia de forma segura.
    public String getHeadline() { return headline; }
    public int getPrice() { return price; }
    public int getPoints() { return points; }
    public String getText() { return text; }


    // EXPERT-NOTE: He refactorizado la creación de noticias para que sea más clara y robusta.
    // Este método estático actúa como una "fábrica" de noticias.
    public static News createNews() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Creando una nueva noticia ---");
        System.out.println("Elige la categoría deportiva:");
        System.out.println("1: Fútbol, 2: Baloncesto, 3: Tenis, 4: F1, 5: Motociclismo");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // EXPERT-NOTE: ¡IMPORTANTE! Limpiar el buffer del scanner después de leer un número.

        System.out.println("Introduce el titular de la noticia:");
        String headline = scanner.nextLine();
        // EXPERT-NOTE: El texto podría pedirse aquí también si fuera necesario.
        String text = "Texto de ejemplo...";

        // EXPERT-NOTE: Ahora, creamos el objeto específico según la elección.
        // Este switch devuelve directamente la instancia de la noticia ya creada.
        switch (categoryChoice) {
            case 1:
                // Para fútbol, necesitamos saber el club y jugador, que extraemos del titular.
                String soccerClub = Soccer.setClub(headline);
                String player = Soccer.setPlayer(headline);
                String soccerTournament = Soccer.setTournament(headline);
                return new Soccer(headline, text, soccerTournament, soccerClub, player);

            case 2:
                // Para baloncesto, podríamos pedir la competición y el club.
                String basketballTournament = Basketball.setTournament(headline);
                String basketballClub = Basketball.setClub(headline);
                return new Basketball(headline, text, basketballTournament, basketballClub);

            // EXPERT-NOTE: He dejado los otros casos para que los completes siguiendo el mismo patrón.
            case 3:
                //String tennisTournament = Tennis.setTournament(headline);
                String tennisPlayer = Tennis.setPlayer(headline);
                return new Tennis(headline, text, /*tennisTournament,*/ tennisPlayer);
            case 4:
                // Para F1, necesitamos la escudería.
                String f1Team = F1.setTeam(headline);
                return new F1(headline, text, f1Team);

            case 5:
                // Para Motociclismo, necesitamos el equipo.
                String motorcycleTeam = Motorcycle.setTeam(headline);
                return new Motorcycle(headline, text, motorcycleTeam);

            default:
                System.out.println("Categoría no válida. No se ha creado la noticia.");
                return null; // EXPERT-NOTE: Devolver null si la opción no es válida.
        }
    }
}

