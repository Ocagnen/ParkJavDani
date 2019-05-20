
package daw.parking.javdan.modelo;

import java.time.LocalDateTime;
import java.util.Objects;


public class TicketVO {
   
    private int codTicket;
    private int tipoVehi;
    private String matricula;
    private int codPlaza;
    private LocalDateTime fecIngreso;
    private LocalDateTime fecSalida;
    private int pin;
    private double costeEstancia;

    public TicketVO(int codTicket, int tipoVehi, String matricula, int codPlaza, LocalDateTime fecIngreso, LocalDateTime fecSalida, int pin, double costeEstancia) {
        this.codTicket = codTicket;
        this.tipoVehi = tipoVehi;
        this.matricula = matricula;
        this.codPlaza = codPlaza;
        this.fecIngreso = fecIngreso;
        this.fecSalida = fecSalida;
        this.pin = pin;
        this.costeEstancia = costeEstancia;
    }

    public int getCodTicket() {
        return codTicket;
    }

    public void setCodTicket(int codTicket) {
        this.codTicket = codTicket;
    }

    public int getTipoVehi() {
        return tipoVehi;
    }

    public void setTipoVehi(int tipoVehi) {
        this.tipoVehi = tipoVehi;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCodPlaza() {
        return codPlaza;
    }

    public void setCodPlaza(int codPlaza) {
        this.codPlaza = codPlaza;
    }

    public LocalDateTime getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(LocalDateTime fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public LocalDateTime getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(LocalDateTime fecSalida) {
        this.fecSalida = fecSalida;
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
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.codTicket;
        hash = 17 * hash + this.tipoVehi;
        hash = 17 * hash + Objects.hashCode(this.matricula);
        hash = 17 * hash + this.codPlaza;
        hash = 17 * hash + Objects.hashCode(this.fecIngreso);
        hash = 17 * hash + Objects.hashCode(this.fecSalida);
        hash = 17 * hash + this.pin;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.costeEstancia) ^ (Double.doubleToLongBits(this.costeEstancia) >>> 32));
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

    @Override
    public String toString() {
        return "TicketVO{" + "codTicket=" + codTicket + ", tipoVehi=" + tipoVehi + ", matricula=" + matricula + ", codPlaza=" + codPlaza + ", fecIngreso=" + fecIngreso + ", fecSalida=" + fecSalida + ", pin=" + pin + ", costeEstancia=" + costeEstancia + '}';
    }
    
    

}