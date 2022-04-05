
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
                //Conecta db
                Connection conexion = con.conectar();
                //Prepara la sentencia sql 
                Statement st = conexion.createStatement();
                //Sentencia SQL
                String sql = "INSERT INTO estudiantes (codigo,nombre,apellido,telefono) VALUES ('"+codigo+"','"+nombre+"','"+apellido+"','"+telefono+"');";
                st.execute(sql);
                st.close();
                JOptionPane.showMessageDialog(null, "Estudiante Agregado");

            }
            catch(Exception e){
                //System.err.println("eee");
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public void MostrarEstudiante (String id){
        
        try{
            Connection conexion = con.conectar();
            Statement st = conexion.createStatement();
             int i = Integer.parseInt(id);
            String sql = "SELECT * FROM estudiantes WHERE codigo='"+i+"';";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                
                varEstudiante.setCodigo(rs.getString("codigo"));
                varEstudiante.setNombre(rs.getString("nombre"));
                varEstudiante.setApellido(rs.getString("apellido"));
                varEstudiante.setTelefono(rs.getString("telefono"));
                System.out.print(varEstudiante.getCodigo()+"\t");
                System.out.print(varEstudiante.getNombre());
                System.out.print(varEstudiante.getApellido());
                System.out.print(varEstudiante.getTelefono()+"\n");
            }else
                JOptionPane.showMessageDialog(null, "No existe Estudiante, revisar codigo");
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    }
}
