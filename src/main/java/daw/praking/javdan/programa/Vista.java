
package daw.praking.javdan.programa;

import java.util.Scanner;


public class Vista {
    
    public void menu(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Desea acceder a zona cliente o zona administrador");
        System.out.println("Escoja una opción de las siguientes");
        System.out.println("1-->Zona administrador");
        System.out.println("2-->Zona cliente");
        
        int eleccionZona= teclado.nextInt();
        
        do{
            
            System.out.println("Por favor elija una opción correcta");
            eleccionZona= teclado.nextInt();
            
        }while(!(eleccionZona==1 ||eleccionZona==2));
        
        switch (eleccionZona) {
            case 1:
                
                System.out.println("Ha elegido zona administrador");
                System.out.println("--------------------");
                break;
                
            case 2: 
               
                System.out.println("Ha elegido zona cliente");
                System.out.println("--------------------");
                break;
                
        }
        }
    }
    
