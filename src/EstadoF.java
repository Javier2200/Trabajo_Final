import java.sql.*;
import conexion.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class EstadoF extends EstadoAPP.EstadoPOA{
    
    private ORB orb;
    Conexion conex2 = new Conexion();
    
    @Override
    public boolean insertarEstado(int id, String nombre) {
        boolean resultado = false;
        try {
            String query = "insert into estado(id,nombre)" + "values "
                    + "('"+id+"','"+nombre+"')";
            
           conex2.conexion();
           Statement st = conex2.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex2.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarEstadoa(int id) {
        String resultado = "" ;
        try {
            String query = "Select * from estado WHERE id =" + id;
            conex2.conexion();
            Statement st = conex2.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1)+ " - "
                         + rs.getString(2) + "\n";
            }
            st.close();
            conex2.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
      
      return resultado;
    }

    @Override
    public boolean eliminarEstado(int id) {
        boolean resultado = false;
        try {
            String query = "Delete from estado WHERE id =" + id;
            
           conex2.conexion();
           Statement st = conex2.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex2.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarEstado(int id, String nombre) {
        boolean resultado = false;
        try {
            String query = "update estado set nombre = '"+nombre+"' "
                    + "WHERE id = " +id;
            
           conex2.conexion();
           Statement st = conex2.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex2.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarEstado() {
        
        String resultado = "" ;
        try {
            String query = "Select * from estado";
            conex2.conexion();
            Statement st = conex2.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1)+ " - "
                         + rs.getString(2) + "\n";
            }
            st.close();
            conex2.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
      
      return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ResultSet cargarTablaEstado(){
    
        ResultSet resultado = null;
        
        try {
            String query = "Select id, nombre from estado";
            conex2.conexion();
            Statement st = conex2.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error"+e.getMessage());
        }

        return resultado;
    }
    
}
