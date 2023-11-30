package org.example;

import java.util.Objects;

public class Person {
    private String name;
    private String about;
    private int birthYear;

    public Person(String name, String about, int birthYear) {
        this.name = name;
        this.about = about;
        this.birthYear = birthYear;
    }

    public Person() {

    }

    public Person(String name) {
    }

    public Person(int id, String name, String about, int birthYear) {
    }


    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public int getBirthYear() {
        return birthYear;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getBirthYear() == person.getBirthYear() && Objects.equals(getName(), person.getName()) && Objects.equals(getAbout(), person.getAbout());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAbout(), getBirthYear());
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

}

