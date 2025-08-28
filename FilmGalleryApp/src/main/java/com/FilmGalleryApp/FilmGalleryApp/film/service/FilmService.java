package com.FilmGalleryApp.FilmGalleryApp.film.service;

import com.FilmGalleryApp.FilmGalleryApp.film.model.Film;
import com.FilmGalleryApp.FilmGalleryApp.film.repo.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
public class FilmService {

    // Repository für Datenbankzugriffe auf "Films"
    private final FilmRepository filmRepository;

    // Konstruktorinjektion (empfohlen)
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    // Liefert alle Filme für die Startseite (Grid)
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    // Liefert einen einzelnen Film nach Id (für die Detailseite)
    public Optional<Film> findById(Integer id) {
        return filmRepository.findById(id);
    }

    // (Optional) Suchen nach Titelteil
    public List<Film> searchByTitle(String part) {
        return filmRepository.findByTitleContainingIgnoreCase(part);
    }

    // (Optional) Suchen nach Genrestück
    public List<Film> searchByGenre(String part) {
        return filmRepository.findByGenreContainingIgnoreCase(part);
    }


    public Page<Film> findPage(int page, int size) {
        // Hinweis: wenn CreatedAt null sein kann, kannst du auf Title zurückfallen.
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt").and(Sort.by("title"));
        return filmRepository.findAll(PageRequest.of(page, size, sort));
    }
}
