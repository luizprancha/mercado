package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

import java.util.List;

public class CadastroProdutoController {

    private TelaCadastroProdutos view;
    private Jframe frame;

    public CadastroProdutoController(TelaCadastroProdutos view, Jframe frame) {
        this.view = view;
        this.frame = frame;

        carregarTabela();
        initEventos();
    }

    private void initEventos() {

        // ➕ ADICIONAR
        view.getbtAdicionar().addActionListener(e -> {

            try {
                String nome = view.getTfProduto().getText();
                double preco = Double.parseDouble(view.getTfPreco().getText());
                int quantidade = Integer.parseInt(view.getTfQuantidade().getText());

                ProdutoDAO.salvar(new Produto(nome, preco, quantidade));

                JOptionPane.showMessageDialog(view, "Produto cadastrado!");

                limparCampos();
                carregarTabela();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erro!");
            }
        });

        // 🔴 SELECIONAR NA TABELA → PREENCHER CAMPOS
        view.gettable().getSelectionModel().addListSelectionListener(e -> {

            int linha = view.gettable().getSelectedRow();

            if (linha != -1) {

                String nome = view.gettable().getValueAt(linha, 1).toString();
                String preco = view.gettable().getValueAt(linha, 2).toString();
                String quantidade = view.gettable().getValueAt(linha, 3).toString();

                view.getTfProduto().setText(nome);
                view.getTfPreco().setText(preco);
                view.getTfQuantidade().setText(quantidade);
            }
        });

        // 🟡 EDITAR
        view.getbtEditar().addActionListener(e -> {

            int linha = view.gettable().getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(view, "Selecione um produto!");
                return;
            }

            try {
                int id = (int) view.gettable().getValueAt(linha, 0);

                String nome = view.getTfProduto().getText();
                double preco = Double.parseDouble(view.getTfPreco().getText());
                int quantidade = Integer.parseInt(view.getTfQuantidade().getText());

                Produto atualizado = new Produto(id, nome, preco, quantidade);

                ProdutoDAO.atualizar(atualizado);

                JOptionPane.showMessageDialog(view, "Produto atualizado!");

                carregarTabela();
                limparCampos();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erro ao editar!");
            }
        });

        // �?� REMOVER
        view.getbtRemover().addActionListener(e -> {

            int linha = view.gettable().getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(view, "Selecione um produto!");
                return;
            }

            int id = (int) view.gettable().getValueAt(linha, 0);

            ProdutoDAO.remover(id);

            JOptionPane.showMessageDialog(view, "Produto removido!");

            carregarTabela();
            limparCampos();
        });

        // 🔙 VOLTAR
        view.getbtVoltar().addActionListener(e -> {
            TelaLogin tela = new TelaLogin();
            new LoginController(tela, frame);
            Navegador.trocarTela(tela);
        });
    }

    private void carregarTabela() {

        DefaultTableModel model = (DefaultTableModel) view.gettable().getModel();
        model.setRowCount(0);

        List<Produto> lista = ProdutoDAO.listar();

        for (Produto p : lista) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getQuantidade()
            });
        }
    }

    private void limparCampos() {
        view.getTfProduto().setText("");
        view.getTfPreco().setText("");
        view.getTfQuantidade().setText("");
    }
}