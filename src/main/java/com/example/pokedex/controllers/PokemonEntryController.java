package com.example.pokedex.controllers;

import com.example.pokedex.models.PokemonEntryModel;
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

        Object resultObject = null;
        PokemonEntryModel pokemonEntryModel = new PokemonEntryModel();
        try {
            JSONParser parser = new JSONParser();
            resultObject = parser.parse(this.pokemonEntryFetch.getPokemonEntry(id));
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;
                pokemonEntryModel.setName(obj.get("name").toString());
                pokemonEntryModel.setId((Long) obj.get("id"));
                pokemonEntryModel.setHeight((Long) obj.get("height"));
                pokemonEntryModel.setWeight((Long) obj.get("weight"));

            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            e.printStackTrace();
        }

        return pokemonEntryModel;
    }

}
