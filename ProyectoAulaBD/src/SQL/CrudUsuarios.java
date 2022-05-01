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
    public int Validar (String usuarioIngresado, String claveIngresada){
        
        int i = Integer.parseInt(usuarioIngresado);
        int ingreso=0;
        try {
            VarUsuario ObjSesion = new VarUsuario();
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql = "SELECT id_usu, clave_usu FROM usuario WHERE id_usu='"+i+"' and clave_usu='"+claveIngresada+"';";
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
               
                //La idea es guardar los datos por usuario para definir que esta o no habilitado
                ObjSesion.setUsuario(rs.getString(String.valueOf("id_usu")));
                ObjSesion.setClave(rs.getString("clave_usu"));
                JOptionPane.showMessageDialog(null, "Usuario Valido");
                
                ingreso =1;
                
            }else JOptionPane.showMessageDialog(null, "Usuario No encontado");
           
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Error en Inicio sesion: "+e);}
        return ingreso;
    
    }
}
