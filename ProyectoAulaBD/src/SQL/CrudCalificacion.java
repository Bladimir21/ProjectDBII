/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;


import GetSet.VarCalificacion;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Bladimir
 */
public class CrudCalificacion {
    public List Mostrar(){
        List<VarCalificacion> datos = new ArrayList<>();
        ConexionSQL con = new ConexionSQL();
        try {
            
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            String sql ="SELECT * FROM vista_calificacion;";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                VarCalificacion calificacion = new VarCalificacion();
                
                calificacion.setDocumentoEst(rs.getString(1));
                calificacion.setAsignatura(rs.getString(2));
                calificacion.setNombreDocente(rs.getString(3));
                calificacion.setApellidoDocente(rs.getString(4));
                calificacion.setNota1(rs.getString(5));
                calificacion.setNota2(rs.getString(6));
                calificacion.setEvaluacion(rs.getString(7));
                datos.add(calificacion);
            }
            JOptionPane.showMessageDialog(null,"Funciona :D");
        } catch (SQLException e) {JOptionPane.showMessageDialog(null,"Error en Mostrar calificacion: "+e);}
        return datos;
    }
}
