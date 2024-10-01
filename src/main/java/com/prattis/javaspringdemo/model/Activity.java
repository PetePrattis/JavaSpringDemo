package com.prattis.javaspringdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ACTIVITIES")
public class Activity extends BaseModel {
	private long authorId;
	
	private long contentId;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal fee;
	
	public Activity(final Content content, final Author author, final BigDecimal fee) {
		this.contentId = content.getId();
		this.authorId = author.getId();
		this.fee = fee;
	}
}
