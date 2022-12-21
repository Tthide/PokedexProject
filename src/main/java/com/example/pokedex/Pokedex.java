package com.example.pokedex;


import com.example.pokedex.controllers.PokemonEntryController;
import com.example.pokedex.models.PokemonEntry;
import com.example.pokedex.services.PokemonEntryHTTP;
import com.example.pokedex.views.PokemonEntryView;

public class Pokedex {

    public static void main(String[] args) {
        System.out.println("Java version " + System.getProperty("java.version"));
        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);

            PokemonEntry pokemonEntry = PokemonEntryController
                    .JSONParse(PokemonEntryHTTP
                            .getJSONPokemon(Integer.parseInt(args[0])));

            PokemonEntryView.Display(pokemonEntry);
        }


    }

    public String getName() {
        return "Hello";
    }
}
