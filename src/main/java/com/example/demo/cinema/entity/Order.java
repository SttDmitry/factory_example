package com.example.demo.cinema.entity;

public class Order implements Comparable<Order>{
    private Integer id;
    private Integer sessionId;
    private Integer seat;

    public Order(Integer id, Integer sessionId, Integer seat) {
        this.id = id;
        this.sessionId = sessionId;
        this.seat = seat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Override
    public int compareTo(Order o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sessionId=" + sessionId +
                ", seat=" + seat +
                '}';
    }
}
