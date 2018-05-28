import java.sql.*;
import conexion.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class GeneroF extends GeneroAPP.GeneroPOA{
    
    private ORB orb;
    Conexion conex3 = new Conexion();
    
    @Override
    public boolean insertarGenero(int id, String nombre) {
        boolean resultado = false;
        try {
            String query = "insert into genero(id,nombre)" + "values "
                    + "('"+id+"','"+nombre+"')";
            
           conex3.conexion();
           Statement st = conex3.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex3.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarGenero(int id) {
        String resultado = "" ;
        try {
            String query = "Select * from genero WHERE id =" + id;
            conex3.conexion();
            Statement st = conex3.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1)+ " - "
                         + rs.getString(2) + "\n";
            }
            st.close();
            conex3.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
      
      return resultado;
    }

    @Override
    public boolean eliminarGenero(int id) {
        boolean resultado = false;
        try {
            String query = "Delete from genero WHERE id =" + id;
            
           conex3.conexion();
           Statement st = conex3.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex3.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarGenero(int id, String nombre) {
        boolean resultado = false;
        try {
            String query = "update genero set nombre = '"+nombre+"' "
                    + "WHERE id = " +id;
            
           conex3.conexion();
           Statement st = conex3.conex.createStatement();
           int valor = st.executeUpdate(query);
           if(valor > 0){
               resultado = true;
           }
               //Cerramos los recursos.
           st.close();
           conex3.conex.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarGenero() {
        String resultado = "" ;
        try {
            String query = "Select * from genero";
            conex3.conexion();
            Statement st = conex3.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(1)+ " - "
                         + rs.getString(2) + "\n";
            }
            st.close();
            conex3.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
      
      return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTablaGenero(){
    
        ResultSet resultado = null;
        
        try {
            String query = "Select id, nombre from genero";
            conex3.conexion();
            Statement st = conex3.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error"+e.getMessage());
        }

        return resultado;
    }
}
