package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class TelaCadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfProduto;
	private JTextField tfPreco;
	private JTextField tfQuantidade;
	private JButton btAdicionar;
	private JButton btRemover;
	private JButton btEditar;
	private JScrollPane scrollPane;
	private JButton btVoltar;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProdutos() {
		setBackground(new Color(244, 247, 246));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][::20px,grow 20][::20px,grow 20][::20px,grow 20][::20px,grow 20][::20px,grow][::20px,grow 20][][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastre os produtos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblNewLabel, "cell 1 1 5 1,alignx center");
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Produto", "Valor", "Quantidade"
			}
		));
		scrollPane = new JScrollPane(table);
		add(scrollPane, "cell 5 3 1 8,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(lblNewLabel_1, "cell 1 4,growx");
		
		tfProduto = new JTextField();
		add(tfProduto, "cell 2 4,growx");
		tfProduto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Preço kg/uni:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(lblNewLabel_2, "cell 1 5,growx");
		
		tfPreco = new JTextField();
		add(tfPreco, "cell 2 5,growx");
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(lblNewLabel_3, "cell 1 6,growx");
		
		tfQuantidade = new JTextField();
		add(tfQuantidade, "cell 2 6,growx");
		tfQuantidade.setColumns(10);
		
		btAdicionar = new JButton("Adicionar");
		btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btAdicionar, "cell 1 8,growx");
		
		btRemover = new JButton("Remover");
		btRemover.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btRemover, "cell 2 8,growx");
		
		btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(btEditar, "cell 3 8,growx");
		
		btVoltar = new JButton("Voltar");
		add(btVoltar, "cell 2 9");

	}
	public JTextField getTfProduto() { return tfProduto; }
    public JTextField getTfPreco() { return tfPreco; }
    public JTextField getTfQuantidade() { return tfQuantidade; }
    public JButton getbtAdicionar() { return btAdicionar; }
    public JButton getbtRemover() { return btRemover; }
    public JButton getbtEditar() { return btEditar; }
    public JTable gettable() {return table; }
    public JScrollPane getscrollPane() {return scrollPane; }
    public JButton getbtVoltar() { return btVoltar; }

}