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
import daw.parking.javdan.modelo.Vista;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class Parking {

    public static void main(String[] args) throws SQLException {

        int opcion = 0;
        do {
            opcion = Vista.menu();
        } while (opcion != 3);

    }

}
