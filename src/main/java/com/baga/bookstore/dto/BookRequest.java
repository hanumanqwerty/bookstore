package com.baga.bookstore.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Validated
@JsonIgnoreProperties
@NotNull
public class BookRequest {

	
	@NotNull(message="book name should not be null")
	@JsonProperty("book_name")
	private String bookName;
	@JsonProperty("book_author")
	@NotNull(message="author name should not be null")
	private String bookAuthor;
	@JsonProperty("year_publication")
	@NotNull(message="year of publication should not be null")
	private int yearOfPublication;
	@NotNull(message="price  should not be null")
	@JsonProperty("book_price")
	private int bookPrice;


}