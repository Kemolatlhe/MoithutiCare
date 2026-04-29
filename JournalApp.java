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
        library.addJournal(new Journal("Morning Peace", "Dr. Smith", "Anxiety", 
            "Take deep breaths. Focus on the present moment. You are safe."));
        
        library.addJournal(new Journal("Overcoming Fear", "Sarah Johnson", "Anxiety", 
            "Fear is just a feeling. Acknowledge it, then let it pass."));
        
        library.addJournal(new Journal("Rising Again", "Mike Brown", "Depression", 
            "Every day is a new beginning. Small steps lead to big changes."));
        
        library.addJournal(new Journal("Finding Light", "Emma Wilson", "Depression", 
            "Even on dark days, look for tiny moments of joy."));
        
        library.addJournal(new Journal("Daily Fuel", "John Doe", "Motivation", 
            "You are capable of amazing things. Start with one small action."));
        
        library.addJournal(new Journal("Power Within", "Lisa Ray", "Motivation", 
            "Believe in yourself. You've overcome challenges before."));
        
        library.addJournal(new Journal("Calm Mind", "Dr. Chen", "Stress", 
            "Stress is temporary. Take a break, breathe, reset."));
        
        library.addJournal(new Journal("Gratitude Practice", "Anna Lee", "Wellness", 
            "Write three things you're grateful for today."));
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
