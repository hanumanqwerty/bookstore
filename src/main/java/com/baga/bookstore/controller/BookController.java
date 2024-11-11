package com.baga.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baga.bookstore.dto.BookRequest;
import com.baga.bookstore.dto.BookResponce;
import com.baga.bookstore.dto.BookUpdateRequest;
import com.baga.bookstore.model.BookModel;
import com.baga.bookstore.service.BookService;

import jakarta.validation.Valid;

/** BookController to handle http methods. */
@RestController
@RequestMapping("/bookstore")
public class BookController{
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping(value="/createBook")
	public ResponseEntity<BookResponce> createBookStore (@Valid @RequestBody BookRequest bookRequest ) {   
		           BookResponce createBook = bookService.createBookStore(bookRequest);
		return new ResponseEntity<>(createBook,HttpStatus.CREATED);
	}
//	@GetMapping(value = "/getBook")
//	public ResponseEntity<BookResponce> getBookName(@PathVariable Integer id) {
//	     BookResponce book = bookService.getValue(id);
//    return new ResponseEntity<BookResponce>(book,HttpStatusCode.valueOf(200));
//	    }
	

	@GetMapping(value = "/getBook/{bookName}")
	public ResponseEntity<List<BookModel>> getBooks(@PathVariable String bookName) {
//	    if (bookName == null) {
//	        // Handle the case where bookName is null, perhaps by returning a 400 Bad Request response.
//	        return ResponseEntity.badRequest().build();
//	    }

	    List<BookModel> matchingBooks = bookService.getBooksByTitle(bookName);

//	    if (matchingBooks.isEmpty()) {
//	        // Handle the case where no matching books are found, perhaps by returning a 404 Not Found response.
//        return ResponseEntity.notFound().build();
//	    }
	    return new ResponseEntity<List<BookModel>>(matchingBooks,HttpStatusCode.valueOf(200));
	}
	
	@PutMapping(value="/updateBook/{bookId}")	
	public ResponseEntity<BookModel> updateBook(@RequestBody BookUpdateRequest bookUpdateRequest, @PathVariable int bookId){
		
		BookModel bookModel = bookService.updateBookById(bookId,bookUpdateRequest);
		
		return new ResponseEntity<BookModel>(bookModel,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteBook/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookId){
		bookService.deleteByBookId(bookId);
		return new ResponseEntity<String>("Success",HttpStatus.NO_CONTENT);
		
	}
	}
