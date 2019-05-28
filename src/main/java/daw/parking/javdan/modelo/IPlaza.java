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
public interface IPlaza {
    
     // Método para obtener todos los registros de la tabla
    List<PlazaVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    PlazaVO findByCod(int codplaz) throws SQLException;
    
    // Método para insertar un registro
    int insertPlaza (PlazaVO plaza) throws SQLException;
    
    // Método para insertar varios registros
    int insertPlaza (List<PlazaVO> lista) throws SQLException;
    
    // Método para borrar una plaza
    int deletePlaza (PlazaVO p) throws SQLException;
    
    // Método para borrar toda la tabla
    int deletePlaza() throws SQLException;
    
    // Método para modificar una plaza
    int updatePlaza (int codpla, PlazaVO nuevosDatos) throws SQLException;
    
}

