package com.albumsecommerse.albums.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alb_id;

    @Column(nullable = false)
    private String alb_name;

    private LocalDate alb_releaseDate;

    private String alb_genre;

    @ManyToOne
    @JoinColumn(name = "art_id", nullable = false)
    private Artist artist;

    public Album() {
    }

    public Album(Long alb_id, String alb_name, LocalDate alb_releaseDate, String alb_genre, Artist artist) {
        this.alb_id = alb_id;
        this.alb_name = alb_name;
        this.alb_releaseDate = alb_releaseDate;
        this.alb_genre = alb_genre;
        this.artist = artist;
    }

    public Album(String alb_name, LocalDate alb_releaseDate, String alb_genre, Artist artist) {
        this.alb_name = alb_name;
        this.alb_releaseDate = alb_releaseDate;
        this.alb_genre = alb_genre;
        this.artist = artist;
    }

    public Long getAlb_id() {
        return alb_id;
    }

    public void setAlb_id(Long alb_id) {
        this.alb_id = alb_id;
    }

    public String getAlb_name() {
        return alb_name;
    }

    public void setAlb_name(String alb_name) {
        this.alb_name = alb_name;
    }

    public LocalDate getAlb_releaseDate() {
        return alb_releaseDate;
    }

    public void setAlb_releaseDate(LocalDate alb_releaseDate) {
        this.alb_releaseDate = alb_releaseDate;
    }

    public String getAlb_genre() {
        return alb_genre;
    }

    public void setAlb_genre(String alb_genre) {
        this.alb_genre = alb_genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
