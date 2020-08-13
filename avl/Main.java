import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	private AVL<Integer> avl;
	
	public Main() {
		super("Árbol AVL");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		PanelDibujo pt = new PanelDibujo();
		this.add(pt, BorderLayout.NORTH);
		
		Controles p = new Controles(avl);
		this.add(p, BorderLayout.SOUTH);
				
		this.pack();//Hace que la ventana se ajuste a sus componentes 
		this.setResizable(false);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		Main v1 = new Main();

	}

}
