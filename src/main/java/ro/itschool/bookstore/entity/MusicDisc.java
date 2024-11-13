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
public class MusicDisc extends BookstoreItem{

    private String bandName;

    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private GenreEnum genreEnum;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
