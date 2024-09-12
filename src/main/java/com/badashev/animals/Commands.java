package com.badashev.animals;

import com.badashev.data.Command;

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

        System.out.println(Arrays.toString(com.badashev.data.Command.values())); // Вывод списка доступны видов животных
        System.out.print("Введите команду: ");
        String inputLine = scanner.nextLine();
        try {
            Command command = Command.fromString(inputLine);

            switch (command) {
                case ADD:
                    AnimalFactory animalFactory = new AnimalFactory(scanner);
                    Animal newAnimal = animalFactory.createAnimal();
                    animals.add(newAnimal);
                    break;

                case LIST:
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;

                case EXIT:
                    System.exit(200);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка ввода комманды. Не обходимо ввести значение из списка.");
            this.executeCommand();
        }
    }
}
