package server;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JLabel;


public class ServerStatisticsGUI implements Runnable {

	public static JLabel lblNewLabel_3 = new JLabel();
	public static JLabel label = new JLabel(String.valueOf(Statistics.averageTimePerClient));
	public static JLabel label_2 = new JLabel(String.valueOf(Statistics.activeThreads));
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/**
	 * @wbp.parser.entryPoint
	 */
	public void run() {
		try {
			initialize();
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ServerStatisticsGUI() {

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.menu);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 300, 245);
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
		
		lblNewLabel_3.setForeground(UIManager.getColor("CheckBox.focus"));
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(169, 47, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		label.setForeground(Color.BLACK);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(169, 82, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Valores");
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(169, 116, 46, 14);
		frame.getContentPane().add(label_1);
		
		
		label_2.setForeground(Color.BLACK);
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(169, 146, 46, 14);
		frame.getContentPane().add(label_2);
	}
	
}
