package view;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.*;

public class TelaCadastro extends JPanel {

    private JTextField tfNome;
    private JTextField tfCpf;
    private JButton btnCadastrar;
    private JRadioButton rbSim;
    private JRadioButton rbNao;
    private JButton btnVoltar;

    public TelaCadastro() {

        setBackground(new Color(245, 235, 220));
        setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][grow][grow]"));

        JLabel label_1 = new JLabel("Cadastre - se j\u00E1");
        label_1.setFont(new Font("Alef", Font.BOLD, 30));
        add(label_1, "cell 0 0 4 1,alignx center");
        
                JLabel label = new JLabel("Nome:");
                label.setFont(new Font("Alef", Font.BOLD, 20));
                add(label, "cell 1 1");
        tfNome = new JTextField();
        add(tfNome, "cell 2 1,growx");
        
                JLabel label_3 = new JLabel("CPF:");
                label_3.setFont(new Font("Alef", Font.BOLD, 20));
                add(label_3, "cell 1 2");
        tfCpf = new JTextField();
        add(tfCpf, "cell 2 2,growx");

        rbSim = new JRadioButton("Sim");
        rbNao = new JRadioButton("Não");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbSim);
        grupo.add(rbNao);
        
                JLabel label_2 = new JLabel("Admin?");
                label_2.setFont(new Font("Alef", Font.BOLD, 20));
                add(label_2, "cell 1 3");

        add(rbSim, "cell 2 3");
        add(rbNao, "cell 3 3");
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setFont(new Font("Alef", Font.BOLD, 20));
        btnVoltar.setBackground(new Color(8, 69, 145));
        btnVoltar.setBorderPainted(false);
        add(btnVoltar, "cell 1 4,alignx center");

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setForeground(new Color(255, 255, 255));
        btnCadastrar.setFont(new Font("Alef", Font.BOLD, 20));
        btnCadastrar.setBackground(new Color(8, 69, 145));
        btnCadastrar.setBorderPainted(false);
        add(btnCadastrar, "cell 2 4,alignx center");
    }

    public JTextField getTfNome() { return tfNome; }
    public JTextField getTfCpf() { return tfCpf; }
    public JButton getbtnCadastrar() { return btnCadastrar; }
    public JRadioButton getRbSim() { return rbSim; }
    public JRadioButton getRbNao() { return rbNao; }
    public JButton getbtnVoltar() { return btnVoltar; }
}