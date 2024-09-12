package com.badashev.animals;

import com.badashev.data.AnimalEnum;

import java.util.Arrays;
import java.util.Scanner;

public class AnimalFactory {

    private final Scanner scanner;

    public AnimalFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Animal createAnimal() {
        // Ввод тип животного
        System.out.println(Arrays.toString(AnimalEnum.values())); // Вывод списка доступны видов животных
        System.out.println("Какое животное вы хотите добавить? (Выберите из приведенного выше списка)");
        String inputLineAnimal = scanner.nextLine(); // Ввод значения пользователем
        try {
            AnimalEnum animalTypeCommand = AnimalEnum.fromString(inputLineAnimal);

            // Ввод основных атрибутов животного
            System.out.print("Введите кличку животного: ");
            String inputAnimalName = scanner.nextLine();

            System.out.print("Введите возраст животного: ");
            Integer inputAnimalAge = Integer.valueOf(scanner.nextLine());

            System.out.print("Введите вес животного: ");
            Integer inputAnimalWeight = Integer.valueOf(scanner.nextLine());

            System.out.print("Введите цвет животного: ");
            String inputAnimalColor = scanner.nextLine();

            switch (animalTypeCommand) {
                case CAT:
                    Cat cat = new Cat(inputAnimalName, inputAnimalAge, inputAnimalWeight, inputAnimalColor);
                    cat.say();
                    return cat;

                case DUCK:
                    Duck duck = new Duck(inputAnimalName, inputAnimalAge, inputAnimalWeight, inputAnimalColor);
                    duck.say();
                    duck.fly();
                    return duck;

                case DOG:
                    Dog dog = new Dog(inputAnimalName, inputAnimalAge, inputAnimalWeight, inputAnimalColor);
                    dog.say();
                    return dog;

                case null, default:
                    System.out.print("Ошибка. Выберите из ранее приведенного списка!");
                    return null;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода информации о животном.Не обходимо ввести значение из списка.");
            return createAnimal();
        }
    }
}
