package com.example.pokedex.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SQLResultSetToJSON {

    public static <JSONException> String SQLResultToJson(ResultSet rs) throws SQLException {
// Convert a single item of a SQL database to a singular JSON item
// found here : https://stackoverflow.com/a/41453021 adapted it since we only have one json item and not an array
        ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i=1; i<=numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
            }

    return obj.toJSONString();
    }
}
