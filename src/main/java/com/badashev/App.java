package com.badashev;

import com.badashev.animals.Animal;
import com.badashev.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        while (true) {
            Commands command = new Commands(scanner, animals);
            command.executeCommand();
        }
    }
}
