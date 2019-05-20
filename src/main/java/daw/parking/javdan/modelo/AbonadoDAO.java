/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.parking.javdan.modelo;

import java.sql.Connection;
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

}

@Override
        public AbonadoVO findByCod(int codabo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        public int deleteAbonado(AbonadoVO p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public int deleteAbonado() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public int updateAbonado(int codabo, AbonadoVO nuevosDatos) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
