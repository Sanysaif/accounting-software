package project;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSearch extends JPanel{
	private JTextField textStartDate, textEndDate, textAccId, textAccHd, textDonorId, textRcvrId, textVchrNo, textPrjctId;
	private JLabel lblStartDate, lblEndDate, lblAccId, lblAccHd, lblDonorId, lblRcvrId, lblVchrNo, lblPrjctId;
	private JButton btnSearch;
	
	DBwork searchDB;
	ResultSet searchResultSet;
	
	public PanelSearch(){
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
		// TODO Auto-generated method stub
		
	}

	private void addComponents() {
		textStartDate.setBounds(80, 10, 100, 20);
		textEndDate.setBounds(300, 10, 100, 20);
		textAccId.setBounds(80, 40, 100, 20);
		textAccHd.setBounds(300, 40, 120, 20);
		textDonorId.setBounds(80, 70, 100, 20);
		textRcvrId.setBounds(300, 70, 100, 20);
		textVchrNo.setBounds(80, 102, 100, 20);
		textPrjctId.setBounds(80, 134, 100, 20);
		
		
		lblStartDate.setBounds(10, 10, 70, 20);
		lblEndDate.setBounds(200, 10, 80, 20);
		lblAccId.setBounds(10, 40, 70, 20);
		lblAccHd.setBounds(200, 40, 90, 20);
		lblDonorId.setBounds(10, 70, 70, 20);
		lblRcvrId.setBounds(200, 70, 80, 20);
		lblVchrNo.setBounds(10, 102, 70, 20);
		lblPrjctId.setBounds(10, 134, 70, 20);
		btnSearch.setBounds(10,170,100,30);
		
		this.add(lblStartDate); this.add(textStartDate);
		this.add(lblEndDate); this.add(textEndDate);
		this.add(lblAccId); this.add(textAccId);
		this.add(lblAccHd); this.add(textAccHd);
		this.add(lblDonorId); this.add(textDonorId);
		this.add(lblRcvrId); this.add(textRcvrId);
		this.add(lblVchrNo); this.add(textVchrNo);
		this.add(lblPrjctId); this.add(textPrjctId);
		this.add(btnSearch);
		
	}

	private void initComponents() {
		this.textStartDate = new JTextField();
		this.textEndDate = new JTextField();
		this.textAccId = new JTextField();
		this.textAccHd = new JTextField();
		this.textDonorId = new JTextField();
		this.textRcvrId = new JTextField();
		this.textVchrNo = new JTextField();
		this.textPrjctId = new JTextField();
		
		
		this.lblStartDate = new JLabel("Start Date:");
		this.lblEndDate = new JLabel("End Date:");
		this.lblAccId = new JLabel("Account ID:");
		this.lblAccHd = new JLabel("Account Name:");
		this.lblDonorId = new JLabel("Donor ID:");
		this.lblRcvrId = new JLabel("Receiver ID:");
		this.lblVchrNo = new JLabel("Voucher no:");
		this.lblPrjctId = new JLabel("Project ID:");
		
		this.btnSearch = new JButton("Search");
		
		
	}
	
	private void searchDBvalue(){
		
		searchDB = new DBwork();
		
		String searchQuery = "select * from trans";
		searchResultSet = searchDB.searchdb(searchQuery);
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
