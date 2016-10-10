package project;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class PanelPrjct extends JPanel{
	
	JLabel lblPrjctID, lblPrjctName, lblCrntAmnt, lblPrjctExp, lblRcvble, lblClient;
	JTextField txtPrjctID, txtPrjctName, txtCrntAmnt, txtPrjctExp, txtRcvble, txtClient;
	JButton btnSave, btnUpdate, btnDelete;
	
	JTable jtable;
	JScrollPane jspane;
	JPanel tablePan; 
	
	DBwork prjctDB;
	ResultSet prjctResultSet;
	
	public PanelPrjct(){
		this.initialize();
	}

	private void initialize() {
		this.setBackground(new Color(0, 102, 204));
		this.setLayout(null);
		
		this.initComponents();
		this.addComponents();
		this.addButtonLis();
		this.setTable();
	}

	private void addButtonLis() {
		// TODO Auto-generated method stub
		
	}

	private void addComponents() {
		lblPrjctID.setBounds(10,10,100,20); txtPrjctID.setBounds(120,10,100,20); lblPrjctName.setBounds(230,10,100,20); txtPrjctName.setBounds(340,10,150,20);
		lblCrntAmnt.setBounds(10,40,100,20); txtCrntAmnt.setBounds(120,40,100,20);
		lblPrjctExp.setBounds(10,70,100,20); txtPrjctExp.setBounds(120,70,100,20);
		lblRcvble.setBounds(10,100,100,20); txtRcvble.setBounds(120,100,100,20);
		lblClient.setBounds(10,130,100,20); txtClient.setBounds(120,130,100,20);
	
		this.add(lblPrjctID); this.add(txtPrjctID);
		this.add(lblPrjctName); this.add(txtPrjctName);
		this.add(lblCrntAmnt); this.add(txtCrntAmnt);
		this.add(lblPrjctExp); this.add(txtPrjctExp);
		this.add(lblRcvble); this.add(txtRcvble);
		this.add(lblClient); this.add(txtClient);
		
		btnSave.setBounds(10,170,100,30); btnUpdate.setBounds(120,170,100,30); btnDelete.setBounds(230,170,100,30);
		
		tablePan.setBounds(30, 220, 900, 260);
		
		this.add(btnSave);
		this.add(btnUpdate);
		this.add(btnDelete);
		this.add(tablePan);
	}

	private void initComponents() {
		this.lblPrjctID = new JLabel("Project ID:");
		this.lblPrjctName = new JLabel("Project Name:");
		this.lblCrntAmnt = new JLabel("Current Amount:");
		this.lblPrjctExp = new JLabel("Project Expenditure:");
		this.lblRcvble = new JLabel("Receivable:");
		this.lblClient = new JLabel("Client:");
		
		this.txtPrjctID = new JTextField();
		this.txtPrjctName = new JTextField();
		this.txtCrntAmnt = new JTextField();
		this.txtPrjctExp = new JTextField();
		this.txtRcvble = new JTextField();
		this.txtClient = new JTextField();
		
		this.btnSave = new JButton("Save");
		this.btnUpdate = new JButton("Update");
		this.btnDelete = new JButton("Delete");
		
		this.tablePan = new JPanel();
	}
	
	private void setTable() {
		
		prjctDBvalue();
	/*	String data[][] = {{"01","hog","20300"},
				{"02","lava","13000"},
				{"02","lava","13000"},
				{"02","lava","13000"},
				{"04","gaint","23400"}};  
		String[] column = {"Em_ID","Em_Name","Basic"};
		*/
		jtable = new JTable(); //data,column
		try {
			jtable.setModel(DbUtils.resultSetToTableModel(prjctResultSet));
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		jtable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(150);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(100);
		jtable.getColumnModel().getColumn(5).setPreferredWidth(100);
		jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		jtable.setPreferredScrollableViewportSize(jtable.getPreferredSize());
		jtable.setFillsViewportHeight(true);
		
		
		jspane = new JScrollPane(jtable);
		
		
		tablePan.add(jspane);
	}

	
	private void prjctDBvalue(){
		
		prjctDB = new DBwork();
		
		String prjctQuery = "select * from project";
		prjctResultSet = prjctDB.prjctdb(prjctQuery);
		/*
		try {
			while(homeResultSet.next()){
			    int accid = homeResultSet.getInt("acc_id");
			    String acchd = homeResultSet.getString("acc_hd");
			    System.out.println(accid+" "+acchd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
*/
	}

}
