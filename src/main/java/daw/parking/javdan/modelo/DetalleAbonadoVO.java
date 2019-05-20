package daw.parking.javdan.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class DetalleAbonadoVO {

    private String matricula;
    private int codPlaza;
    private int tipoAbono;
    private LocalDate fecIniabono;
    private LocalDate fecFinabono;

    public DetalleAbonadoVO(String matricula, int codplaza, int tipoAbono, LocalDate feciniabono, LocalDate fecfinabono) {
        this.matricula = matricula;
        this.codPlaza = codplaza;
        this.tipoAbono = tipoAbono;
        this.fecIniabono = feciniabono;
        this.fecFinabono = fecfinabono;
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

    public int getTipoAbono() {
        return tipoAbono;
    }

    public void setTipoAbono(int tipoAbono) {
        this.tipoAbono = tipoAbono;
    }

    public LocalDate getFeciniabono() {
        return fecIniabono;
    }

    public void setFeciniabono(LocalDate feciniabono) {
        this.fecIniabono = feciniabono;
    }

    public LocalDate getFecfinabono() {
        return fecFinabono;
    }

    public void setFecfinabono(LocalDate fecfinabono) {
        this.fecFinabono = fecfinabono;
    }

    @Override
    public String toString() {
        return "detallesAbonadosVO{" + "matricula=" + matricula + ", codplaza=" + codPlaza + ", tipoAbono=" + tipoAbono + ", feciniabono=" + fecIniabono + ", fecfinabono=" + fecFinabono + '}';
    }

    public String mostrarTipAb() {

        switch (this.tipoAbono) {
            case 0:

                return "Mensual:25€";

            case 1:

                return "Trimestral:70€";

            case 2:

                return "Semestral:130€";

            default:

                return "Anual:200€";

        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.matricula);
        hash = 47 * hash + this.codPlaza;
        hash = 47 * hash + this.tipoAbono;
        hash = 47 * hash + Objects.hashCode(this.fecIniabono);
        hash = 47 * hash + Objects.hashCode(this.fecFinabono);
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
        final DetalleAbonadoVO other = (DetalleAbonadoVO) obj;
        if (this.codPlaza != other.codPlaza) {
            return false;
        }
        if (this.tipoAbono != other.tipoAbono) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.fecIniabono, other.fecIniabono)) {
            return false;
        }
        if (!Objects.equals(this.fecFinabono, other.fecFinabono)) {
            return false;
        }
        return true;
    }
    
    

}
