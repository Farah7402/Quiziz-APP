package com.example.farahjabeen.wq;

public class Category {
    public static final int SCIENCE = 1;
    public static final int Sport = 2;
    public static final int Famous_Places = 3;
    public static final int Technology = 4;
    public static final int Genral_Knowledge = 5;


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