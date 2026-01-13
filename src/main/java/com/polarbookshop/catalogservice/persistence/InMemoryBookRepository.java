package com.polarbookshop.catalogservice.persistence;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private static final Map<String, Book> books= new ConcurrentHashMap<>();

    public InMemoryBookRepository() {
        books.put("9781617294945", new Book("9781617294945", "Spring in Action", "Craig Walls", 39.99));
        books.put("9780134686097", new Book("9780134686097", "Effective Java", "Joshua Bloch", 45.00));
        books.put("9781492072508", new Book("9781492072508", "Learning Spring Boot 2.0", "Greg L. Turnquist", 44.99));
    }

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return books.get(isbn) != null ? Optional.of(books.get(isbn)) : Optional.empty();
    }

    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }

}
