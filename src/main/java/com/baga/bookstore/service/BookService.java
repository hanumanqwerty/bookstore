package com.baga.bookstore.service;

import java.awt.print.Book;
import java.util.List;

import com.baga.bookstore.dto.BookRequest;
import com.baga.bookstore.dto.BookResponce;
import com.baga.bookstore.dto.BookUpdateRequest;
import com.baga.bookstore.model.BookModel;

public interface BookService {

BookResponce createBookStore(BookRequest bookRequest);

//  BookResponce getValue(Integer id);

 List<BookModel> getBooksByTitle(String bookName);
 
 
 BookModel updateBookById(int bookId,BookUpdateRequest bookUpdateRequest);
 
 void deleteByBookId(int bookId);
}