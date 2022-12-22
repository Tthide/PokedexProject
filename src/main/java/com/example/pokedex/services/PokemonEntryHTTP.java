package com.example.pokedex.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PokemonEntryHTTP implements PokemonEntryFetch{
    public PokemonEntryHTTP() {
    }

    public String getPokemonEntry(Long id) {
        String jsonResponse = "";
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + id); // send request to API
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8"); // convert JSON to string

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResponse;


    }

}