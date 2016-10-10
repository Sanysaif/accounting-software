package project;

import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class PanelHome extends JPanel{
	JTable jtable;
	JScrollPane jspane;
	JPanel tablePan;
	DBwork homeDB;
	ResultSet homeResultSet;
	
	public PanelHome(){
		this.initailize();
	}

	private void initailize() {
		this.setLayout(null);
		
		
		this.initComponents();
		this.addComponents();
		this.setTable();
	}
	
	private void addComponents() {

		this.setBackground(new Color(0, 102, 204));
		
		tablePan.setBounds(20,20,900,480);
		
		this.add(tablePan);
	}

	private void initComponents() {
		this.tablePan = new JPanel();
		this.jtable = new JTable();
	}

	private void setTable(){

		
		homeDBvalue();
		try {
			jtable.setModel(DbUtils.resultSetToTableModel(homeResultSet));
			/*while(homeResultSet.next()){
			    int accid = homeResultSet.getInt("trans_id");
			    String tDate = homeResultSet.getString("tdate");
			    double amount = homeResultSet.getDouble("amount");
			    System.out.println(accid+" "+tDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		*/}catch (Exception e) {
			System.out.println("get the error here..!!");
		}
		
		/*
		String data[][]= {{"01","hog","hajari","20300"},
				{"02","lava","majari","13000"},
				{"02","lava","ganjutti","13000"},
				{"02","lava","accountent","13000"},
				{"02","lava","pion","13000"},
				{"04","gaint","CEO","234000"}}; 
		String colum[] = {"Em_ID","Em_Name","Desig","Basic"};
		*/
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
		
		
	//	this.setLayout(null);
	}
	
	private void homeDBvalue(){
		
		homeDB = new DBwork();
		
		String homeQuery = "select * from trans";
		homeResultSet = homeDB.homedb(homeQuery);
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
