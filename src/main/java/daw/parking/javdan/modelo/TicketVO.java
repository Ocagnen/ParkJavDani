
package daw.parking.javdan.modelo;

import java.time.LocalDate;


public class TicketVO {
   
    private int codticket;
    private int tipovehi;
    private String matricula;
    private int codplaza;
    private LocalDate fecingreso;
    private LocalDate fecsalida;
    private int pin;
    private double costeEstancia;

    public TicketVO(int codticket, int tipovehi,String matricula, int codplaza, LocalDate fecingreso, LocalDate fecsalida, int pin, double costeEstancia) {
        this.codticket = codticket;
        this.tipovehi = tipovehi;
        this.matricula = matricula;
        this.codplaza = codplaza;
        this.fecingreso = fecingreso;
        this.fecsalida = fecsalida;
        this.pin = pin;
        this.costeEstancia = costeEstancia;
    }

    public int getCodticket() {
        return codticket;
    }

    public void setCodticket(int codticket) {
        this.codticket = codticket;
    }

    public int getTipovehi() {
        return tipovehi;
    }

    public void setTipovehi(int tipovehi) {
        this.tipovehi = tipovehi;
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

    public LocalDate getFecingreso() {
        return fecingreso;
    }

    public void setFecingreso(LocalDate fecingreso) {
        this.fecingreso = fecingreso;
    }

    public LocalDate getFecsalida() {
        return fecsalida;
    }

    public void setFecsalida(LocalDate fecsalida) {
        this.fecsalida = fecsalida;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getCosteEstancia() {
        return costeEstancia;
    }

    public void setCosteEstancia(double costeEstancia) {
        this.costeEstancia = costeEstancia;
    }

    @Override
    public String toString() {
        return "TicketVO{" + "codticket=" + codticket + ", tipovehi=" + tipovehi + ", matricula=" + matricula + ", codplaza=" + codplaza + ", fecingreso=" + fecingreso + ", fecsalida=" + fecsalida + ", pin=" + pin + ", costeEstancia=" + costeEstancia + '}';
    }
    
    
    
}
