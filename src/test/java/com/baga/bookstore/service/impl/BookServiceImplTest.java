package com.baga.bookstore.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.baga.bookstore.dto.BookRequest;
import com.baga.bookstore.dto.BookResponce;
import com.baga.bookstore.model.BookModel;
import com.baga.bookstore.repository.BookRepository;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookServiceImplTest {

	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookServiceImpl bookServiceImpl;
	
	@BeforeAll
	public void setUp() {
	MockitoAnnotations.openMocks(bookServiceImpl);	
	}
	@Test
	void createBookStore_test() {
		
		when(bookRepository.save(any(BookModel.class))).thenReturn(createBookModel());
		BookResponce bookResponce = bookServiceImpl.createBookStore(createBookRequest());
		Assertions.assertEquals("Harry Potter", bookResponce.getBookName());
	}
	
	public BookModel createBookModel() {
		
		BookModel bookModel = new BookModel();
		bookModel.setId(1);
		bookModel.setBookAuthor("JK Rowling");
		bookModel.setBookName("Harry Potter");
		bookModel.setBookPrice(10000);
		bookModel.setYearOfPublication(1994);
		return bookModel;
		
	}
	public BookRequest createBookRequest() {
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookName("Harry Potter");
		bookRequest.setBookAuthor("JK Rowling");
		bookRequest.setBookPrice(10000);
		bookRequest.setYearOfPublication(1994);
		
		return bookRequest;
	}
}
