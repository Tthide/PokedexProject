package com.example.pokedex.views;

import com.example.pokedex.models.PokemonEntryModel;
import com.example.pokedex.utilities.HTMLGeneratorInterface;
import com.example.pokedex.utilities.TextGeneratorInterface;

public class PokemonEntryView implements HTMLGeneratorInterface , TextGeneratorInterface {

    private String text;
    private PokemonEntryModel pokemonEntryModel;

    public PokemonEntryView() {
    }

    public PokemonEntryView(PokemonEntryModel pokemonEntryModel) {
        this.text = pokemonEntryModel.toString();
        this.pokemonEntryModel=pokemonEntryModel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void Display(){ // part1 way of displaying entries

        System.out.println("=============================");
        System.out.println(this.text);
        System.out.println("=============================");
    }

    @Override
    public String generateHtml() {
        String[] lines = text.split("\\n");
        String Html ="<h1>" + pokemonEntryModel.getName()+"</h1>\n"
                + "<ul>\n"
                + "<li>Id : "+ pokemonEntryModel.getId().toString()+"</li>\n";
        for(int i =2;i< lines.length;i++){
            Html+="<li>"+ lines[i]+"</li>\n";
        }

        return Html + "</ul>";

    }

    @Override
    public String generateText() {
        String line="=============================\n";
        return line + this.text +"\n" + line;
    }
}
