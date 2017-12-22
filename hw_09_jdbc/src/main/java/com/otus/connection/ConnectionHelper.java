package com.otus.connection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * {@code ConnectionHelper} class.
 */
public class ConnectionHelper
{
    /**
     * Initializes the data source.
     */
    public static Connection getConnection()
    {
        String dbProps = "hw_09_jdbc/src/main/resources/db.properties";

        try {
            Properties props = new Properties();
            try (InputStream in = Files.newInputStream(Paths.get(dbProps))) {
                props.load(in);
            }

            final String url = props.getProperty("db.url");

            String username = props.getProperty("db.user");
            if (username == null) username = "";

            String password = props.getProperty("db.pass");
            if (password == null) password = "";

            return DriverManager.getConnection(url, username, password);
        }
        catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
