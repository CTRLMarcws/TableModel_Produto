package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Produto;
import model.ProdutoTableModel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProduto extends JFrame
{

	ProdutoTableModel tableModel = new ProdutoTableModel();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtProdutos;
	private JTextField tfDesc;
	private JTextField tfQtd;
	private JTextField tfValor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduto frame = new ViewProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ViewProduto()
	{
		inicializacaoComponentes();
		
		jtProdutos.setModel(tableModel);
		
	}


	private void inicializacaoComponentes()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 414, 156);
		contentPane.add(scrollPane);
		
		jtProdutos = new JTable();
		scrollPane.setViewportView(jtProdutos);
		
		tfDesc = new JTextField();
		tfDesc.setBounds(10, 29, 222, 20);
		contentPane.add(tfDesc);
		tfDesc.setColumns(10);
		
		tfQtd = new JTextField();
		tfQtd.setColumns(10);
		tfQtd.setBounds(242, 29, 86, 20);
		contentPane.add(tfQtd);
		
		tfValor = new JTextField();
		tfValor.setBounds(338, 29, 86, 20);
		contentPane.add(tfValor);
		tfValor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = new Produto();
				p.setDescricao(tfDesc.getText());
				p.setQtd(Integer.parseInt(tfQtd.getText()));
				p.setValor(Double.parseDouble(tfValor.getText()));
				
				tableModel.addRow(p);
			}
		});
		btnSalvar.setBounds(10, 56, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtProdutos.getSelectedRow() != -1)
				{
					tableModel.removeRow(jtProdutos.getSelectedRow());
				}
				else
				{
					System.out.println("Nenhum dado selecionado.");
				}
			}
		});
		btnExcluir.setBounds(170, 56, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtProdutos.getSelectedRow() != -1)
				{
					tableModel.setValueAt(tfDesc.getText(), jtProdutos.getSelectedRow(), 0);
					tableModel.setValueAt(tfQtd.getText(), jtProdutos.getSelectedRow(), 1);
					tableModel.setValueAt(tfValor.getText(), jtProdutos.getSelectedRow(), 2);
				}
			}
		});
		btnAlterar.setBounds(335, 56, 89, 23);
		contentPane.add(btnAlterar);
		
		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o");
		lblDesc.setBounds(10, 11, 78, 14);
		contentPane.add(lblDesc);
		
		JLabel lblQnt = new JLabel("Quantidade");
		lblQnt.setBounds(242, 11, 86, 14);
		contentPane.add(lblQnt);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(338, 11, 74, 14);
		contentPane.add(lblValor);	
	}
}
