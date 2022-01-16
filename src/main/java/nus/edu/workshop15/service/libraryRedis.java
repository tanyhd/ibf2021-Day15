package nus.edu.workshop15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import nus.edu.workshop15.model.Author;
import nus.edu.workshop15.model.Books;

@Service
public class libraryRedis implements libraryRepo {

    @Autowired
    private RedisTemplate<String, Object> template;

    @Override
    public void addBook(Books book, Author author) {
        template.opsForValue().set(book.getIsbn() + "_book", book);
        template.opsForValue().set(book.getIsbn() + "_author", author);
    }

    @Override
    public Books findByAuthor(String authorName, Books book) {
        // TODO Auto-generated method stub
        return (Books) template.opsForValue().get(book.getAuthor().getName() == authorName);
    }

    @Override
    public Books findByTitle(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Books findById(String id) {
        Books book = new Books();
        book = (Books) template.opsForValue().get(id + "_book");
        return book;
    }

}
