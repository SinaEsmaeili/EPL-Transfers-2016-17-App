package com.unishi.sina.premapp;

/**
 * Created by Sina on 2016-06-07.
 */
public class Club {

    public int photoID;
    private String name;

    public Club(String name, int photoID) {
        this.photoID = photoID;
        this.name = name;
    }

    public String getNom() {
        return name;
    }
}
