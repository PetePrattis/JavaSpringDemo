package com.prattis.javaspringdemo.service;

import com.prattis.javaspringdemo.model.Activity;
import com.prattis.javaspringdemo.model.Author;
import com.prattis.javaspringdemo.model.Content;
import com.prattis.javaspringdemo.repository.ActivityRepository;
import com.prattis.javaspringdemo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl extends BaseServiceImpl<Author> implements AuthorService {
	private final AuthorRepository authorRepository;
	private final ActivityRepository activityRepository;
	
	@Override
	public JpaRepository<Author, Long> getRepository() {
		return authorRepository;
	}
	
	@Override
	public void assign(Author author, Content content, BigDecimal cost) {
		Activity newActivity = new Activity(content.getId(), author.getId(), cost);
		Activity newActivityEntities = new Activity(content, author, cost);
		activityRepository.save(newActivity);
	}
}
