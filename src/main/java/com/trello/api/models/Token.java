package com.trello.api.models;

public class Token {

    public String id;
    public String idMember;

    @Override
    public String toString() {
        return "Token{" +
                "id='" + id + '\'' +
                ", idMember='" + idMember + '\'' +
                '}';
    }
}

