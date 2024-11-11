package com.baga.bookstore.service.impl;
import com.baga.bookstore.BookStoreApplication;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.baga.bookstore.dto.BookRequest;
import com.baga.bookstore.dto.BookResponce;
import com.baga.bookstore.dto.BookUpdateRequest;
import com.baga.bookstore.model.BookModel;
import com.baga.bookstore.repository.BookRepository;
import com.baga.bookstore.service.BookService;


import lombok.Data;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookResponce createBookStore(BookRequest bookRequest) {
		
		         BookModel book = new BookModel();
		         
		         book.setBookName(bookRequest.getBookName());
		         book.setBookAuthor(bookRequest.getBookAuthor());
		         book.setYearOfPublication(bookRequest.getYearOfPublication());
		         book.setBookPrice(bookRequest.getBookPrice());
		         
		         BookModel model=bookRepository.save(book);
		         
		         BookResponce bookResponce = new BookResponce();
		         bookResponce.setBookName(model.getBookName());
		         bookResponce.setBookAuthor(model.getBookAuthor());
		         bookResponce.setYearOfPublication(model.getYearOfPublication());
		         bookResponce.setBookPrice(model.getBookPrice());		    
		return bookResponce;
}

	@Override
	public List<BookModel> getBooksByTitle(String bookName) {
		
	    
		
		
	    return bookRepository.getByBookName(bookName);
	    	    
	}

	@Override
	public BookModel updateBookById(int bookId,BookUpdateRequest bookUpdateRequest) {
		Optional<BookModel> book = bookRepository.findById(bookId);
		BookModel bookModel = book.get();
		if(bookUpdateRequest.getBookAuthor()!=null) {
		bookModel.setBookAuthor(bookUpdateRequest.getBookAuthor());
		}
		if(bookUpdateRequest.getBookPrice()!=0) {
			bookModel.setBookPrice(bookUpdateRequest.getBookPrice());
		}
		if(bookUpdateRequest.getYearOfPublication()!=0) {
			bookModel.setYearOfPublication(bookUpdateRequest.getYearOfPublication());
		}
		
		return  bookRepository.save(bookModel);
		
	}

	@Override
	public void deleteByBookId(int bookId) {
		bookRepository.deleteById(bookId);
		}}

//	@Override
//	public BookResponce getValue(Integer id) {
//		       
//		Optional<BookModel> ff = bookRepository.findById(id);
//		
//		BookResponce responce = new BookResponce();
//		
//		
//	
//		
//		return null;      
//    
//	
//	}}

//	@Override
//	public List<Book> getBooksByTitle(String bookName) {
//	    List<BookModel> bookModels =bookRepository.getByBookName(bookName);
//	    
//	    
//	        Book book = new Book();
//	        book.setSerialId(bookModel.getSerialId());
//	        book.setBookName(bookModel.getBookName());
//	        book.setBookAuthor(bookModel.getBookAuthor());
//	        book.setYearOfPublication(bookModel.getYearOfPublication());
//	        book.setBookPrice(bookModel.getBookPrice());
//	        
//	    return    bookModel;
//	    }
	//}





