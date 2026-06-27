package model;

import java.sql.*;

public class UsuarioDAO {

    public static boolean salvar(Usuario user) {

        if (cpfExiste(user.getCpf())) {
            return false;
        }

        String sql = "INSERT INTO usuarios (nome, cpf, cargo) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCpf());
            stmt.setBoolean(3, user.isAdmin());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean cpfExiste(String cpf) {

        String sql = "SELECT COUNT(*) FROM usuarios WHERE cpf = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Usuario buscarusuario(String nome, String cpf) {

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