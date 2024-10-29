package com.badashev.animals;

public abstract class Animal {
    private String name;
    private Integer age;
    private Integer weight;
    private String color;

    protected Animal(String name, Integer age, Integer weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void say();

    public abstract void go();

    public abstract void eat();

    public abstract void drink();

    private String ageStringConvert(){
        if (age % 10 == 1 && age % 100 != 11) {
            return age + " год";
        }
        if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
            return age + " года";
        }
        return age + " лет";
    }
    @Override
    public String toString() {
        return "Привет! Меня зовут "
                + name + ". Мне "
                + ageStringConvert()
                + ". Я вешу - "
                + weight
                + " кг. Мой цвет - "
                + color;
    }
}
