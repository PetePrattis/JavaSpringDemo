package com.prattis.javaspringdemo.service;

import com.prattis.javaspringdemo.model.Book;
import com.prattis.javaspringdemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {
    private final BookRepository bookRepository;

    @Override
    public JpaRepository<Book, Long> getRepository() {
        return bookRepository;
    }
}
