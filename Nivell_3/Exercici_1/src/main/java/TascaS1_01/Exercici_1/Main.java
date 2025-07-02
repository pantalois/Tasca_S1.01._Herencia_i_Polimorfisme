package TascaS1_01.Exercici_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Contratamos a editor:
        Editor editor = Editor.createEditor();
        System.out.println(editor.name);
        System.out.println(editor.DNI);
        System.out.println(editor.salary);
        System.out.println(editor);
        //crear noticia

        News.createNews();
        editor = Editor.fireEditor(editor);



    }
}