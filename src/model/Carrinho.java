package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    public static List<Produto> itens = new ArrayList<>();

    public static void adicionar(Produto novo) {

        for (Produto p : itens) {

            if (p.getId() == novo.getId()) {

                int novaQuantidade = p.getQuantidade() + novo.getQuantidade();

                itens.set(itens.indexOf(p),
                        new Produto(p.getId(), p.getNome(), p.getPreco(), novaQuantidade));

                return;
            }
        }

        itens.add(novo);
    }

    public static void remover(int index) {
        if (index >= 0 && index < itens.size()) {
            itens.remove(index);
        }
    }

    public static void limpar() {
        itens.clear();
    }
}