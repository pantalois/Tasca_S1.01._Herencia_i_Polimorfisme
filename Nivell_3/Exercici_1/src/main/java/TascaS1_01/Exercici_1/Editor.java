package TascaS1_01.Exercici_1;

import java.util.Scanner;

public class Editor {
    public String name;
    public final String DNI; // final es correcto para un valor que no debe cambiar.
    public int salary;
    private News news; // private es correcto para aplicar encapsulamiento.

    public Editor(String name, String DNI) {
        this.name = name;
        this.DNI = DNI;
        this.salary = 1500; // Salario inicial por defecto.
        this.news = null; // Un editor empieza sin noticias asignadas.
    }

    // --- Métodos estáticos para gestionar editores ---
    public static Editor initEditor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Contratando nuevo Editor ---");
        System.out.println("Nombre del editor:");
        String name = scanner.nextLine();
        System.out.println("DNI del editor:");
        String DNI = scanner.nextLine();
        System.out.println("¡Editor " + name + " contratado con un salario de 1500€!");
        return new Editor(name, DNI);
    }

    // EXPERT-NOTE: La lógica de "despedir" puede ser simplemente eliminar la referencia al objeto.
    // En el main, haremos 'editor = null;'.
    // Este método podría tener más lógica, como reasignar las noticias del editor despedido.
    public static void fireEditor(Editor editor) {
        System.out.println("El editor " + editor.name + " ha sido despedido.");
        // La variable que apunta a este editor se pondrá a null en el main.
    }

    // --- Getters y Setters para las noticias ---
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
        // EXPERT-NOTE: He eliminado el método 'assingNews' porque 'setNews' ya hace ese trabajo.
        // Es mejor tener un solo método que haga una cosa para evitar confusiones.
    }
}