package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Statement;

public class PanelAcc extends JPanel implements ActionListener{
	

	JLabel lblAccID, lblAccHd, lblRptHd, lblVchr, lblAmount;
	JTextField txtAccID, txtAccHd, txtRptHd, txtVchr, txtAmount;
	JButton btnSave, btnUpdate, btnDelete;
	JTable jtable;
	JScrollPane jspane;
	JPanel tablePan;
	
	String accQuery;
	
	DBwork accDB;			//Database variables
	ResultSet accResultSet; //
	
	public PanelAcc(){
		this.setBackground(new Color(0, 102, 204));
		this.initialize();
	}

	private void initialize() {
		this.setLayout(null);
		
		
		this.initComponents();
		this.addComponents();
		this.addButtonLis();
		this.setTable();
	}

	

	private void addComponents() {
		lblAccID.setBounds(10,10,90,20); txtAccID.setBounds(110,10,100,20);
		lblAccHd.setBounds(10,40,90,20); txtAccHd.setBounds(110,40,100,20);
		lblRptHd.setBounds(10,70,90,20); txtRptHd.setBounds(110,70,100,20);
		lblVchr.setBounds(10,100,90,20); txtVchr.setBounds(110,100,100,20);
		lblAmount.setBounds(10,130,90,20); txtAmount.setBounds(110,130,100,20);
		
		btnSave.setBounds(10,170,100,30); btnUpdate.setBounds(120,170,100,30); btnDelete.setBounds(230,170,100,30);
		
		tablePan.setBounds(30, 220, 900, 260);
		
		this.add(lblAccID); this.add(txtAccID);
		this.add(lblAccHd); this.add(txtAccHd);
		this.add(lblRptHd); this.add(txtRptHd);
		this.add(lblVchr); this.add(txtVchr);
		this.add(lblAmount); this.add(txtAmount);
		
		this.add(btnSave);
		this.add(btnUpdate);
		this.add(btnDelete);
		
		
		this.add(tablePan);
		
	}

	private void initComponents() {
		this.lblAccID = new JLabel("Account ID:");
		this.lblAccHd = new JLabel("Account Name:");
		this.lblRptHd = new JLabel("Report Head:");
		this.lblVchr = new JLabel("Voucher No:");
		this.lblAmount = new JLabel("Bill Amount:");
		
		this.txtAccID = new JTextField();
		this.txtAccHd = new JTextField();
		this.txtRptHd = new JTextField();
		this.txtVchr = new JTextField();
		this.txtAmount = new JTextField();
		this.btnSave = new JButton("Save");
		this.btnUpdate = new JButton("Update");
		this.btnDelete = new JButton("Delete");
		
		this.tablePan = new JPanel();
		
		this.accDB = new DBwork();
		
	}
	
	
	private void setTable() {
		
		accDBvalue();
	
		jtable = new JTable();
		try {
			jtable.setModel(DbUtils.resultSetToTableModel(accResultSet));
		} catch (Exception e) {
			System.out.println("Error "+e);
			//e.getMessage();
		}
		
		
		jtable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(100);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton source = (JButton) obj;
		
		if(source.equals(this.btnSave)){
			this.accSaveData();
		}
		if(source.equals(this.btnUpdate)){
			this.accUpdateData();
		}
		if(source.equals(this.btnDelete)){
			this.accDeleteData();
		}
		
	}


	private void accDeleteData() {
		accQuery = "DELETE FROM accdb where acc_id='"+txtAccID.getText()+"'";
		accDB.accUpdate(accQuery);
	}

	private void accUpdateData() {
		accQuery = "Update accdb SET acc_hd='"+txtAccHd.getText()+"', rept_hd='"+txtRptHd.getText()+"', vhcr_hd='"+txtVchr.getText()+"', bill_amnt='"+txtAmount.getText()+"' where acc_id='"+txtAccID.getText()+"'";
		accDB.accUpdate(accQuery);
	}

	private void accSaveData() {
		//System.out.println("Save");
		accQuery = "INSERT INTO accdb (acc_id, acc_hd, rept_hd, vhcr_hd, bill_amnt) VALUES ('"+txtAccID.getText()+"','"+txtAccHd.getText()+"','"+txtRptHd.getText()+"','"+txtVchr.getText()+"','"+txtAmount.getText()+"')";
		accDB.accUpdate(accQuery);
	}
	

	private void accDBvalue(){
	
	
	accQuery = "select * from accdb";
	accResultSet = accDB.accdb(accQuery);
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
