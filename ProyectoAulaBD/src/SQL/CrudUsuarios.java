/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;
import GetSet.VarUsuario;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Bladimir
 */
public class CrudUsuarios {
    ConexionSQL con = new ConexionSQL();
    public String ingreso;
    public int  Validar (String usuarioIngresado, String claveIngresada){
        
         
        try {
            VarUsuario ObjSesion = new VarUsuario();
            //Docente
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql = "SELECT id_doc, clave_doc FROM docentes WHERE id_doc='"+usuarioIngresado+"' and clave_doc='"+claveIngresada+"';";
            ResultSet rs= st.executeQuery(sql);
            //Estudiante
           
            if(rs.next()){
                
                //La idea es guardar los datos por usuario para definir que esta o no habilitado
                ObjSesion.setUsuario(rs.getString(String.valueOf("id_doc")));
                ObjSesion.setClave(rs.getString("clave_doc"));
                JOptionPane.showMessageDialog(null, "Usuario Docente Valido");   
                return 1;
            }
            
            else if (true){
                 //Connection conexion2 = con.conectar();
                Connection conexion2 = con.conectar();
                Statement st2 = conexion2.createStatement();
                String sql2 = "SELECT id_est, clave_est FROM estudiantes WHERE id_est='"+usuarioIngresado+"' and clave_est='"+claveIngresada+"';";
                ResultSet rs2= st2.executeQuery(sql2);
                if(rs2.next()){
                    ObjSesion.setUsuario(rs2.getString(String.valueOf("id_est")));
                    ObjSesion.setClave(rs2.getString("clave_est"));
                    JOptionPane.showMessageDialog(null, "Usuario Estudiante Valido"); 
                    return 1;
                }
                else {JOptionPane.showMessageDialog(null, "Usuario No encontado");}
            }
           
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Error en Inicio sesion: "+e);}
        return 0;
    }
}
