package project;

import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class PanelTrans extends PanelEntry{
	
	JButton btnUpdate, btnDelete;
	
	JTable jtable;
	JScrollPane jspane;
	JPanel tablePan; 
	
	DBwork transDB;
	ResultSet transResultSet;
	
	public PanelTrans(){
		this.initialize();
	}

	private void initialize() {
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
		btnUpdate.setBounds(120,170,100,30); btnDelete.setBounds(230,170,100,30);
		
		tablePan.setBounds(30, 220, 900, 260);
		
		this.add(btnUpdate);
		this.add(btnDelete);
		this.add(tablePan);
	}

	private void initComponents() {
		this.btnUpdate = new JButton("Update");
		this.btnDelete = new JButton("Delete");
		this.tablePan = new JPanel();
	}
private void setTable() {
		
		transDBvalue();
	/*	String data[][] = {{"01","hog","20300"},
				{"02","lava","13000"},
				{"02","lava","13000"},
				{"02","lava","13000"},
				{"04","gaint","23400"}};  
		String[] column = {"Em_ID","Em_Name","Basic"};
		*/
		jtable = new JTable(); //data,column
		try {
			jtable.setModel(DbUtils.resultSetToTableModel(transResultSet));
		} catch (Exception e) {
			e.getMessage();
		}
		jtable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(70);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(5).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(6).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(7).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(8).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(7).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(8).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(9).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(10).setPreferredWidth(100);
		jtable.getColumnModel().getColumn(11).setPreferredWidth(100);
		jtable.getColumnModel().getColumn(12).setPreferredWidth(50);
	
		jtable.setPreferredScrollableViewportSize(jtable.getPreferredSize());
		jtable.setFillsViewportHeight(true);;
		
		jspane = new JScrollPane(jtable);
		tablePan.add(jspane);
		
	}

	
	
	private void transDBvalue(){
		
		transDB = new DBwork();
		
		String transQuery = "select * from trans";
		transResultSet = transDB.transdb(transQuery);
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
