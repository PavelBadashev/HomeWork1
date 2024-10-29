package com.badashev.animals;

import com.badashev.animals.birds.Duck;
import com.badashev.data.AnimalEnum;
import com.badashev.validator.ScannerValidator;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class AnimalFactory {

    private final Scanner scanner;
    private final PrintStream printStream;

    public AnimalFactory(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public Animal createAnimal() {
        // Ввод тип животного
        printStream.println(Arrays.toString(AnimalEnum.values())); // Вывод списка доступны видов животных
        printStream.println("Какое животное вы хотите добавить? (Выберите из приведенного выше списка)");
        String inputLineAnimal = scanner.nextLine(); // Ввод значения пользователем
        try {
            AnimalEnum animalTypeCommand = AnimalEnum.fromString(inputLineAnimal);
            ScannerValidator validator = new ScannerValidator(scanner);

            // Ввод основных атрибутов животного
            printStream.print("Введите кличку животного: ");
            String inputAnimalName = validator.inputString();

            printStream.print("Введите возраст животного: ");
            Integer inputAnimalAge = validator.inputNumber();

            printStream.print("Введите вес животного: ");
            Integer inputAnimalWeight = validator.inputNumber();

            printStream.print("Введите цвет животного: ");
            String inputAnimalColor = validator.inputString();

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

                default:
                    printStream.println("Ошибка. Выберите из ранее приведенного списка!");
                    return null;
            }
        } catch (IllegalArgumentException e) {
            printStream.println("Ошибка ввода информации о животном. Необходимо ввести значение из списка.");
            return createAnimal();
        }
    }
}
