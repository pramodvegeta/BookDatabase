package bookdatabase;

/**
 *
 * @author Pramod
 * @modifier Vinayak, Kiranjit
 */
public class Books {

    private int ISBN;
    private String title;
    private String author;
    private int edition;
    private String category;

//  Record size = int = 4 , String = 40 , String = 30, int = 4 , String = 20
//              = 4 + 80 + 60 + 4 + 40
//  Each record = 188 bytes
    public Books(int ISBN, String title, String author, int edition, String category) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.category = category;
    }

    public Books() {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.category = category;

    }

    @Override()
    public String toString() {
        String format = " %d    %s    %s    %d    %s ";
        return String.format(format, ISBN, title, author, edition, category);
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }
    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
