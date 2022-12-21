package com.example.pokedex.views;

import com.example.pokedex.HTTPRequestExample;
import com.example.pokedex.SQLLiteExample;
import com.example.pokedex.models.PokemonEntry;

public class PokemonEntryView {

    public PokemonEntryView() {
    }

    public static void Display(PokemonEntry pokemonEntry){

        System.out.println("=============================");
        System.out.println("Pokémon # " + Long.toString(pokemonEntry.getId()));
        System.out.println("Nom : " + pokemonEntry.getName());
        System.out.println("Taille : " + Long.toString(pokemonEntry.getHeight()));
        System.out.println("Poids : " + Long.toString(pokemonEntry.getWeight()));
        System.out.println("=============================");
    }


}
