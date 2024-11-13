package ro.itschool.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Magazine extends BookstoreItem{

    private Integer pages;

    private Integer volumeEdition;

    private String publisher;

    private LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    private GenreEnum genreEnum;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
