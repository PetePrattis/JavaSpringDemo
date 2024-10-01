package com.prattis.javaspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/*
-Choose Spring initializer
-Maven & Lombok
-Maven is an automation tool
-Create package model not including Main
-Packages always written with all small letters
-BaseModel is always the first class
-Dependencies for updates regarding libraries
-Adding H2 dependency, JPA & test
-JPA dependency is used by Hibernate, enables @Id
-Properties including global ones, e.g. portal & project name
-Hibernate translates java to SQL and creates Database
-Hibernate understands the annotation @Id
-JPA stands for Java Persistence API
*/
@Data //functions provided by Lombok, e.g. setters/getters/constructors
@NoArgsConstructor //initializes JPA entity for Database
@MappedSuperclass
/*
table is not created in Database for this entity
every class (entity) inheritances the ID from this class
the opposite of @Entity
*/
@SuperBuilder //constructor provided by Lombok for massive initialization
public class BaseModel {
	@Id //special annotation for Hibernate that indicates id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //an ID is automatically created
	@Column(updatable = false)
	private Long id;
}

/*
1. BaseModel
This is a @MappedSuperclass, meaning it won't have its own table in the database. Instead, its fields will be included in the tables of its subclasses (Author, Content, Activity, Comment).
Fields from BaseModel (inherited by subclasses):
id (Long): A primary key, auto-generated with GenerationType.IDENTITY.

2. AUTHORS Table
This table is created for the Author entity, which extends BaseModel and contains additional fields:

Columns:

id (Long): Inherited from BaseModel, primary key.
firstname (String, length = 20, nullable = false).
lastname (String, length = 30, nullable = false).
email (String, length = 50, nullable = false).
Relationships:

One-to-Many with Activity: The activities collection will reference Activity through the authorId field in Activity.

3. CONTENTS Table
This table is created for the Content entity, which extends BaseModel and uses the InheritanceType.JOINED strategy. All subclasses of Content (like BlogPost and Book) will have their own tables, with foreign key references back to the CONTENTS table.

Columns:

id (Long): Inherited from BaseModel, primary key.
title (String, length = 100, nullable = false).
Relationships:

One-to-Many with Activity: The activities collection will reference Activity through the contentId field in Activity.

4. BLOGPOSTS Table
This table is created for the BlogPost entity, which extends Content. It will contain its own fields as well as a foreign key (id)
 referencing the CONTENTS table.

Columns:

id (Long): Primary key, foreign key to CONTENTS.
publishedAt (Date with TIMESTAMP, nullable = false).
site (String, length = 50, nullable = false).
Relationships:

One-to-Many with Comment: The comments collection will reference Comment through the BLOGPOST_ID foreign key in the COMMENTS table.

5. BOOKS Table
This table is created for the Book entity, which extends Content. It will contain its own fields as well as a foreign key (id)
 referencing the CONTENTS table.

Columns:
id (Long): Primary key, foreign key to CONTENTS.
summary (String, length = 1024, nullable = false).
isbn (String, length = 30, nullable = false).
publicationYear (Integer, nullable = false).
publisher (String, length = 50, nullable = false).
pages (Integer, nullable = true).
cost (BigDecimal, precision = 10, scale = 2, nullable = false).

6. COMMENTS Table
This table is created for the Comment entity, which extends BaseModel.

Columns:

id (Long): Primary key, inherited from BaseModel.
body (String, length = 4096, nullable = false).
publishDate (Date with TIMESTAMP, nullable = false).
Relationships:

Foreign Key: There will be a BLOGPOST_ID foreign key, defined by @JoinColumn(name = "BLOGPOST_ID") in the BlogPost class. This column references the id in the BLOGPOSTS table.

7. ACTIVITIES Table
This table is created for the Activity entity, which extends BaseModel.

Columns:
id (Long): Primary key, inherited from BaseModel.
authorId (long): Foreign key reference to id in the AUTHORS table.
contentId (long): Foreign key reference to id in the CONTENTS table.
fee (BigDecimal, precision = 10, scale = 2, nullable = false).


Summary of Tables:
AUTHORS:
id, firstname, lastname, email

CONTENTS (joined inheritance base):
id, title

BLOGPOSTS:
id (FK to CONTENTS), publishedAt, site

BOOKS:
id (FK to CONTENTS), summary, isbn, publicationYear, publisher, pages, cost

COMMENTS:
id, body, publishDate, BLOGPOST_ID (FK to BLOGPOSTS)

ACTIVITIES:
id, authorId, contentId, fee

Each subclass of Content (BlogPost, Book) has its own table with a foreign key to the CONTENTS table. The ACTIVITIES and COMMENTS tables establish relationships with AUTHORS and BLOGPOSTS, respectively.
 */

