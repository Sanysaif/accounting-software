package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 960, 540);
		this.getContentPane().add(tabbedPane);
		
		PanelHome ph= new PanelHome();
		tabbedPane.addTab("Home", null, ph, null);
		
		
		PanelOpts po = new PanelOpts();
		tabbedPane.addTab("Options", null, po, null);
		
		PanelSearch ps = new PanelSearch();
		tabbedPane.addTab("Search", null, ps, null);
		PanelEntry pe = new PanelEntry();
		tabbedPane.addTab("New Entry", null, pe, null);
			}
}
