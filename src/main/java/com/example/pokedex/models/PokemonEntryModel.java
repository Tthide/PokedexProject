package com.example.pokedex.models;

public class PokemonEntryModel {

    private Long id;
    private String Name;
    private Long Height;
    private Long Weight;

    public PokemonEntryModel() {
    }

    public PokemonEntryModel(PokemonEntryModel pokemonEntryModel) {
        this.id= pokemonEntryModel.getId();
        this.Name= pokemonEntryModel.getName();
        this.Weight= pokemonEntryModel.getWeight();
        this.Height= pokemonEntryModel.getHeight();
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


    public String toString() { // follows the format that we need to display in terminal
        return
                "Pokémon # " + id +
                "\nNom : " + Name +
                "\nTaille : " + Height +
                "\nPoids : " + Weight ;

    }
}
