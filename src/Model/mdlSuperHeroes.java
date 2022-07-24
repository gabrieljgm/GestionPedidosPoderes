package Model;

import Classes.Dotacion;
import Classes.Poder;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author marga
 */
public class mdlSuperHeroes {
    
    DbData dbData;
    
    public mdlSuperHeroes(){
        this.dbData = new DbData();
    }
    
     public void AdicionarPoderCarrito(){
       
    }
    
    public void EliminarPoderCarrito(){
        
    }
    
    public  LinkedList<Poder> consultarPoderesCarrito(){
        ResultSet rs = null;
        PreparedStatement pStatament = null;
        try{
            Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword());
            String query = "SELECT * FROM tb_poder";
            pStatament = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            rs = pStatament.executeQuery();
            LinkedList<Poder> poder = new LinkedList<>();
            LinkedList<Dotacion> dotacion = new LinkedList<>();
            dotacion.add(new Dotacion("Capa", "Azul"));
            dotacion.add(new Dotacion("Capa", "Roja"));
            while (rs.next()) {
                poder.add(new Poder(rs.getLong("id"),rs.getString("nombre"),
                              rs.getDouble("precio"),
                              rs.getInt("duracion"),
                              rs.getString("imagen"),dotacion));
            }
            return poder;
            
                   
        }catch(SQLException e){
            System.out.println("SQLException : "+e.getMessage());
            System.out.println("SQLState : "+e.getSQLState());
            System.out.println("Error : "+e.getErrorCode());
            return null;
        }
        finally{
            if (rs != null){
                try {
                     rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : "+e.getMessage());
                }
            }
            if (pStatament != null){
                try {
                     pStatament.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : "+e.getMessage());
                }
            }
        }       
    }
    
}
