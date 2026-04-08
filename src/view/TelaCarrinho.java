package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
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

	/**
	 * Create the panel.
	 */
	public TelaCarrinho() {
		setBackground(new Color(244, 247, 246));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow 20][::20px,grow 20][::20px,grow 20][::20px,grow 20][::20px,grow 20][][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Carrinho de compras");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		add(lblNewLabel, "cell 1 1");
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
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
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(lblNewLabel_1, "cell 2 4,alignx trailing");
		
		total = new JLabel("");
		add(total, "cell 3 4");
		
		btRemover = new JButton("Remover do carrinho");
		btRemover.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btRemover, "cell 3 5,growx");
		
		btNota = new JButton("Emitir nota fiscal e pagar");
		btNota.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btNota, "cell 3 6,growx");
		
		btPagar = new JButton("Pagar");
		btPagar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btPagar, "cell 3 7,growx");
		
		btVoltar = new JButton("Voltar");
		add(btVoltar, "cell 3 8,growx");
	}
	
	public JScrollPane getscrollPane() {return scrollPane; }
	public JTable gettable() { return table; }
	public JButton getbtRemover() { return btRemover; }
	public JButton getbtNota() { return btNota; }
	public JButton getbtPagar() { return btPagar; }
	public JButton getbtVoltar() { return btVoltar; }
	public JLabel gettotal() { return total; }
		
	}
	
	