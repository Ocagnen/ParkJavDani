
package daw.parking.javdan.modelo;

import java.sql.SQLException;
import java.util.List;


public interface ITicket {
    
    // Método para obtener todos los registros de la tabla
    List<TicketVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    TicketVO findByCod(int codticket) throws SQLException;
    
    // Método para insertar un registro
    int insertTicket (TicketVO ticket) throws SQLException;
    
    // Método para insertar varios registros
    int insertTicket (List<TicketVO> lista) throws SQLException;
    
    // Método para borrar un ticket
    int deleteTicket (TicketVO t) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteTicket() throws SQLException;
    
    // Método para modificar un ticket
    int updateTicket (int codticket, TicketVO nuevosDatos) throws SQLException;
    
}