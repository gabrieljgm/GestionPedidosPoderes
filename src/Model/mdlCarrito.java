package Model;

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
public class mdlCarrito {

    DbData dbData;

    public mdlCarrito() {
        this.dbData = new DbData();
    }

    public boolean registrarCarrito(long clienteId) {
        PreparedStatement pStatament = null;
        try {
            Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword());
            String query = "INSERT INTO tb_carritocompra (tb_cliente_id) VALUES (?)";
            pStatament = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatament.setLong(1, clienteId);
            int rowsInserted = pStatament.executeUpdate();
            ResultSet generetedKeys = pStatament.getGeneratedKeys();
            generetedKeys.next();
            long idCarrito = generetedKeys.getLong(1);
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
