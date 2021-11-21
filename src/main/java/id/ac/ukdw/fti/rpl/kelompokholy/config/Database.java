package id.ac.ukdw.fti.rpl.kelompokholy.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private final String url = "jdbc:sqlite:vizbible.db";

    public Connection connection;

    public Database() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
