package com.badashev.animals.birds;

import com.badashev.animals.Animal;

public abstract class Bird extends Animal implements Flying {
    protected Bird(String name, Integer age, Integer weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void fly() {
        System.out.println("Летит!");
    }
}
