package com.example.pokedex.utilities;

public class ConsoleLogUtility {
    public static void logTextToConsole(TextGeneratorInterface generator) {
        //Writes in terminal the entry found
        System.out.println(generator.generateText());
    }

}
