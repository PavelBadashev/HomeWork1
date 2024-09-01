package Menu;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Duck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println(Arrays.toString(Command.values())); // Вывод списка доступны видов животных
            System.out.printf("Введите команду: ");
            String inputLine =scanner.nextLine();

            Command command = Command.fromString(inputLine);

            switch (command) {
                case ADD:
                    // Ввод тип животного
                    System.out.println(Arrays.toString(AnimalEnum.values())); // Вывод списка доступны видов животных
                    System.out.println("Какое животное вы хотите добавить? (Выберите из приведенного выше списка)");
                    String inputLineAnimal = scanner.nextLine(); // Ввод значения пользователем
                    AnimalEnum animalTypeCommand = AnimalEnum.fromString(inputLineAnimal); // Валидация введенного текста

                    // Ввод основных атрибутов животного
                    System.out.printf("Введите кличку животного: ");
                    String inputAnimalName = scanner.nextLine();

                    System.out.printf("Введите возраст животного: ");
                    Integer inputAnimalAge = Integer.valueOf(scanner.nextLine());

                    System.out.printf("Введите вес животного: ");
                    Integer inputAnimalWeight = Integer.valueOf(scanner.nextLine());

                    System.out.printf("Введите цвет животного: ");
                    String inputAnimalColor = scanner.nextLine();

                    switch (animalTypeCommand) {
                        case CAT:
                            Cat cat = new Cat(inputAnimalName, inputAnimalAge, inputAnimalWeight, inputAnimalColor);
                            cat.say();
                            animals.add(cat);
                            break;

                        case DUCK:
                            Duck duck = new Duck(inputAnimalName, inputAnimalAge, inputAnimalWeight, inputAnimalColor);
                            duck.say();
                            duck.fly();
                            animals.add(duck);
                            break;

                        case DOG:
                            Dog dog = new Dog(inputAnimalName, inputAnimalAge, inputAnimalWeight, inputAnimalColor);
                            dog.say();
                            animals.add(dog);
                            break;

                        case null, default:
                            System.out.printf("Ошибка. Выберите из ранее приведенного списка!");
                    }
                    break;

                case LIST:
                    for (Animal animal : animals){
                        System.out.println(animal.toString());
                    }
                    break;

                case EXIT:
                    exit = true;
                    System.out.printf("Выход из программы...");
                    break;
                case null:
                    System.out.printf("Введи команду!!!");
                    break;
                default:
                    System.out.printf("Ошибка. Введите одну из комманд из " + Arrays.toString(Command.values()));
            }
        }
    }
}
