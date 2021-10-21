package com.example.demo.cinema.entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class Session implements Comparable<Session>{
    private Integer id;
    private Integer filmId;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
    private Integer price;

    public Session(Integer id, Integer filmId, LocalDateTime sessionStart, LocalDateTime sessionEnd, Integer price) {
        this.id = id;
        this.filmId = filmId;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public LocalDateTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(LocalDateTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public LocalDateTime getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(LocalDateTime sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", sessionStart=" + sessionStart +
                ", sessionEnd=" + sessionEnd +
                ", price=" + price +
                '}';
    }


    @Override
    public int compareTo(Session o) {
        return this.getId().compareTo(o.getId());
    }
}
