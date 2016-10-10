package project;


import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBwork {
	
	private static Connection conection;
	private static Statement statment;
	private static ResultSet resultSet;
	
	    
    public DBwork(){
        initialize();
    }
    
    private void initialize() {
		
    	try {
            Class.forName("com.mysql.jdbc.Driver");
            conection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/officework", "root", "");
            statment = (Statement) conection.createStatement();
            
            //PreparedStatement statement = con.prepareStatement("select acc_id from accdb");
            
        }
        catch(Exception ex) {
            ex.printStackTrace();//error find korer jonno
        }
	}
    
    public ResultSet homedb(String q){
    	
    	try{
		    	String query = q;		//"select acc_id from accdb";
		        resultSet = statment.executeQuery(query);
		      
            }catch(Exception ex){
    		System.out.println("Error "+ex);
    	}
        return resultSet;
    }

	public ResultSet accdb(String q) {
		
		try{
	    	String query = q;
	        resultSet = statment.executeQuery(query);
	        
        }catch(Exception ex){
		System.out.println("Error "+ex);
	}
		return resultSet;
	}
	
	public void accUpdate(String q) {
	
		try{
	    	PreparedStatement pst = conection.prepareStatement(q);
	    	pst.execute();
	    	
	    	JOptionPane.showMessageDialog(null, "Query Successful");
	        
        }catch(Exception ex){
		System.out.println("Error "+ex);
	}
		
	}

	public ResultSet empdb(String q) {
		try{
	    	String query = q;
	        resultSet = statment.executeQuery(query);
	        
        }catch(Exception ex){
		System.out.println("Error "+ex);
        }
		return resultSet;
	}
	
	public void empUpdate(String q) {
		try{
	    	PreparedStatement pst = conection.prepareStatement(q);
	    	pst.execute();
	    	
	    	JOptionPane.showMessageDialog(null, "Query Successful");
	        
        }catch(Exception ex){
        	JOptionPane.showMessageDialog(null, "Some Error occour..!!\n"+ex);
        	//System.out.println("Error "+ex);
	}
		
	}

	public ResultSet prjctdb(String q) {
		try{
	    	String query = q;
	        resultSet = statment.executeQuery(query);
	        
        }catch(Exception ex){
		System.out.println("Error "+ex);
        }
		return resultSet;
	}
	
	public ResultSet transdb(String q) {
		try{
	    	String query = q;
	        resultSet = statment.executeQuery(query);
	        
        }catch(Exception ex){
		System.out.println("Error "+ex);
        }
		return resultSet;
	}
	
	public ResultSet searchdb(String q) {
		try{
	    	String query = q;
	        resultSet = statment.executeQuery(query);
	        
        }catch(Exception ex){
		System.out.println("Error "+ex);
        }
		return resultSet;
	}
	
	public ResultSet entrydb(String q) {
		try{
	    	String query = q;
	        resultSet = statment.executeQuery(query);
	        
        }catch(Exception ex){
		System.out.println("Error "+ex);
        }
		return resultSet;
	}

	
}