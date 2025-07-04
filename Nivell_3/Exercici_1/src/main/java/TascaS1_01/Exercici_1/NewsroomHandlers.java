package TascaS1_01.Exercici_1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class NewsroomHandlers {
    public static void handleHire(Company company, Scanner scanner) {
        Editor editor = Editor.initEditor();
        String error = NewsroomUtils.getDuplicateError(company, editor);

        if (error != null) {
            System.out.println(error);
            System.out.println("Journalist not hired.");
        } else {
            company.companyStruct.put(editor, new ArrayList<>());
            System.out.println("✅ " + editor.getName() + " hired successfully!");
        }
    }

    public static void handleFire(Company company, Scanner scanner) {
        if (company.companyStruct.isEmpty()) {
            System.out.println("No journalists to fire.");
            return;
        }

        System.out.println("Available journalists:");
        NewsroomUtils.listEditors(company);

        System.out.print("Enter journalist's name to fire: ");
        String name = scanner.nextLine().trim();
        Editor editor = NewsroomUtils.findEditor(company, name);

        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        List<News> news = company.companyStruct.get(editor);
        if (news == null || news.isEmpty()) {
            Editor.fireEditor(editor);
            company.companyStruct.remove(editor);
            System.out.println(name + " fired successfully!");
        } else {
            System.out.println("Cannot fire - journalist has " + news.size() + " assigned news.");
        }
    }

    public static void handleAssignNews(Company company, Scanner scanner) {
        if (company.companyStruct.isEmpty()) {
            System.out.println("No journalists available.");
            return;
        }

        System.out.println("--- Creating news ---");
        News news = News.createNews();
        if (news == null) return;

        System.out.println("\nAvailable journalists:");
        NewsroomUtils.listEditors(company);

        System.out.print("\nEnter journalist's name to assign news: ");
        String name = scanner.nextLine().trim();
        Editor editor = NewsroomUtils.findEditor(company, name);

        if (editor != null) {
            editor.addNews(company.companyStruct, news);
            System.out.println("News assigned successfully!");
        } else {
            System.out.println("Journalist not found. News not assigned.");
        }
    }

    public static void handleDeleteNews(Company company, Scanner scanner) {
        if (NewsroomUtils.countAllNews(company) == 0) {
            System.out.println("No news available to delete.");
            return;
        }

        System.out.println("Available journalists with news:");
        NewsroomUtils.listEditorsWithNews(company);

        System.out.print("Enter journalist's name: ");
        String editorName = scanner.nextLine().trim();
        Editor editor = NewsroomUtils.findEditor(company, editorName);

        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        List<News> newsList = company.companyStruct.get(editor);
        if (newsList == null || newsList.isEmpty()) {
            System.out.println("No news assigned to this journalist.");
            return;
        }

        System.out.println("News by " + editorName + ":");
        for (News news : newsList) {
            System.out.println("- " + news.getHeadline());
        }

        System.out.print("Enter headline to delete: ");
        String headline = scanner.nextLine().trim();
        NewsroomUtils.deleteNews(company, editor, headline);
    }

    public static void handleShowNews(Company company, Scanner scanner) {
        if (company.companyStruct.isEmpty()) {
            System.out.println("No journalists available.");
            return;
        }

        System.out.println("Available journalists:");
        NewsroomUtils.listEditors(company);

        System.out.print("Enter journalist's name: ");
        String name = scanner.nextLine().trim();
        NewsroomUtils.displayJournalistNews(company, name);
    }

    public static void handleCalculateScore(Company company, Scanner scanner) {
        System.out.print("Enter news headline: ");
        String headline = scanner.nextLine().trim();
        News news = NewsroomUtils.findNews(company, headline);

        if (news != null) {
            news.calculatePoints();
            System.out.println("Score: " + news.getPoints() + " points");
        } else {
            System.out.println("News not found.");
        }
    }

    public static void handleCalculatePrice(Company company, Scanner scanner) {
        System.out.print("Enter news headline: ");
        String headline = scanner.nextLine().trim();
        News news = NewsroomUtils.findNews(company, headline);

        if (news != null) {
            news.calculatePrice();
            System.out.println("Price: " + news.getPrice() + " euros");
        } else {
            System.out.println("News not found.");
        }
    }
}