
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

    public DetalleAbonadoDAO() {
        con = Conexion.getInstance();
    }

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
                d.setFecFinAbono(res.getDate("fecfinabono"));
                d.setFecIniAbono(res.getDate("feciniabono"));
               
                //Añadimos el objeto a la lista
                lista.add(d);
            }
        }

        return lista;
    }

    @Override
    public DetalleAbonadoVO findByCod(String matricula, LocalDate fecIniabono, int codplaz) throws SQLException {
        
          ResultSet res = null;
        DetalleAbonadoVO d = new DetalleAbonadoVO();

        String sql = "select * from detallesAbonados where matricula=?, feciniabono=?, codplaza=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, codplaz);
            

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.first()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                d.setMatricula(res.getString("matricula"));
                d.setCodPlaza(res.getInt("codplaza"));
                d.setTipoAbono(res.getInt("tipoabono"));
                d.setFecIniAbono(res.getDate("feciniabono"));
                d.setFecFinAbono(res.getDate("fecfinabono"));
                return d;
            }

            return null;
        }
        
    }

    @Override
    public int insertDetAb(DetalleAbonadoVO DetalleAbonado) throws SQLException {
        
         
        int numFilas = 0;
        String sql = "insert into detallesAbonados values (?,?,?,?,?,?,?,?)";

        if (findByCod(DetalleAbonado.getMatricula(),DetalleAbonado.getFecFinAbono(),DetalleAbonado.getCodPlaza()) != null ) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1,DetalleAbonado.getCodPlaza());
                prest.setString(2,DetalleAbonado.getMatricula());
                prest.setInt(3,DetalleAbonado.getTipoAbono());
                prest.setDate(4,DetalleAbonado.getFecIniabono());
                prest.setDate(5, DetalleAbonado.getFecFinabono());
            

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }

    @Override
    public int insertDetAb(List<DetalleAbonadoVO> lista) throws SQLException {
        
         int numFilas = 0;

        for (DetalleAbonadoVO tmp : lista) {
            numFilas += insertDetAb(tmp);
        }

        return numFilas;
        
    }

    @Override
    public int deleteDetAb(DetalleAbonadoVO d) throws SQLException {
        
        int numFilas = 0;

        String sql = "delete from tickets where codticket = ?";

        
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, d.getCodPlaza());
            prest.setDate(2,d.getFecIniabono());
            prest.setString(1,d.getMatricula());

            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
        
        
    }

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

    @Override
    public int updateDetAb(String matricula, LocalDate fecIniabono, int codplaz, DetalleAbonadoVO nuevosDatos) throws SQLException {
      
         int numFilas = 0;
        String sql = "update tickets set fecfinabono=?, tipoabono=? "
                + " where matricula = codplaza = ? and feciniabono=?";

        if (findByCod(codplaz,matricula,fecIniabono) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1,nuevosDatos.getCodPlaza());
                prest.setInt(2,nuevosDatos.getTipoAbono());
                prest.setString(3,nuevosDatos.getMatricula());
                prest.setDate(4,nuevosDatos.getFecIniAbono());
                prest.setDate(5,nuevosDatos.getFecFinAbono());
                                       

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }

   

    
    
}

