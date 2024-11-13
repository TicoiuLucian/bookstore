package ro.itschool.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ro.itschool.bookstore.entity.Magazine;
import ro.itschool.bookstore.entity.MusicDisc;
import ro.itschool.bookstore.repository.MusicDiscRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MusicDiscService {

    private final MusicDiscRepository musicDiscRepository;

    public MusicDisc saveNewMusicDisc(MusicDisc musicDisc) {
        log.info("Saving music disc: {}", musicDisc.getName());
        return musicDiscRepository.save(musicDisc);
    }

    public Optional<MusicDisc> findMusicDiscsById(Integer id) {
        return musicDiscRepository.findById(id);
    }

    public Optional<MusicDisc> findMusicDiscsByName(String name) {
        return musicDiscRepository.findByName(name);
    }

    public List<MusicDisc> findAllMusicDiscsByAuthor(String bandName) {
        return musicDiscRepository.findByBandName(bandName);
    }

    public List<MusicDisc> findAllMusicDiscs() {
        return musicDiscRepository.findAll();
    }

//    @Query("DELETE FROM Music_disc d WHERE d.id = :id")
    public void deleteMusicDiscById(Integer id) {
        if (musicDiscRepository.existsById(id)) {
            musicDiscRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("music disc with id {} was not found");
        }
    }
}
