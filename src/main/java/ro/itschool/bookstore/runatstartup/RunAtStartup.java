package ro.itschool.bookstore.runatstartup;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.bookstore.entity.*;
import ro.itschool.bookstore.service.BookService;
import ro.itschool.bookstore.service.CustomerService;
import ro.itschool.bookstore.service.MagazineService;
import ro.itschool.bookstore.service.MusicDiscService;

import java.time.LocalDate;
import java.time.Month;


@Component
@RequiredArgsConstructor
public class RunAtStartup {

    private final CustomerService customerService;
    private final BookService bookService;
    private final MagazineService magazineService;
    private final MusicDiscService musicDiscService;

    @EventListener(ApplicationReadyEvent.class)
    public void insertDataIntoDBAfterServerStartup() {

// customers------------------------------------------------------------------------------------------------------------
        Customer customer1 = new Customer();
        customer1.setUsername("customer1");
        customer1.setPassword("customer1");
        customer1.setEmail("customer1@mail.com");
        customer1.setIsMajor(false);
        customerService.addNewCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setUsername("customer2");
        customer2.setPassword("customer2");
        customer2.setEmail("customer2@mail.com");
        customer2.setIsMajor(true);
        customerService.addNewCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setUsername("customer3");
        customer3.setPassword("customer3");
        customer3.setEmail("customer3@mail.com");
        customer3.setIsMajor(true);
        customerService.addNewCustomer(customer3);

// boooks---------------------------------------------------------------------------------------------------------------
        Book book1 = new Book();
        book1.setPrice(80F);
        book1.setName("Dezumanizat");
        book1.setIsSuitableForChildren(false);
        book1.setPages(210);
        book1.setAuthorName("Osamu Dazai");
        book1.setGenreEnum(GenreEnum.BIOGRAPHY);
        book1.setPublicationDate(LocalDate.of(1999, Month.JULY, 7));
        book1.setCustomer(customer1);
        bookService.saveNewBook(book1);

        Book book2 = new Book();
        book2.setPrice(34.70F);
        book2.setName("Orbitor");
        book2.setIsSuitableForChildren(true);
        book2.setPages(450);
        book2.setAuthorName("Mircea Cartarescu");
        book2.setGenreEnum(GenreEnum.FANTASY);
        book2.setPublicationDate(LocalDate.of(1980, Month.DECEMBER, 18));
        book2.setCustomer(customer1);
        bookService.saveNewBook(book2);

        Book book3 = new Book();
        book3.setPrice(56.50F);
        book3.setName("Nostalgia");
        book3.setIsSuitableForChildren(false);
        book3.setPages(360);
        book3.setAuthorName("Mircea Cartarescu");
        book3.setGenreEnum(GenreEnum.FICTION);
        book3.setPublicationDate(LocalDate.of(2020, Month.APRIL, 20));
        book3.setCustomer(customer1);
        bookService.saveNewBook(book3);

        Book book4 = new Book();
        book4.setPrice(20F);
        book4.setName("Metamorfoza");
        book4.setIsSuitableForChildren(false);
        book4.setPages(80);
        book4.setAuthorName("Franz Kafka");
        book4.setGenreEnum(GenreEnum.PHILOSOPHY);
        book4.setPublicationDate(LocalDate.of(1960, Month.JULY, 13));
        book4.setCustomer(customer2);
        bookService.saveNewBook(book4);

        Book book5 = new Book();
        book5.setPrice(30.59F);
        book5.setName("Nopti Albe");
        book5.setIsSuitableForChildren(true);
        book5.setPages(180);
        book5.setAuthorName("Fyodor Dostoievsky");
        book5.setGenreEnum(GenreEnum.MYSTERY);
        book5.setPublicationDate(LocalDate.of(1908, Month.JANUARY, 2));
        book5.setCustomer(customer2);
        bookService.saveNewBook(book5);

        Book book6 = new Book();
        book6.setPrice(56.50F);
        book6.setName("Melancolia");
        book6.setIsSuitableForChildren(true);
        book6.setPages(390);
        book6.setAuthorName("Mircea Cartarescu");
        book6.setGenreEnum(GenreEnum.FICTION);
        book6.setPublicationDate(LocalDate.of(1990, Month.SEPTEMBER, 20));
        book6.setCustomer(customer3);
        bookService.saveNewBook(book6);

        Book book7 = new Book();
        book7.setPrice(40F);
        book7.setName("Castelul");
        book7.setIsSuitableForChildren(true);
        book7.setPages(120);
        book7.setAuthorName("Franz Kafka");
        book7.setGenreEnum(GenreEnum.FICTION);
        book7.setPublicationDate(LocalDate.of(1945, Month.FEBRUARY, 16));
        book7.setCustomer(customer3);
        bookService.saveNewBook(book7);

// magazines------------------------------------------------------------------------------------------------------------

        Magazine magazine1 = new Magazine();
        magazine1.setPrice(12F);
        magazine1.setName("Alien");
        magazine1.setIsSuitableForChildren(true);
        magazine1.setPages(27);
        magazine1.setVolumeEdition(3);
        magazine1.setPublisher("Publisher1");
        magazine1.setPublicationDate(LocalDate.of(2024, Month.JULY, 27));
        magazine1.setGenreEnum(GenreEnum.SCIENCE_FICTION);
        magazine1.setCustomer(customer1);
        magazineService.saveNewMagazine(magazine1);

        Magazine magazine2 = new Magazine();
        magazine2.setPrice(10F);
        magazine2.setName("Best of Y2K");
        magazine2.setIsSuitableForChildren(true);
        magazine2.setPages(50);
        magazine2.setVolumeEdition(1);
        magazine2.setPublisher("Publisher 2");
        magazine2.setPublicationDate(LocalDate.of(2015, Month.AUGUST, 19));
        magazine2.setGenreEnum(GenreEnum.HISTORY);
        magazine2.setCustomer(customer1);
        magazineService.saveNewMagazine(magazine2);

        Magazine magazine3 = new Magazine();
        magazine3.setPrice(12F);
        magazine3.setName("History of Race Cars");
        magazine3.setIsSuitableForChildren(true);
        magazine3.setPages(30);
        magazine3.setVolumeEdition(1);
        magazine3.setPublisher("Publisher1");
        magazine3.setPublicationDate(LocalDate.of(2022, Month.JANUARY, 12));
        magazine3.setGenreEnum(GenreEnum.HISTORY);
        magazine3.setCustomer(customer2);
        magazineService.saveNewMagazine(magazine3);

// music discs----------------------------------------------------------------------------------------------------------

        MusicDisc musicDisc1 = new MusicDisc();
        musicDisc1.setPrice(5F);
        musicDisc1.setName("All Hope Is Hone");
        musicDisc1.setIsSuitableForChildren(true);
        musicDisc1.setBandName("Slipknot");
        musicDisc1.setReleaseDate(LocalDate.of(2008, Month.APRIL, 28));
        musicDisc1.setGenreEnum(GenreEnum.METAL);
        musicDisc1.setCustomer(customer2);
        musicDiscService.saveNewMusicDisc(musicDisc1);

        MusicDisc musicDisc2 = new MusicDisc();
        musicDisc2.setPrice(6F);
        musicDisc2.setName("See You On The Other Side");
        musicDisc2.setIsSuitableForChildren(true);
        musicDisc2.setBandName("Korn");
        musicDisc2.setReleaseDate(LocalDate.of(2005, Month.JULY, 12));
        musicDisc2.setGenreEnum(GenreEnum.METAL);
        musicDisc2.setCustomer(customer2);
        musicDiscService.saveNewMusicDisc(musicDisc2);

        MusicDisc musicDisc3 = new MusicDisc();
        musicDisc3.setPrice(5F);
        musicDisc3.setName("Oops, I Did It Again");
        musicDisc3.setIsSuitableForChildren(true);
        musicDisc3.setBandName("Britney Spears");
        musicDisc3.setReleaseDate(LocalDate.of(2002, Month.SEPTEMBER, 5));
        musicDisc3.setGenreEnum(GenreEnum.POP);
        musicDisc3.setCustomer(customer3);
        musicDiscService.saveNewMusicDisc(musicDisc3);

        MusicDisc musicDisc4 = new MusicDisc();
        musicDisc4.setPrice(12F);
        musicDisc4.setName("Despacito");
        musicDisc4.setIsSuitableForChildren(true);
        musicDisc4.setBandName("Luis Fonsi");
        musicDisc4.setReleaseDate(LocalDate.of(2016, Month.JULY, 15));
        musicDisc4.setGenreEnum(GenreEnum.LATINO);
        musicDisc4.setCustomer(customer3);
        musicDiscService.saveNewMusicDisc(musicDisc4);

        MusicDisc musicDisc5 = new MusicDisc();
        musicDisc5.setPrice(7F);
        musicDisc5.setName("Saint Anger");
        musicDisc5.setIsSuitableForChildren(true);
        musicDisc5.setBandName("Metallica");
        musicDisc5.setReleaseDate(LocalDate.of(2008, Month.APRIL, 28));
        musicDisc5.setGenreEnum(GenreEnum.ROCK);
        musicDisc5.setCustomer(customer3);
        musicDiscService.saveNewMusicDisc(musicDisc5);
    }
}
