package server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import client.ClientCreator;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;

public class ServerStatisticsGUI implements Runnable {

	private JFrame frame;
	private JTextField txtCPS;
	private JTextField txtAVG;
	ClientCreator.Statistics cc;

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
	public ServerStatisticsGUI(ClientCreator.Statistics cc) {
		this.cc = cc;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 404, 126);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Connections Per Second");
		panel_1.add(lblNewLabel);
		
		txtCPS = new JTextField();
		txtCPS.setText(Integer.toString(cc.ConnectionsPerSecond));
		panel_1.add(txtCPS);
		txtCPS.setColumns(10);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Average Client Time");
		panel.add(lblNewLabel_1);
		
		txtAVG = new JTextField();
		txtAVG.setText();
		panel.add(txtAVG);
		txtAVG.setColumns(10);
	}
}
