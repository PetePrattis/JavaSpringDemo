package com.prattis.javaspringdemo.repository;

import com.prattis.javaspringdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
Repository layer is the second package to be created
Repository connects/ communicates with Database through CRUD operations
Create, Read, Update, Delete stands for CRUD for the data
Spring Data adds an access layer
Extends JPARepository regards the Spring Data and enables CRUD operations
*/
@Repository //mandatory annotation
public interface AuthorRepository extends JpaRepository<Author, Long> { //second parameter is the primary key of the corresponding table

	//customized query
	@Query("select a from Author a join fetch a.activities where a.id = ?1") //?1 stands for first parameter
	Optional<Author> getAuthor(Long id);
	
}
