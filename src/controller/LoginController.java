package controller;

import javax.swing.JOptionPane;

import model.Sessao;
import model.Usuario;
import model.UsuarioDAO;
import view.*;

public class LoginController {

    private TelaLogin view;
    private Jframe frame;

    public LoginController(TelaLogin view, Jframe frame) {
        this.view = view;
        this.frame = frame;

        initEventos();
    }

    private void initEventos() {

        // �? BOTÃO ENTRAR
        view.getBtEntrar().addActionListener(e -> {

            String nome = view.getTfNome().getText();
            String cpf = view.getTfCpf().getText();

            Usuario usuario = UsuarioDAO.buscar(nome, cpf);

            if (usuario == null) {
                JOptionPane.showMessageDialog(view, "Usuário não encontrado!");
                return;
            }

            // 🔥 SALVA USU�?RIO LOGADO
            Sessao.setUsuario(usuario);

            JOptionPane.showMessageDialog(view, "Bem-vindo " + nome);

            // 🔀 REDIRECIONAMENTO
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

        // �? BOTÃO CADASTRAR
        view.getBtCadastrar().addActionListener(e -> {

            TelaCadastro tela = new TelaCadastro();
            new CadastroController(tela, frame);
            Navegador.trocarTela(tela);
        });
    }
}