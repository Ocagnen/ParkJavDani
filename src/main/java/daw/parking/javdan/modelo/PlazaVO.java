/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.parking.javdan.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class PlazaVO {

    private int codPlaza;
    private int tipoPlaza;
    private int estado;
    private double coste;

    public PlazaVO(int codPlaza, int tipoPlaza, int estado, double coste) {
        this.codPlaza = codPlaza;
        this.tipoPlaza = tipoPlaza;
        this.estado = estado;
        this.coste = coste;
    }

    public PlazaVO() {

    }

    public String getNombreTipo() {

        switch (this.tipoPlaza) {
            case 0:
                return "Turismos";
            case 1:
                return "Motocicleta";
            default:
                return "Caravana";

        }

    }

    public String mostrarEstado() {

        switch (this.estado) {
            case 0:
                return "Libre";
            case 1:
                return "Ocupada";
            case 2:
                return "Abono ocupada";
            default:
                return "Abono libre";
        }

    }

    public static void mostrarPlazasLibres() {
        
        PlazaDAO daoPlaza = new PlazaDAO();        
        int contadorTuris = 0;
        int contadorMoto = 0;
        int contadorCarav = 0;
        

        try {
            ArrayList<PlazaVO> lista = (ArrayList<PlazaVO>) daoPlaza.getAll();
            for (PlazaVO plaza : lista) {

                if (plaza.getEstado() == 0 && plaza.getTipoPlaza() == 0) {

                    contadorTuris++;

                } else if (plaza.getEstado() == 0 && plaza.getTipoPlaza() == 1) {

                    contadorMoto++;

                } else if (plaza.getEstado() == 0 && plaza.getTipoPlaza() == 2) {

                    contadorCarav++;
                }

            }

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        System.out.println("Hay un total de "+
                (contadorTuris+contadorMoto+contadorCarav)+" plazas libres");
        System.out.println(contadorTuris+" plazas de turismos");
        System.out.println(contadorMoto+ " plazas de motos");
        System.out.println(contadorCarav+ " plazas de caravanas");

    }

    public static int obtenerPlazaLibre(int tipoVehi) {

        PlazaDAO daoPlaza = new PlazaDAO();

        try {
            ArrayList<PlazaVO> lista = (ArrayList<PlazaVO>) daoPlaza.getAll();
            for (PlazaVO plaza : lista) {

                if (plaza.getEstado() == 0 && plaza.getTipoPlaza() == tipoVehi) {

                    plaza.setEstado(1);
                    return plaza.getCodPlaza();

                }

            }

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return 0;

    }
    

    public int getCodPlaza() {
        return codPlaza;
    }

    public void setCodPlaza(int codPlaza) {
        this.codPlaza = codPlaza;
    }

    public int getTipoPlaza() {
        return tipoPlaza;
    }

    public void setTipoPlaza(int tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "PlazaVO{" + "codPlaza=" + codPlaza + ", tipoPlaza=" + tipoPlaza + ", estado=" + estado + ", coste=" + coste + '}';
    }
    
    public String toStringAdmin() {
        return "PlazaVO{" + "codPlaza=" + codPlaza + ", tipoPlaza=" + this.getNombreTipo() + ", estado=" + this.mostrarEstado() +'}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.codPlaza;
        hash = 71 * hash + this.tipoPlaza;
        hash = 71 * hash + this.estado;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.coste) ^ (Double.doubleToLongBits(this.coste) >>> 32));
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
        final PlazaVO other = (PlazaVO) obj;
        if (this.codPlaza != other.codPlaza) {
            return false;
        }
        if (this.tipoPlaza != other.tipoPlaza) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (Double.doubleToLongBits(this.coste) != Double.doubleToLongBits(other.coste)) {
            return false;
        }
        return true;
    }

}
