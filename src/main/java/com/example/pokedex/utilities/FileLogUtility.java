package com.example.pokedex.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogUtility {
    public static void logHtmlToFile(String filePath, HTMLGeneratorInterface generator) throws IOException {
        // convert the entry to html and write it to a html file
        Files.write(Paths.get(filePath+"\\output.html"), generator.generateHtml().getBytes(StandardCharsets.UTF_8));
    }

}
