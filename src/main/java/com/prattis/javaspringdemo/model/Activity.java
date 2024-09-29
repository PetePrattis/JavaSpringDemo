package com.prattis.javaspringdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ACTIVITIES")
public class Activity extends BaseModel {

    /*
	foreign keys
	only exist so that relations with the other tables to be created
	these ARE columns in this table
	*/
	private long authorId;
	
	private long contentId;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal fee;
}
