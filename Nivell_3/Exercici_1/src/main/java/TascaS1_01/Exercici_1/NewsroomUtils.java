package TascaS1_01.Exercici_1;

import java.util.List;
import java.util.Map;

public class NewsroomUtils {
    public static int countAllNews(Company company) {
        int count = 0;
        for (List<News> newsList : company.companyStruct.values()) {
            if (newsList != null) count += newsList.size();
        }
        return count;
    }

    public static void listEditors(Company company) {
        if (company.companyStruct.isEmpty()) {
            System.out.println(" (None)");
            return;
        }
        for (Editor editor : company.companyStruct.keySet()) {
            int count = company.companyStruct.get(editor).size();
            System.out.println("- " + editor.getName() + " (" + count + " news)");
        }
    }

    public static void listEditorsWithNews(Company company) {
        boolean hasNews = false;
        for (Editor editor : company.companyStruct.keySet()) {
            List<News> news = company.companyStruct.get(editor);
            if (news != null && !news.isEmpty()) {
                System.out.println("- " + editor.getName() + " (" + news.size() + " news)");
                hasNews = true;
            }
        }
        if (!hasNews) System.out.println(" (None)");
    }

    public static Editor findEditor(Company company, String name) {
        for (Editor editor : company.companyStruct.keySet()) {
            if (editor.getName().equalsIgnoreCase(name)) {
                return editor;
            }
        }
        return null;
    }

    public static News findNews(Company company, String headline) {
        for (Map.Entry<Editor, List<News>> entry : company.companyStruct.entrySet()) {
            for (News news : entry.getValue()) {
                if (news.getHeadline().equals(headline)) {
                    return news;
                }
            }
        }
        return null;
    }

    public static String getDuplicateError(Company company, Editor editor) {
        for (Editor e : company.companyStruct.keySet()) {
            if (e.getName().equalsIgnoreCase(editor.getName())) {
                return "Name already exists: " + editor.getName();
            }
            if (e.id.equalsIgnoreCase(editor.id)) {
                return "ID already exists: " + editor.id;
            }
        }
        return null;
    }

    public static void deleteNews(Company company, Editor editor, String headline) {
        List<News> newsList = company.companyStruct.get(editor);
        for (int i = 0; i < newsList.size(); i++) {
            if (newsList.get(i).getHeadline().equals(headline)) {
                newsList.remove(i);
                System.out.println("News deleted successfully.");
                return;
            }
        }
        System.out.println("News not found.");
    }

    public static void displayJournalistNews(Company company, String name) {
        Editor editor = findEditor(company, name);
        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        List<News> news = company.companyStruct.get(editor);
        if (news == null || news.isEmpty()) {
            System.out.println("No news assigned.");
            return;
        }

        System.out.println("\n--- News for " + name + " ---");
        for (News n : news) {
            System.out.println("Headline: " + n.getHeadline());
            System.out.println("Content: " + n.getText());
            System.out.println("-------------------");
        }
    }
}