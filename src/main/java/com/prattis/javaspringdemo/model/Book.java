package com.prattis.javaspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "BOOKS")
public class Book extends Content {
	@Column(length = 1024, nullable = false)
	private String summary;
	
	@Column(length = 30, nullable = false)
	private String isbn;
	
	@Column(nullable = false)
	private Integer publicationYear;
	
	@Column(length = 50, nullable = false)
	private String publisher;
	
	@Column(nullable = true)
	private Integer pages;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal cost;
}
