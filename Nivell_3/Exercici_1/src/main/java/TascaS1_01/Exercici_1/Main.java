package TascaS1_01.Exercici_1;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- INICIO DEL PROGRAMA DE GESTIÓN DE NOTICIAS ---");

        // 1. Contratamos a un editor.
        // El método estático 'initEditor' se encarga de pedir los datos y crear el objeto.
        Editor editor = Editor.initEditor();
        System.out.println("Editor creado: " + editor.name + " con DNI " + editor.DNI);

        System.out.println("\n-------------------------------------------------\n");

        // 2. Creamos una noticia.
        // Usamos el método de fábrica 'createNews' de la clase News.
        News noticia = News.createNews();

        // 3. Verificamos si la noticia se creó correctamente.
        // EXPERT-NOTE: ¡CORRECCIÓN CRÍTICA! Siempre hay que comprobar si un objeto es 'null'
        // después de un método que podría devolverlo, para evitar un 'NullPointerException'.
        if (noticia != null) {
            System.out.println("Noticia creada con el titular: \"" + noticia.getHeadline() + "\"");

            // 4. Asignamos la noticia al editor.
            editor.setNews(noticia);
            System.out.println("Noticia asignada al editor " + editor.name + ".");

            // 5. Calculamos y mostramos el precio y los puntos de la noticia.
            // Estos métodos usarán la implementación específica de la subclase (Soccer, Basketball, etc.).
            noticia.calculatePrice();
            noticia.calculatePoints();

            System.out.println("\n--- Detalles de la Noticia ---");
            System.out.println("Precio de la noticia: " + noticia.getPrice() + "€");
            System.out.println("Puntuación de la noticia: " + noticia.getPoints() + " puntos");

        } else {
            System.out.println("La operación de creación de noticias fue cancelada o falló.");
        }

        System.out.println("\n-------------------------------------------------\n");

        // 6. Despedimos al editor.
        Editor.fireEditor(editor);
        editor = null; // Para que el recolector de basura de Java libere la memoria.

        System.out.println("--- FIN DEL PROGRAMA ---");
    }
}