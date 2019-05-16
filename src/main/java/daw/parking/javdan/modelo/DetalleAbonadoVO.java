
package daw.parking.javdan.modelo;

import java.time.LocalDate;


public class DetalleAbonadoVO {
   
    private String matricula;
    private int codplaza;
    private int tipoAbono;
    private LocalDate feciniabono;
    private LocalDate fecfinabono;

    public DetalleAbonadoVO(String matricula, int codplaza, int tipoAbono, LocalDate feciniabono, LocalDate fecfinabono) {
        this.matricula = matricula;
        this.codplaza = codplaza;
        this.tipoAbono = tipoAbono;
        this.feciniabono = feciniabono;
        this.fecfinabono = fecfinabono;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCodplaza() {
        return codplaza;
    }

    public void setCodplaza(int codplaza) {
        this.codplaza = codplaza;
    }

    public int getTipoAbono() {
        return tipoAbono;
    }

    public void setTipoAbono(int tipoAbono) {
        this.tipoAbono = tipoAbono;
    }

    public LocalDate getFeciniabono() {
        return feciniabono;
    }

    public void setFeciniabono(LocalDate feciniabono) {
        this.feciniabono = feciniabono;
    }

    public LocalDate getFecfinabono() {
        return fecfinabono;
    }

    public void setFecfinabono(LocalDate fecfinabono) {
        this.fecfinabono = fecfinabono;
    }

    @Override
    public String toString() {
        return "detallesAbonadosVO{" + "matricula=" + matricula + ", codplaza=" + codplaza + ", tipoAbono=" + tipoAbono + ", feciniabono=" + feciniabono + ", fecfinabono=" + fecfinabono + '}';
    }
    
    
    
}
