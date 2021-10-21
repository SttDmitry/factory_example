package com.example.demo.cinema.entity;

import java.time.LocalDateTime;

public class SessionFiltered  implements Comparable<SessionFiltered>{
    private String filmName;
    private LocalDateTime sessionStart;
    private String filmLength;
    private LocalDateTime secondSessionStart;
    private String timePeriod;
    private Integer minutesPeriod;

    public SessionFiltered(String filmName, LocalDateTime sessionStart, String filmLength, LocalDateTime secondSessionStart, String timePeriod, int minutesPeriod) {
        this.filmName = filmName;
        this.sessionStart = sessionStart;
        this.filmLength = filmLength;
        this.secondSessionStart = secondSessionStart;
        this.timePeriod = timePeriod;
        this.minutesPeriod = minutesPeriod;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public LocalDateTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(LocalDateTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public LocalDateTime getSecondSessionStart() {
        return secondSessionStart;
    }

    public void setSecondSessionStart(LocalDateTime secondSessionStart) {
        this.secondSessionStart = secondSessionStart;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Integer getMinutesPeriod() {
        return minutesPeriod;
    }

    public void setMinutesPeriod(Integer minutesPeriod) {
        this.minutesPeriod = minutesPeriod;
    }

    @Override
    public String toString() {
        return "SessionFiltered{" +
                "filmName='" + filmName + '\'' +
                ", sessionStart=" + sessionStart +
                ", filmLength='" + filmLength + '\'' +
                ", secondSessionStart=" + secondSessionStart +
                ", timeBetween='" + timePeriod +
                '}';
    }


    @Override
    public int compareTo(SessionFiltered o) {
        return this.getMinutesPeriod().compareTo(o.getMinutesPeriod());
    }
}
