
package daw.parking.javdan.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DetalleAbonadoDAO implements IDetalleAbonado {

       private Connection con = null;

    // Constructor por defecto
    public DetalleAbonadoDAO() {
        con = Conexion.getInstance();
    }

    // Método para obtener todos los DetAbon de la BD en una lista
    @Override
    public List<DetalleAbonadoVO> getAll() throws SQLException {
        
        
          
        List<DetalleAbonadoVO> lista = new ArrayList<>();

        try (Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from detallesAbonados");

            while (res.next()) {
                
                DetalleAbonadoVO d= new DetalleAbonadoVO();

                d.setMatricula(res.getString("matricula"));
                d.setCodPlaza(res.getInt("codplaza"));
                d.setTipoAbono(res.getInt("tipoabono"));
                d.setFecIniAbono(res.getDate("feciniabono").toLocalDate());
                d.setFecFinAbono(res.getDate("fecfinabono").toLocalDate());
               
                //Añadimos el objeto a la lista
                lista.add(d);
            }
        }

        return lista;
    }

    // Método que devuelve un objeto de la bd mediante su pk
    @Override
    public DetalleAbonadoVO findByCod(String matricula, int codplaz, LocalDate fecIniabono) throws SQLException {
        
        ResultSet res = null;
        DetalleAbonadoVO d = new DetalleAbonadoVO();

        String sql = "select * from detallesAbonados where matricula=? and feciniabono=? and codplaza=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setString(1, matricula);
            prest.setDate(2, Date.valueOf(fecIniabono));
            prest.setInt(3, codplaz);
            

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.first()) {
                d.setMatricula(res.getString("matricula"));
                d.setCodPlaza(res.getInt("codplaza"));
                d.setTipoAbono(res.getInt("tipoabono"));
                d.setFecIniAbono(res.getDate("feciniabono").toLocalDate());
                d.setFecFinAbono(res.getDate("fecfinabono").toLocalDate());                
                return d;                
            }

            return null;
        }
        
    }

    // Método para insertar DetAbonado en la bbdd
    @Override
    public int insertDetAb(DetalleAbonadoVO DetalleAbonado) throws SQLException {
        
        
        int numFilas = 0;
        String sql = "insert into detallesAbonados values (?,?,?,?,?)";

        if (findByCod(DetalleAbonado.getMatricula(),DetalleAbonado.getCodPlaza(),DetalleAbonado.getFecFinAbono()) != null ) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1,DetalleAbonado.getMatricula());
                prest.setInt(2,DetalleAbonado.getCodPlaza());                
                prest.setInt(3,DetalleAbonado.getTipoAbono());
                prest.setDate(4,Date.valueOf(DetalleAbonado.getFecIniAbono()));
                prest.setDate(5, Date.valueOf(DetalleAbonado.getFecFinAbono()));            

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }

    // Método para insertar una lista de DetallesAbonados en la bbdd
    @Override
    public int insertDetAb(List<DetalleAbonadoVO> lista) throws SQLException {
        
         int numFilas = 0;

        for (DetalleAbonadoVO tmp : lista) {
            numFilas += insertDetAb(tmp);
        }

        return numFilas;
        
    }

    // Método para eliminar un objeto DetAbonado concreto de la bbdd
    @Override
    public int deleteDetAb(DetalleAbonadoVO d) throws SQLException {
        
        int numFilas = 0;

        String sql = "delete from detallesAbonados where matricula = ? and "
                + "codplaza = ? and feciniabono = ?";

        
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setString(1, d.getMatricula());
            prest.setInt(2,d.getCodPlaza());
            prest.setDate(3,Date.valueOf(d.getFecIniAbono()));

            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
        
        
    }

    // Método para borrar todos los objetos de la bbdd
    @Override
    public int deleteDetAb() throws SQLException {
        
        String sql = "delete from detallesAbonados";

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

    // Método para modificar un objeto de la bbdd
    @Override
    public int updateDetAb(String matricula, int codplaz, LocalDate fecIniabono, DetalleAbonadoVO nuevosDatos) throws SQLException {
      
         int numFilas = 0;
        String sql = "update detallesAbonados set tipoabono=?, fecfinabono=? "
                + " where matricula =? and codplaza = ? and feciniabono=?";

        if (findByCod(matricula,codplaz,fecIniabono) == null) {
            
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {
                

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, nuevosDatos.getTipoAbono());
                prest.setDate(2, Date.valueOf(nuevosDatos.getFecFinAbono()));
                prest.setString(3, nuevosDatos.getMatricula());
                prest.setInt(4, nuevosDatos.getCodPlaza());
                prest.setDate(5, Date.valueOf(nuevosDatos.getFecIniAbono()));                                      

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }
 
    
}

