import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.io.File;

public class EjJTree extends JFrame {
	
	private JTree arbol;
	private JPanel pnlArbol;
	
	public EjJTree() {
		
		//Ajustes de la ventana
		
		setSize(750,650);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Crear componentes
		
		pnlArbol = new JPanel();
		pnlArbol.setPreferredSize(new Dimension(750,650));
		pnlArbol.setBackground(Color.YELLOW);
		
		arbol = new JTree();
		File rootFile = new File("C:\\");
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile);
		
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
