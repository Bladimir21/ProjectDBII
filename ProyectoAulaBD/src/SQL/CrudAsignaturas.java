/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;
import GetSet.VarAsignatura;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Bladimir
 */
public class CrudAsignaturas {
    ConexionSQL con = new ConexionSQL();
    VarAsignatura ObjAsignatura = new VarAsignatura();
    /*asignaturas
        codigo_asig
        nombre_asig*/
    public void Insertar (String id, String nombre){
        int i = Integer.parseInt(id);
        try {
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql = "INSERT INTO asignaturas(codigo_asig, nombre_asig) VALUES('"+i+"','"+nombre+"');";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null,"Error en Insertar asignatura: "+e);}
    }
    //Los datos se pierden al llegar a la Clase varAsignatura
    public void Mostrar(String id){
        int i = Integer.parseInt(id);
        try {
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="SELECT * FROM asignaturas WHERE codigo_asig='"+i+"';";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                ObjAsignatura.setCodigo(rs.getString(String.valueOf("codigo_asig")));
                ObjAsignatura.setNombre(rs.getString("nombre_asig"));
                System.out.print("Codigo: "+ObjAsignatura.getCodigo()+"Nombre: "+ObjAsignatura.getNombre());
            }else{JOptionPane.showMessageDialog(null,"Verficar codigo de asignatura");}
        } catch (SQLException e) {JOptionPane.showMessageDialog(null,"Error en Mostrar asignatura: "+e);}
    }
    
    public void Actualizar (String id, String nombre){
        
        int i = Integer.parseInt(id);
        try {
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="UPDATE asignaturas SET nombre_asig='"+nombre+"' WHERE codigo_asig='"+i+"';";
            st.executeUpdate(sql);
            st.close();
            conexion.close(); 
        } catch (SQLException e) {JOptionPane.showMessageDialog(null,"Error en Actualizar asignatura: "+e);}
    }
    
    public void Eliminar (String id){
        int i = Integer.parseInt(id);
        try {
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql= "DELETE FROM asignaturas WHERE codigo_asig='"+i+"';";
            st.executeQuery(sql);
            st.close();
            conexion.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null,"Error en Eliminar asignatura: "+e);}
    }
}