package com.prattis.javaspringdemo.dummy;

import com.prattis.javaspringdemo.model.Author;
import com.prattis.javaspringdemo.model.BlogPost;
import com.prattis.javaspringdemo.model.Book;
import com.prattis.javaspringdemo.service.AuthorService;
import com.prattis.javaspringdemo.service.BlogPostService;
import com.prattis.javaspringdemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class SampleContentCreator implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SampleContentCreator.class);

    private final AuthorService authorService;
    private final BookService bookService;
    private final BlogPostService blogPostService;

    @Override
    public void run(String... args) throws Exception {
        Author a1 = Author.builder().firstname("Art").lastname("Weller").email("art.w@mail.com").build();
        Author a2 = Author.builder().firstname("Mary").lastname("Stevens").email("mary.s@mail.com").build();
        Author a3 = Author.builder().firstname("Sam").lastname("Lien").email("sam.l@mail.com").build();

        authorService.createAll(a1, a2, a3);
        logger.info("Saved authors {}, {}, {}.", a1, a2, a3); // logger.debug

        Book b1 = Book.builder().title("How to eat well").isbn("111-222-333").pages(500).summary("Simple and quick recipes").publisher(
                "Warmen Publishers").publicationYear(2010).cost(BigDecimal.valueOf(18.99)).build();
        Book b2 = Book.builder().title("Nice islands").isbn("222-333-444").pages(500).summary("A travel guide for Europe").publisher(
                "Books and Stuff").publicationYear(2015).cost(BigDecimal.valueOf(30.00)).build();
        Book b3 = Book.builder().title("Airplanes of the 16th century").isbn("123-456-789").pages(500).summary("Deep research on the subject of medieval flights").publisher(
                "Indepenbook").publicationYear(2020).cost(BigDecimal.valueOf(45.99)).build();

        bookService.createAll(b1, b2, b3);
        logger.info("Saved books {}, {}, {}.", b1, b2, b3); // logger.debug

        BlogPost bp1 = BlogPost.builder().title("Old news are useful").site("blog1.example.com").publishedAt(
                Date.from(LocalDate.of(2021, 10, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
        BlogPost bp2 = BlogPost.builder().title("X changes to Z").site("blog1.example.com").publishedAt(
                Date.from(LocalDate.of(2021, 10, 2).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
        BlogPost bp3 = BlogPost.builder().title("Review of current politics").site("blog2.example.com").publishedAt(
                Date.from(LocalDate.of(2021, 10, 3).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();

        blogPostService.createAll(bp1, bp2, bp3);
        logger.info("Saved blogposts {}, {}, {}.", bp1, bp2, bp3); // logger.debug

        authorService.assign(a1, b1, BigDecimal.valueOf(6000L));
        authorService.assign(a1, b2, BigDecimal.valueOf(7000L));
        authorService.assign(a2, b3, BigDecimal.valueOf(9600L));
        authorService.assign(a1, bp1, BigDecimal.valueOf(120L));
        authorService.assign(a2, bp2, BigDecimal.valueOf(130L));
        authorService.assign(a3, bp3, BigDecimal.valueOf(90L));

    }
}
