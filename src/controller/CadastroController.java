package controller;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.*;

public class CadastroController {

    private TelaCadastro view;
    private Janela frame;

    public CadastroController(TelaCadastro view, Janela frame) {
        this.view = view;
        this.frame = frame;
        initEventos();
    }

    private void initEventos() {

        view.telacadastrar(e -> {

            String nome = view.getTfNome();
            String cpf = view.getTfCpf();

            if (nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Preencha todos os campos!");
                return;
            }

            if (!view.getRbSim().isSelected() && !view.getRbNao().isSelected()) {
                JOptionPane.showMessageDialog(view, "Selecione se é administrador!");
                return;
            }

            boolean admin = view.getRbSim().isSelected();

            try {
                Usuario user = new Usuario(nome, cpf, admin);
                UsuarioDAO.salvar(user);

                JOptionPane.showMessageDialog(view, "Cadastro realizado com sucesso!");

                TelaLogin telaLogin = new TelaLogin();
                new LoginController(telaLogin, frame);
                Navegador.trocarTela(telaLogin);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar usuário!");
                ex.printStackTrace();
            }
        });
        
        
        view.voltar(e -> {
            TelaLogin tela = new TelaLogin();
            new LoginController(tela, frame);
            Navegador.trocarTela(tela);
        });
    }
}