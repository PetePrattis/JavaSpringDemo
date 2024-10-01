package com.prattis.javaspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "COMMENTS")
public class Comment extends BaseModel {
	@Column(length = 4096, nullable = false)
	private String body;
	
	@Temporal(TemporalType.TIMESTAMP) //includes date & time
	@Column(nullable = false)
	private Date publishDate;
}
