import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Sample Data
        library.addJournal(new Journal("Overcoming Anxiety", "Anxiety", "Take deep breaths and stay calm."));
        library.addJournal(new Journal("Dealing with Depression", "Depression", "Talk to someone you trust."));
        library.addJournal(new Journal("Stay Motivated", "Motivation", "Set goals and stay focused."));

        while (true) {
            System.out.println("\n==== Journal System ====");
            System.out.println("1. View All Journals");
            System.out.println("2. Search by Category");
            System.out.println("3. Search by Keyword");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    for (Journal j : library.getJournals()) {
                        j.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    ArrayList<Journal> categoryResults =
                        SearchService.searchByCategory(library.getJournals(), category);

                    if (categoryResults.isEmpty()) {
                        System.out.println("No journals found.");
                    } else {
                        for (Journal j : categoryResults) {
                            j.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter keyword: ");
                    String keyword = scanner.nextLine();

                    ArrayList<Journal> keywordResults =
                        SearchService.searchByKeyword(library.getJournals(), keyword);

                    if (keywordResults.isEmpty()) {
                        System.out.println("No journals found.");
                    } else {
                        for (Journal j : keywordResults) {
                            j.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
