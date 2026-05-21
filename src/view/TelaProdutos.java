package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class TelaProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfQuantidade;
	private JScrollPane scrollPane;
	private JButton btAdicionar;
	private JButton btCarrinho;
	private JButton btVoltar;

	/**
	 * Create the panel.
	 */
	public TelaProdutos() {
		setBackground(new Color(245, 235, 220));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][::20px,grow 20][::20px,grow 20][::20px,grow 20][][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Hora de comprar!!!");
		lblNewLabel.setFont(new Font("Alef", Font.BOLD, 35));
		add(lblNewLabel, "cell 1 1");
		
		table = new JTable();
		table.setFont(new Font("Alef", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Produtos", "Valor", "Quantidade"
			}
		));
		scrollPane = new JScrollPane(table);
		add(scrollPane, "cell 1 3 1 5,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setFont(new Font("Alef", Font.PLAIN, 12));
		add(lblNewLabel_1, "cell 2 3,alignx trailing");
		
		tfQuantidade = new JTextField();
		add(tfQuantidade, "cell 3 3,growx");
		tfQuantidade.setColumns(10);
		
		btAdicionar = new JButton("Adicionar ao carrinho");
		btAdicionar.setForeground(new Color(255, 255, 255));
		btAdicionar.setFont(new Font("Alef", Font.BOLD, 20));
		btAdicionar.setBackground(new Color(8, 69, 145));
		btAdicionar.setBorderPainted(false);
		add(btAdicionar, "cell 3 4,growx");
		
		btCarrinho = new JButton("Ver carrinho");
		btCarrinho.setForeground(new Color(255, 255, 255));
		btCarrinho.setFont(new Font("Alef", Font.BOLD, 20));
		btCarrinho.setBackground(new Color(8, 69, 145));
		btCarrinho.setBorderPainted(false);
		add(btCarrinho, "cell 3 5,growx");
		
		btVoltar = new JButton("Voltar");
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setFont(new Font("Alef", Font.BOLD, 20));
		btVoltar.setBackground(new Color(8, 69, 145));
        btVoltar.setBorderPainted(false);
		add(btVoltar, "cell 3 6,growx");
	}
	
	public JTable gettable() { return table; }
	public JScrollPane getscrollPane() { return scrollPane; } 
	public JTextField gettfQuantidade() {return tfQuantidade; } 
	
	public void voltar (ActionListener acao) {
		btVoltar.addActionListener(acao);
	}
	
	public void carrinho (ActionListener acao) {
		btCarrinho.addActionListener(acao);
	}
	
	public void adicionar (ActionListener acao) {
		btAdicionar.addActionListener(acao);
	}

}