package CodigoJTables;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
public class RendererTabla extends JFrame{

	private JTable tabla;
	private JPanel pnlTabla;
	private final String[] cabeceras = {"Col1", "Col2", "Col3"};
	private final String[] row = {"A", "2", "324"};
	@SuppressWarnings("serial")
	public RendererTabla() {
		
		//Ajustes de la ventana
		
		setSize(750, 650);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// Crear componentes
		
		pnlTabla = new JPanel();
		pnlTabla.setBackground(Color.BLUE);
		pnlTabla.setPreferredSize(new Dimension(200,650));
		
		//Crear la tabla
		
		tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		for (String str: cabeceras) {
			modelo.addColumn(str);
		}
		tabla.setModel(modelo);
		pnlTabla.add(new JScrollPane(tabla));
		
		add(pnlTabla);
		tabla.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < 4; i++) {
			modelo.addRow(row);
		} 
		
		//Crear renderer
		
		tabla.setDefaultRenderer( String.class , new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				JLabel lbl = (JLabel) comp;
				if ( column == 0) {
					comp.setBackground(Color.red);
				}else {
					comp.setBackground(Color.green);
				}
				if(isSelected) {
					comp.setBackground(Color.RED);
					if(hasFocus) {
						lbl.setBorder (BorderFactory.createLineBorder(Color.CYAN, 3));
					}
				}
			
				return comp;
			}
			
			
			
			
		});
		tabla.repaint();
		
		tabla.setDefaultEditor(String.class, new TableCellEditor() {

			@Override
			public Object getCellEditorValue() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isCellEditable(EventObject anEvent) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean shouldSelectCell(EventObject anEvent) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean stopCellEditing() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void cancelCellEditing() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void addCellEditorListener(CellEditorListener l) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeCellEditorListener(CellEditorListener l) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		 
	}
	
	
	
	public static void main(String[] args) {
		RendererTabla vent = new RendererTabla();
		vent.setVisible(true);
	}
	
}
