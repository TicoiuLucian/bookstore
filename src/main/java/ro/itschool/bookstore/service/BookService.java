package ro.itschool.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.itschool.bookstore.entity.Book;
import ro.itschool.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public Book saveNewBook(Book book) {
        log.info("Saving book: {}", book.getName());
        return bookRepository.save(book);
    }

    public Optional<Book> findBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> findBookByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<Book> findAllBooksByAuthor(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findAllPeekBooks() {
        return bookRepository.findAllPeekBooks();
    }

//    @Query("DELETE FROM Book b WHERE b.id = :id")
    public void deleteBookById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Book ID cannot be null.");
        }
        bookRepository.deleteById(id);
    }
}