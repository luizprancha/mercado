package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaLogin extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField tfNome;
    private JTextField tfCpf;
    private JButton btEntrar;
    private JButton btCadastrar;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    public TelaLogin() {
        setBackground(new Color(245, 235, 220));
        setToolTipText("Tela Login");

        setLayout(new MigLayout("", "[grow][grow][][grow][grow]", "[][grow][grow][grow][grow][grow][grow][grow][grow]"));
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/256.png")));
        add(lblNewLabel_1, "cell 1 1 3 1,alignx center");
        
        lblNewLabel = new JLabel("Por favor, acesse sua conta ou crie uma nova.");
        lblNewLabel.setFont(new Font("Alef", Font.PLAIN, 14));
        add(lblNewLabel, "cell 1 2 3 1,alignx center");

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Alef", Font.BOLD, 20));
        add(lblNome, "cell 1 4,alignx right");

        tfNome = new JTextField();
        tfNome.setFont(new Font("Alef", Font.PLAIN, 14));
        add(tfNome, "cell 3 4,growx");
        tfNome.setColumns(10);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setFont(new Font("Alef", Font.BOLD, 20));
        add(lblCpf, "cell 1 5,alignx right");

        tfCpf = new JTextField();
        tfCpf.setFont(new Font("Alef", Font.PLAIN, 14));
        add(tfCpf, "cell 3 5,growx");
        tfCpf.setColumns(10);

        btEntrar = new JButton("Entrar");
        btEntrar.setForeground(new Color(255, 255, 255));
        btEntrar.setFont(new Font("Alef", Font.BOLD, 20));
        btEntrar.setBackground(new Color(8, 69, 145));
        btEntrar.setBorderPainted(false);
        add(btEntrar, "cell 1 7,alignx center");

        btCadastrar = new JButton("Cadastrar");
        btCadastrar.setForeground(new Color(255, 255, 255));
        btCadastrar.setFont(new Font("Alef", Font.BOLD, 20));
        btCadastrar.setBackground(new Color(8, 69, 145));
        btCadastrar.setBorderPainted(false);
        add(btCadastrar, "cell 3 7,alignx center");
    }

    public JTextField getTfNome() { return tfNome; }
    public JTextField getTfCpf() { return tfCpf; }
    
    public void entrar (ActionListener acao) {
    	btEntrar.addActionListener(acao);
	}
    
    public void cadastrar (ActionListener acao) {
    	btCadastrar.addActionListener(acao);
	}
}