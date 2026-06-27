package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;

public class TelaCarrinho extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btRemover;
	private JButton btNota;
	private JButton btPagar;
	private JButton btVoltar;
	private JLabel total;

	public TelaCarrinho() {
		setBackground(new Color(245, 235, 220));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow 20][::20px,grow 20][::20px,grow 20][::20px,grow 20][::20px,grow 20][][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Carrinho de compras:");
		lblNewLabel.setFont(new Font("Alef", Font.BOLD, 25));
		add(lblNewLabel, "cell 1 1");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Produto", "Preço", "Quantidade"
			}
		));
		scrollPane = new JScrollPane(table);
		add(scrollPane, "cell 1 3 1 7,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Total a pagar:");
		lblNewLabel_1.setFont(new Font("Alef", Font.PLAIN, 12));
		add(lblNewLabel_1, "cell 2 4,alignx trailing");
		
		total = new JLabel("");
		add(total, "cell 3 4");
		
		btRemover = new JButton("Remover do carrinho");
		btRemover.setForeground(new Color(255, 255, 255));
		btRemover.setFont(new Font("Alef", Font.BOLD, 10));
		btRemover.setBackground(new Color(8, 69, 145));
		btRemover.setBorderPainted(false);
		add(btRemover, "cell 3 5,growx");
		
		btNota = new JButton("Emitir nota fiscal");
		btNota.setForeground(new Color(255, 255, 255));
		btNota.setFont(new Font("Alef", Font.BOLD, 10));
		btNota.setBackground(new Color(8, 69, 145));
		btNota.setBorderPainted(false);
		add(btNota, "cell 3 6,growx");
		
		btPagar = new JButton("Pagar");
		btPagar.setForeground(new Color(255, 255, 255));
		btPagar.setFont(new Font("Alef", Font.BOLD, 10));
		btPagar.setBackground(new Color(8, 69, 145));
		btPagar.setBorderPainted(false);
		add(btPagar, "cell 3 7,growx");
		
		btVoltar = new JButton("Voltar");
		btVoltar.setForeground(new Color(255, 255, 255));
		btVoltar.setFont(new Font("Alef", Font.BOLD, 10));
		btVoltar.setBackground(new Color(8, 69, 145));
        btVoltar.setBorderPainted(false);
		add(btVoltar, "cell 3 8,growx");
	}
	
	public JScrollPane getscrollPane() {return scrollPane; }
	public JTable gettable() { return table; }  
	public JLabel gettotal() { return total; }
	
	public void remover (ActionListener acao) {
		btRemover.addActionListener(acao);
	}
	
	public void nota (ActionListener acao) {
		btNota.addActionListener(acao);
	}
	
	public void pagar (ActionListener acao) {
		btPagar.addActionListener(acao);
	}
	
	public void voltar (ActionListener acao) {
		btVoltar.addActionListener(acao);
	}
		
	}
	
	