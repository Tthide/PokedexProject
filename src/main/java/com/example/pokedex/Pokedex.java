package com.example.pokedex;


import com.example.pokedex.controllers.PokemonEntryController;
import com.example.pokedex.models.PokemonEntryModel;
import com.example.pokedex.services.PokemonEntryFetch;
import com.example.pokedex.services.PokemonEntryHTTP;
import com.example.pokedex.views.PokemonEntryView;

public class Pokedex {

    public static void main(String[] args) {
        System.out.println("Java version " + System.getProperty("java.version"));
        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);


            PokemonEntryHTTP pokemonEntryHTTP = new PokemonEntryHTTP();
            PokemonEntryController pokemonEntryController = new PokemonEntryController(pokemonEntryHTTP);
            PokemonEntryModel pokemonEntryModel = pokemonEntryController.getPokemonEntryById(Long.valueOf(args[0]));


            PokemonEntryView.Display(pokemonEntryModel);
        }


    }

    public String getName() {
        return "Hello";
    }
}
