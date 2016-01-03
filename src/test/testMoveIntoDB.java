package test;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import package1.DBConnection;

public class testMoveIntoDB {
	private static String url="123";
	private static String name="刘洋";
	public static void addToDB2(DBConnection dbc){
		String sql = "insert into test2(id,name)"+
	            "values('"+url+"', '"+name+"')";
	    dbc.execute(sql);
	}
	public static void main (String [] args){	
			DBConnection dbc= new DBConnection();
			testMoveIntoDB.addToDB2(dbc);
	}
}
