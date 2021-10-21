package com.example.demo.cinema.entity;

public class Film implements Comparable<Film>{
    private Integer id;
    private String name;

    public Film(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Film o) {
        return this.getId().compareTo(o.getId());
    }
}
