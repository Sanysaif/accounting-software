package project;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelOpts extends JPanel{
	
	JTabbedPane opTab, tabbedPane_1;
	//JPanel panelAdd, panelUp, panelEmp, panelAcc, panelTrans, panelDel, panelPrjct;
	PanelEmp emppan;
	PanelAcc accpan;
	PanelTrans transpan;
	PanelPrjct prjctpan;
	PanelEntry panEntry;
	public PanelOpts(){
		this.initialize();
	}

	private void initialize() {
		this.setBackground(new Color(0, 102, 204));
		this.setLayout(null);
		
		this.initComponents();
		this.addComponents();
		this.addButtonLis();
	}

	private void addButtonLis() {
		
	}

	private void addComponents() {
		opTab.setBounds(0, 0, 960, 520);
		//panelAdd.setLayout(null);
		tabbedPane_1.setBounds(0, 0, 454, 333);
		
		this.add(opTab);
		opTab.addTab("Employee", null, emppan, null);
		//tabbedPane_1.addTab("Employee", null, panelEmp, null);
		//tabbedPane_1.addTab("Account", null, panelAcc, null);
		//tabbedPane_1.addTab("Transaction", null, panelTrans, null);
		//panelAdd.add(tabbedPane_1);
		opTab.addTab("Account", null, accpan, null);
		opTab.addTab("Transaction", null, transpan, null);
		opTab.addTab("Project", null, prjctpan, null);
		
	
		
	}

	private void initComponents() {
		
		this.opTab = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		this.emppan = new PanelEmp();
		this.accpan = new PanelAcc();
		this.transpan = new PanelTrans();
		this.prjctpan = new PanelPrjct();
		this.panEntry = new PanelEntry();
		}
}
