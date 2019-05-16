
package daw.parking.javdan.modelo;

import java.time.LocalDate;


public class detallesAbonadosVO {
   
    private int matricula;
    private int codplaza;
    private int tipoAbono;
    private LocalDate feciniabono;
    private LocalDate fecfinabono;

    public detallesAbonadosVO(int matricula, int codplaza, int tipoAbono, LocalDate feciniabono, LocalDate fecfinabono) {
        this.matricula = matricula;
        this.codplaza = codplaza;
        this.tipoAbono = tipoAbono;
        this.feciniabono = feciniabono;
        this.fecfinabono = fecfinabono;
    }
    
    
    
}
