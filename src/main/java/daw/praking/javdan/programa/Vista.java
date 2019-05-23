package daw.praking.javdan.programa;

import java.util.Scanner;

public class Vista {

    public void menu() {

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

                System.out.println("Ha elegido zona administrador");
                System.out.println("-----------------");
                break;

            case 2:

                System.out.println("Ha elegido zona cliente");
                System.out.println("-----------------");
                break;

        }
    }

    public void seleccionCliente() {

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
                System.out.println("3-->Retirar abono");
                seleccionAccion = teclado.nextInt();
                break;

            case 2:

                System.out.println("¿Desea hacerse abonado?");
                System.out.println("1-->Si");
                System.out.println("2-->No");
                seleccionAccion = teclado.nextInt();

                while (!(seleccionAccion == 1 || seleccionAccion == 2)) {
                    System.out.println("ERROR, seleccione una de las opciones mostradas");
                    seleccionAccion = teclado.nextInt();
                }

                switch (seleccionAccion) {
                    case 1:
                        
                        System.out.println("Ha entrado en el menú de Depositar Abonado");
                        break;

                    case 2:
                        
                        System.out.println("Elija una opción: ");
                        System.out.println("1-->Depositar vehículo");
                        System.out.println("2-->Retirar vehículo");    
                        seleccionAccion = teclado.nextInt();
                        break;
                }
                break;
        }

    }
}
