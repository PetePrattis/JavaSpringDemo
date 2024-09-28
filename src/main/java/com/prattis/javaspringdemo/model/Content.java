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
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "CONTENTS")
public class Content extends BaseModel{
	@Column(length = 100, nullable = false)
	private String title;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "contentId")
	private Set<Activity> activities = new HashSet<>();
}
