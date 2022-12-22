package com.example.pokedex.services;

import java.sql.*;

public class PokemonEntrySQL implements PokemonEntryFetch{

    public PokemonEntrySQL() {
    }

    public String getPokemonEntry(Long id)  {
        /* Connect to the database */
        Connection conn = null;
        ResultSet rs = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:ressources/pokemondatabase.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT * FROM pokemons WHERE id = ?");
            stmt.setInt(1, Math.toIntExact(id)); // Sets the value "3" for parameter at position 1
            rs    = stmt.executeQuery();
            rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {

            return SQLResultSetToJSON.SQLResultToJson(rs); // Controller has a JSON String as input so we need to convert it
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
