package project;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelEntry extends JPanel{
	private JTextField textDate, textAccId, textAccHd, textDonor, textRcvr, textVchr, textAmount, textPrjct, textRemarks;
	private JLabel lblDate, lblAccId, lblAccHd, lblDonorId, lblRcvrId, lblVchrNo, lblAmount, lblRemarks, lblPrjctId;
	private JButton btnSave;
	
	DBwork entryDB;
	ResultSet entryResultSet;
	
	public PanelEntry(){
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
		textDate.setBounds(100, 10, 100, 20); lblDate.setBounds(10, 10, 80, 20);
		textAccId.setBounds(100, 40, 100, 20); lblAccId.setBounds(10, 40, 80, 20);
		textAccHd.setBounds(360, 40, 120, 20); lblAccHd.setBounds(260, 40, 90, 20);
		textDonor.setBounds(100, 70, 100, 20); lblDonorId.setBounds(10, 70, 80, 20);
		textRcvr.setBounds(360, 70, 100, 20); lblRcvrId.setBounds(260, 70, 80, 20);
		textVchr.setBounds(100, 100, 100, 20); lblVchrNo.setBounds(10, 100, 80, 20);		
		textAmount.setBounds(360, 100, 100, 20); lblAmount.setBounds(260, 100, 80, 20);
		textPrjct.setBounds(360, 10, 100, 20);  lblPrjctId.setBounds(260, 10, 80, 20);
		textRemarks.setBounds(100, 130, 150, 20);  lblRemarks.setBounds(10, 130, 80, 20);
			
		btnSave.setBounds(10,170,100,30);
		
		this.add(lblDate); this.add(textDate);
		this.add(lblAccId); this.add(textAccId);
		this.add(lblAccHd); this.add(textAccHd);
		this.add(lblDonorId); this.add(textDonor);
		this.add(lblRcvrId); this.add(textRcvr);
		this.add(lblVchrNo); this.add(textVchr);
		this.add(lblAmount); this.add(textAmount);
		this.add(lblPrjctId); this.add(textPrjct);
		this.add(lblRemarks); this.add(textRemarks);
		this.add(btnSave);
		
	}

	private void initComponents() {
		this.textDate = new JTextField();
		this.textAccId = new JTextField();
		this.textAccHd = new JTextField();
		this.textDonor = new JTextField();
		this.textRcvr = new JTextField();
		this.textVchr = new JTextField();
		this.textAmount = new JTextField();
		this.textPrjct = new JTextField();	
		this.textRemarks = new JTextField();
		
		this.lblDate = new JLabel("Date:");
		this.lblAccId = new JLabel("Account ID:");
		this.lblAccHd = new JLabel("Account Name:");
		this.lblDonorId = new JLabel("Donor ID:");
		this.lblRcvrId = new JLabel("Receiver ID:");
		this.lblVchrNo = new JLabel("Voucher no:");
		this.lblAmount = new JLabel("Amount:");
		this.lblRemarks = new JLabel("Remarks:");
		this.lblPrjctId = new JLabel("Project ID:");
		
		this.btnSave = new JButton("Save");
	}
	

	private void searchDBvalue(){
		
		entryDB = new DBwork();
		
		String entryQuery = "insert * from trans";
		entryResultSet = entryDB.entrydb(entryQuery);
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
