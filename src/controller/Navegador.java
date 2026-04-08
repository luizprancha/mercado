package controller;

import javax.swing.JPanel;

import view.Janela;

public class Navegador {

    private static Janela frame;

    public static void setFrame(Janela framePrincipal) {
        frame = framePrincipal;
    }

    public static void trocarTela(JPanel novaTela) {
        frame.setContentPane(novaTela);
        frame.revalidate();
        frame.repaint();
    }
}