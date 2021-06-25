package com.example.demojsp.interfaces;

import com.example.demojsp.model.Book;

import java.util.Collection;

public interface BookService {
    Collection<Book> getBooks();
    Book addBook(Book book);
}
