
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

public class PlazaDAO implements IPlaza{
    
    private Connection con = null;

    public PlazaDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<PlazaVO> getAll() throws SQLException {
        
        List<PlazaVO> lista = new ArrayList<>();
        
        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from plazas");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                PlazaVO p= new PlazaVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setCodPlaza(res.getInt("codplaza"));
                p.setTipoPlaza(res.getInt("tipoplaza"));
                p.setEstado(res.getInt("estado"));
                p.setCoste(res.getDouble("coste"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }
            return lista;
    }

    @Override
    public PlazaVO findByCod(int codplaz) throws SQLException {
       
        
        ResultSet res = null;
        PlazaVO p = new PlazaVO();

        String sql = "select * from plazas where codplaza=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, codplaz);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.first()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setCodPlaza(res.getInt("codplaza"));
                p.setTipoPlaza(res.getInt("tipoplaza"));
                p.setEstado(res.getInt("estado"));
                p.setCoste(res.getDouble("coste"));
               
                
                
                return p;
            }

            return null;
        }
        
    }

    @Override
    public int insertPlaza(PlazaVO plaza) throws SQLException {
        
        int numFilas = 0;
        String sql = "insert into plazas values (?,?,?,?)";

        if (findByCod(plaza.getCodPlaza()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1,plaza.getCodPlaza());
                prest.setInt(2,plaza.getTipoPlaza());
                prest.setInt(3,plaza.getEstado());
                prest.setDouble(4,plaza.getCoste());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }

    @Override
    public int insertPlaza(List<PlazaVO> lista) throws SQLException {
       
        int numFilas = 0;

        for (PlazaVO tmp : lista) {
            numFilas += insertPlaza(tmp);
        }

        return numFilas;
        
    }

    @Override
    public int deletePlaza(PlazaVO p) throws SQLException {
        
         int numFilas = 0;

        String sql = "delete from plazas where codplaza = ?";

        
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, p.getCodPlaza());

            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
        
    }

    @Override
    public int deletePlaza() throws SQLException {
       
        String sql = "delete from plazas";

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
    public int updatePlaza(int codpla, PlazaVO nuevosDatos) throws SQLException {
        
         int numFilas = 0;
        String sql = "update plazas set tipoplaza = ?, estado = ?, coste = ? "
                + " where codplaza=?";

        if (findByCod(codpla) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                
                prest.setInt(1,nuevosDatos.getTipoPlaza());
                prest.setInt(2,nuevosDatos.getEstado());
                prest.setDouble(3,nuevosDatos.getCoste());
                prest.setInt(4, nuevosDatos.getCodPlaza());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
        
    }
    
    
}
