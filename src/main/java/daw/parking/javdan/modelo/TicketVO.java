
package daw.parking.javdan.modelo;

import java.time.LocalDate;


public class TicketVO {
   
    private int codTicket;
    private int tipoVehi;
    private String matricula;
    private int codPlaza;
    private LocalDate fecIngreso;
    private LocalDate fecSalida;
    private int pin;
    private double costeEstancia;

    public TicketVO(int codticket, int tipovehi,String matricula, int codplaza, LocalDate fecingreso, LocalDate fecsalida, int pin, double costeEstancia) {
        this.codTicket = codticket;
        this.tipoVehi = tipovehi;
        this.matricula = matricula;
        this.codPlaza = codplaza;
        this.fecIngreso = fecingreso;
        this.fecSalida = fecsalida;
        this.pin = pin;
        this.costeEstancia = costeEstancia;
    }

    public int getCodticket() {
        return codTicket;
    }

    public void setCodticket(int codticket) {
        this.codTicket = codticket;
    }

    public int getTipovehi() {
        return tipoVehi;
    }

    public void setTipovehi(int tipovehi) {
        this.tipoVehi = tipovehi;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCodplaza() {
        return codPlaza;
    }

    public void setCodplaza(int codplaza) {
        this.codPlaza = codplaza;
    }

    public LocalDate getFecingreso() {
        return fecIngreso;
    }

    public void setFecingreso(LocalDate fecingreso) {
        this.fecIngreso = fecingreso;
    }

    public LocalDate getFecsalida() {
        return fecSalida;
    }

    public void setFecsalida(LocalDate fecsalida) {
        this.fecSalida = fecsalida;
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
        return "TicketVO{" + "codticket=" + codTicket + ", tipovehi=" + tipoVehi + ", matricula=" + matricula + ", codplaza=" + codPlaza + ", fecingreso=" + fecIngreso + ", fecsalida=" + fecSalida + ", pin=" + pin + ", costeEstancia=" + costeEstancia + '}';
    }
    
    
    
}
