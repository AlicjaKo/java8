package myapp;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<String> hobbies;

    public Person() {
        this.hobbies = new ArrayList<String>();
    }

    public void setName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void addHobby(String hobby) {
        if (hobby == null || hobby.length() == 0) {
            throw new IllegalArgumentException("Hobby cannot be null or empty");
        }
        hobbies.add(hobby);
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return this.name + " has " + this.age + " years old, and they like " + this.hobbies;
    }
}
