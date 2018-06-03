package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {

        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/BancoSD", "postgres", "masterkey");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
