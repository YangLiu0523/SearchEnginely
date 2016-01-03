package package1;

import java.io.InputStream;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBConnection {
	String driver = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement prepstmt = null;
	private String url = "jdbc:mysql://localhost/DB? useUnicode=true&characterEncoding=UTF-8"; 
	String user = "root"; 
	String password = "123456"; 
	
	public DBConnection(){
		try{
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);
			stmt = (Statement) conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public DBConnection(String sql){
		try{
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);
			this.prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return conn;
	}
	public void prepareStatement (String sql){
		try{
			prepstmt=(PreparedStatement) conn.prepareStatement(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
	}public void setString(int index,String value)
    {   
        try
        {
            prepstmt.setString(index,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setInt(int index,int value)
    {
        try
        {
            prepstmt.setInt(index,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setBoolean(int index,boolean value)
    { 
        try
        {
            prepstmt.setBoolean(index,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setDate(int index,Date value) throws SQLException 
    {
        try
        {
            prepstmt.setDate(index,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setLong(int index,long value) throws SQLException 
    {
        try
        {
            prepstmt.setLong(index,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setFloat(int index,float value) throws SQLException 
    {
        try
        {
            prepstmt.setFloat(index,value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setBinaryStream(int index,InputStream in,int length) throws SQLException
    {
        try
        {
            prepstmt.setBinaryStream(index,in,length);
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    public void clearParameters()throws SQLException
    {
        try
        {
            prepstmt.clearParameters();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public PreparedStatement getPreparedStatement()
    {
        return prepstmt;
    }
    
    public Statement getStatement() 
    {
        return stmt;
    }
    
    public ResultSet executeQuery(String sql)
    {
        try
        {
            if (stmt != null) 
                return stmt.executeQuery(sql);
            else 
                return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    public void execute(String sql){
    	try{
    		if (stmt != null)
    			stmt.execute(sql);
    		else ;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public ResultSet executeQuery()
    {
        try
        {
            if (prepstmt != null) 
                return prepstmt.executeQuery();
            else
                return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void executeUpdate(String sql)
    {
        try
        {
            if (stmt != null)
                stmt.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void executeUpdate()
    {
        try
        {
            if (prepstmt != null)
                prepstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void close()     
    {
        try
        {
            if (stmt != null) 
            {
                stmt.close();
                stmt = null;
            }
            if (prepstmt != null) 
            {
                prepstmt.close();
                prepstmt = null;
            }
            conn.close();
            conn = null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
	


