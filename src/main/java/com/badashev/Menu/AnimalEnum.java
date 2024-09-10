package com.badashev.Menu;

public enum AnimalEnum {
    DOG,
    CAT,
    DUCK;

    public static AnimalEnum fromString(String animalEnum){
        return AnimalEnum.valueOf(animalEnum.trim().toUpperCase());
    }
}