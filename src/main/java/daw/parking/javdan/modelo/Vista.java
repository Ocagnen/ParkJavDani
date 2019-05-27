package daw.parking.javdan.modelo;

import daw.parking.javdan.modelo.AbonadoVO;
import java.sql.SQLException;
import java.util.Scanner;

public class Vista {

    public static void menu() throws SQLException {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Desea acceder a zona cliente o zona administrador");
        System.out.println("Escoja una opción de las siguientes");
        System.out.println("1-->Zona administrador");
        System.out.println("2-->Zona cliente");

        System.out.println("-----------------");
        System.out.println("-----------------");
        // Cambialo por un while
        int eleccionZona = teclado.nextInt();

        while (!(eleccionZona == 1 || eleccionZona == 2)) {

            System.out.println("ERROR, seleccione una de las opciones mostradas");
            eleccionZona = teclado.nextInt();

        }

        switch (eleccionZona) {
            case 1:
                seleccionAdmin();
                break;

            case 2:
                seleccionCliente();
                break;

        }
    }

    //RAMA DE ZONA CLIENTE
    public static void seleccionCliente() throws SQLException{

        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Es usted abonado?: ");
        System.out.println("1-->Si");
        System.out.println("2-->No");
        System.out.println("-----------------");
        System.out.println("-----------------");

        int seleccionAccion = teclado.nextInt();

        while (!(seleccionAccion == 1 || seleccionAccion == 2)) {
            System.out.println("ERROR, seleccione una de las opciones mostradas");
            seleccionAccion = teclado.nextInt();
        }

        switch (seleccionAccion) {
            case 1:

                System.out.println("Seleccione una opción: ");
                System.out.println("1-->Depositar vehículo");
                System.out.println("2-->Retirar vehículo");

                seleccionAccion = teclado.nextInt();

                while (!(seleccionAccion == 1 || seleccionAccion == 2 || seleccionAccion == 3)) {
                    System.out.println("ERROR, seleccione una de las opciones mostradas");
                    seleccionAccion = teclado.nextInt();
                }

                switch (seleccionAccion) {

                    case 1:
                        System.out.println("Introduzca el PIN de abonado");
                        seleccionAccion = teclado.nextInt();
                        System.out.println("Introduzca su matricula");
                        teclado.nextLine();
                        String matricula = teclado.nextLine();
                        if (AbonadoVO.comprobarPin(seleccionAccion, matricula)) {

                            PlazaDAO daoPlaza = new PlazaDAO();
                            try {
                                PlazaVO plazaTempo = daoPlaza.findByCod(DetalleAbonadoVO.obtenerPlaza(matricula));
                                plazaTempo.setEstado(2);
                                daoPlaza.updatePlaza(DetalleAbonadoVO.obtenerPlaza(matricula), plazaTempo);
                            } catch (SQLException sqle) {
                                System.out.println("No se ha podido realizar la operación:");
                                System.out.println(sqle.getMessage());
                            }

                        } else {

                            System.out.println("Error, los datos introducidos "
                                    + "no son correctos");

                        }
                        break;
                    case 2:
                        System.out.println("Introduce la matricula de tu vehiculo");
                        matricula = teclado.nextLine();
                        System.out.println("Introduce el nº de plaza");
                        int plaza = teclado.nextInt();
                        System.out.println("Introduce tu PIN");
                        int pin = teclado.nextInt();

                        if (DetalleAbonadoVO.retirarVehiAbo(matricula, plaza, pin)) {
                            System.out.println("Vehiculo retirado con éxito");
                        }

                        break;

                }

                break;

            case 2:

                System.out.println("Elija una opción: ");
                System.out.println("1-->Depositar vehículo");
                System.out.println("2-->Retirar vehículo");
                seleccionAccion = teclado.nextInt();

                while (!(seleccionAccion == 1 || seleccionAccion == 2)) {
                    System.out.println("ERROR, seleccione una de las opciones mostradas");
                    seleccionAccion = teclado.nextInt();
                }

                switch (seleccionAccion) {

                    case 1:
                        PlazaVO.mostrarPlazasLibres();
                        teclado.nextLine();
                        System.out.println("Introduzca matricula");
                        String matricula = teclado.nextLine();

                        while (matricula.length() != 8) {
                            System.out.println("Matricula erronea");
                            System.out.println("Introduzcala de nuevo "
                                    + "con formato 1111-XXX");
                            matricula = teclado.nextLine();
                        }

                        System.out.println("Introduzca el tipo de vehiculo");
                        System.out.println("0 - Turismo");
                        System.out.println("1 - Motocicleta");
                        System.out.println("2 - Caravana");
                        int tipoVehi = teclado.nextInt();

                        while (tipoVehi > 2 || tipoVehi < 0) {
                            System.out.println("Tipo erroneo, pruebe de nuevo");
                            System.out.println("0 - Turismo");
                            System.out.println("1 - Motocicleta");
                            System.out.println("2 - Caravana");
                            tipoVehi = teclado.nextInt();
                        }

                        if (PlazaVO.obtenerPlazaLibre(tipoVehi) == 0) {
                            System.out.println("Lo siento, no hay plazas libres");
                        } else {
                            System.out.println("Operación realizada con éxito");
                            System.out.println("Su plaza es la número "
                                    + PlazaVO.obtenerPlazaLibre(tipoVehi));
                            TicketVO tickaux = TicketVO.generarTicket(matricula, tipoVehi, PlazaVO.obtenerPlazaLibre(tipoVehi));
                            System.out.println("");
                            System.out.println("INFORMACIÓN DEL TICKET");
                            tickaux.toStringParaClientes();
                        }

                        break;

                    case 2:
                        teclado.nextLine();
                        System.out.println("Introduzce la matricula");
                        matricula = teclado.nextLine();

                        while (matricula.length() != 8) {
                            System.out.println("Matricula erronea");
                            System.out.println("Introduzcala de nuevo "
                                    + "con formato 1111-XXX");
                            matricula = teclado.nextLine();
                        }

                        System.out.println("Introduce nº plaza");
                        int numeroPlaza = teclado.nextInt();

                        System.out.println("Introduce el PIN");
                        int pin = teclado.nextInt();

                        int pkTick = TicketVO.obtenerCodTickSalida(matricula, numeroPlaza, pin);

                        TicketVO auxTick = TicketVO.obtenerTicket(pkTick);

                        auxTick.actualizarTicketSalida();

                        System.out.println("El importe a pagar será de " + auxTick.calcularTarifa());                       

                        break;

                }
        }

    }//FIN DE RAMA DE ZONA CLIENTE 

//RAMA DE ZONA ADMINITRADOR
    public static void seleccionAdmin() {

        Scanner teclado = new Scanner(System.in);
        int seleccionAccion = teclado.nextInt();

        System.out.println("¿Que desea ver?");
        System.out.println("1-->Estado de Parking");
        System.out.println("2-->Facturación");
        System.out.println("3-->Abonos");

        while (!(seleccionAccion == 1 || seleccionAccion == 2 || seleccionAccion == 3)) {
            System.out.println("ERROR, seleccione una de las opciones mostradas");
            seleccionAccion = teclado.nextInt();
        }

        switch (seleccionAccion) {
            case 1:

                System.out.println("Se le mostrará el estado del parking");
                //estadoParking();
                break;

            case 2:

                //mostarFacturación()
                break;

            case 3:

                //Abonos()
                break;
        }

    }

    //FIN DE RAMA DE ZONA ADMINISTRADOR
    //Métodos para implementar en las ramas anteriores
    public void depositarVehi() {

        System.out.println("Plazas libres totales ");

        System.out.println("Escoja una de las plazas libres");

        //aquí se mostrarán todas las plazas disponibles
        System.out.println("Introduzca matrícula");
        //aquí introduciremos la matrícula

        System.out.println("Introduzca el tipo de vehícula");
        //aquí introduciremos tipo de vehículo

        System.out.println("Aquí tiene su ticket: ");
        //se generará un ticket 

    }

    public void retirarVehi() {

        System.out.println("Introduzca matrícula");
        //se introduce la matrícula del vehículo depositado

        System.out.println("Introduzca el identificador de la plaza");
        //se introduce el codplaza de la plaza donde se ubica el coche   

        System.out.println("Introduzca el pin");
        //se introduce el pin del ticket

        System.out.println("El coste total es: " + "" /*Aqui se introducirá el coste*/);

        //Después actualizamos toda la información
    }

    public void depositarAb() {

        System.out.println("Introduzca su DNI");
        //se introducirá el DNI

        System.out.println("Introduzca la matrícula");
        //

        System.out.println("Introduzca su nombre");
        //

        System.out.println("Introduzca su apellidos");
        //

        System.out.println("Introduzca su número de tarjeta");
        //

        System.out.println("Introduzca su email");
        //

        System.out.println("¿Que tipo de abono desea?");
        //

        //Se actualizarán las plazas
        System.out.println("Aquí tiene su pin");
        //
    }

}
