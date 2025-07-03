package TascaS1_01.Exercici_1;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- INICIO DEL PROGRAMA DE GESTIÓN DE NOTICIAS ---");

        //0. Inicio la estructura de la compañía que estará a null para poder comenzar a meter cosas.
        Company company = new Company();
        System.out.println(company.companyStruct);
        // 1. Contratamos a un editor.
        // El método estático 'initEditor' se encarga de pedir los datos y crear el objeto.
        Editor editor = Editor.initEditor();

        System.out.println("Editor creado: " + editor.name + " con DNI " + editor.DNI);
        //Aquí ya podemos asignar nuestro objeto editor a su clave correspondiente.
        System.out.println("\n-------------------------------------------------\n");

        //System.out.println(company.companyStruct);
        // 2. Creamos una noticia.
        // Usamos el método de fábrica 'createNews' de la clase News.
        //Pondremos todo en un bucle para que el usuario vaya decidiendo que hacer.
        News currentNew = News.createNews();
        company.companyStruct.put(editor, null);//Empezamos pasando como null
        // 3. Verificamos si la noticia se creó correctamente.
        // EXPERT-NOTE:Siempre hay que comprobar si un objeto es 'null'
        // después de un método que podría devolverlo, para evitar un 'NullPointerException'.
        if (currentNew != null) {
            System.out.println("Noticia creada con el titular: \"" + currentNew.getHeadline() + "\"");

            // 4. Asignamos la noticia al editor.
            //Aquí habría que hacer que se nos liste la Structcompany para ver que editores tenemos para assignar la noticia
            company.companyStruct = editor.setNews(company.companyStruct, currentNew);
           // System.out.println("Noticia asignada al editor " + editor.name + ".");

            // 5. Calculamos y mostramos el precio y los puntos de la noticia.
            // Estos métodos usarán la implementación específica de la subclase (Soccer, Basketball, etc.).
            currentNew.calculatePrice();
            currentNew.calculatePoints();

            System.out.println("\n--- Detalles de la Noticia ---");
            System.out.println("Precio de la noticia: " + currentNew.getPrice() + "€");
            System.out.println("Puntuación de la noticia: " + currentNew.getPoints() + " puntos");

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