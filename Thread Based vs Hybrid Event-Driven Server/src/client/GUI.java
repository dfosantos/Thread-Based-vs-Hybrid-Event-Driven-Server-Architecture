package client;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class GUI implements Runnable {

	ClientCreator.Statistics cc;
	private JFrame frame;
	private JTextField textField;

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
	public GUI(ClientCreator.Statistics cc) {
		this.cc = cc;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 270, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblConnectionsPerSecond = DefaultComponentFactory.getInstance().createTitle("Connections Per Second:");
		frame.getContentPane().add(lblConnectionsPerSecond, BorderLayout.WEST);
		
		Action action = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cps = Integer.parseInt(textField.getText());
				if(cps != 0) {
					cc.ConnectionsPerSecond = cps;
					System.out.println("Connections per second changed to " + cps);
				}
				
			}
		};
		textField = new JTextField();
		textField.addActionListener(action);
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
