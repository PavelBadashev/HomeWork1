package com.badashev.data;

public enum CommandEnum {
    ADD,
    LIST,
    EXIT;

    public static CommandEnum fromString(String command){
        return CommandEnum.valueOf(command.trim().toUpperCase());
    }
}