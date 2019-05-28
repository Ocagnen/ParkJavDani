package daw.parking.javdan.modelo;

import daw.parking.javdan.modelo.AbonadoVO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public static void seleccionCliente() throws SQLException {

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
                            int codPlazaAux = PlazaVO.obtenerPlazaLibre(tipoVehi);

                            System.out.println("Su plaza es la número "
                                    + codPlazaAux);
                            TicketVO tickaux = TicketVO.generarTicket(matricula, tipoVehi, codPlazaAux);

                            System.out.println("");
                            System.out.println("INFORMACIÓN DEL TICKET");
                            System.out.println(tickaux.toStringParaClientes());

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
    public static void seleccionAdmin() throws SQLException {

        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Que desea ver?");
        System.out.println("1-->Estado de Parking");
        System.out.println("2-->Facturación");
        System.out.println("3-->Abonos");
        int seleccionAccion = teclado.nextInt();

        while (!(seleccionAccion == 1 || seleccionAccion == 2 || seleccionAccion == 3)) {
            System.out.println("ERROR, seleccione una de las opciones mostradas");
            seleccionAccion = teclado.nextInt();
        }

        switch (seleccionAccion) {
            case 1:
                System.out.println("---------- ESTADO DEL PARKING -----------");
                PlazaDAO daoPlaza = new PlazaDAO();
                ArrayList<PlazaVO> lista = (ArrayList<PlazaVO>) daoPlaza.getAll();

                for (PlazaVO plazaVO : lista) {

                    System.out.println(plazaVO.toStringAdmin());

                }

                System.out.println("");

                break;

            case 2:
                System.out.println("Introduzca el tipo de facturación a consultar");
                System.out.println("1 - Entre fechas");
                System.out.println("2 - Abonos");
                seleccionAccion = teclado.nextInt();

                while (seleccionAccion > 2 || seleccionAccion < 1) {
                    System.out.println("Opcion incorrecta, seleccione una de las siguientes:");
                    System.out.println("1 - Entre fechas");
                    System.out.println("2 - Abonos");
                    seleccionAccion = teclado.nextInt();
                }

                switch (seleccionAccion) {
                    case 1:
                        System.out.println("FECHA INICIAL");
                        System.out.println("Introduce el año (formato YYYY)");
                        int anio = teclado.nextInt();
                        System.out.println("Introduce el mes (formato MM)");
                        int mes = teclado.nextInt();
                        System.out.println("Introduce el dia (formato dd)");
                        int dia = teclado.nextInt();
                        LocalDate fecIni = LocalDate.of(anio, mes, dia);

                        System.out.println("FECHA FINAL");
                        System.out.println("Introduce el año (formato YYYY)");
                        anio = teclado.nextInt();
                        System.out.println("Introduce el mes (formato MM)");
                        mes = teclado.nextInt();
                        System.out.println("Introduce el dia (formato dd)");
                        dia = teclado.nextInt();
                        LocalDate fecFin = LocalDate.of(anio, mes, dia);

                        ArrayList<TicketVO> listTickAux = TicketVO.obtenerTicketsFechas(fecIni, fecFin);
                        TicketVO.mostrarCobros(listTickAux);
                        break;

                    case 2:
                        ArrayList<DetalleAbonadoVO> listDetAb = DetalleAbonadoVO.obtenerAbonosAnuales();
                        DetalleAbonadoVO.muestraCobroAbonados(listDetAb);
                        break;
                }

                break;

            case 3:
                System.out.println("GESTION DE ABONADOS");
                System.out.println("Introduzca el número de la opción "
                        + "que desea ejecutar");
                System.out.println("1 - Insertar abonado");
                System.out.println("2 - Modificar un abonado");
                System.out.println("3 - Modificar un abono concreto");
                System.out.println("4 - Dar de baja a un abonado");
                seleccionAccion = teclado.nextInt();

                while (seleccionAccion > 4 || seleccionAccion < 1) {
                    System.out.println("Opcion incorrecta, seleccione una de las siguientes:");
                    System.out.println("1 - Insertar abonado");
                    System.out.println("2 - Modificar un abonado");
                    System.out.println("3 - Modificar un abono concreto");
                    System.out.println("4 - Dar de baja a un abonado");
                    seleccionAccion = teclado.nextInt();
                }

                switch (seleccionAccion) {
                    case 1:
                        System.out.println("Introduzca opción");
                        System.out.println("1 - Dar de alta nuevo abonado");
                        System.out.println("2 - Dar de alta nuevo abono a plaza");
                        seleccionAccion = teclado.nextInt();
                        while (seleccionAccion > 2 || seleccionAccion < 1) {
                            System.out.println("Opcion incorrecta, seleccione una de las siguientes:");
                            System.out.println("1 - Dar de alta nuevo abonado");
                            System.out.println("2 - Dar de alta nuevo abono a plaza");
                            seleccionAccion = teclado.nextInt();
                        }

                        switch (seleccionAccion) {
                            case 1:
                                System.out.println("INTRODUCIR DATOS DE ABONADO");
                                System.out.println("Introduzca nombre");
                                teclado.nextLine();
                                String nombre = teclado.nextLine();

                                System.out.println("Introduzca apellidos");
                                String apellidos = teclado.nextLine();

                                System.out.println("Introduzca dni");
                                String dni = teclado.nextLine();
                                while (dni.length() != 9) {

                                    System.out.println("Dni incorrecto");
                                    dni = teclado.nextLine();

                                }

                                System.out.println("Introduzca su email");
                                String email = teclado.nextLine();

                                System.out.println("Introduzca su número de tarjeta");
                                String numTarjeta = teclado.nextLine();
                                while (numTarjeta.length() != 16) {
                                    System.out.println("Número de tarjeta incorrecto");
                                    numTarjeta = teclado.nextLine();
                                }

                                System.out.println("Introduzca su matricula");
                                String matricula = teclado.nextLine();
                                while (matricula.length() != 8) {
                                    System.out.println("Matricula erronea, introduzca en formato 1111-XXX");
                                    matricula = teclado.nextLine();
                                }

                                AbonadoVO abonadoAux = new AbonadoVO(matricula, dni, nombre, apellidos, numTarjeta, email, TicketVO.generarPin());

                                AbonadoVO.insertarAbonado(abonadoAux);
                                break;

                            case 2:
                                System.out.println("REGISTRAR NUEVO ABONO A PLAZA");
                                System.out.println("Selecciona un tipo de abono");
                                System.out.println("1 - Mensual(25€)");
                                System.out.println("2 - Trimestral (70€)");
                                System.out.println("3 - Semestral (130€)");
                                System.out.println("4 - Anual (200€)");
                                int tipoAbono = teclado.nextInt();
                                while (tipoAbono > 4 || tipoAbono < 1) {
                                    System.out.println("Opcion incorrecta, seleccione una de las siguientes:");
                                    System.out.println("1 - Mensual(25€)");
                                    System.out.println("2 - Trimestral (70€)");
                                    System.out.println("3 - Semestral (130€)");
                                    System.out.println("4 - Anual (200€)");
                                    tipoAbono = teclado.nextInt();
                                }

                                System.out.println("Introduce el tipo de vehiculo");
                                System.out.println("0 - Turismo");
                                System.out.println("1 - Motocicleta");
                                System.out.println("2 - Caravana");
                                int tipoVe = teclado.nextInt();
                                while (tipoVe > 2 || tipoVe < 0) {
                                    System.out.println("Opcion incorrecta, seleccione una de las siguientes:");
                                    System.out.println("0 - Turismo");
                                    System.out.println("1 - Motocicleta");
                                    System.out.println("2 - Caravana");
                                    tipoVe = teclado.nextInt();
                                }

                                System.out.println("Introduce tu matricula");
                                teclado.nextLine();
                                String matrAbo = teclado.nextLine();
                                while ((matrAbo.length() != 8)
                                        && (AbonadoVO.comprobarAbonadoMatr(matrAbo))) {
                                    System.out.println("Matricula erronea, introduzca en formato 1111-XXX");
                                    System.out.println("Tambien es posible que la "
                                            + "matricula introducida no esté abonada");
                                    matrAbo = teclado.nextLine();
                                }

                                DetalleAbonadoVO.insertaNuevoDetalleAbonado(tipoAbono, tipoVe, matrAbo);
                                break;

                        }
                        break;

                    case 2:
                        System.out.println("MODIFICAR DATOS DE ABONADO");
                        System.out.println("Introduzca la matricula del abdonado"
                                + " que desea modificar");
                        teclado.nextLine();
                        String matrModif = teclado.nextLine();
                        while ((matrModif.length() != 8)
                                && (AbonadoVO.comprobarAbonadoMatr(matrModif))) {
                            System.out.println("Matricula erronea, introduzca en formato 1111-XXX");
                            System.out.println("Tambien es posible que la "
                                    + "matricula introducida no esté abonada");
                            matrModif = teclado.nextLine();
                        }
                        AbonadoVO aboAux = AbonadoVO.obtenerAbonado(matrModif);

                        do {
                            System.out.println("Introduzca el valor que desea modificar");
                            System.out.println("1 - Nombre");
                            System.out.println("2 - Apellidos");
                            System.out.println("3 - Correo");
                            System.out.println("4 - Dni");
                            System.out.println("5 - Nº de tarjeta");
                            System.out.println("6 - Salir");
                            seleccionAccion = teclado.nextInt();
                            while (seleccionAccion > 6 || seleccionAccion < 1) {
                                System.out.println("Opcion incorrecta, seleccione una de las siguientes:");
                                System.out.println("1 - Nombre");
                                System.out.println("2 - Apellidos");
                                System.out.println("3 - Correo");
                                System.out.println("4 - Dni");
                                System.out.println("5 - Nº de tarjeta");
                                seleccionAccion = teclado.nextInt();
                            }

                            switch (seleccionAccion) {

                                case 1:
                                    System.out.println("Introduzca nuevo nombre");
                                    teclado.nextLine();
                                    String nuevoNombre = teclado.nextLine();
                                    aboAux.setNombre(nuevoNombre);
                                    AbonadoVO.modificarAbonado(aboAux);
                                    break;
                                case 2:
                                    System.out.println("Introduzca nuevos apellidos");
                                    teclado.nextLine();
                                    String nuevoApel = teclado.nextLine();
                                    aboAux.setApellidos(nuevoApel);
                                    AbonadoVO.modificarAbonado(aboAux);
                                    break;
                                case 3:
                                    System.out.println("Introduzca nuevo correo");
                                    teclado.nextLine();
                                    String nuevoCorreo = teclado.nextLine();
                                    aboAux.setEmail(nuevoCorreo);
                                    AbonadoVO.modificarAbonado(aboAux);
                                    break;
                                case 4:
                                    System.out.println("Introduzca nuevo Dni");
                                    teclado.nextLine();
                                    String nuevoDni = teclado.nextLine();
                                    while (nuevoDni.length() != 9) {

                                        System.out.println("Dni incorrecto");
                                        nuevoDni = teclado.nextLine();

                                    }
                                    aboAux.setDni(nuevoDni);
                                    AbonadoVO.modificarAbonado(aboAux);
                                    break;
                                case 5:
                                    System.out.println("Introduzca nuevo nº tarjeta");
                                    teclado.nextLine();
                                    String nuevaTarj = teclado.nextLine();
                                    while (nuevaTarj.length() != 16) {

                                        System.out.println("nº tarjeta incorrecto");
                                        nuevaTarj = teclado.nextLine();

                                    }
                                    aboAux.setDni(nuevaTarj);
                                    AbonadoVO.modificarAbonado(aboAux);
                                    break;
                            }

                        } while (seleccionAccion != 6);
                        break;

                    case 3:
                        System.out.println("MODIFICACION DE ABONO CONCRETO");
                        System.out.println("Introduzca matricula abonado");
                        teclado.nextLine();
                        String matAb = teclado.nextLine();
                        while ((matAb.length() != 8)
                                && (AbonadoVO.comprobarAbonadoMatr(matAb))) {
                            System.out.println("Matricula erronea, introduzca en formato 1111-XXX");
                            System.out.println("Tambien es posible que la "
                                    + "matricula introducida no esté abonada");
                            matAb = teclado.nextLine();
                        }

                        if (DetalleAbonadoVO.compruebaAbonoActivo(matAb)) {

                            System.out.println("Introduzca el nuevo tipo"
                                    + " de tarifa que desea el abonado");
                            System.out.println("1 - Mensual(25€)");
                            System.out.println("2 - Trimestral (70€)");
                            System.out.println("3 - Semestral (130€)");
                            System.out.println("4 - Anual (200€)");
                            int tipoAbo = teclado.nextInt();
                            while (tipoAbo > 4 || tipoAbo < 1) {
                                System.out.println("Opcion incorrecta, seleccione una de las siguientes:");
                                System.out.println("1 - Mensual(25€)");
                                System.out.println("2 - Trimestral (70€)");
                                System.out.println("3 - Semestral (130€)");
                                System.out.println("4 - Anual (200€)");
                                tipoAbo = teclado.nextInt();
                            }

                            DetalleAbonadoVO.renovarAbono(DetalleAbonadoVO.obtenerDetallesAbonoActivo(matAb), tipoAbo);

                        } else {
                            System.out.println("La matricula introducida no"
                                    + "dispone de abonos que ampliar");
                        }
                        break;

                    case 4:
                        System.out.println("DAR DE BAJA ABONADO");
                        System.out.println("Introduce matricula del abonado");
                        teclado.nextLine();
                        String mat = teclado.nextLine();
                        while ((mat.length() != 8)
                                && (AbonadoVO.comprobarAbonadoMatr(mat))) {
                            System.out.println("Matricula erronea, introduzca en formato 1111-XXX");
                            System.out.println("Tambien es posible que la "
                                    + "matricula introducida no esté abonada");
                            mat = teclado.nextLine();
                        }

                        AbonadoVO.borrarAbonado(AbonadoVO.obtenerAbonado(mat));

                        DetalleAbonadoVO detAux = DetalleAbonadoVO.obtenerDetallesAbonoActivo(mat);

                        PlazaVO.cambiarEstadoPlaza(PlazaVO.obtenerPlazaConId(detAux.getCodPlaza()), 0);
                        break;

                }

                break;
        }

    }

}
