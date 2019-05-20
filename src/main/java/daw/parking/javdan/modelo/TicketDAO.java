

package daw.parking.javdan.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements ITicket {

       private Connection con = null;

    public TicketDAO() {
        con = Conexion.getInstance();
    }
    
    
    @Override
    public List<TicketVO> getAll() throws SQLException {
        
           List<TicketVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Ticket");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                TicketVO t= new TicketVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                t.setCodPlaza(res.getInt("codplaza"));
                t.setCodTicket(res.getInt("codticket"));
                t.setFecIngreso(res.);
                t.setCosteEstancia(res.getInt("costeestancia"));
                t.setFecSalida(res.);
                t.setMatricula(res.getString("matricula"));
                t.setPin(res.getInt("pin"));
                t.setTipoVehi(res.getInt("tipovehiculo"));
                t.setMatricula(res.getString("matricula"));

                //Añadimos el objeto a la lista
                lista.add(t);
            }
        }

        return lista;
    }

    @Override
    public TicketVO findByCod(int codticket) throws SQLException {
        
        ResultSet res = null;
        TicketVO t = new TicketVO();

        String sql = "select * from Ticket where pk=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, codticket);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.first()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                  t.setCodPlaza(res.getInt("codplaza"));
                  t.setCodTicket(res.getInt("codticket"));
                  t.setFecIngreso(res.);
                  t.setCosteEstancia(res.getInt("costeestancia"));
                  t.setFecSalida(res.);
                  t.setMatricula(res.getString("matricula"));
                  t.setPin(res.getInt("pin"));
                  t.setTipoVehi(res.getInt("tipovehiculo"));
                  t.setMatricula(res.getString("matricula"));
                return t;
            }

            return null;
        }
        
    }

    @Override
    public int insertTicket(TicketVO ticket) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertTicket(List<TicketVO> lista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteTicket(TicketVO t) throws SQLException {
       
        
        
    }

    @Override
    public int deleteTicket() throws SQLException {
       
    }

    @Override
    public int updateTicket(int codticket, TicketVO nuevosDatos) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
