/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.praking.javdan.programa;

import daw.parking.javdan.modelo.AbonadoDAO;
import daw.parking.javdan.modelo.AbonadoVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class Parking {
    
    public static void main(String[] args) {
        
        AbonadoDAO daoAbonado = new AbonadoDAO();
        ArrayList<AbonadoVO> listaAbonado = new ArrayList<>();
        listaAbonado.add(new AbonadoVO("4356-LPK", "36573621B", "Javier", "Oca infa", 
        "3644236541236541", "blabla@gmail.com", 123456));
        listaAbonado.add(new AbonadoVO("2365-LPK", "36573621B", "Javier", "Oca infa", 
        "3644236541236541", "blabla@gmail.com", 123456));
        listaAbonado.add(new AbonadoVO("4587-LPK", "36573621B", "Javier", "Oca infa", 
        "3644236541236541", "blabla@gmail.com", 123456));
        listaAbonado.add(new AbonadoVO("1123-LPK", "36573621B", "Javier", "Oca infa", 
        "3644236541236541", "blabla@gmail.com", 123456));
        listaAbonado.add(new AbonadoVO("6985-LPK", "36573621B", "Javier", "Oca infa", 
        "3644236541236541", "blabla@gmail.com", 123456));
        
        try {
            
            System.out.println("Nº peliculas insertadas " + daoAbonado.insertAbonado(listaAbonado));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<AbonadoVO> nuevaLista = daoAbonado.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Pelicula con primary key 1: ");
            System.out.println(daoAbonado.findByCod("1123-LPK"));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la pelicula con pk 3");
            System.out.println("Nº peliculas borradas "
                    + daoAbonado.deleteAbonado(new AbonadoVO("6985-LPK", "36573621B", "Javier", "Oca infa", 
        "3644236541236541", "blabla@gmail.com", 123456)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoAbonado.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una pelicula -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la pelicula con pk 5");
            System.out.println("Nº Personas modificadas "
                    + daoAbonado.updateAbonado("6985-LPK", new AbonadoVO("1111-LPK", "36573621B", "Javier", "Oca infa", 
        "3644236541236541", "blabla@gmail.com", 123456)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoAbonado.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una pelicula -------------");
            nuevaLista.forEach(System.out::println);
        
            System.out.println("-----------------------------------------");
            // daoPelicula.deletePelicula();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        
        
    }
    
}
