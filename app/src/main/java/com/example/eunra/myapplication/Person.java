package com.example.eunra.myapplication;

public class Person {
    private String ten;
    private int age;

    @Override
    public String toString() {
        return ten+ " " + age;
    }

    public Person(String ten, int age) {
        this.ten = ten;
        this.age = age;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
