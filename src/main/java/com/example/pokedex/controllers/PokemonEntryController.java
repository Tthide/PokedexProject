package com.example.pokedex.controllers;

import com.example.pokedex.models.PokemonEntryModel;
import com.example.pokedex.models.PokemonEntryModelLocal;
import com.example.pokedex.services.PokemonEntryFetch;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PokemonEntryController {

    private PokemonEntryFetch pokemonEntryFetch;


    public PokemonEntryController(PokemonEntryFetch pokemonEntryFetch) {
        this.pokemonEntryFetch = pokemonEntryFetch;
    }

    public PokemonEntryFetch getPokemonEntryFetch() {
        return pokemonEntryFetch;
    }

    public void setPokemonEntryFetch(PokemonEntryFetch pokemonEntryFetch) {
        this.pokemonEntryFetch = pokemonEntryFetch;
    }

    public PokemonEntryModel getPokemonEntryById(Long id) {


        PokemonEntryModel pokemonEntryModel = new PokemonEntryModel(); // creating a new instance

        try {
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(this.pokemonEntryFetch.getPokemonEntry(id));

            if (resultObject instanceof JSONObject obj) {
                int i = obj.size();

                // These item exist in any case as PokemonEntryModelLocal is a child of PokemonEntryModel
                pokemonEntryModel.setName(obj.get("name").toString());
                pokemonEntryModel.setId((Long) obj.get("id"));
                pokemonEntryModel.setHeight((Long) obj.get("height"));
                pokemonEntryModel.setWeight((Long) obj.get("weight"));


                if (i==5){// for local or second method
                    // here we change the class as we add a new item
                    pokemonEntryModel = new PokemonEntryModelLocal(pokemonEntryModel,obj.get("description").toString());
                }



            } else {
                System.err.println("Error, we expected a JSON Object ");
            }
        } catch (ParseException e) {
            System.err.println("Could not parse the response given as JSON");
            e.printStackTrace();
        }

        return pokemonEntryModel;
    }

}
