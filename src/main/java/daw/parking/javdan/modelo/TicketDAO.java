

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
            ResultSet res = st.executeQuery("select * from tickets");
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
                t.setTipoVehi(res.getInt("tipovehi"));

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

        String sql = "select * from tickets where codticket=?";

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
                  t.setTipoVehi(res.getInt("tipovehi"));
                  t.setMatricula(res.getString("matricula"));
                return t;
            }

            return null;
        }
        
    }

    @Override
    public int insertTicket(TicketVO ticket) throws SQLException {
       
        int numFilas = 0;
        String sql = "insert into tickets values (?,?,?,?,?,?,?,?)";

        if (findByCod(ticket.getCodTicket()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1,ticket.getCodPlaza());
                prest.setInt(2,ticket.getCodTicket() );
                prest.setDouble(3,ticket.getCosteEstancia());
                prest.setInt(4,ticket.getPin());
                prest.setString(5,ticket.getFecIngreso());
                prest.setDate(6,ticket.getFecSalida() );
                prest.setString(7,ticket.getMatricula());  
                prest.setInt(8,ticket.getTipoVehi() ); 

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }

    @Override
    public int insertTicket(List<TicketVO> lista) throws SQLException {
           
        int numFilas = 0;

        for (TicketVO tmp : lista) {
            numFilas += insertTicket(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteTicket(TicketVO t) throws SQLException {
       
        int numFilas = 0;

        String sql = "delete from tickets where codticket = ?";

        
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, t.getCodTicket());

            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
        
    }

    @Override
    public int deleteTicket() throws SQLException {
       
          String sql = "delete from tickets";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;
        
    }

    @Override
    public int updateTicket(int codTicket, TicketVO nuevosDatos) throws SQLException {
       
        int numFilas = 0;
        String sql = "update tickets set matricula = ?,codplaza = ?, costeEstancia = ?, "
                + "pin = ?, fecIngreso = ?, fecSalida = ?, tipovehi = ? where codticket=?";

        if (findByCod(codTicket) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1,nuevosDatos.getCodPlaza());
                prest.setInt(2,nuevosDatos.getCodTicket() );
                prest.setDouble(3,nuevosDatos.getCosteEstancia());
                prest.setInt(4,nuevosDatos.getPin());
                prest.setString(5,nuevosDatos.getFecIngreso());
                prest.setDate(6,nuevosDatos.getFecSalida() );
                prest.setString(7,nuevosDatos.getMatricula());  
                prest.setInt(8,nuevosDatos.getTipoVehi() );                         

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }
   
    
    
}