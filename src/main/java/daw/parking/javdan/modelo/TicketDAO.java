package daw.parking.javdan.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
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

        try (Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from tickets");

            while (res.next()) {

                TicketVO t = new TicketVO();

                t.setCodTicket(res.getInt("codticket"));
                t.setTipoVehi(res.getInt("tipovehi"));
                t.setMatricula(res.getString("matricula"));
                t.setCodPlaza(res.getInt("codplaza"));
                t.setFecIngreso(res.getDate("fecingreso").toLocalDate());
                t.setFecSalida(res.getDate("fecsalida").toLocalDate());
                t.setHoraIngreso(res.getTime("horaingreso").toLocalTime());
                t.setHoraSalida(res.getTime("horasalida").toLocalTime());
                t.setPin(res.getInt("pin"));
                t.setCosteEstancia(res.getDouble("costeestancia"));

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

            prest.setInt(1, codticket);

            res = prest.executeQuery();

            if (res.first()) {

                t.setTipoVehi(res.getInt("tipovehi"));
                t.setMatricula(res.getString("matricula"));
                t.setCodPlaza(res.getInt("codplaza"));
                t.setFecIngreso(res.getDate("fecingreso").toLocalDate());
                t.setFecSalida(res.getDate("fecsalida").toLocalDate());
                t.setHoraIngreso(res.getTime("horaingreso").toLocalTime());
                t.setHoraSalida(res.getTime("horasalida").toLocalTime());
                t.setPin(res.getInt("pin"));
                t.setCosteEstancia(res.getDouble("costeestancia"));

                return t;
            }

            return null;
        }

    }

    @Override
    public int insertTicket(TicketVO ticket) throws SQLException {

        int numFilas = 0;
        String sql = "insert into tickets values (?,?,?,?,?,?,?,?,?,?)";

        if (findByCod(ticket.getCodTicket()) != null) {

            return numFilas;

        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1,ticket.getCodTicket());
                prest.setInt(2, ticket.getTipoVehi());
                prest.setString(3, ticket.getMatricula());
                prest.setInt(4, ticket.getCodPlaza());
                prest.setDate(5,Date.valueOf(ticket.getFecIngreso()));
                prest.setDate(6,Date.valueOf(ticket.getFecSalida()));
                prest.setTime(7, Time.valueOf(ticket.getHoraIngreso()));
                prest.setTime(8, Time.valueOf(ticket.getHoraSalida()));
                prest.setInt(9, ticket.getPin());
                prest.setDouble(10, ticket.getCosteEstancia());              

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
        String sql = "update tickets set tipovehi = ?, matricula = ?,codplaza = ?,"
                + "fecingreso=?, fecsalida=?, horaingreso = ?, horasalida=?,"                
                + "pin = ?, costeestancia=? where codticket=?";

        if (findByCod(codTicket) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {
                
                prest.setInt(1, nuevosDatos.getTipoVehi());
                prest.setString(2, nuevosDatos.getMatricula());
                prest.setInt(3, nuevosDatos.getCodPlaza());
                prest.setDate(4, Date.valueOf(nuevosDatos.getFecIngreso()));
                prest.setDate(5, Date.valueOf(nuevosDatos.getFecSalida()));
                prest.setTime(6, Time.valueOf(nuevosDatos.getHoraIngreso()));
                prest.setTime(7, Time.valueOf(nuevosDatos.getHoraSalida()));
                prest.setInt(8, nuevosDatos.getPin());
                prest.setDouble(9, nuevosDatos.getCosteEstancia());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

}
