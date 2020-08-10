import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controles extends JPanel{
	private JTextField tfInsertar;
	private JButton agregar, 
					eliminar;
	private AVL<Integer> avl;
	
	public Controles(AVL<Integer> avl) {
		super();
		this.setPreferredSize(new Dimension(200,55));
		this.setBackground(new Color(224,125,124));

		this.avl=avl;
		
		this.agregar = new JButton("Agregar");
		this.agregar.setFont(new Font("Arial", Font.BOLD,13));
		this.agregar.setBackground(new Color(180,230,30));
		this.agregar.setPreferredSize( new Dimension( 120, 25 ));
		this.agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar();	
			}
		});
		
		//Boton agregar
		this.agregar = new JButton("Agregar");
		this.agregar.setPreferredSize( new Dimension( 120, 25 ));
		this.agregar.setFont(new Font("Arial",Font.PLAIN,18));
		this.agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar();
			}
		});
		this.add(this.agregar);
		
		//Boton eliminar
		this.eliminar = new JButton("Eliminar");
		this.eliminar.setFont(new Font("Arial", Font.BOLD,13));
		this.eliminar.setBackground(new Color(180,230,30));
		this.eliminar.setPreferredSize( new Dimension( 120, 25 ));
		this.eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonEliminar();	
			}
		});
		this.add(this.eliminar);		
	}
				
	//********************** M�todos *************************
		
		public void botonAgregar() {
			try {
				Integer valor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor:"));
				avl.insertar(valor);
			}catch(NullPointerException ev) {
				JOptionPane.showMessageDialog(null,"No ingresaste ningun dato");
			}catch(NumberFormatException evt) {
				JOptionPane.showMessageDialog(null,"No ingresaste un Número");
			}
		}
		
		public void botonEliminar() {
			try {
				Integer numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número"));
				avl.remover(numero);
				
			}catch(NullPointerException ev) {
				JOptionPane.showMessageDialog(null,"No ingresaste ningun dato");
			}catch(NumberFormatException evt) {
				JOptionPane.showMessageDialog(null,"No ingresaste un Número");
			}
		}
	
}
