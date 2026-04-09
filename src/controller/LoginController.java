package controller;

import javax.swing.JOptionPane;

import model.Sessao;
import model.Usuario;
import model.UsuarioDAO;
import view.*;

public class LoginController {

    private TelaLogin view;
    private Janela frame;

    public LoginController(TelaLogin view, Janela frame) {
        this.view = view;
        this.frame = frame;

        initEventos();
    }

    private void initEventos() {

        view.entrar(e ->{

            String nome = view.getNome();
            String cpf = view.getCpf();

            Usuario usuario = UsuarioDAO.buscar(nome, cpf);

            if (usuario == null) {
                JOptionPane.showMessageDialog(view, "Usuário não encontrado!");
                return;
            }

            Sessao.setUsuario(usuario);

            JOptionPane.showMessageDialog(view, "Bem-vindo " + nome);

            if (usuario.isAdmin()) {

                TelaCadastroProdutos tela = new TelaCadastroProdutos();
                new CadastroProdutoController(tela, frame);
                Navegador.trocarTela(tela);

            } else {

                TelaProdutos tela = new TelaProdutos();
                new ProdutosController(tela, frame);
                Navegador.trocarTela(tela);
            }
        }); 

        view.cadastrar(e -> {

            TelaCadastro tela = new TelaCadastro();
            new CadastroController(tela, frame);
            Navegador.trocarTela(tela);
        });
    }
}