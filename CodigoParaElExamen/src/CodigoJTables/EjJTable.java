package CodigoJTables;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;

public class EjJTable extends JFrame{

	private JPanel pnlTabla;
	private JTable tabla;
	
	public EjJTable() {
		
		//Ajustes de la ventana
		
		setSize(750,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		// Crear los componentes
		
		pnlTabla = new JPanel();
		pnlTabla.setBackground(Color.WHITE);
		pnlTabla.setPreferredSize(new Dimension(650, 600));
		
		// Crear JTable
		
		tabla = new JTable();
		final DefaultTableModel modeloT = new DefaultTableModel();
		modeloT.addColumn("Caracter");
		modeloT.addColumn("Contador");
		tabla.setModel(modeloT);
		tabla.getTableHeader().setReorderingAllowed(false);
		
		tabla.addKeyListener( new KeyListener() {
			
			@Override
			 public void keyTyped(KeyEvent e) {
	            char typedChar = e.getKeyChar();
	            
	            for (int i = 0; i < modeloT.getRowCount(); i++) {
	                if (modeloT.getValueAt(i, 0).equals(String.valueOf(typedChar))) {
	                    // Si el carácter ya está, incrementamos el contador
	                    int currentCount = (int) modeloT.getValueAt(i, 1);
	                    modeloT.setValueAt(currentCount + 1, i, 1);
	                    return;
	                }
	            }
	            Object[] newRow = {String.valueOf(typedChar), 1};
	            modeloT.addRow(newRow);
	        }
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		pnlTabla.add(new JScrollPane(tabla));
		
		add(pnlTabla);
		
		
	}
	
	public static void main(String[] args) {
		
		EjJTable vent = new EjJTable();
		vent.setVisible(true);
		
	}
	
}
