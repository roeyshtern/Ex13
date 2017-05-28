package com.example.user.ex13.Data;

/**
 * Created by User on 5/23/17.
 */

public class Item {
    public long id;
    public int number;
    public int color;

    public Item(int number, long id, int color) {
        this.number = number;
        this.id = id;
        this.color = color;
    }

    public Item(int number, int color) {
        this(-1,number,color);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
