/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.parking.javdan.modelo;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javier
 */
public interface IAbonado {
    
     // Método para obtener todos los registros de la tabla
    List<AbonadoVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    AbonadoVO findByCod(String codabo) throws SQLException;
    
    // Método para insertar un registro
    int insertAbonado (AbonadoVO abonado) throws SQLException;
    
    // Método para insertar varios registros
    int insertAbonado (List<AbonadoVO> lista) throws SQLException;
    
    // Método para borrar un aboando
    int deleteAbonado (AbonadoVO p) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteAbonado() throws SQLException;
    
    // Método para modificar un abonado
    int updateAbonado (String codabo, AbonadoVO nuevosDatos) throws SQLException;
    
}
