/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import GetSet.VarDocentes;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bladimir
 */
public class CrudDocentes {
    ConexionSQL con = new ConexionSQL();
    VarDocentes ObjDocente = new VarDocentes();
    //Falta agregar Asignatura dictada por el docente
    public void InsertarDocente1(String id, String nombre, String apellido, String telefono, String direccion){
        
        try {
            int i = Integer.parseInt(id);
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            /*docentes
                id_doc
                nombre_doc
                apellido_doc
                telefono_doc
                direccion_doc*/
            String sql = "INSERT INTO docentes (id_doc, nombre_doc , apellido_doc, telefono_doc, direccion_doc) VALUES ('"+i+"','"+nombre+"','"+apellido+"','"+telefono+"','"+direccion+"');";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Error en Insertar Docente 1: "+e);}
    }
    
    public void InsertarDocente2(String id, String nombre, String apellido, String telefono, String direccion,String asignatura){
        
        try {
            int i = Integer.parseInt(id);
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            /*docentes
                id_doc
                nombre_doc
                apellido_doc
                telefono_doc
                direccion_doc*/
            String sql = "INSERT INTO docentes (id_doc, nombre_doc , apellido_doc, telefono_doc, direccion_doc, codigo_asig) VALUES ('"+i+"','"+nombre+"','"+apellido+"','"+telefono+"','"+direccion+"','"+asignatura+"');";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Error en Insertar Docente 2: "+e);}
    }
    public void Mostrar(String id){
        
        int i = Integer.parseInt(id);
        try {
            
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="SELECT * FROM docentes WHERE id_doc='"+i+"' ORDER BY id_doc ASC;";
            ResultSet rs = st.executeQuery(sql);
            ArrayList<VarDocentes> datos = new ArrayList<>();
            while (rs.next()){
                ObjDocente.setCc(rs.getString(String.valueOf("id_doc")));
                ObjDocente.setNombre(rs.getString("nombre_doc"));
                ObjDocente.setApellido(rs.getString("apellido_doc"));
                ObjDocente.setDireccion("direccion_Doc");
                ObjDocente.setTelefono(rs.getString("telefono_doc"));
                datos.add(ObjDocente);
            }
            conexion.close();
            st.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "No existe Docente, revisar codigo: "+e);}
    }
    public void Actualizar(String id, String nombre, String apellido, String telefono, String direccion,String asignatura){
        int i = Integer.parseInt(id);
        try {
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="UPDATE docentes SET nombre_doc='"+nombre+"' ,apellido_doc='"+apellido+"', telefono_doc='"+telefono+"', direccion_doc='"+direccion+"', codigo_asig='"+asignatura+"' WHERE id_doc='"+i+"';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Error en Actualizar Docente: "+e);}
    }
    public void Eliminar (String id){
        
        int i = Integer.parseInt(id);
        try {
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="DELETE FROM docentes WHERE id_doc='"+i+"';";
            st.execute(sql);
            st.close();
            conexion.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Error en Eliminar Docente: "+e);}
    }
        
    public ArrayList<VarDocentes> Consultar (){
        ArrayList<VarDocentes> datos = new ArrayList<>();
        try {
            
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="SELECT id_doc,nombre_doc,apellido_doc,telefono_doc FROM docentes WHERE codigo_asig IS null;";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                ObjDocente.setCc(rs.getString(1));
                ObjDocente.setNombre(rs.getString(2));
                ObjDocente.setApellido(rs.getString(3));
                ObjDocente.setTelefono(rs.getString(4));
                datos.add(ObjDocente);
            }
            conexion.close();
            st.close();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "No existe Docente, sin carga academica: "+e);}
         return datos;
    }
}

