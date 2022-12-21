package com.example.pokedex.models;

public class PokemonEntry {

    private Long id;
    private String Name;
    private Long Height;
    Long Weight;

    public PokemonEntry() {
    }

    public PokemonEntry(PokemonEntry pokemonEntry) {
        this.id= pokemonEntry.getId();
        this.Name=pokemonEntry.getName();
        this.Weight=pokemonEntry.getWeight();
        this.Height=pokemonEntry.getHeight();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getHeight() {
        return Height;
    }

    public void setHeight(Long height) {
        Height = height;
    }

    public Long getWeight() {
        return Weight;
    }

    public void setWeight(Long weight) {
        Weight = weight;
    }




}
