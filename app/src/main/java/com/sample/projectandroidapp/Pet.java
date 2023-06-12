package com.sample.projectandroidapp;

public class Pet {
    private String name;
    private String age;
    private String type;
    private String gender;

    public Pet(String name, String age, String type, String gender) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
