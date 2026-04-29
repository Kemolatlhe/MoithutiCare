import java.util.ArrayList;

public class SearchService {

    // Search by category
    public static ArrayList<Journal> searchByCategory(ArrayList<Journal> journals, String category) {
        ArrayList<Journal> results = new ArrayList<>();

        for (Journal j : journals) {
            if (j.getCategory().equalsIgnoreCase(category)) {
                results.add(j);
            }
        }

        return results;
    }

    // Search by keyword
    public static ArrayList<Journal> searchByKeyword(ArrayList<Journal> journals, String keyword) {
        ArrayList<Journal> results = new ArrayList<>();

        for (Journal j : journals) {
            if (j.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                j.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(j);
            }
        }

        return results;
    }
}
