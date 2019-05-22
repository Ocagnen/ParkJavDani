
package daw.parking.javdan.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public interface IDetalleAbonado {
    
     // Método para obtener todos los registros de la tabla
    List<DetalleAbonadoVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    DetalleAbonadoVO findByCod(int matricula, int codplaz, LocalDate fecIniabono) throws SQLException;
    
    // Método para insertar un registro
    int insertDetAb (DetalleAbonadoVO detalleAbonado) throws SQLException;
    
    // Método para insertar varios registros
    int insertDetAb (List<DetalleAbonadoVO> lista) throws SQLException;
    
    // Método para borrar una persona
    int deleteDetAb (DetalleAbonadoVO d) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteDetAb() throws SQLException;
    
    // Método para modificar un abonado
    int updateDetAb (int matricula, int codplaz, LocalDate fecIniabono, DetalleAbonadoVO nuevosDatos) throws SQLException;
    
}

    

