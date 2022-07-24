package Model;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author margarita forero
 */
public class mdlCliente {

    DbData dbData;

    public mdlCliente() {
        this.dbData = new DbData();
    }

    public Cliente consultarCliente(int tipoDocumento, long documento) {
        ResultSet rs = null;
        Cliente cliente = null;
        PreparedStatement pStatament = null;
        try {
            Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword());
            String query = "SELECT * FROM tb_cliente WHERE tipodocumento=" + tipoDocumento + " and documento=" + Long.toString(documento);
            pStatament = conn.prepareStatement(query);
            rs = pStatament.executeQuery();
            rs.next();
            if (rs.getRow() >= 1){
                cliente = new Cliente(rs.getInt("id"),
                            tipoDocumento,documento,
                            rs.getString("nombre"), 
                            rs.getString("apellidos"), 
                            rs.getString("direccion"),
                            rs.getInt("celular"),
                            rs.getString("email"));
                return cliente;
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("SQLException : " + e.getMessage());
            System.out.println("SQLState : " + e.getSQLState());
            System.out.println("Error : " + e.getErrorCode());
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : " + e.getMessage());
                }
            }
            if (pStatament != null) {
                try {
                    pStatament.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : " + e.getMessage());
                }
            }
        }
    }
    
    public boolean registrarCliente(Cliente cliente){
        PreparedStatement pStatament = null;
        try {
            Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword());
            String query = "INSERT INTO tb_cliente (documento,tipodocumento,nombre,direccion,email,celular) VALUES (?,?,?,?,?,?)";
            pStatament = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatament.setLong(1, cliente.getDocumento());
            pStatament.setInt(2, cliente.getTipoDocumento());
            pStatament.setString(3, cliente.getNombre());
            pStatament.setString(4, cliente.getDireccion());
            pStatament.setString(5, cliente.getEmail());
            pStatament.setInt(6, cliente.getCelular());
            int rowsInserted = pStatament.executeUpdate();
            ResultSet generetedKeys = pStatament.getGeneratedKeys();
            generetedKeys.next();
            long idCliente = generetedKeys.getLong(1);
            cliente.setId(idCliente);
            return rowsInserted > 0;
            
           
        } catch (SQLException e) {
            System.out.println("SQLException : " + e.getMessage());
            System.out.println("SQLState : " + e.getSQLState());
            System.out.println("Error : " + e.getErrorCode());
            return false;
        } finally {
             if (pStatament != null) {
                try {
                    pStatament.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : " + e.getMessage());
                }
            }
        }
        
    }

}
