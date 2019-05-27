package daw.parking.javdan.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;

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

    public int generarPin() {

        Random alt = new Random();

        return alt.nextInt(999998 - 100000 + 1) + 100000;

    }

    public int calcularDias() {

        long diferenciaDias = ChronoUnit.DAYS.between(this.fecIngreso, this.fecSalida);

        return (int) diferenciaDias;

    }

    public int calcularMinutos(int dias) {

        int numMin;
        long minutosEnMismoDia;
        long minutosDiaDespues;

        switch (dias) {
            case 0:
                minutosEnMismoDia = ChronoUnit.MINUTES.between(this.horaIngreso, this.horaSalida);
                numMin = (int) minutosEnMismoDia;
                break;
            case 1:
                minutosEnMismoDia = ChronoUnit.MINUTES.between(this.horaIngreso, LocalTime.MIDNIGHT);
                minutosDiaDespues = ChronoUnit.MINUTES.between(LocalTime.MIDNIGHT, this.horaSalida);
                numMin = (int)minutosEnMismoDia + (int)minutosDiaDespues;
                break;
            default:
                minutosEnMismoDia = ChronoUnit.MINUTES.between(this.horaIngreso, LocalTime.MIDNIGHT);
                minutosDiaDespues = ChronoUnit.MINUTES.between(LocalTime.MIDNIGHT, this.horaSalida);
                numMin = (int)minutosEnMismoDia + (int)minutosDiaDespues + ((dias-1)*1440);
                break;
        }
        
        return numMin;

    }

    public double calcularTarifa() {

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
        int hash = 3;
        hash = 53 * hash + this.codTicket;
        hash = 53 * hash + this.tipoVehi;
        hash = 53 * hash + Objects.hashCode(this.matricula);
        hash = 53 * hash + this.codPlaza;
        hash = 53 * hash + Objects.hashCode(this.fecIngreso);
        hash = 53 * hash + Objects.hashCode(this.fecSalida);
        hash = 53 * hash + Objects.hashCode(this.horaIngreso);
        hash = 53 * hash + Objects.hashCode(this.horaSalida);
        hash = 53 * hash + this.pin;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.costeEstancia) ^ (Double.doubleToLongBits(this.costeEstancia) >>> 32));
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
