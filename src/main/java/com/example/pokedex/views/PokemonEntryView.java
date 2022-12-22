package com.example.pokedex.views;

import com.example.pokedex.models.PokemonEntryModel;

public class PokemonEntryView {

    public PokemonEntryView() {
    }


    public static void Display(PokemonEntryModel pokemonEntryModel){

        System.out.println("=============================");
        System.out.println(pokemonEntryModel.toString());
        System.out.println("=============================");
    }


}
