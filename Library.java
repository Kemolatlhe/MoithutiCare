import java.util.ArrayList;

public class Library {
    private ArrayList<Journal> journals;
    
    public Library() {
        this.journals = new ArrayList<>();
    }
    
    public void addJournal(Journal journal) {
        journals.add(journal);
    }
    
    public ArrayList<Journal> getAllJournals() { return journals; }
    
    // Search by exact category
    public ArrayList<Journal> searchByCategory(String category) {
        ArrayList<Journal> results = new ArrayList<>();
        for(Journal j : journals) {
            if(j.getCategory().equalsIgnoreCase(category)) {
                results.add(j);
            }
        }
        return results;
    }
    
    // Get all unique categories
    public ArrayList<String> getAllCategories() {
        ArrayList<String> categories = new ArrayList<>();
        for(Journal j : journals) {
            if(!categories.contains(j.getCategory())) {
                categories.add(j.getCategory());
            }
        }
        return categories;
    }
    
    // Search by keyword (optional but impressive)
    public ArrayList<Journal> searchByKeyword(String keyword) {
        ArrayList<Journal> results = new ArrayList<>();
        for(Journal j : journals) {
            if(j.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
               j.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(j);
            }
        }
        return results;
    }
    
    // Filter by multiple categories
    public ArrayList<Journal> filterByCategories(ArrayList<String> categories) {
        ArrayList<Journal> results = new ArrayList<>();
        for(Journal j : journals) {
            if(categories.contains(j.getCategory())) {
                results.add(j);
            }
        }
        return results;
    }
}
