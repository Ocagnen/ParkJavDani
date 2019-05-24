/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.praking.javdan.programa;

import daw.parking.javdan.modelo.AbonadoDAO;
import daw.parking.javdan.modelo.AbonadoVO;
import daw.parking.javdan.modelo.DetalleAbonadoDAO;
import daw.parking.javdan.modelo.DetalleAbonadoVO;
import daw.parking.javdan.modelo.PlazaDAO;
import daw.parking.javdan.modelo.PlazaVO;
import daw.parking.javdan.modelo.TicketDAO;
import daw.parking.javdan.modelo.TicketVO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class Parking {

    public static void main(String[] args) throws SQLException {

        /*
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
                    + daoAbonado.updateAbonado("1123-LPK", new AbonadoVO("1123-LPK", "36573621B", "Leopoldo", "Oca infa",
                            "3644236541236541", "blabla@gmail.com", 123456)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoAbonado.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una pelicula -------------");
            nuevaLista.forEach(System.out::println);

            System.out.println("-----------------------------------------");
            //daoAbonado.deleteAbonado();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        
        /*
        PlazaDAO daoPlaza = new PlazaDAO();
        ArrayList<PlazaVO> listaPlaza= new ArrayList<>();
        
        listaPlaza.add(new PlazaVO(1,2,3,4.5));
        listaPlaza.add(new PlazaVO(6,1,0,5.5));
        listaPlaza.add(new PlazaVO(9,3,1,6.5));
        listaPlaza.add(new PlazaVO(12,0,2,7.5));
        listaPlaza.add(new PlazaVO(15,2,6,8.5));
        
        try {
            
            System.out.println("Nº plazas insertadas " + daoPlaza.insertPlaza(listaPlaza));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<PlazaVO> nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Plaza con primary key 1: ");
            System.out.println(daoPlaza.findByCod(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la plaza con pk 6");
            System.out.println("Nº plazas borradas "
                    + daoPlaza.deletePlaza(new PlazaVO(6,1,0,5.5)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una plaza -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la plaza con pk 9");
            System.out.println("Nº Plazas modificadas "
                    + daoPlaza.updatePlaza(9, new PlazaVO(9,8,78,95.5)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una plaza -------------");
            nuevaLista.forEach(System.out::println);
        
            System.out.println("-----------------------------------------");
            // daoPlaza.deletePlaza();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
 /*
        TicketDAO daoticket = new TicketDAO();
        ArrayList<TicketVO> listaticket = new ArrayList<>();

        listaticket.add(new TicketVO(1, 2, "wer234", 5, LocalDate.of(1999, 3, 8),
                LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01), LocalTime.of(19, 45, 01), 111, 23.3));

        listaticket.add(new TicketVO(4, 5, "wer224", 7, LocalDate.of(1998, 3, 8),
                LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01), LocalTime.of(19, 45, 01), 111, 23.3));

        listaticket.add(new TicketVO(5, 3, "wer244", 9, LocalDate.of(1997, 3, 8),
                LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01), LocalTime.of(19, 45, 01), 111, 23.3));

        listaticket.add(new TicketVO(6, 9, "wer254", 78, LocalDate.of(1996, 3, 8),
                LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01), LocalTime.of(19, 45, 01), 111, 23.3));

        listaticket.add(new TicketVO(7, 8, "wer264", 65, LocalDate.of(1995, 3, 8),
                LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01), LocalTime.of(19, 45, 01), 111, 23.3));

        try {

            System.out.println("Nº tickets insertados " + daoticket.insertTicket(listaticket));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<TicketVO> nuevaLista = daoticket.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("ticket con primary key 1: ");
            System.out.println(daoticket.findByCod(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar el ticket con pk 6");
            System.out.println("Nº tickets borrados "
                    + daoticket.deleteTicket(new TicketVO(6, 9, "wer254", 78, LocalDate.of(1996, 3, 8),
                            LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01), LocalTime.of(19, 45, 01), 111, 23.3)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoticket.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar un ticket -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de el ticket con pk 7");
            System.out.println("Nº Tickets modificadas "
                    + daoticket.updateTicket(7, new TicketVO(1, 2, "wer234", 5, LocalDate.of(1999, 3, 8),
                            LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01), LocalTime.of(19, 45, 01), 111, 23.3)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoticket.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar un ticket -------------");
            nuevaLista.forEach(System.out::println);

            System.out.println("-----------------------------------------");
            // daoPlaza.deletePlaza();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }
         */
        
        /*
        DetalleAbonadoDAO daoDetAbo = new DetalleAbonadoDAO();
        ArrayList<DetalleAbonadoVO> listaDetAbo= new ArrayList<>();
        
        listaDetAbo.add(new DetalleAbonadoVO("1123-LPK", 1, 2, LocalDate.now(),LocalDate.of(2200, 1, 1)));
        listaDetAbo.add(new DetalleAbonadoVO("2365-LPK", 9, 2, LocalDate.now(),LocalDate.of(2200, 1, 1)));
        listaDetAbo.add(new DetalleAbonadoVO("4356-LPK", 12, 2, LocalDate.now(),LocalDate.of(2200, 1, 1)));
        listaDetAbo.add(new DetalleAbonadoVO("4587-LPK", 15, 2, LocalDate.now(),LocalDate.of(2200, 1, 1)));
        daoDetAbo.deleteDetAb();
        
        try {
            
            System.out.println("Nº plazas insertadas " + daoDetAbo.insertDetAb(listaDetAbo));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<DetalleAbonadoVO> nuevaLista = daoDetAbo.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Plaza con primary key 1: ");
            System.out.println(daoDetAbo.findByCod("1123-LPK",1,LocalDate.now()));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la plaza con pk 6");
            System.out.println("Nº plazas borradas "
                    + daoDetAbo.deleteDetAb(new DetalleAbonadoVO("1123-LPK", 1, 2, 
                            LocalDate.now(),LocalDate.of(2200, 1, 1))));
            System.out.println("-----------------------------------------");
            nuevaLista = daoDetAbo.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una plaza -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la plaza con pk 9");
            System.out.println("Nº Plazas modificadas "
                    + daoDetAbo.updateDetAb("4356-LPK", 12, LocalDate.now(), new DetalleAbonadoVO("4356-LPK",12, 4, LocalDate.now(),LocalDate.of(2200, 1, 1))));
            System.out.println("-----------------------------------------");
            nuevaLista = daoDetAbo.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una plaza -------------");
            nuevaLista.forEach(System.out::println);
        
            System.out.println("-----------------------------------------");
            
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        */
        
        TicketDAO daoTicket = new TicketDAO();
        ArrayList<TicketVO> listaTicket= new ArrayList<>();
        
        listaTicket.add(new TicketVO(1, 0, "1234-PAJ", 1, LocalDate.now(),
                LocalDate.of(2200, 1, 1), LocalTime.now(), LocalTime.of(20, 20, 20),123456,20.5));
        listaTicket.add(new TicketVO(2, 0, "1287-LPO", 9, LocalDate.now(),
                LocalDate.of(2200, 1, 1), LocalTime.now(), LocalTime.of(20, 20, 20),123456,20.5));
        listaTicket.add(new TicketVO(3, 0, "1675-ADF", 12, LocalDate.now(),
                LocalDate.of(2200, 1, 1), LocalTime.now(), LocalTime.of(20, 20, 20),123456,20.5));
        listaTicket.add(new TicketVO(5, 0, "9987-XDF", 15, LocalDate.now(),
                LocalDate.of(2200, 1, 1), LocalTime.now(), LocalTime.of(20, 20, 20),123456,20.5));
        //daoTicket.deleteTicket();
       
        
        try {
            
            System.out.println("Nº plazas insertadas " + daoTicket.insertTicket(listaTicket));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<TicketVO> nuevaLista = daoTicket.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Plaza con primary key 1: ");
            System.out.println(daoTicket.findByCod(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la plaza con pk 6");
            System.out.println("Nº plazas borradas "
                    + daoTicket.deleteTicket(new TicketVO(5, 0, "9987-XDF", 4, LocalDate.now(),
                LocalDate.of(2200, 1, 1), LocalTime.now(), LocalTime.of(20, 20, 20),123456,20.5)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoTicket.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una plaza -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la plaza con pk 9");
            System.out.println("Nº Plazas modificadas "
                    + daoTicket.updateTicket(1,new TicketVO(1, 0, "1234-PAJ", 1, LocalDate.now(),
                LocalDate.of(2500, 1, 1), LocalTime.now(), LocalTime.of(20, 20, 20),123123,20.5)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoTicket.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una plaza -------------");
            nuevaLista.forEach(System.out::println);
        
            System.out.println("-----------------------------------------");
            
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        
        
        
    }

}
