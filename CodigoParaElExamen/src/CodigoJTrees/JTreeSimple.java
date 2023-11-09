package CodigoJTrees;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.*;

public class JTreeSimple extends JFrame {
	
	private JPanel pnlIzquierda;
	private JPanel pnlCentro;
	private JTree tree;
	private final String[] strings = {"Nodo1", "Nodo2", "Nodo3"};
	
	
	
	
	public JTreeSimple() {
		
		//Ajustes de la ventana
		
		setSize(750, 650);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Crear los paneles
		
		pnlIzquierda = new JPanel();
		pnlIzquierda.setBackground(Color.BLUE);
		pnlIzquierda.setPreferredSize(new Dimension(200,650));
		
		add(pnlIzquierda, BorderLayout.WEST);
		
		//Crear los paneles
		
		
		tree = new JTree();
		tree.setPreferredSize(new Dimension(170, 600));
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultTreeModel modelo = new DefaultTreeModel(root);
		tree.setModel(modelo);
		pnlIzquierda.add(new JScrollPane(tree));
		
		DefaultMutableTreeNode nodoEjemplo = new DefaultMutableTreeNode("Ejemplo");
		modelo.insertNodeInto(nodoEjemplo, root, 0);
		
		for(String str: strings) {
			DefaultMutableTreeNode nodoB = new DefaultMutableTreeNode(str);
			modelo.insertNodeInto(nodoB, root, 0);
		}
	}
	
	public static void main(String[] args) {
		JTreeSimple vent = new JTreeSimple();
		vent.setVisible(true);
	}
}
