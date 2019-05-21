
package daw.parking.javdan.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;


public class TicketVO {
   
    private int codTicket;
    private int tipoVehi;
    private String matricula;
    private int codPlaza;
    private LocalDate fecIngreso;
    private LocalDate fecSalida;
    private LocalTime horaIngreso;
    private LocalTime horaSalida;
    private int pin;
    private double costeEstancia;

    public TicketVO(int codTicket, int tipoVehi, String matricula, int codPlaza, LocalDate fecIngreso, LocalDate fecSalida, LocalTime horaIngreso, LocalTime horaSalida, int pin, double costeEstancia) {
        this.codTicket = codTicket;
        this.tipoVehi = tipoVehi;
        this.matricula = matricula;
        this.codPlaza = codPlaza;
        this.fecIngreso = fecIngreso;
        this.fecSalida = fecSalida;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.pin = pin;
        this.costeEstancia = costeEstancia;
    }

    public TicketVO() {
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

    public LocalDate getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(LocalDate fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public LocalDate getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(LocalDate fecSalida) {
        this.fecSalida = fecSalida;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
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
        int hash = 7;
        hash = 31 * hash + this.codTicket;
        hash = 31 * hash + this.tipoVehi;
        hash = 31 * hash + Objects.hashCode(this.matricula);
        hash = 31 * hash + this.codPlaza;
        hash = 31 * hash + Objects.hashCode(this.fecIngreso);
        hash = 31 * hash + Objects.hashCode(this.fecSalida);
        hash = 31 * hash + Objects.hashCode(this.horaIngreso);
        hash = 31 * hash + Objects.hashCode(this.horaSalida);
        hash = 31 * hash + this.pin;
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.costeEstancia) ^ (Double.doubleToLongBits(this.costeEstancia) >>> 32));
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
        if (!Objects.equals(this.horaIngreso, other.horaIngreso)) {
            return false;
        }
        if (!Objects.equals(this.horaSalida, other.horaSalida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TicketVO{" + "codTicket=" + codTicket + ", tipoVehi=" + tipoVehi + ", matricula=" + matricula + ", codPlaza=" + codPlaza + ", fecIngreso=" + fecIngreso + ", fecSalida=" + fecSalida + ", horaIngreso=" + horaIngreso + ", horaSalida=" + horaSalida + ", pin=" + pin + ", costeEstancia=" + costeEstancia + '}';
    }
    
    
    
}