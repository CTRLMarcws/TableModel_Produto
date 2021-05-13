package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ProdutoTableModel extends AbstractTableModel
{
	private List<Produto> dados = new ArrayList<>();
	private String[] colunas = {"Descrição", "Quantidade", "Valor"};
	
	@Override
	public String getColumnName(int column)
	{
		return colunas[column];
	}
	
	@Override
	public int getRowCount()
	{
		return dados.size();
	}

	@Override
	public int getColumnCount()
	{
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch(columnIndex)
		{
			case 0:
				return dados.get(rowIndex).getDescricao();
				
			case 1:
				return dados.get(rowIndex).getQtd();
				
			case 2:
				return dados.get(rowIndex).getValor();
			
		}
		return null;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		switch(columnIndex)
		{
			case 0:
				dados.get(rowIndex).setDescricao((String) aValue);
				break;
				
			case 1:
				dados.get(rowIndex).setQtd(Integer.parseInt((String) aValue));
				break;
				
			case 2:
				dados.get(rowIndex).setValor(Double.parseDouble((String) aValue));
				break;
		}
		this.fireTableRowsUpdated(rowIndex, rowIndex);
	}
	
	public void addRow(Produto p)
	{
		this.dados.add(p);
//		ActionListener para atualizar a tabela assim que os dados forem alterados
		this.fireTableDataChanged();
	}
	
	public void removeRow(int rowIndex)
	{
		this.dados.remove(rowIndex);
//		ActionListener para remover linhas da tabela, sendo os dois parametros: linha de inicio e fim.
		this.fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
