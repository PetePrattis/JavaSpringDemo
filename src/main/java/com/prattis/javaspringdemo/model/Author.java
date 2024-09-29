package com.prattis.javaspringdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity //table in Database
@Table(name = "AUTHORS") //table's name, usually plural nouns
public class Author extends BaseModel{ //extends so that id is inherited
	@Column(length = 20, nullable = false)
	private String firstname;
	
	@Column(length = 30, nullable = false)
	private String lastname;
	
	@Column(length = 50, nullable = false)
	private String email;

	//foreign key from class (table) Activity (ies)
	@ToString.Exclude //Lombok annotation excluding
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "authorId") //authorId from Activity class
	private Set<Activity> activities = new HashSet<>();
	/*
    extends collections
	accepts only unique records
	every author has many
	*/
}

