import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Journal> readingHistory;
    
    public User(String username) {
        this.username = username;
        this.readingHistory = new ArrayList<>();
    }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public ArrayList<Journal> getReadingHistory() { return readingHistory; }
    
    public void addToHistory(Journal journal) {
        readingHistory.add(journal);
        System.out.println("Added to history: " + journal.getTitle());
    }
    
    public void showHistory() {
        System.out.println("\n Reading History for " + username + ":");
        for(Journal j : readingHistory) {
            System.out.println("- " + j.getTitle() + " (" + j.getCategory() + ")");
        }
    }
}
