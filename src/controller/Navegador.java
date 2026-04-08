package controller;

import javax.swing.JPanel;

import view.Jframe;

public class Navegador {

    private static Jframe frame;

    public static void setFrame(Jframe framePrincipal) {
        frame = framePrincipal;
    }

    public static void trocarTela(JPanel novaTela) {
        frame.setContentPane(novaTela);
        frame.revalidate();
        frame.repaint();
    }
}