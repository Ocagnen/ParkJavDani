/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.parking.javdan.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author javier
 */
public class AbonadoVO {

    private String matricula;
    private String dni;
    private String nombre;
    private String apellidos;
    private String numeroTarjeta;
    private String email;
    private int pin;

    public AbonadoVO(String matricula, String dni, String nombre, String apellidos, String numeroTarjeta, String email, int pin) {
        this.matricula = matricula;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroTarjeta = numeroTarjeta;
        this.email = email;
        this.pin = pin;
    }

    public AbonadoVO() {
    }

    public static void insertarAbonado(AbonadoVO abonado) {

        AbonadoDAO daoAbonado = new AbonadoDAO();

        try {

            daoAbonado.insertAbonado(abonado);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

    }

    public static void modificarAbonado(AbonadoVO abonado) {

        AbonadoDAO daoAbonado = new AbonadoDAO();

        try {

            daoAbonado.updateAbonado(abonado.getMatricula(), abonado);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

    }

    public static boolean comprobarPin(int pin, String matricula) {

        AbonadoDAO daoAbonado = new AbonadoDAO();

        try {
            ArrayList<AbonadoVO> lista = (ArrayList<AbonadoVO>) daoAbonado.getAll();
            for (AbonadoVO abonado : lista) {

                if (abonado.getPin() == pin) {

                    return matricula.equals(abonado.matricula);

                }

            }

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return false;

    }

    public static boolean comprobarAbonadoMatr(String matricula) {

        AbonadoDAO daoAbonado = new AbonadoDAO();
        ArrayList<AbonadoVO> listaAux = new ArrayList<>();

        try {
            listaAux = (ArrayList<AbonadoVO>) daoAbonado.getAll();

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        for (AbonadoVO abonadoVO : listaAux) {
            if (abonadoVO.getMatricula().equalsIgnoreCase(matricula)) {
                return true;
            }
        }

        return false;

    }

    public static AbonadoVO obtenerAbonado(String matricula) throws SQLException {

        AbonadoDAO daoAbonado = new AbonadoDAO();

        return daoAbonado.findByCod(matricula);

    }

    public static void escribirDni() {

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "AbonadoVO{" + "matricula=" + matricula + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", numeroTarjeta=" + numeroTarjeta + ", email=" + email + ", pin=" + pin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.matricula);
        hash = 17 * hash + Objects.hashCode(this.dni);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.apellidos);
        hash = 17 * hash + Objects.hashCode(this.numeroTarjeta);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + this.pin;
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
        final AbonadoVO other = (AbonadoVO) obj;
        if (this.pin != other.pin) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.numeroTarjeta, other.numeroTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

}
