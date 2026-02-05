package KauaFelix.infrastructure.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSOWRD = "kauafelix123@";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSOWRD);
    }
}
