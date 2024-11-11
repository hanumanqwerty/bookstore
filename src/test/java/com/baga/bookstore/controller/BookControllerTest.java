package com.baga.bookstore.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.baga.bookstore.dto.BookRequest;
import com.baga.bookstore.dto.BookResponce;
import com.baga.bookstore.model.BookModel;
import com.baga.bookstore.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
public class BookControllerTest {
	
	@MockBean
	private BookService bookService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private BookController bookController;
	
	@Test
	void createBookStore_test() throws Exception {
		String request = mapToJson(createBookRequest());
		when(bookService.createBookStore(any(BookRequest.class))).thenReturn(createBookResponse());
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/bookstore/createBook").contentType(MediaType.APPLICATION_JSON_VALUE).content(request)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        Assertions.assertEquals(null, response.getErrorMessage());
        Assertions.assertEquals(201, response.getStatus());
	}

	
	@Test
	void getBooks_test() throws Exception {
		when(bookService.getBooksByTitle(anyString())).thenReturn(getBookList());
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/bookstore/getBook/IIT")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		Assertions.assertEquals(200, response.getStatus());
	}
	public String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	
	
	public List<BookModel> getBookList(){
		BookModel bookModel = new BookModel();
		bookModel.setId(1);
		bookModel.setBookAuthor("Sai");
		bookModel.setBookName("IIT");
		bookModel.setBookPrice(100);
		bookModel.setYearOfPublication(2024);
		
		List<BookModel> bookList =new  ArrayList<>();
		bookList.add(bookModel);
		
		
		return bookList;
	}
	public BookRequest createBookRequest() {
		BookRequest bookRequest = new BookRequest();
		bookRequest.setBookName("Harry Potter");
		bookRequest.setBookAuthor("JK Rowling");
		bookRequest.setBookPrice(10000);
		bookRequest.setYearOfPublication(1994);
		
		return bookRequest;
	}
	
	public BookResponce createBookResponse() {
		BookResponce bookResponce = new BookResponce();
		bookResponce.setBookName("Harry Potter");
		bookResponce.setBookAuthor("JK Rowling");
		bookResponce.setBookPrice(10000);
		bookResponce.setYearOfPublication(1994);
		return bookResponce;
	}
}
