/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.praking.javdan.programa;

import daw.parking.javdan.modelo.AbonadoDAO;
import daw.parking.javdan.modelo.AbonadoVO;
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
            Plaza        + daoAbonado.updateAbonado("6985-LPK", new AbonadoVO("1111-LPK", "36573621B", "Javier", "Oca infa", 
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
        
        */
        /*
        PlazaDAO daoPlaza = new PlazaDAO();
        ArrayList<PlazaVO> listaPlaza= new ArrayList<>();
        
        listaPlaza.add(new PlazaVO(1,2,3,4.5));
        listaPlaza.add(new PlazaVO(6,7,8,5.5));
        listaPlaza.add(new PlazaVO(9,10,11,6.5));
        listaPlaza.add(new PlazaVO(12,13,14,7.5));
        listaPlaza.add(new PlazaVO(15,16,17,8.5));
        
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
                    + daoPlaza.deletePlaza(new PlazaVO(6,7,8,5.5)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una plaza -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la plaza con pk 9");
            System.out.println("Nº Plazas modificadas "
                    + daoPlaza.updatePlaza(9, new PlazaVO(43,56,78,95.5)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una plaza -------------");
            nuevaLista.forEach(System.out::println);
        
            System.out.println("-----------------------------------------");
            // daoPlaza.deletePlaza();
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }*/
        
        TicketDAO daoticket= new TicketDAO();
        ArrayList<TicketVO> listaticket = new ArrayList<>();
        
   listaticket.add(new TicketVO(1,2,"wer234",5,LocalDate.of(1999, 3, 8),
    LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01),LocalTime.of(19, 45, 01),111,23.3));
   
   listaticket.add(new TicketVO(4,5,"wer224",7,LocalDate.of(1998, 3, 8),
    LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01),LocalTime.of(19, 45, 01),111,23.3));
   
   listaticket.add(new TicketVO(5,3,"wer244",9,LocalDate.of(1997, 3, 8),
    LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01),LocalTime.of(19, 45, 01),111,23.3));
   
   listaticket.add(new TicketVO(6,9,"wer254",78,LocalDate.of(1996, 3, 8),
    LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01),LocalTime.of(19, 45, 01),111,23.3));
   
   listaticket.add(new TicketVO(7,8,"wer264",65,LocalDate.of(1995, 3, 8),
    LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01),LocalTime.of(19, 45, 01),111,23.3));
        
    try{
   
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
                    + daoticket.deleteTicket(new TicketVO(6,9,"wer254",78,LocalDate.of(1996, 3, 8),
    LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01),LocalTime.of(19, 45, 01),111,23.3)));
            System.out.println("-----------------------------------------");
            nuevaLista = daoticket.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar un ticket -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de el ticket con pk 7");
            System.out.println("Nº Tickets modificadas "
                    + daoticket.updateTicket(7, new TicketVO(1,2,"wer234",5,LocalDate.of(1999, 3, 8),
    LocalDate.of(1999, 4, 8), LocalTime.of(14, 45, 01),LocalTime.of(19, 45, 01),111,23.3)));
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
        
    }
    

