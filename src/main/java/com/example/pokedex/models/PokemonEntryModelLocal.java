package com.example.pokedex.models;

public class PokemonEntryModelLocal extends PokemonEntryModel{
// we added a description item to the entry
    private String Description;

    public PokemonEntryModelLocal() {
    }

    public PokemonEntryModelLocal(PokemonEntryModel pokemonEntryModel, String description) {
        super(pokemonEntryModel);
        this.Description = description;
    }

    public PokemonEntryModelLocal(PokemonEntryModelLocal pokemonEntryModelLocal) {
        this.setId(pokemonEntryModelLocal.getId());
        this.setName(pokemonEntryModelLocal.getName());
        this.setWeight(pokemonEntryModelLocal.getWeight());
        this.setHeight(pokemonEntryModelLocal.getHeight());
        this.Description = pokemonEntryModelLocal.getDescription();
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() { // just adding the description
        return super.toString() + "\nDescription : " + Description;


    }
}
