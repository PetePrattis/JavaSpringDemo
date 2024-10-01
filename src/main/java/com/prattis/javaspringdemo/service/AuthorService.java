package com.prattis.javaspringdemo.service;

import com.prattis.javaspringdemo.model.Author;
import com.prattis.javaspringdemo.model.Content;

import java.math.BigDecimal;

public interface AuthorService extends BaseService<Author, Long> {
	void assign(Author author, Content content, BigDecimal cost);
}
