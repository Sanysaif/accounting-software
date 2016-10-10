package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.sound.midi.SysexMessage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Statement;

public class PanelEmp extends JPanel implements ActionListener{
	
	JLabel lblEmpID, lblEmpName, lblDesig, lblStatus, lblJoinDate, lblBasic, lblDayRate, lblBill, lblRcv, lblBlnc;
	JTextField txtEmpID, txtEmpName, txtDesig, txtStatus, txtJoinDate, txtBasic, txtDayRate, txtBill, txtRcv, txtBlnc;
	JButton btnSave, btnUpdate, btnDelete;
	JTable jtable;
	JPanel tablePan;
	JScrollPane jspane;

	DBwork empDB;			//Database variables
	ResultSet empResultSet;
	
	String empQuery;
	
	public PanelEmp(){
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
	
	private void setTable() {
		
		empDBvalue();
	/*	String data[][] = {{"01","hog","20300"},
				{"02","lava","13000"},
				{"02","lava","13000"},
				{"02","lava","13000"},
				{"04","gaint","23400"}};  
		String[] column = {"Em_ID","Em_Name","Basic"};
		*/
		jtable = new JTable(); //data,column
		try {
			jtable.setModel(DbUtils.resultSetToTableModel(empResultSet));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Some Error occour..!!");
		}
		
		jtable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(180);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(110);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(80);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(5).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(6).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(7).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(8).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(7).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(8).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(9).setPreferredWidth(65);
		jtable.getColumnModel().getColumn(10).setPreferredWidth(65);
		
		jtable.setPreferredScrollableViewportSize(jtable.getPreferredSize());
		jtable.setFillsViewportHeight(true);
		jspane = new JScrollPane(jtable);
		
		
		tablePan.add(jspane);
	}

	private void addButtonLis() {
		
		this.btnSave.addActionListener(this);
		this.btnUpdate.addActionListener(this);
		this.btnDelete.addActionListener(this);	
	}

	private void addComponents() {
		lblEmpID.setBounds(10,10,90,20); lblEmpName.setBounds(250,10,100,20);
		lblDesig.setBounds(10,40,90,20); lblStatus.setBounds(250,40,90,20);
		lblJoinDate.setBounds(10,70,90,20); lblBasic.setBounds(250,70,90,20);
		lblDayRate.setBounds(10,100,90,20); lblRcv.setBounds(250,100,90,20);
		lblBill.setBounds(10,130,90,20); lblBlnc.setBounds(250,130,90,20);
		
		txtEmpID.setBounds(110,10,110,20); txtEmpName.setBounds(350,10,180,20);
		txtDesig.setBounds(110,40,110,20); txtStatus.setBounds(350,40,90,20);
		txtJoinDate.setBounds(110,70,110,20); txtBasic.setBounds(350,70,90,20);
		txtDayRate.setBounds(110,100,110,20); txtRcv.setBounds(350,100,90,20);
		txtBill.setBounds(110,130,110,20); txtBlnc.setBounds(350,130,90,20);
		
		btnSave.setBounds(10,170,100,30); btnUpdate.setBounds(120,170,100,30); btnDelete.setBounds(230,170,100,30);
		
		tablePan.setBounds(30, 220, 900, 260);
		
		this.add(lblEmpID); this.add(lblEmpName);
		this.add(lblDesig); this.add(lblStatus);
		this.add(lblJoinDate); this.add(lblBasic);
		this.add(lblDayRate); this.add(lblRcv);
		this.add(lblBill); this.add(lblBlnc);
		
		this.add(txtEmpID); this.add(txtEmpName);
		this.add(txtDesig); this.add(txtStatus);
		this.add(txtJoinDate); this.add(txtBasic);
		this.add(txtDayRate); this.add(txtRcv);
		this.add(txtBill); this.add(txtBlnc);
		
		this.add(btnSave);
		this.add(btnUpdate);
		this.add(btnDelete);
		
		this.add(tablePan);
	}

	private void initComponents() {
		this.lblEmpID = new JLabel("Employee ID:");
		this.lblEmpName = new JLabel("Employee Name:");
		this.lblDesig = new JLabel("Designation:");
		this.lblStatus = new JLabel("Job Status:");
		this.lblJoinDate = new JLabel("Join Date:");
		this.lblBasic = new JLabel("Basic Salary:");
		this.lblDayRate = new JLabel("Day Rate:");
		this.lblRcv = new JLabel("Received:");
		this.lblBill = new JLabel("Billed:");
		this.lblBlnc = new JLabel("Balance:");
		
		this.txtEmpID = new JTextField();
		this.txtEmpName = new JTextField();
		this.txtDesig = new JTextField();
		this.txtStatus = new JTextField();
		this.txtJoinDate = new JTextField();
		this.txtBasic = new JTextField();
		this.txtDayRate = new JTextField();
		this.txtRcv = new JTextField();
		this.txtBill = new JTextField();
		this.txtBlnc = new JTextField();
		
		this.btnSave = new JButton("Save");
		this.btnUpdate = new JButton("Update");
		this.btnDelete = new JButton("Delete");
		
		this.tablePan = new JPanel();
		//this.tablePan.setLayout(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton source = (JButton) obj;
		
		if(source.equals(this.btnSave)){
			this.empSaveData();
			
		}
		if(source.equals(this.btnUpdate)){
			this.empUpdateData();
			
		}
		if(source.equals(this.btnDelete)){
			this.empDeleteData();
			
		}
		
	}
	
	private void empDeleteData() {
		empQuery = "DELETE FROM employee where emp_id='"+txtEmpID.getText()+"'";
		empDB.empUpdate(empQuery);
	}

	private void empUpdateData() {
		empQuery = "Update employee SET emp_id='"+txtEmpID.getText()+"', emp_name='"+txtEmpName.getText()+"', desing='"+txtDesig.getText()+"', joindate='"+txtJoinDate.getText()+"', basic='"+txtBasic.getText()+"', day_rate='"+txtDayRate.getText()+"', rcv='"+txtRcv.getText()+"',blnc='"+txtBlnc.getText()+"', jobsts='"+txtStatus.getText()+"', bill='"+txtBasic.getText()+"'  where emp_id='"+txtEmpID.getText()+"'";
		empDB.empUpdate(empQuery);
	}

	private void empSaveData() {
		//System.out.println("Save");
	empQuery = "INSERT INTO employee (emp_id, emp_name, design, joindate, basic, day_rate, rcv, bill, blnc, jobsts) VALUES ('"+txtEmpID.getText()+"','"+txtEmpName.getText()+"','"+txtDesig.getText()+"','"+txtJoinDate.getText()+"','"+txtBasic.getText()+"','"+txtDayRate.getText()+"','"+txtRcv.getText()+"','"+txtBill.getText()+"','"+txtBlnc.getText()+"','"+txtStatus.getText()+"')";
		empDB.empUpdate(empQuery);
	}

	private void empDBvalue(){
		
		empDB = new DBwork();
		
		empQuery = "select * from employee";
		empResultSet = empDB.empdb(empQuery);
		
	}

}
