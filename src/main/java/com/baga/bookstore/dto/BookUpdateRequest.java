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
public class BookUpdateRequest {
	
	
	private String bookAuthor;
	@JsonProperty("year_publication")
	private int yearOfPublication;
	@JsonProperty("book_price")
	private int bookPrice;

}
