package com.baga.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baga.bookstore.dto.BookResponce;
import com.baga.bookstore.model.BookModel;

import lombok.Data;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer>{
	
	List<BookModel> getByBookName(String bookName);
	
//            List<BookModel> getValue(Integer id);
	
//	public void deleteBook(int bookId);


}
