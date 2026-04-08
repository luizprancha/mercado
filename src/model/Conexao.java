package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/mercado";
    private static final String USER = "root";
    private static final String PASSWORD = "admin"; // coloque sua senha

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}