package TascaS1_01.Exercici_1.model;

import java.util.*;

public class Editor {
    public String name;
    public final String id;
    public int salary;

    public Editor(String name, String id) {
        this.name = name;
        this.id = id;
        this.salary = 1500;
    }

    public static Editor initEditor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Hiring new editor ---");
        System.out.println("Name of editor:");
        String name = scanner.nextLine();
        System.out.println("ID of editor:");
        String id = scanner.nextLine();
        System.out.println("Editor " + name + " hired with a salary of 1500 euros!");
        return new Editor(name, id);
    }

    public static void fireEditor(Editor editor) {
        System.out.println("Editor " + editor.name + " has been fired.");
    }

    public String getName() {
        return name;
    }

    public void addNews(Map<Editor, List<News>> companyStruct, News news) {
        List<News> newsList = companyStruct.get(this);
        if (newsList == null) {
            newsList = new ArrayList<>();
            companyStruct.put(this, newsList);
        }
        newsList.add(news);
        System.out.println("News '" + news.getHeadline() + "' assigned to '" + this.name + "'.");
    }

    @Override
    public String toString() {
        return "Editor " + this.name + " with ID " + this.id;
    }
}