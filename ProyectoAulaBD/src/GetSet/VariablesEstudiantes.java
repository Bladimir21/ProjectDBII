/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GetSet;

/**
 *
 * @author Bladimir
 */
//Las variables se pierden en al usar el get
public class VariablesEstudiantes {
    private String codigo,nombre,apellido,telefono,direccion,acudiente,telAcudiente;

    public String getCodigo() {
        //System.out.println("codigo: "+codigo);
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        //System.out.println("codigo: "+codigo);
    }

    public String getNombre() {
        //System.out.println("codigo: "+nombre);
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        //System.out.println("codigo: "+nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public String getTelAcudiente() {
        return telAcudiente;
    }

    public void setTelAcudiente(String telAcudiente) {
        this.telAcudiente = telAcudiente;
    }
 
}