package server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setBounds(100, 100, 257, 246);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLigaesPS = new JLabel("Liga\u00E7\u00F5es p/ segundo");
		lblLigaesPS.setBounds(28, 47, 116, 14);
		frame.getContentPane().add(lblLigaesPS);
		
		JLabel lblNewLabel = new JLabel("Tempo m\u00E9dio p/ cliente");
		lblNewLabel.setBounds(28, 82, 122, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9bito");
		lblNewLabel_1.setBounds(28, 116, 116, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("n\u00BA Threads Ativas");
		lblNewLabel_2.setBounds(28, 146, 109, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valores");
		lblNewLabel_3.setForeground(UIManager.getColor("CheckBox.focus"));
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(169, 47, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("Valores");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(169, 82, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Valores");
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(169, 116, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Valores");
		label_2.setForeground(Color.BLACK);
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(169, 146, 46, 14);
		frame.getContentPane().add(label_2);
	}
}
