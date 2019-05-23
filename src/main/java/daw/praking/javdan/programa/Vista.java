
package daw.praking.javdan.programa;

import java.util.Scanner;


public class Vista {
    
    public void menu(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Desea acceder a zona cliente o zona administrador");
        System.out.println("Escoja una opción de las siguientes");
        System.out.println("1-->Zona administrador");
        System.out.println("2-->Zona cliente");
        
        System.out.println("-----------------");
        System.out.println("-----------------");
        // Cambialo por un while
        int eleccionZona=0;
                
        while(!(eleccionZona==1 ||eleccionZona==2)){
        
        eleccionZona= teclado.nextInt();
        
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
    
        public void seleccionCliente(){
        
            Scanner teclado = new Scanner(System.in);
            
        System.out.println("¿Que desea hacer?: ");
        System.out.println("1-->Depositar Vehiculo");
        System.out.println("2-->Retirar Vehiculo");
        System.out.println("3-->Depositar Abonado");
        System.out.println("4-->Retirar Abonado");
        
        
        System.out.println("-----------------");
        System.out.println("-----------------");
        
        int seleccionAccion=0;
        
        while (!(seleccionAccion==1 ||seleccionAccion==2 |seleccionAccion==3 ||seleccionAccion==4)){
            
            seleccionAccion= teclado.nextInt();
            
        }
        
            switch (seleccionAccion) {
                case 1:
                    
                    System.out.println("Ha elegido Depositar Vehiculo");
                    System.out.println("-----------------");
                    break;
                    
                case 2:
                    
                    System.out.println("Ha elegido Retirar Vehiculo");
                    System.out.println("-----------------");
                    break;
                    
                case 3:
                    
                    System.out.println("Ha elegido Depositar Abonado");
                    System.out.println("-----------------");
                    break;
                    
                case 4:
                    
                    System.out.println("Ha elegido Retirar Abonado");
                    System.out.println("-----------------");
                    break;
                
            }
        
        }
    }
    
