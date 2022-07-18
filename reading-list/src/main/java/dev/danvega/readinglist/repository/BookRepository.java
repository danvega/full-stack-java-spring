package dev.danvega.readinglist.repository;

import dev.danvega.readinglist.model.Book;
import org.springframework.data.repository.ListCrudRepository;

public interface BookRepository extends ListCrudRepository<Book, Integer> {

}
