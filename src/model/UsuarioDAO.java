package model;

import java.sql.*;

public class UsuarioDAO {

    public static void salvar(Usuario user) {

        String sql = "INSERT INTO usuarios (nome, cpf, cargo) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCpf());
            stmt.setBoolean(3, user.isAdmin());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Usuario buscar(String nome, String cpf) {

        String sql = "SELECT * FROM usuarios WHERE nome = ? AND cpf = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getBoolean("cargo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}