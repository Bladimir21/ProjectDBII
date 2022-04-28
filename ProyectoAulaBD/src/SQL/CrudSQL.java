
package SQL;
import java.sql.*;
import javax.swing.JOptionPane;
import GetSet.*;

public class CrudSQL {
    //Se crea un objeto de la clase ConexionSQL el cual permite abrir la conexion con la base de datos
ConexionSQL con = new ConexionSQL();
VariablesEstudiantes varEstudiante = new VariablesEstudiantes();
//Funcion de insertar datos a la DB

    public void insertarEstudiante (String codigo,String nombre, String apellido, String telefono){

            try{
                
                int i = Integer.parseInt(codigo);
                //Conecta db
                Connection conexion = con.conectar();
                //Prepara la sentencia sql 
                Statement st = conexion.createStatement();
                //Sentencia SQL
                String sql = "INSERT INTO estudiantes (codigoEst,nombreest,apellidoest,telefonoest) VALUES ('"+i+"','"+nombre+"','"+apellido+"','"+telefono+"');";
                st.execute(sql);
                st.close();
                conexion.close();
                JOptionPane.showMessageDialog(null, "Estudiante Agregado");

            }
            catch(SQLException e){
                //System.err.println("eee");
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public void MostrarEstudiante (String id){
        
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
            String sql = "SELECT * FROM estudiantes WHERE codigoEst='"+i+"';";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                
                varEstudiante.setCodigo(rs.getString("estudiantes.codigoest"));
                varEstudiante.setNombre(rs.getString("estudiantes.nombreest"));
                varEstudiante.setApellido(rs.getString("estudiantes.apellidoest"));
                varEstudiante.setTelefono(rs.getString("estudiantes.telefonoest"));
                System.out.print(varEstudiante.getCodigo()+"\t");
                System.out.print(varEstudiante.getNombre());
                System.out.print(varEstudiante.getApellido());
                System.out.print(varEstudiante.getTelefono()+"\n");
            }else
                JOptionPane.showMessageDialog(null, "No existe Estudiante, revisar codigo");
        
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    }
}
