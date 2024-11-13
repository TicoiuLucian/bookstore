package ro.itschool.bookstore.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.bookstore.entity.Book;
import ro.itschool.bookstore.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/peek")
    public List<Book> findAllPeekBooks() {
        return bookService.findAllPeekBooks();
    }
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/name-{bookName}")
    public ResponseEntity<Optional<Book>> findByName(@PathVariable String bookName) {
        return new ResponseEntity<>(bookService.findBookByName(bookName), HttpStatus.OK);
    }

    @PostMapping("/save-new-book")
    public ResponseEntity<Book> saveNewBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveNewBook(book), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Book> findBookById(@PathVariable Integer id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/author-{authorName}")
    public List<Book> booksBySpecificAuthor(@PathVariable String authorName) {
        return bookService.findAllBooksByAuthor(authorName);
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
    }
}
