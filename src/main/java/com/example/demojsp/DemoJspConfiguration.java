package com.example.demojsp;

import com.example.demojsp.model.Book;
import com.example.demojsp.interfaces.BookRepository;
import com.example.demojsp.repository.InMemoryBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DemoJspConfiguration {

    @Bean
    public BookRepository provideBookRepository() {
        return new InMemoryBookRepository(initialBookData());
    }

    private static Map<String, Book> initialBookData() {
        Map<String, Book> initData = new HashMap<>();
        initData.put("ISBN-1", new Book("ISBN-1", "Book 1", "Book 1 Author"));
        initData.put("ISBN-2", new Book("ISBN-2", "Book 2", "Book 2 Author"));
        initData.put("ISBN-3", new Book("ISBN-3", "Book 3", "Book 3 Author"));
        return initData;
    }
}
