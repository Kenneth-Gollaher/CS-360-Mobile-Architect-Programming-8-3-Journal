package com.zybooks.healthyapp2;

public class UserModel {

    private int id;
    private String date;
    private int weight;

    // constructor
    public UserModel(int id, String date, int weight) {
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    public UserModel() {
    }

    // toString to print data


    @Override
    public String toString() {
        return date + ' ' +
                + weight +
                ' ';
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
