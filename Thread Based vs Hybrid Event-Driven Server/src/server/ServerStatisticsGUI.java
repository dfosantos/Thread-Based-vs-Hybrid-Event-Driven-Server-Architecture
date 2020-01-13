package server;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import client.ClientCreator;
import threadBased.ThreadBasedServer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;


public class ServerStatisticsGUI implements Runnable {

	public static JLabel lblNewLabel_3 = new JLabel();
	public static JLabel label = new JLabel(String.valueOf(Statistics.averageTimePerClient));
	public static JLabel label_2 = new JLabel(String.valueOf(Statistics.activeThreads));
	private JFrame frame;
	private JTextField textField_CPS;
	private JTextField textField_FileSize;

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
		frame.setBounds(100, 100, 494, 243);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(225, 0, 243, 204);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		Action cps_action = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cps = Integer.parseInt(textField_CPS.getText());
				if (cps != 0) {
					ThreadBasedServer.CPS = cps;
				}

			}
		};
		
		Action newSize = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int size = Integer.parseInt(textField_FileSize.getText());
				System.out.println(size);
				if (size != 0) {
					ThreadBasedServer.FileSize = size;
				}

			}
		};
		
		JLabel lblNewLabel_4 = new JLabel("Connections per second");
		lblNewLabel_4.setBounds(22, 19, 115, 33);
		panel.add(lblNewLabel_4);
		
		textField_CPS = new JTextField();
		textField_CPS.addActionListener(cps_action);
		textField_CPS.setBounds(147, 14, 86, 43);
		panel.add(textField_CPS);
		textField_CPS.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("File Size (KB)");
		lblNewLabel_5.setBounds(45, 94, 61, 43);
		panel.add(lblNewLabel_5);
		
		textField_FileSize = new JTextField();
		textField_FileSize.setBounds(147, 92, 86, 46);
		textField_FileSize.addActionListener(newSize);
		panel.add(textField_FileSize);
		textField_FileSize.setColumns(10);
	}
}
