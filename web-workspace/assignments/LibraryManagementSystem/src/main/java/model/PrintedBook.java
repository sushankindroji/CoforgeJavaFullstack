package model;

import javax.persistence.*;

@Entity
@Table(name = "printed_books")
public class PrintedBook extends Book {
    private int pages;
    private String shelfNo;
    private String edition;

    // Getters & Setters
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
    public String getShelfNo() { return shelfNo; }
    public void setShelfNo(String shelfNo) { this.shelfNo = shelfNo; }
    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }
}