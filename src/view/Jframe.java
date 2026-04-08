package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Jframe extends JFrame {

    private JPanel contentPane;

    public Jframe() {
        setTitle("Sistema de Vendas MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        setLocationRelativeTo(null); // centraliza na tela
    }
}