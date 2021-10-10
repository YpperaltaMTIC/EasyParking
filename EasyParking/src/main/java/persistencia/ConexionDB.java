/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConexionDB {
    private String DB_driver="";
    private String url ="";
    private String db="";
    private String host="";
    private String username="";
    private String password="";
    public Connection con=null;
    private Statement stmt=null;
    private PreparedStatemant pstmt=null;
    private ResultSet rs=null;
    private boolean local;
    
    
    public ConexionDB(){
        DB_driver="com.mysql.jdbc.Driver";
        host="localhost:3306";
        db="easyparking";
        url="jdbc:mysql://"+host+"/"+db;
        username="root";
        password="1234";
        
        try{
            Class.forName(DB_driver);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        try{
            con=DriverManager.getConnection(url,username,password);
            con.setTransactionIsolation(8);
            System.out.println("conectado");
        }catch(SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    //metodos
    
    public Connection getConnection(){
        return con;
    }
    
    public void closeConnection(Connection con){
        if(con!=null){
            try{
                con.close();
            }catch(SQLException ex){
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
    /*
    public ResultSet consultarDB(String sentencia){
        try{
           stmt =(Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           rs=stmt.execute(sentencia);       
        }catch(SQLException sqlex){
            
        }catch(RuntimeException rex){
            
        }catch(Exception ex){
            
        }
        return rs;
    }*/
    
}
