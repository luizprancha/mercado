package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
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
		setBackground(new Color(244, 247, 246));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][::20px,grow 20][::20px,grow 20][::20px,grow 20][][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Hora de comprar!!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		add(lblNewLabel, "cell 1 1");
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
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
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(lblNewLabel_1, "cell 2 3,alignx trailing");
		
		tfQuantidade = new JTextField();
		add(tfQuantidade, "cell 3 3,growx");
		tfQuantidade.setColumns(10);
		
		btAdicionar = new JButton("Adicionar ao carrinho");
		btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btAdicionar, "cell 3 4,growx");
		
		btCarrinho = new JButton("Ver carrinho");
		btCarrinho.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btCarrinho, "cell 3 5,growx");
		
		btVoltar = new JButton("Voltar");
		add(btVoltar, "cell 3 6,growx");
	}
	
	public JTable gettable() { return table; }
	public JScrollPane getscrollPane() { return scrollPane; }
	public JButton getbtAdicionar() {return btAdicionar; }
	public JButton getbtCarrinho() { return btCarrinho; }
	public JTextField gettfQuantidade() {return tfQuantidade; }
	public JButton getbtVoltar() { return btVoltar; }

}