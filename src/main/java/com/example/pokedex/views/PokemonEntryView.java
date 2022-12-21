package com.example.pokedex.views;

import com.example.pokedex.models.PokemonEntryModel;

public class PokemonEntryView {

    public PokemonEntryView() {
    }

    private String log;

    public void setLog(PokemonEntryModel pokemonEntryModel) {
        this.log =  "Pokémon # " + Long.toString(pokemonEntryModel.getId())  +"\n"
        + "Nom : " + pokemonEntryModel.getName() +"\n"
        + "Taille : " + Long.toString(pokemonEntryModel.getHeight()) +"\n"
        + "Poids : " + Long.toString(pokemonEntryModel.getWeight());
    }

    public static void Display(PokemonEntryModel pokemonEntryModel){

        System.out.println("=============================");
        System.out.println("Pokémon # " + Long.toString(pokemonEntryModel.getId()));
        System.out.println("Nom : " + pokemonEntryModel.getName());
        System.out.println("Taille : " + Long.toString(pokemonEntryModel.getHeight()));
        System.out.println("Poids : " + Long.toString(pokemonEntryModel.getWeight()));
        System.out.println("=============================");
    }


}
