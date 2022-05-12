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
    ConexionSQL con = new ConexionSQL();
    
     public void insertar (String nota1,String nota2, String evaluacion, String id_estudiante, String id_docente){

            try{
                
                int i = Integer.parseInt(id_estudiante);
                int e = Integer.parseInt(id_docente);
                //Conecta db
                Connection conexion = con.conectar();
                //Prepara la sentencia sql 
                Statement st = conexion.createStatement();
                //Sentencia SQL
                String sql = "INSERT INTO calificacion (nota1_calificacion,nota2_calificacion,evaluacion_calificacion,id_est,id_doc) VALUES ('"+nota1+"','"+nota2+"','"+evaluacion+"','"+i+"','"+e+"');";
                st.execute(sql);
                st.close();
                conexion.close();
                JOptionPane.showMessageDialog(null, "Calificacion Agregada");

            }
            catch(SQLException e){
                //System.err.println("Error en Insertar Estudiante" +e);
                JOptionPane.showMessageDialog(null, "Error en Insertar Calificacion" +e);
            }
    }
    
    public List Mostrar(){
        List<VarCalificacion> datos = new ArrayList<>();
        
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
    
     public void EliminarEstudiante(String id){
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
             if(i>0){
                String sql = "DELETE FROM calificacion WHERE id_calificacion='"+i+"';";
                st.executeQuery(sql);
             }
             st.close();
             conexion.close();
        }
        catch(SQLException e){JOptionPane.showMessageDialog(null,"Error en Eliminar Calificacion: "+e);}
    }
}
