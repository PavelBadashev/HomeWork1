package com.badashev.animals;

public class Cat extends Animal{
    public Cat(String name, Integer age, Integer weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }

    @Override
    public void go() {
        System.out.println("Бежит");
    }

    @Override
    public void eat() {
        System.out.println("Кушает");
    }

    @Override
    public void drink() {
        System.out.println("Пьет воду");
    }
}
