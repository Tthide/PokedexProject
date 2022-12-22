package com.example.pokedex;


import com.example.pokedex.controllers.PokemonEntryController;
import com.example.pokedex.models.PokemonEntryModel;
import com.example.pokedex.models.PokemonEntryModelLocal;
import com.example.pokedex.services.PokemonEntryFetch;
import com.example.pokedex.services.PokemonEntryHTTP;
import com.example.pokedex.services.PokemonEntrySQL;
import com.example.pokedex.utilities.ConsoleLogUtility;
import com.example.pokedex.utilities.FileLogUtility;
import com.example.pokedex.views.PokemonEntryView;

import java.io.IOException;
import java.lang.reflect.Type;

public class Pokedex {

    public static void main(String[] args) {
        System.out.println("Java version " + System.getProperty("java.version"));
        System.out.println("It's working !");
        PokemonEntryHTTP pokemonEntryHTTP = new PokemonEntryHTTP();


        PokemonEntryController pokemonEntryController = new PokemonEntryController(pokemonEntryHTTP); //by default we go with the first method
        PokemonEntryModel pokemonEntryModel = new PokemonEntryModel();

        if (args.length > 0) {

            System.out.println("Vous avez fourni l'argument " + args.length);

            if (args.length > 1) { // for second method

                PokemonEntrySQL pokemonEntrySQL = new PokemonEntrySQL();
                pokemonEntryController.setPokemonEntryFetch(pokemonEntrySQL);
                pokemonEntryModel = new PokemonEntryModelLocal((PokemonEntryModelLocal) pokemonEntryController.getPokemonEntryById(Long.valueOf(args[0])));



            }
            else{
                pokemonEntryModel = pokemonEntryController.getPokemonEntryById(Long.valueOf(args[0])); //first method
            }

            ////////////////////////////////////////////////////////// Displaying and writing the entry
            PokemonEntryView pokemonEntryView = new PokemonEntryView((PokemonEntryModel) pokemonEntryModel);

            //pokemonEntryView.Display(); // part1 way of displaying result


            ConsoleLogUtility.logTextToConsole(pokemonEntryView);// part 3 way of displaying result in terminal

            try { // writing HTML log in current file
                FileLogUtility.logHtmlToFile("C:\\Users\\franc\\Desktop\\cours\\EMSE_2A\\TB3\\Good_practice\\PokedexProject",pokemonEntryView);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public String getName() {
        return "Hello";
    }
}
