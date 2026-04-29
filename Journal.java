public class Journal {
    private String title;
    private String author;
    private String category;
    private String content;
    
    // Constructor
    public Journal(String title, String author, String category, String content) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.content = content;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getContent() { return content; }
    
    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setCategory(String category) { this.category = category; }
    public void setContent(String content) { this.content = content; }
    
    // Display method
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Content: " + content);
        System.out.println("-----------------------------------");
    }
}
