
package SQL;
import java.sql.*;
import javax.swing.JOptionPane;
import GetSet.*;
import Vista.frmEstudiantes;

public class CrudSQL {
    //Se crea un objeto de la clase ConexionSQL el cual permite abrir la conexion con la base de datos
ConexionSQL con = new ConexionSQL();
VariablesEstudiantes varEstudiante = new VariablesEstudiantes();
    /*estudiantes
    id_est
    nombre_est
    apellido_est
    telefono_est
    acudiente_est
    telAcudiente_est
    -fechaNac_est
    direccion_est*/

//Funcion de insertar datos a la DB
    //Sin fecha de nacimiento del estudiante
    public void insertarEstudiante (String id,String nombre, String apellido, String telefono, String acudiente, String telAcudiente, String direccion, String grupo){

            try{
                
                int i = Integer.parseInt(id);
                //Conecta db
                Connection conexion = con.conectar();
                //Prepara la sentencia sql 
                Statement st = conexion.createStatement();
                //Sentencia SQL
                String sql = "INSERT INTO estudiantes (id_est,nombre_est, apellido_est, telefono_est, acudiente_est, telacudiente_est, direccion_est, id_grupo) VALUES ('"+i+"','"+nombre+"','"+apellido+"','"+telefono+"','"+acudiente+"','"+telAcudiente+"','"+direccion+"','"+grupo+"');";
                st.execute(sql);
                st.close();
                conexion.close();
                JOptionPane.showMessageDialog(null, "Estudiante Agregado");

            }
            catch(SQLException e){
                //System.err.println("Error en Insertar Estudiante" +e);
                JOptionPane.showMessageDialog(null, "Error en Insertar Estudiante" +e);
            }
    }
    /*
    public void MostrarEstudiante (String id){
        
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
            String sql = "SELECT * FROM estudiantes WHERE id_est='"+id+"';";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                
                varEstudiante.setCodigo(rs.getString("id_est"));
                varEstudiante.setNombre(rs.getString("nombre_est"));
                varEstudiante.setApellido(rs.getString("apellido_est"));
                varEstudiante.setTelefono(rs.getString("telefono_est"));
                varEstudiante.setAcudiente(rs.getString("acudiente_est"));
                varEstudiante.setTelAcudiente(rs.getString("telAcudiente_est"));
                varEstudiante.setDireccion(rs.getString("direccion_est"));
               
                System.out.println("C: "+varEstudiante.getCodigo()+"Nom: "+varEstudiante.getNombre()+"Ape: "+varEstudiante.getApellido()+"Faltan");
            }else{JOptionPane.showMessageDialog(null, "No existe Estudiante, revisar codigo");}
            conexion.close();
            st.close();
        
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en Mostrar estudiante: "+ e);
        
        }
    }*/
    
    public void ActualizarEstudiante(String id,String nombre, String apellido, String telefono, String acudiente, String telAcudiente, String direccion,String grupo) {
         
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
            
            String sql = "UPDATE estudiantes SET nombre_est='"+nombre+"', apellido_est='"+apellido+"', telefono_est='"+telefono+"', "
                    + "acudiente_est='"+acudiente+"', telacudiente_est='"+telAcudiente+"', direccion_est='"+direccion+"', id_grupo='"+grupo+"' WHERE id_est='"+i+"';";
            st.executeUpdate(sql);
            conexion.close();
            st.close();
         }
         catch(SQLException e){JOptionPane.showMessageDialog(null,"Error en Actualizar estudiante: "+ e);}
    }

    public void EliminarEstudiante(String id){
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
             if(i>0){
                String sql = "DELETE FROM estudiantes WHERE id_est='"+i+"';";
                st.executeQuery(sql);
             }
             st.close();
             conexion.close();
        }
        catch(SQLException e){JOptionPane.showMessageDialog(null,"Error en Eliminar Estudiante: "+e);}
    }
}
