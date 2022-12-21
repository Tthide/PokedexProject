package com.example.pokedex.controllers;

import com.example.pokedex.models.PokemonEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PokemonEntryController {

    public PokemonEntryController() {
    }

    public static PokemonEntry JSONParse(String jsonResponse) {

        Object resultObject = null;
        PokemonEntry pokemonEntry = new PokemonEntry();
        try {
            JSONParser parser = new JSONParser();
            resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;
                pokemonEntry.setName(obj.get("name").toString());
                pokemonEntry.setId((Long) obj.get("id"));
                pokemonEntry.setHeight((Long) obj.get("height"));
                pokemonEntry.setWeight((Long) obj.get("weight"));

            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }

        return pokemonEntry;
    }

}
