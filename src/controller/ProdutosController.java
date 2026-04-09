package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

import java.util.List;

public class ProdutosController {

    private TelaProdutos view;
    private Janela frame;

    public ProdutosController(TelaProdutos view, Janela frame) {
        this.view = view;
        this.frame = frame;
        carregarTabela();
        initEventos();
    }

    private void initEventos() {

        view.btAdicionarAction(e -> {

            int linha = view.gettable().getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(view, "Selecione um produto!");
                return;
            }

            try {
                int id = (int) view.gettable().getValueAt(linha, 0);
                String nome = view.gettable().getValueAt(linha, 1).toString();
                double preco = Double.parseDouble(view.gettable().getValueAt(linha, 2).toString());
                int estoqueAtual = Integer.parseInt(view.gettable().getValueAt(linha, 3).toString());

                int quantidade = Integer.parseInt(view.gettfQuantidade().getText());

                if (quantidade > estoqueAtual) {
                    JOptionPane.showMessageDialog(view, "Estoque insuficiente!");
                    return;
                }

                Produto p = new Produto(id, nome, preco, quantidade);
                Carrinho.adicionar(p);

                int novoEstoque = estoqueAtual - quantidade;
                ProdutoDAO.atualizarEstoque(id, novoEstoque);

                JOptionPane.showMessageDialog(view, "Adicionado ao carrinho!");

                carregarTabela();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erro ao adicionar!");
            }
        });

        view.btCarrinhoAction(e -> {
            TelaCarrinho tela = new TelaCarrinho();
            new CarrinhoController(tela, frame);
            Navegador.trocarTela(tela);
        });

        view.btVoltarAction(e -> {
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
}