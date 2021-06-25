package com.example.demojsp.service;

import com.example.demojsp.interfaces.BookService;
import com.example.demojsp.model.Book;
import com.example.demojsp.interfaces.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Collection<Book> getBooks() {
        return new ArrayList<>(bookRepository.findAll());
    }

    @Override
    public Book addBook(Book book) {
        final Optional<Book> existingBook = bookRepository.findById(book.getIsbn());
        if (existingBook.isPresent()) {
            throw new RuntimeException("Book exists");
        }

        final Book savedBook = bookRepository.add(book);
        return savedBook;
    }

}
