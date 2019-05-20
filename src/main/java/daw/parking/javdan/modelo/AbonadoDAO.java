/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.parking.javdan.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class AbonadoDAO implements IAbonado {

    private Connection con = null;

    public AbonadoDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<AbonadoVO> getAll() throws SQLException {
        List<AbonadoVO> lista = new ArrayList<>();

        try (Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from abonados");

            while (res.next()) {
                AbonadoVO a = new AbonadoVO();

                a.setMatricula(res.getString("matricula"));
                a.setDni(res.getString("dni"));
                a.setNombre(res.getString("nombre"));
                a.setApellidos(res.getString("apellidos"));
                a.setNumeroTarjeta(res.getString("numerotarjeta"));
                a.setEmail(res.getString("email"));
                a.setPin(res.getInt("pin"));
                
                //Añadimos el objeto a la lista
                lista.add(a);
            }
        }

        return lista;
    }

    @Override
    public AbonadoVO findByCod(String codabo) throws SQLException {
        
        ResultSet res = null;
        AbonadoVO abonado = new AbonadoVO();

        String sql = "select * from abonados where matricula=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setString(1, codabo);            

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.first()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                
                abonado.setDni(res.getString("dni"));
                abonado.setNombre(res.getString("nombre"));
                abonado.setApellidos(res.getString("apellidos"));
                abonado.setNumeroTarjeta(res.getString("numerotarjeta"));
                abonado.setEmail(res.getString("email"));
                abonado.setPin(res.getInt("pin"));
                
                return abonado;
            }

            return null;
        }
        
    }

    @Override
    public int insertAbonado(AbonadoVO abonado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertAbonado(List<AbonadoVO> lista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteAbonado(AbonadoVO abonado) throws SQLException {
        
        String sql = "delete from abonados";

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
    public int deleteAbonado() throws SQLException {
        
        String sql = "delete from abonados";

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
    public int updateAbonado(int codabo, AbonadoVO nuevosDatos) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

