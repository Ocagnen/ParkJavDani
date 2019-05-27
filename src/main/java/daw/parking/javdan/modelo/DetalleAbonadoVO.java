package daw.parking.javdan.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class DetalleAbonadoVO {

    private String matricula;
    private int codPlaza;
    private int tipoAbono;
    private LocalDate fecIniAbono;
    private LocalDate fecFinAbono;

    public DetalleAbonadoVO(String matricula, int codPlaza, int tipoAbono, LocalDate fecIniAbono, LocalDate fecFinAbono) {
        this.matricula = matricula;
        this.codPlaza = codPlaza;
        this.tipoAbono = tipoAbono;
        this.fecIniAbono = fecIniAbono;
        this.fecFinAbono = fecFinAbono;
    }

    public DetalleAbonadoVO() {
    }

    public static int obtenerPlaza(String matricula) {

        DetalleAbonadoDAO daoDetalleAbonado = new DetalleAbonadoDAO();

        try {
            ArrayList<DetalleAbonadoVO> lista = (ArrayList<DetalleAbonadoVO>) daoDetalleAbonado.getAll();
            for (DetalleAbonadoVO detAbonado : lista) {

                if (matricula.equals(detAbonado.matricula) && detAbonado.fecFinAbono.isAfter(LocalDate.now())) {

                    return detAbonado.codPlaza;

                }

            }

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return 0;
    }

    public boolean retirarVehiAbo(String matricula, int plaza, int pin) {

        DetalleAbonadoDAO daoDetalleAbonado = new DetalleAbonadoDAO();

        try {
            ArrayList<DetalleAbonadoVO> lista = (ArrayList<DetalleAbonadoVO>) daoDetalleAbonado.getAll();
            for (DetalleAbonadoVO detAbonado : lista) {

                if (matricula.equals(detAbonado.matricula) && detAbonado.codPlaza == plaza
                        && AbonadoVO.comprobarPin(pin, matricula) && detAbonado.fecFinAbono.isAfter(LocalDate.now())) {

                    PlazaDAO daoPlaza = new PlazaDAO();
                    try {
                        PlazaVO plazaTempo = daoPlaza.findByCod(DetalleAbonadoVO.obtenerPlaza(matricula));
                        plazaTempo.setEstado(3);
                        daoPlaza.updatePlaza(DetalleAbonadoVO.obtenerPlaza(matricula), plazaTempo);
                    } catch (SQLException sqle) {
                        System.out.println("No se ha podido realizar la operación:");
                        System.out.println(sqle.getMessage());
                    }

                    return true;

                }

            }

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return false;

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

    public int getTipoAbono() {
        return tipoAbono;
    }

    public void setTipoAbono(int tipoAbono) {
        this.tipoAbono = tipoAbono;
    }

    public LocalDate getFecIniAbono() {
        return fecIniAbono;
    }

    public void setFecIniAbono(LocalDate fecIniAbono) {
        this.fecIniAbono = fecIniAbono;
    }

    public LocalDate getFecFinAbono() {
        return fecFinAbono;
    }

    public void setFecFinAbono(LocalDate fecFinAbono) {
        this.fecFinAbono = fecFinAbono;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.matricula);
        hash = 61 * hash + this.codPlaza;
        hash = 61 * hash + this.tipoAbono;
        hash = 61 * hash + Objects.hashCode(this.fecIniAbono);
        hash = 61 * hash + Objects.hashCode(this.fecFinAbono);
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
        if (!Objects.equals(this.fecIniAbono, other.fecIniAbono)) {
            return false;
        }
        if (!Objects.equals(this.fecFinAbono, other.fecFinAbono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleAbonadoVO{" + "matricula=" + matricula + ", codPlaza=" + codPlaza + ", tipoAbono=" + tipoAbono + ", fecIniAbono=" + fecIniAbono + ", fecFinAbono=" + fecFinAbono + '}';
    }

}
