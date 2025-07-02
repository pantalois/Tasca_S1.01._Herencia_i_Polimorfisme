package TascaS1_01.Exercici_1;

import java.util.Scanner;

public class Editor {
    public String name;
    public final String DNI;
    public int salary;
    public String news;

    public Editor(String name, String DNI, int salary, String news) {
        this.name = name;
        this.DNI = DNI;
        this.salary = salary;
        this.news = news;
    }

    public static Editor createEditor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the team. what is your Name?");
        String name = scanner.nextLine();
        System.out.println("What is your DNI?");
        String DNI = scanner.nextLine();
        System.out.println("By now your salary is 1500€, let´s see if you can improve it!!");
        System.out.println("By now you have 0 notices assigned");

        return new Editor(name, DNI, 1500, null);
    }

    public static Editor fireEditor(Editor editor){
        if (editor.news == null){
            return null;
        }
        //Cositas a hacer aquí
        return editor;
    }

    public void assingNews(Editor editor){

    }


    //Se puede contratar tarea.
    //Se puede despedir tarea.
    //Se le puede asignar noticia.
    //Que pasa si lo despedimos pero tenía tarea asignada.
}