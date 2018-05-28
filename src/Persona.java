import java.sql.*;
import conexion.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Persona extends PersonaAPP.PersonaPOA{
    
    private ORB orb;
    Conexion conex = new Conexion();
    
    @Override
    public boolean insertarPersona(int identificacion, String nombre, String apellido, int edad, String genero, String estado) {
        
        boolean resultado = false;
        try {
            String query = "insert into persona(identificacion,nombre,apellido,edad,genero,estado)" + "values "
                    + "('"+identificacion+"','"+nombre+"','"+apellido+"','"+edad+"','"+genero+"','"+estado+"')";
            
           conex.conexion();
           Statement st = conex.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarPersona(int identificacion) {
        
        String resultado = "" ;
        try {
            String query = "Select * from persona WHERE identificacion =" + identificacion;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1)+ " - "
                         + rs.getString(2)+ " - "
                         + rs.getString(3)+ " - "
                         + rs.getLong(4)+ " - "
                         + rs.getString (5)+ " - "
                         + rs.getString(6) + "\n";
            }
            st.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
      
      return resultado;
    }

    @Override
    public boolean eliminarPersona(int identificacion) {
        
        boolean resultado = false;
        try {
            String query = "Delete from persona WHERE identificacion =" + identificacion;
            
           conex.conexion();
           Statement st = conex.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarPersona(int identificacion, String nombre, String apellido, int edad, String genero, String estado) {
        
        boolean resultado = false;
        try {
            String query = "update persona set nombre = '"+nombre+"' , apellido = '"+apellido+"' , edad = '"+edad+"' , genero = '"+genero+"' , estado = '"+estado+"' "
                    + "WHERE identificacion = " +identificacion;
            
           conex.conexion();
           Statement st = conex.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarPersona() {
        
        String resultado = "" ;
        try {
            String query = "Select * from persona";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1)+ " - "
                         + rs.getString(2)+ " - "
                         + rs.getString(3)+ " - "
                         + rs.getLong(4)+ " - "
                         + rs.getString(5)+ " - "
                         + rs.getString(6) + "\n";
            }
            st.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
      
      return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet listaEstados(){
    
        ResultSet resultado = null;
        
        try {
            String query = "Select id, nombre from estado";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
        
        
        return resultado;
    }
    
    public ResultSet cargarTablaPersona(){
    
        ResultSet resultado = null;
        
        try {
            String query = "Select identificacion, nombre, apellido from persona";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error"+e.getMessage());
        }

        return resultado;
    }
    
    public ResultSet cargarTablaGenero(){
    
        ResultSet resultado = null;
        
        try {
            String query = "Select id, nombre from genero";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error"+e.getMessage());
        }

        return resultado;
    }
    
}
