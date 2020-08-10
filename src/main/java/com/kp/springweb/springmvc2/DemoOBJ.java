package com.kp.springweb.springmvc2;

public class DemoOBJ {
    private int age;
    private String name;

    public DemoOBJ() {
        super();
    }

    public DemoOBJ(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
