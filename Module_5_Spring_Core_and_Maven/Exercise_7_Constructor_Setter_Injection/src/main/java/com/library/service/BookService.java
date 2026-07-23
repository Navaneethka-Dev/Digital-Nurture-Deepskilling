package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected via Constructor");
    }

    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected via Setter");
    }

    public void manageBooks() {
        System.out.println("Managing library books (Constructor/Setter)...");
        bookRepository.getBooks();
    }
}
