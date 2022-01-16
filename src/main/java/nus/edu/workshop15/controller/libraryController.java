package nus.edu.workshop15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import nus.edu.workshop15.model.Author;
import nus.edu.workshop15.model.Books;
import nus.edu.workshop15.service.libraryRedis;

@Controller
public class libraryController {
    
    @Autowired
    private libraryRedis libraryRedis;

    @GetMapping("/requestForm")
    public String requestForm(Model model) {
        model.addAttribute("book", new Books());
        model.addAttribute("author", new Author());
        return "requestForm";
    }

    //add books
    @PostMapping("/library")
    public String addBooks(@ModelAttribute Books book, @ModelAttribute Author author) {
        book.setAuthor(author);
        libraryRedis.addBook(book, author);
        return "ok";
    }

    //search books
    @GetMapping("/libraryBooks")
    public String searchBooks(Books book, Author author, Model model) {
        Books foundBook = new Books();
        Author foundAuthor = new Author();

        if(!author.getName().isEmpty()) {
            System.out.println("Get name");
        } else if (!book.getTitle().isEmpty()) {
            System.out.println("Get title");
        } else {
            foundBook = libraryRedis.findById(book.getIsbn());
            System.out.println("Get isbn");
        }
        
        model.addAttribute("bookInfo", book);
        model.addAttribute("authorInfo", author);
        return "result";
    }

}
