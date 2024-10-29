package com.badashev.commands;

import com.badashev.animals.Animal;
import com.badashev.animals.AnimalFactory;
import com.badashev.data.CommandEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Commands {

    private final Scanner scanner;
    private final List<Animal> animals;

    public Commands(Scanner scanner, List<Animal> animals) {
        this.scanner = scanner;
        this.animals = animals;
    }

    public void executeCommand() {

        System.out.println(Arrays.toString(CommandEnum.values())); // Вывод списка доступны видов животных
        System.out.print("Введите команду: ");
        String inputLine = scanner.nextLine();
        try {
            CommandEnum commandEnum = CommandEnum.fromString(inputLine);

            switch (commandEnum) {
                case ADD:
                    AnimalFactory animalFactory = new AnimalFactory(scanner, System.out);
                    Animal newAnimal = animalFactory.createAnimal();
                    animals.add(newAnimal);
                    break;

                case LIST:
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;

                case EXIT:
                    System.exit(0);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка ввода комманды. Не обходимо ввести значение из списка.");
            this.executeCommand();
        }
    }
}
