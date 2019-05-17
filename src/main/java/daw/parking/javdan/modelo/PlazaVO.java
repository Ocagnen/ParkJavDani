/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.parking.javdan.modelo;

/**
 *
 * @author javier
 */
public class PlazaVO {
    
    private int codPlaza;
    private int tipoPlaza;
    private int estado;

    public PlazaVO(int codPlaza, int tipoPlaza, int estado) {
        this.codPlaza = codPlaza;
        this.tipoPlaza = tipoPlaza;
        this.estado = estado;
    }
    
    public String getNombreTipo(){
        
        switch(this.tipoPlaza){
            case 0:
                return "Turismos";
            case 1:
                return "Motocicleta";     
            default:
                return "Caravana"; 
          
        } 
        
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

    @Override
    public String toString() {
        return "PlazaVO{" + "codPlaza=" + codPlaza + ", tipoPlaza=" + tipoPlaza + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codPlaza;
        hash = 67 * hash + this.tipoPlaza;
        hash = 67 * hash + this.estado;
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
        return true;
    }

    
    
    
           
    
}
