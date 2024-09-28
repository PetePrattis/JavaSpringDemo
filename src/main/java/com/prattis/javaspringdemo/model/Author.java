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
@Entity
@Table(name = "AUTHORS")
public class Author extends BaseModel{
	@Column(length = 20, nullable = false)
	private String firstname;
	
	@Column(length = 30, nullable = false)
	private String lastname;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "authorId")
	private Set<Activity> activities = new HashSet<>();
}

