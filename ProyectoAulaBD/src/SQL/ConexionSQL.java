package SQL;

import java.sql.*;

public class ConexionSQL {
    
    String url="jdbc:postgresql://localhost:5432/damocles";
    String user="postgres";
    String password="12345";
    Connection conn = null;
    public Connection conectar(){
        
        try{
        
            conn = DriverManager.getConnection(url,user,password);
        }
        catch(SQLException e){
        
            System.out.println("conexion fallida: "+e);
        }
        return conn;
    
    }

}