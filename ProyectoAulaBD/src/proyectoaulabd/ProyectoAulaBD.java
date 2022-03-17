/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoaulabd;

import java.sql.*;
/**
 *
 * @author Bladimir
 */
public class ProyectoAulaBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String drive ="JDBC Posgrest 42.3";
        String conexion="jdbc:postgresql://localhost:5050/ProyectoDB2";
        String user ="EstDB2";
        String passwordUser="Unimeta2021";
        try{
            Connection conn = DriverManager.getConnection(conexion,user,passwordUser);
            System.out.print("Conexion establecida");
            conn.close();
        }
        catch(SQLException e){
            System.out.print("Conexion perdida");
        }
    }
    
}
