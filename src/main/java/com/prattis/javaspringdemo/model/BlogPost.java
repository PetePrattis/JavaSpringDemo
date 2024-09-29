package com.prattis.javaspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity()
@Table(name = "BLOGPOSTS")
public class BlogPost extends Content {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date publishedAt;

	@Column(length = 50, nullable = false)
	private String site;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(orphanRemoval = true) //if a comment is removed then its id is also removed from java
	@JoinColumn(name = "BLOGPOST_ID") //the id is used as foreign key in Comments table
	private Set<Comment> comments = new HashSet<>();
}
