package nus.edu.workshop15.service;

import nus.edu.workshop15.model.Author;
import nus.edu.workshop15.model.Books;

public interface libraryRepo {
    public void addBook(Books book, Author author);
    public Books findById(String id);
    public Books findByAuthor(String author, Books book);
    public Books findByTitle(String title);
}
