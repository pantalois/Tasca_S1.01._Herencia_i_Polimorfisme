package TascaS1_01.Exercici_1;

import java.security.Key;
import java.util.*;


public class Editor{
    public String name;
    public final String DNI; // final es correcto para un valor que no debe cambiar.
    public int salary;
    public List<Object> news;

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
    public Object getNews() {
        return news;
    }
    public String getName() {
        return name;
    }

    public Map<Editor, List<News>> setNews(Map<Editor, List<News>> companyStruct, News currentNew) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("setNews");
        System.out.println(companyStruct);
        System.out.println("This are your current editors ");
        //puede que metamos esto en un bucle para que hasta que no elija al redactor no avance
        //Crear una lista vacía de editores para hacer la selección más cómoda.
        //Esto puede ser que lo pasemos a otro método que sea list editors.
        List<Editor> editors = new ArrayList<>();
        for (Editor editor : companyStruct.keySet()) {
            System.out.println("Editor: " + editor.getName());
            editors.add(editor);
            List<News> newsList = companyStruct.get(editor);
            System.out.println("Noticias asignadas:");

            for (News news : newsList) {
                System.out.println("- " + news.getHeadline());
            }

            System.out.println(); // Línea en blanco entre editores
        }
        System.out.println("Choose the editor so assign the current news :" + currentNew.getHeadline());
        String election = scanner.nextLine();
        while (!editors.contains("election")){
            System.out.println("You did not write properly the name of the editor, please, choose between " + editors);
        }
        System.out.println("News " + currentNew.getHeadline() + " assigned to " + election);
        companyStruct.put()//Cómo hago para poner el editor objeto correcto en mi struct

        // EXPERT-NOTE: He eliminado el método 'assingNews' porque 'setNews' ya hace ese trabajo.
        // Es mejor tener un solo método que haga una cosa para evitar confusiones.
        return companyStruct;
    }


    @Override
    public String toString() {
        return "Editor " + this.name + " with DNI " + this.DNI + " and salary of 1500€ is working in " + news;
    }
}




"""
public Map<Editor, List<News>> setNews(Map<Editor, List<News>> companyStruct, News currentNew) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Asignar Noticia ---");
        System.out.println("Estructura actual de la compañía: " + companyStruct); // Para depuración

        System.out.println("\nEstos son tus editores actuales:");

        // Paso 1: Mostrar los editores y sus noticias asignadas
        // Y almacenar los editores en una lista temporal para facilitar la selección.
        List<Editor> availableEditors = new ArrayList<>(); // Renombrado para mayor claridad
        for (Editor editor : companyStruct.keySet()) {
            System.out.println("  Editor: " + editor.getName()); // Usar getName() para imprimir el nombre
            availableEditors.add(editor); // Añadir el objeto Editor a la lista

            List<News> newsList = companyStruct.get(editor);
            System.out.println("    Noticias asignadas:");
            if (newsList == null || newsList.isEmpty()) {
                System.out.println("      (Ninguna noticia asignada)");
            } else {
                for (News news : newsList) {
                    // Aquí asumimos que News.getHeadline() no devuelve null y que News tiene un toString() adecuado
                    System.out.println("      - " + news.getHeadline());
                }
            }
            System.out.println(); // Línea en blanco entre editores
        }

        // Paso 2: Pedir al usuario que elija un editor y validar la entrada
        Editor chosenEditor = null;
        String electionName;

        while (chosenEditor == null) {
            System.out.println("Elige el editor al que asignar la noticia: '" + currentNew.getHeadline() + "'");
            System.out.print("Introduce el nombre del editor: ");
            electionName = scanner.nextLine().trim(); // .trim() para eliminar espacios en blanco al inicio/final

            // Buscar el objeto Editor que coincide con el nombre introducido
            for (Editor editor : availableEditors) {
                if (editor.getName().equalsIgnoreCase(electionName)) { // Ignorar mayúsculas/minúsculas para la comparación
                    chosenEditor = editor; // Hemos encontrado el editor
                    break; // Salir del bucle una vez encontrado
                }
            }

            if (chosenEditor == null) {
                System.out.println("Error: El nombre '" + electionName + "' no corresponde a ningún editor existente.");
                System.out.println("Por favor, elige entre los siguientes nombres:");
                for (Editor editor : availableEditors) {
                    System.out.print("'" + editor.getName() + "' ");
                }
                System.out.println("\n"); // Añadir un salto de línea
            }
        }

        // Paso 3: Asignar la noticia al editor elegido
        System.out.println("Noticia '" + currentNew.getHeadline() + "' asignada a '" + chosenEditor.getName() + "'.");

        // Obtener la lista de noticias actual del editor
        List<News> editorsNews = companyStruct.get(chosenEditor);

        // Si la lista de noticias es null (porque al inicio el editor no tenía noticias), inicialízala
        if (editorsNews == null) {
            editorsNews = new ArrayList<>();
            companyStruct.put(chosenEditor, editorsNews); // Poner la nueva lista vacía en el mapa
        }

        // Añadir la nueva noticia a la lista del editor
        editorsNews.add(currentNew);

        System.out.println("\n--- Estructura de la compañía después de la asignación ---");
        System.out.println(companyStruct); // Para ver el resultado final

        // EXPERT-NOTE: He eliminado el método 'assingNews' porque 'setNews' ya hace ese trabajo.
        // Es mejor tener un solo método que haga una cosa para evitar confusiones.
        // scanner.close(); // Generalmente no se cierra el scanner si es global o se usa en otros métodos.
        // Si el scanner se crea y cierra aquí, asegúrate de que no lo necesitas en otro lugar.
        // Para aplicaciones de consola simples, a menudo se usa un solo scanner abierto durante toda la ejecución.

        return companyStruct;
    }
}
"""
