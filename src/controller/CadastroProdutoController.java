package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import view.*;

public class CadastroProdutoController {

    private TelaCadastroProdutos view;
    private Janela frame;

    public CadastroProdutoController(TelaCadastroProdutos view, Janela frame) {
        this.view = view;
        this.frame = frame;

        carregarTabela();
        initEventos();
    }

    private void initEventos() {
    	
    	

        // ➕ ADICIONAR
        view.adicionar(e -> {

        	try {

                String nome = view.getTfProduto().getText().trim();
                double preco = Double.parseDouble(view.getTfPreco().getText());
                int quantidade = Integer.parseInt(view.getTfQuantidade().getText());

                // VERIFICA SE JÁ EXISTE PRODUTO COM ESSE NOME
                for (Produto p : ProdutoDAO.listar()) {

                    if (p.getNome().equalsIgnoreCase(nome)) {

                        JOptionPane.showMessageDialog(view, "Já existe um produto com esse nome!");
                        return;
                    }
                }

                Produto produto = new Produto(nome, preco, quantidade);

                ProdutoDAO.salvar(produto);

                JOptionPane.showMessageDialog(view, "Produto cadastrado!");

                carregarTabela();
                limparCampos();

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(view, "Preço e quantidade devem ser números!");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(view, "Erro ao cadastrar produto!");
                ex.printStackTrace();
            }
        });

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

        view.editar(e -> {

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

        view.remover(e -> {

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

        view.voltar(e -> {
            TelaLogin tela = new TelaLogin();
            new LoginController(tela, frame);
            Navegador.trocarTela(tela);
        });
    }

    private void carregarTabela() {

        DefaultTableModel modelo =
                (DefaultTableModel) view.gettable().getModel();

        modelo.setRowCount(0);

        for (Produto p : ProdutoDAO.listar()) {

            modelo.addRow(new Object[] {
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