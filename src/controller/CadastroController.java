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

        view.cadastrar(e -> {

            String nome = view.getTfNome().getText().trim();
            String cpf = view.getTfCpf().getText().trim();

            if (nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Preencha todos os campos!");
                return;
            }

            for (char c : nome.toCharArray()) {

                if (Character.isDigit(c)) {
                    JOptionPane.showMessageDialog(view, "O nome não pode conter números!");
                    return;
                }
            }

            try {

                Long.parseLong(cpf);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(view, "O CPF deve conter apenas números!");
                return;
            }

            if (cpf.length() != 11) {
                JOptionPane.showMessageDialog(view, "O CPF deve ter 11 dígitos!");
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