
package daw.parking.javdan.modelo;

import java.time.LocalDate;


public class TicketVO {
   
    private int codticket;
    private int tipovehi;
    private int matricula;
    private int codplaza;
    private LocalDate fecingreso;
    private LocalDate fecsalida;
    private int pin;
    private double costeEstancia;

    public TicketVO(int codticket, int tipovehi, int matricula, int codplaza, LocalDate fecingreso, LocalDate fecsalida, int pin, double costeEstancia) {
        this.codticket = codticket;
        this.tipovehi = tipovehi;
        this.matricula = matricula;
        this.codplaza = codplaza;
        this.fecingreso = fecingreso;
        this.fecsalida = fecsalida;
        this.pin = pin;
        this.costeEstancia = costeEstancia;
    }
    
    
    
}
