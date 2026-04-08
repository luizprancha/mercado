package model;

public class Sessao {

    private static Usuario usuarioLogado;

    public static void setUsuario(Usuario user) {
        usuarioLogado = user;
    }

    public static Usuario getUsuario() {
        return usuarioLogado;
    }
}