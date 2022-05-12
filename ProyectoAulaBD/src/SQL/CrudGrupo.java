/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import GetSet.*; 
import java.sql.ResultSet;
/**
 *
 * @author Bladimir
 */
public class CrudGrupo {
    ConexionSQL con = new ConexionSQL();
    public void insertar (String id,String nombre, String id_docente){

            try{
                
                int i = Integer.parseInt(id);
                int e = Integer.parseInt(id_docente);
                //Conecta db
                Connection conexion = con.conectar();
                //Prepara la sentencia sql 
                Statement st = conexion.createStatement();
                //Sentencia SQL
                String sql = "INSERT INTO grupo (id_grupo,nombre_grupo,id_docentes) VALUES('"+i+"'+'"+nombre+"'+'"+e+"');";
                st.execute(sql);
                st.close();
                conexion.close();
                JOptionPane.showMessageDialog(null, "Grupo Crado");

            }
            catch(SQLException e){
                //System.err.println("Error en Insertar Estudiante" +e);
                JOptionPane.showMessageDialog(null, "Error en Insertar grupo" +e);
            }
    }
    
     public void MostrarEstudiante (String id){
        VarGrupo objVarGrupo= new VarGrupo();
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
            String sql = "SELECT * FROM grupo WHERE id_grupos ='"+i+"';";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                
                objVarGrupo.setId(rs.getString(String.valueOf("id_grupo")));
                objVarGrupo.setNombre(rs.getString("nombre_grupo"));
                objVarGrupo.setId_docente(rs.getString(String.valueOf("id_docentes")));
            }else{JOptionPane.showMessageDialog(null, "No existe Estudiante, revisar codigo");}
            conexion.close();
            st.close();
        
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en Mostrar grupo: "+ e);
        
        }
    }
    
    public void ActualizarEstudiante(String id,String nombre, String id_docente){
         
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
            int i = Integer.parseInt(id);
            int e = Integer.parseInt(id_docente);
            String sql = "UPDATE grupo SET nombre_grupo='"+nombre+"', id_docentes='"+e+"' WHERE id_est='"+i+"';";
            st.executeUpdate(sql);
            conexion.close();
            st.close();
         }
         catch(SQLException e){JOptionPane.showMessageDialog(null,"Error en Actualizar grupo: "+ e);}
    }

    public void EliminarEstudiante(String id){
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
             if(i>0){
                String sql = "DELETE FROM grupo WHERE id_est='"+i+"';";
                st.executeQuery(sql);
             }
             st.close();
             conexion.close();
        }
        catch(SQLException e){JOptionPane.showMessageDialog(null,"Error en Eliminar grupo: "+e);}
    }
    
}
