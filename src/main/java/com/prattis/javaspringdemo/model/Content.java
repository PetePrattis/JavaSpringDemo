package com.prattis.javaspringdemo.model;

import jakarta.persistence.*;
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
@Inheritance(strategy = InheritanceType.JOINED) //whichever class inheritance from Content, has its own table in Database
@Entity
@Table(name = "CONTENTS")
/*
We create Content as Book & BlogPost share the same field 'title'
ID of Content is used as foreign, primary key in Book & BlogPost
*/
public class Content extends BaseModel{
	@Column(length = 100, nullable = false)
	private String title;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "contentId") //contentId from Activity class
	private Set<Activity> activities = new HashSet<>();
}
