package com.example.demojsp.repository;

import com.example.demojsp.interfaces.BookRepository;
import com.example.demojsp.model.Book;

import java.util.*;

public class InMemoryBookRepository implements BookRepository {

    private final Map<String, Book> storedBooks;

    public InMemoryBookRepository(Map<String, Book> storedBooks) {
        this.storedBooks = new HashMap<>();
        this.storedBooks.putAll(storedBooks);
    }

    @Override
    public Collection<Book> findAll() {
        if (storedBooks.isEmpty()) {
            return Collections.emptyList();
        }

        return storedBooks.values();
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(storedBooks.get(isbn));
    }

    @Override
    public Book add(Book book) {
        storedBooks.put(book.getIsbn(), book);
        return book;
    }
}
