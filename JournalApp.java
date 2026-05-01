import java.util.ArrayList;
import java.util.Scanner;

public class JournalApp {
    private static Library library = new Library();
    private static User currentUser;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeData();
        setupUser();
        runMainMenu();
    }
    
    private static void initializeData() {
        // Sample journal data
        library.addJournal(new Journal("Source: HelpGuide.org https://share.google/OxsYTYXzkZXbG5nKX"));
        
        library.addJournal(new Journal("Source: Government of Western Australia Department of Health https://share.google/4iv87X9KTUOsCeyNz"));
        
        library.addJournal(new Journal("Source: Early Psychosis Intervention Ontario Network (EPION) https://share.google/6rrHGdjHxMJ2G8vIZ"));
        
        library.addJournal(new Journal("Source: Money & Youth https://share.google/zxMRqRsgw2onqPTAH"));
        
        library.addJournal(new Journal("Source: PCC Harbormasters https://share.google/NlLtTLN1uLRtawwWt"));
        
        library.addJournal(new Journal("Source: American Psychological Association (APA) https://share.google/OdFI6jiitR5staqoO"));
        
        library.addJournal(new Journal("Source: National Institute of Mental Health (NIMH) (.gov) https://share.google/hoNyo0q9DA7UmJuEc"));
        
        library.addJournal(new Journal("Source: National Institute of Mental Health (NIMH) (.gov) https://share.google/hoNyo0q9DA7UmJuEc"));
    }
    
    private static void setupUser() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        currentUser = new User(username);
        System.out.println("\n Welcome, " + username + "!\n");
    }
    
    private static void runMainMenu() {
        while(true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. View All Categories");
            System.out.println("2. Search by Category");
            System.out.println("3. Search by Keyword");
            System.out.println("4. View Reading History");
            System.out.println("5. Exit");
            System.out.print("\nChoose an option (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch(choice) {
                case 1: viewCategories(); break;
                case 2: searchByCategory(); break;
                case 3: searchByKeyword(); break;
                case 4: currentUser.showHistory(); break;
                case 5: 
                    System.out.println("Goodbye, " + currentUser.getUsername() + "!");
                    System.exit(0);
                    break;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }
    
    private static void viewCategories() {
        ArrayList<String> categories = library.getAllCategories();
        System.out.println("\n=== AVAILABLE CATEGORIES ===");
        for(int i = 0; i < categories.size(); i++) {
            System.out.println((i+1) + ". " + categories.get(i));
        }
        System.out.println("\nTotal: " + categories.size() + " categories");
    }
    
    private static void searchByCategory() {
        System.out.print("\nEnter category (Anxiety, Depression, Motivation, etc): ");
        String category = scanner.nextLine();
        
        ArrayList<Journal> results = library.searchByCategory(category);
        
        if(results.isEmpty()) {
            System.out.println("No journals found in category: " + category);
        } else {
            System.out.println("\n=== Found " + results.size() + " journal(s) ===");
            displayJournalList(results);
        }
    }
    
    private static void searchByKeyword() {
        System.out.print("\nEnter keyword to search: ");
        String keyword = scanner.nextLine();
        
        ArrayList<Journal> results = library.searchByKeyword(keyword);
        
        if(results.isEmpty()) {
            System.out.println("No journals found containing: " + keyword);
        } else {
            System.out.println("\n=== Found " + results.size() + " journal(s) ===");
            displayJournalList(results);
        }
    }
    
    private static void displayJournalList(ArrayList<Journal> journals) {
        for(int i = 0; i < journals.size(); i++) {
            Journal j = journals.get(i);
            System.out.println("\n[" + (i+1) + "] " + j.getTitle());
            System.out.println("Category: " + j.getCategory());
            System.out.println("Author: " + j.getAuthor());
        }
        
        System.out.print("\nEnter journal number to read (or 0 to go back): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if(choice > 0 && choice <= journals.size()) {
            Journal selected = journals.get(choice-1);
            System.out.println("\n=== READING JOURNAL ===");
            selected.displayInfo();
            currentUser.addToHistory(selected);
            
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
}
