package dev.danvega.readinglist;

import dev.danvega.readinglist.model.Book;
import dev.danvega.readinglist.model.Status;
import dev.danvega.readinglist.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ReadingListApplication {

	private static final Logger log = LoggerFactory.getLogger(ReadingListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository repository) {
		return args -> {
			List<Book> books = List.of(
					new Book(null,"Reactive Spring", 484, "Josh Long", Status.IN_PROGRESS),
					new Book(null, "Spring Boot Up and Running", 328, "Mark Heckler", Status.COMPLETED),
					new Book(null, "Hacking with Spring Boot 2.3", 392, "Greg Turnquist", Status.NOT_STARTED)
			);
			log.info("Inserting demo data");
			String titles = books.stream().map(Book::title).collect(Collectors.joining(", "));
			log.info("Inserting books: {}", titles);
			repository.saveAll(books);
		};
	}

}
