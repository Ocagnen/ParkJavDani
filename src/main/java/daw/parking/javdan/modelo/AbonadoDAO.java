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
                abonado.setMatricula(res.getString("matricula"));
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
        
        int numFilas = 0;
        String sql = "insert into abonados values (?,?,?,?,?,?,?)";

        if (findByCod(abonado.getMatricula()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, abonado.getMatricula());
                prest.setString(2, abonado.getDni());
                prest.setString(3, abonado.getNombre());
                prest.setString(4, abonado.getApellidos());
                prest.setString(5, abonado.getNumeroTarjeta());
                prest.setString(6, abonado.getEmail());
                prest.setInt(7, abonado.getPin());                

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    @Override
    public int insertAbonado(List<AbonadoVO> lista) throws SQLException {
         int numFilas = 0;

        for (AbonadoVO tmp : lista) {
            numFilas += insertAbonado(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteAbonado(AbonadoVO abonado) throws SQLException {

        int numFilas = 0;

        String sql = "delete from abonados where matricula = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setString(1, abonado.getMatricula());

            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;

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
    public int updateAbonado(String codabo, AbonadoVO nuevosDatos) throws SQLException {
        
        int numFilas = 0;
        String sql = "update abonados set dni = ?, nombre = ?, apellidos = ?, "
                + "numerotarjeta = ?, email = ?, pin = ? where matricula=?";

        if (findByCod(codabo) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, nuevosDatos.getDni());
                prest.setString(2, nuevosDatos.getNombre());
                prest.setString(3, nuevosDatos.getApellidos());
                prest.setString(4, nuevosDatos.getNumeroTarjeta());
                prest.setString(5, nuevosDatos.getEmail());
                prest.setInt(6, nuevosDatos.getPin());
                prest.setString(7, nuevosDatos.getMatricula());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

}
