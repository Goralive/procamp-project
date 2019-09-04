package com.trello.api.models;

public class Board {
    public String id;
    public String name;
    public String desc;
    public String url;

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
