package com.FilmGalleryApp.FilmGalleryApp.film.controller;

import com.FilmGalleryApp.FilmGalleryApp.film.model.Film;
import com.FilmGalleryApp.FilmGalleryApp.film.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.NoSuchElementException;

@Controller
public class FilmController {

    // Service-Schicht zwischen Web (Controller) und Datenzugriff (Repository)
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // GET "/" – Startseite: Grid mit allen Filmen
//    @GetMapping("/")
//    public String index(Model model) {
//        // Filme aus der DB laden und ans View-Modell übergeben
//        model.addAttribute("films", filmService.findAll());
//        return "index"; // rendert templates/index.html
//    }

    // GET "/films/{id}" – Detailseite für einen Film
    @GetMapping("/films/{id}")
    public String filmDetails(@PathVariable Integer id, Model model) {
        Film film = filmService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Film mit Id " + id + " nicht gefunden"));

        model.addAttribute("film", film);
        return "film-details"; // rendert templates/film-details.html
    }

    // (Optional) Fehler-Routing für NoSuchElementException
    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound(NoSuchElementException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "not-found"; // optionales Fehler-Template
    }

    // GET "/" – Startseite mit Paging (9 Einträge pro Seite)
    @GetMapping("/")
    public String index(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        final int size = 9; // 3x3

        // Seite laden
        Page<Film> filmPage = filmService.findPage(page, size);

        // Daten ans View-Modell
        model.addAttribute("films", filmPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", filmPage.getTotalPages());
        model.addAttribute("hasNext", filmPage.hasNext());
        model.addAttribute("hasPrevious", filmPage.hasPrevious());

        return "index"; // templates/index.html
    }
}
