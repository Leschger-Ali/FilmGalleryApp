package com.FilmGalleryApp.FilmGalleryApp.film.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "Films", schema = "dbo")
public class Film {

    // Primärschlüssel mit IDENTITY (1,1) – wird von der Datenbank automatisch vergeben
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    // Titel des Films (Pflichtfeld)
    @Column(name = "Title", nullable = false, length = 200)
    private String title;

    // Veröffentlichungsdatum (optional)
    @Column(name = "ReleaseDate")
    private LocalDate releaseDate;

    // Dauer in Minuten (optional)
    @Column(name = "DurationMinutes")
    private Integer durationMinutes;

    // Genre/Genres als Text (optional)
    @Column(name = "Genre", length = 100)
    private String genre;

    // Bewertung als DECIMAL(3,1) – BigDecimal passend zum DB-Typ
    @Column(name = "Rating", precision = 3, scale = 1)
    private BigDecimal rating;

    // Kurzbeschreibung (optional)
    @Column(name = "Description", length = 1000)
    private String description;

    // URL zum Poster/Deckbild (optional)
    @Column(name = "PosterUrl", length = 500)
    private String posterUrl;

    // Wird in der DB per DEFAULT SYSUTCDATETIME() gesetzt – nicht insert/updatebar
    @Column(name = "CreatedAt", insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    // ==== Konstruktoren ====
    public Film() {}

    public Film(String title, LocalDate releaseDate, Integer durationMinutes,
                String genre, BigDecimal rating, String description, String posterUrl) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.durationMinutes = durationMinutes;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
        this.posterUrl = posterUrl;
    }

    // ==== Getter/Setter ====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
