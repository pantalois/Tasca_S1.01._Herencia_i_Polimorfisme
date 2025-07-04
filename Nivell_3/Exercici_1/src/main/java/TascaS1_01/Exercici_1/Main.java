package TascaS1_01.Exercici_1;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();
        System.out.println("Welcome to the newsroom!");

        String textMenu = "Type the number of your option:\n" +
                "1. Hire a journalist\n" +
                "2. Fire a journalist\n" +
                "3. Assign news to a journalist\n" +
                "4. Delete news\n" +
                "5. Show all news by journalist\n" +
                "6. Calculate news score\n" +
                "7. Calculate news price\n" +
                "8. Exit\n";

        while (true) {
            System.out.println("\nCurrent state:");
            System.out.println("- Journalists: " + company.companyStruct.size());
            System.out.println("- Total news: " + NewsroomUtils.countAllNews(company));
            System.out.println("\n" + textMenu);

            try {
                System.out.print("Your choice: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        NewsroomHandlers.handleHire(company, scanner);
                        break;
                    case 2:
                        NewsroomHandlers.handleFire(company, scanner);
                        break;
                    case 3:
                        NewsroomHandlers.handleAssignNews(company, scanner);
                        break;
                    case 4:
                        NewsroomHandlers.handleDeleteNews(company, scanner);
                        break;
                    case 5:
                        NewsroomHandlers.handleShowNews(company, scanner);
                        break;
                    case 6:
                        NewsroomHandlers.handleCalculateScore(company, scanner);
                        break;
                    case 7:
                        NewsroomHandlers.handleCalculatePrice(company, scanner);
                        break;
                    case 8:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please choose 1-8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}