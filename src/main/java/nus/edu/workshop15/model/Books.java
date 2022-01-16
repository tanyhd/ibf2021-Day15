package nus.edu.workshop15.model;

import java.io.Serializable;

public class Books implements Serializable {
    private String title;
    private String image;
    private String isbn;
    private Author author;

    public Books() {
        this.isbn = String.valueOf(randomId());
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Books(String title, String image, String isbn, Author author) {
        this.title = title;
        this.image = image;
        this.isbn = isbn;
        this.author = author;
    }

    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public int randomId() {
        int minValue = 1;
        //max interger value use for the upper bound
        int maxValue = Integer.MAX_VALUE;
        int ranNum = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        return ranNum;
    }
    
}
