package com.example.pokedex.services;

import java.sql.*;

public class PokemonEntrySQL implements PokemonEntryFetch{

    private String dbUrl;

    public PokemonEntrySQL(String dbUrl) {
        this.dbUrl=dbUrl;
    }



    public String getPokemonEntry(Long id)  {
        /* Connect to the database */
        Connection conn = null;
        ResultSet rs = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + dbUrl;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT * FROM pokemons WHERE id = ?");
            stmt.setInt(1, Math.toIntExact(id)); // We want the item whose id is put as an argument of the method
            rs= stmt.executeQuery();
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
