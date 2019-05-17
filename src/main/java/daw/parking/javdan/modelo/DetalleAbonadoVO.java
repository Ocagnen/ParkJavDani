
package daw.parking.javdan.modelo;

import java.time.LocalDate;


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
    
    public void mostrarTipAb(){
        
        System.out.println("Seleccione el tipo de abono deseado");
        System.out.println("0--->mensual");
        System.out.println("1--->trimestral");
        System.out.println("2--->semestral");
        System.out.println("3--->anual");
        System.out.println("");
        
        switch (tipoAbono) {
            case 0:
                
                System.out.println("Mensual:25€");
                break;
            
            case 1:
                
                System.out.println("Trimestral:70€");
                break;
                
             case 2:
                
                System.out.println("Semestral:130€");
                break;
                
            case 3:
                
                System.out.println("Anual:200€");
                break;
            
        }
        
        System.out.println("----------------------------------");
    
}
    
}
