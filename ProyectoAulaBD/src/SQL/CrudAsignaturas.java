/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;
import GetSet.VarAsignatura;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

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
    public List Mostrar(){
        //int i = Integer.parseInt(id);
        List<VarAsignatura> datos = new ArrayList<>();
        try {
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="SELECT codigo_asig, nombre_asig, nombre_doc, apellido_doc FROM vista_asignatura ORDER BY codigo_asig ASC ;";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                //Creacion de instancia de VarAsignatura
                VarAsignatura asignatura = new VarAsignatura();
                asignatura.setCodigo(rs.getString(1));
                asignatura.setNombre(rs.getString(2));
                asignatura.setDocenteNombre(rs.getString(3));
                asignatura.setDocenteApellido(rs.getString(4));
                datos.add(asignatura);
            }
        } catch (SQLException e) {JOptionPane.showMessageDialog(null,"Error en Mostrar asignatura: "+e);}
        return datos;
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