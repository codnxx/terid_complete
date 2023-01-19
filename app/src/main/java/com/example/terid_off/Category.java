package com.example.terid_off;

public class Category {

    public static final int DAY1 = 1;
    public static final int DAY2 = 2;
    public static final int DAY3 = 3;
    public static final int DAY4 = 4;
    public static final int DAY5 = 5;
    public static final int DAY6 = 6;
    public static final int DAY7 = 7;
    public static final int DAY8 = 8;
    public static final int DAY9 = 9;
    public static final int DAY10 = 10;
    public static final int DAY11 = 11;
    public static final int DAY12 = 12;
    public static final int DAY13 = 13;
    public static final int DAY14 = 14;
    public static final int DAY15 = 15;
    public static final int DAY16 = 16;
    public static final int DAY17 = 17;
    public static final int DAY18 = 18;
    public static final int DAY19 = 19;
    public static final int DAY20 = 20;
    public static final int DAY21 = 21;
    public static final int DAY22 = 22;
    public static final int DAY23 = 23;
    public static final int DAY24 = 24;
    public static final int DAY25 = 25;
    public static final int DAY26 = 26;
    public static final int DAY27 = 27;
    public static final int DAY28 = 28;
    public static final int DAY29 = 29;
    public static final int DAY30 = 30;

    private int id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return getName();
    }
}
