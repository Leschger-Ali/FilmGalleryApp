package com.FilmGalleryApp.FilmGalleryApp.film.repo;

import com.FilmGalleryApp.FilmGalleryApp.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Standard-JPA-Repository für CRUD-Operationen auf der Entität "Film"
public interface FilmRepository extends JpaRepository<Film, Integer> {

    // Suche nach Titeln, die einen Teilstring enthalten (Groß-/Kleinschreibung ignorieren)
    List<Film> findByTitleContainingIgnoreCase(String titlePart);

    // Suche nach Genre-Teilstring (Groß-/Kleinschreibung ignorieren)
    List<Film> findByGenreContainingIgnoreCase(String genrePart);
}
