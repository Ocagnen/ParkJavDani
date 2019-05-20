
package daw.parking.javdan.modelo;

import java.time.LocalDate;
import java.util.Objects;


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
    
    public double calcularEstancia(){
        
        if(this.fecSalida != null){
            
            
            
        }
        
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codTicket;
        hash = 29 * hash + this.tipoVehi;
        hash = 29 * hash + Objects.hashCode(this.matricula);
        hash = 29 * hash + this.codPlaza;
        hash = 29 * hash + Objects.hashCode(this.fecIngreso);
        hash = 29 * hash + Objects.hashCode(this.fecSalida);
        hash = 29 * hash + this.pin;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.costeEstancia) ^ (Double.doubleToLongBits(this.costeEstancia) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TicketVO other = (TicketVO) obj;
        if (this.codTicket != other.codTicket) {
            return false;
        }
        if (this.tipoVehi != other.tipoVehi) {
            return false;
        }
        if (this.codPlaza != other.codPlaza) {
            return false;
        }
        if (this.pin != other.pin) {
            return false;
        }
        if (Double.doubleToLongBits(this.costeEstancia) != Double.doubleToLongBits(other.costeEstancia)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.fecIngreso, other.fecIngreso)) {
            return false;
        }
        if (!Objects.equals(this.fecSalida, other.fecSalida)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
