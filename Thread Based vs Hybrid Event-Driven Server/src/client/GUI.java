package client;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

public class GUI implements Runnable {

	ClientCreator.Statistics cc;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.setBounds(100, 100, 431, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblConnectionsPerSecond = DefaultComponentFactory.getInstance().createTitle("Connections Per Second:");
		lblConnectionsPerSecond.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectionsPerSecond.setBounds(0, 0, 132, 47);
		frame.getContentPane().add(lblConnectionsPerSecond);

		Action cps = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cps = Integer.parseInt(textField.getText());
				if (cps != 0) {
					cc.ConnectionsPerSecond = cps;
					System.out.println("Connections per second changed to " + cps);
				}

			}
		};

		Action newSize = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int size = Integer.parseInt(textField_1.getText());
				System.out.println(size);
				if (size != 0) {
					cc.nBytes = size * 1000;
					System.out.println("File Size Requests changed to " + size + "KB");
				}

			}
		};

		textField = new JTextField();
		textField.setBounds(142, 0, 120, 47);
		textField.addActionListener(cps);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblReadSize = new JLabel("Read Size (KB)");
		lblReadSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblReadSize.setBounds(0, 58, 132, 47);
		frame.getContentPane().add(lblReadSize);

		textField_1 = new JTextField();
		textField_1.addActionListener(newSize);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(142, 58, 120, 47);
		frame.getContentPane().add(textField_1);
	}
}
