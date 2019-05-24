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
    
    
     public void depositarVehi(){
         
         System.out.println("Escoja una de las plazas libres");
         //aquí se mostrarán todas las plazas disponibles
              
         System.out.println("Introduzca matrícula");
         //aquí introduciremos la matrícula
         
         System.out.println("Introduzca el tipo de vehícula");
         //aquí introduciremos tipo de vehículo
         
         System.out.println("Aquí tiene su ticket: ");
         //se generará un ticket 
         
    }
     
    public void retirarVehi(){
        
        System.out.println("Introduzca matrícula");
        //se introduce la matrícula del vehículo depositado
       
        System.out.println("Introduzca el identificador de la plaza");
        //se introduce el codplaza de la plaza donde se ubica el coche   
        
        System.out.println("Introduzca el pin");
        //se introduce el pin del ticket
        
        System.out.println("El coste total es: "+ "" /*Aqui se introducirá el coste*/);
        
        //Después actualizamos toda la información
    }

}
