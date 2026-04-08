package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

public class CarrinhoController {

    private TelaCarrinho view;
    private Jframe frame;

    public CarrinhoController(TelaCarrinho view, Jframe frame) {
        this.view = view;
        this.frame = frame;

        carregarCarrinho();
        initEventos();
    }

    private void initEventos() {

        // �?� REMOVER ITEM
        view.getbtRemover().addActionListener(e -> {

            int linha = view.gettable().getSelectedRow();

            if (linha != -1) {
                Carrinho.remover(linha);
                carregarCarrinho();
            }
        });

        // 💰 PAGAR
        view.getbtPagar().addActionListener(e -> {

            if (Carrinho.itens.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Carrinho vazio!");
                return;
            }

            JOptionPane.showMessageDialog(view, "Pagamento realizado!");

            Carrinho.limpar();
            carregarCarrinho();
        });

        // 🧾 NOTA FISCAL
        view.getbtNota().addActionListener(e -> {

            if (Carrinho.itens.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Carrinho vazio!");
                return;
            }

            Usuario user = Sessao.getUsuario();

            StringBuilder nota = new StringBuilder();

            nota.append("===== NOTA FISCAL =====\n\n");
            nota.append("Cliente: ").append(user.getNome()).append("\n");
            nota.append("CPF: ").append(user.getCpf()).append("\n\n");

            double total = 0;

            nota.append("Produtos:\n");

            for (Produto p : Carrinho.itens) {

                double subtotal = p.getPreco() * p.getQuantidade();

                nota.append("- ")
                    .append(p.getNome())
                    .append(" | Qtd: ").append(p.getQuantidade())
                    .append(" | R$ ").append(subtotal)
                    .append("\n");

                total += subtotal;
            }

            nota.append("\nTOTAL: R$ ").append(total);

            JOptionPane.showMessageDialog(view, nota.toString());
        });

        // 🔙 VOLTAR
        view.getbtVoltar().addActionListener(e -> {
            TelaProdutos tela = new TelaProdutos();
            new ProdutosController(tela, frame);
            Navegador.trocarTela(tela);
        });
    }

    private void carregarCarrinho() {

        DefaultTableModel model = (DefaultTableModel) view.gettable().getModel();
        model.setRowCount(0);

        double total = 0;

        for (Produto p : Carrinho.itens) {

            model.addRow(new Object[]{
                    p.getNome(),
                    p.getPreco(),
                    p.getQuantidade()
            });

            total += p.getPreco() * p.getQuantidade();
        }

        // 💰 MOSTRAR TOTAL
        view.gettotal().setText("R$ " + total);
    }
}