package ro.fasttrackit.curs19;

import java.sql.*;

public class TestSQL {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://mysql-rfam-public.ebi.ac.uk:4497/Rfam", "rfamro",
                "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from family");

            while (resultSet.next()) {
                System.out.print(resultSet.getInt("maxl"));
                System.out.print(" : ");
                System.out.println(resultSet.getString("author"));
            }
        }
    }

}
