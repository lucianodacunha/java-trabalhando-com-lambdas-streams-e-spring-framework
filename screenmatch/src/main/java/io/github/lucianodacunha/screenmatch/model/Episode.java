package io.github.lucianodacunha.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double rating;
    private LocalDate released;

    public Episode(Integer seasonNumber, EpisodeData episodeData) {
        this.season = seasonNumber;
        this.title = episodeData.title();
        this.episodeNumber = episodeData.number();

        try {
            this.rating = Double.valueOf(episodeData.rating());
        } catch (NumberFormatException ex) {
            this.rating = 0.0;
        }

        try {
            this.released = LocalDate.parse(episodeData.realeadDate());
        } catch (DateTimeParseException ex) {
            this.released = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "seson = " + season +
                ", title = " + title + '\'' +
                ", episode number =" + episodeNumber +
                ", rating = " + rating +
                ", released = " + released;
    }
}
