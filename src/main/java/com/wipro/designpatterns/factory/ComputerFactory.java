package com.wipro.designpatterns.factory;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {

        if ("desktop".equalsIgnoreCase(type))
            return new Desktop(ram, hdd, cpu);
        else if ("laptop".equalsIgnoreCase(type))
            return new Laptop(ram, hdd, cpu);

        return null;
    }
}
