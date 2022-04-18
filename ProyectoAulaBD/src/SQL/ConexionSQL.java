package SQL;

import java.sql.*;

public class ConexionSQL {
    
    String url="jdbc:postgresql://localhost:5432/Damocles [postgres on Default schema]";
    String user="posfrest";
    String password="1234";
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