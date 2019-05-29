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

    // Constructor parametrizado
    public DetalleAbonadoVO(String matricula, int codPlaza, int tipoAbono, LocalDate fecIniAbono, LocalDate fecFinAbono) {
        this.matricula = matricula;
        this.codPlaza = codPlaza;
        this.tipoAbono = tipoAbono;
        this.fecIniAbono = fecIniAbono;
        this.fecFinAbono = fecFinAbono;
    }

    // Constructor por defecto
    public DetalleAbonadoVO() {
    }

    // Método para obtener el cod plaza de un abono
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

    // Método para retirar un Vehiculo de abonado
    public static boolean retirarVehiAbo(String matricula, int plaza, int pin) {

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

    // Método para obtener todos los abonos del año en una lista
    public static ArrayList<DetalleAbonadoVO> obtenerAbonosAnuales() {

        DetalleAbonadoDAO daoDetAbo = new DetalleAbonadoDAO();

        ArrayList<DetalleAbonadoVO> listaAux = new ArrayList<>();
        ArrayList<DetalleAbonadoVO> listaDev = new ArrayList<>();
        int anioActual = LocalDate.now().getYear();

        try {

            listaAux = (ArrayList<DetalleAbonadoVO>) daoDetAbo.getAll();

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        for (DetalleAbonadoVO detalleAbonadoVO : listaAux) {

            if (detalleAbonadoVO.getFecFinAbono().isAfter(LocalDate.of(anioActual, 1, 1))
                    && detalleAbonadoVO.getFecFinAbono().isBefore(LocalDate.of(anioActual, 12, 31))) {

                listaDev.add(detalleAbonadoVO);

            }

        }

        return listaDev;

    }

    // Método para mostrar el cobro de los abonados
    public static void muestraCobroAbonados(ArrayList<DetalleAbonadoVO> lista) {

        System.out.println("COBROS ABONADOS");
        int cobroTotal = 0;

        for (DetalleAbonadoVO detalleAbonadoVO : lista) {

            System.out.println(detalleAbonadoVO.calcularAbonos() + "€");
            cobroTotal = cobroTotal + detalleAbonadoVO.calcularAbonos();
        }

        System.out.println("COBRO TOTAL ABONADOS");
        System.out.println(cobroTotal + "€");

    }

    // Método para calcular el importe de los abonos
    public int calcularAbonos() {

        switch (this.tipoAbono) {

            case 0:
                return 25;
            case 1:
                return 70;
            case 2:
                return 130;
            default:
                return 200;

        }

    }

    // Método para insertar un abono en la bbdd
    public static DetalleAbonadoVO insertaNuevoDetalleAbonado(int tipoAbono, int tipoVehi, String matricula) {

        DetalleAbonadoDAO daoDetAbo = new DetalleAbonadoDAO();
        DetalleAbonadoVO detAb = new DetalleAbonadoVO();

        PlazaDAO daoPlaza = new PlazaDAO();
        PlazaVO plazaAux = new PlazaVO();

        AbonadoDAO daoAbonado = new AbonadoDAO();
        AbonadoVO abonadoAux = new AbonadoVO();

        int pkPlaza = PlazaVO.obtenerPlazaLibreAbo(tipoVehi);

        try {
            abonadoAux = daoAbonado.findByCod(matricula);
            plazaAux = daoPlaza.findByCod(pkPlaza);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        detAb.setCodPlaza(pkPlaza);
        detAb.setFecIniAbono(LocalDate.now());
        detAb.setMatricula(matricula);
        detAb.setTipoAbono(tipoAbono);
        detAb.setFecFinAbono(DetalleAbonadoVO.generarFechaFinAbono(tipoAbono));

        try {

            daoDetAbo.insertDetAb(detAb);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return detAb;

    }

    // Método para obtener un abonado que tenga un abono activo
    public static DetalleAbonadoVO obtenerDetallesAbonoActivo(String matricula) throws SQLException {

        DetalleAbonadoDAO daoDetAbo = new DetalleAbonadoDAO();
        ArrayList<DetalleAbonadoVO> lista = new ArrayList<>();
        DetalleAbonadoVO detAuxi = new DetalleAbonadoVO();

        lista = (ArrayList<DetalleAbonadoVO>) daoDetAbo.getAll();

        for (DetalleAbonadoVO detalleAbonadoVO : lista) {

            if (detalleAbonadoVO.getMatricula().equals(matricula)
                    && detalleAbonadoVO.getFecFinAbono().isAfter(LocalDate.now())) {
                detAuxi = detalleAbonadoVO;
            }

        }

        return detAuxi;
    }

    // Comprobar si un abonado tiene un abono activo
    public static boolean compruebaAbonoActivo(String matricula) {

        DetalleAbonadoDAO daoDetAbo = new DetalleAbonadoDAO();
        ArrayList<DetalleAbonadoVO> lista = new ArrayList<>();

        try {

            lista = (ArrayList<DetalleAbonadoVO>) daoDetAbo.getAll();

            for (DetalleAbonadoVO detalleAbonadoVO : lista) {

                if (detalleAbonadoVO.getMatricula().equals(matricula)
                        && detalleAbonadoVO.getFecFinAbono().isAfter(LocalDate.now())) {
                    return true;
                }

            }

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return false;

    }

    // Método para generar la fecha de abono tras actualizarla
    public static LocalDate generarFechaFinAbono(int tipoAbo) {

        switch (tipoAbo) {
            case 0:
                return LocalDate.now().plusMonths(1);
            case 1:
                return LocalDate.now().plusMonths(3);
            case 2:
                return LocalDate.now().plusMonths(6);
            default:
                return LocalDate.now().plusYears(1);

        }

    }

    // Método para renovar los abonos cambiando su fecha de vencimiento
    public static void renovarAbono(DetalleAbonadoVO detAb, int tipoAbo) {

        switch (tipoAbo) {
            case 0:
                detAb.setFecFinAbono(detAb.getFecFinAbono().plusMonths(1));
                break;
            case 1:
                detAb.setFecFinAbono(detAb.getFecFinAbono().plusMonths(3));
                break;
            case 2:
                detAb.setFecFinAbono(detAb.getFecFinAbono().plusMonths(6));
                break;
            case 3:
                detAb.setFecFinAbono(detAb.getFecFinAbono().plusYears(1));
                break;

        }

        DetalleAbonadoDAO daoDetAbo = new DetalleAbonadoDAO();

        try {

            daoDetAbo.updateDetAb(detAb.getMatricula(), detAb.getCodPlaza(), detAb.getFecIniAbono(), detAb);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

    }

    // Método para mostrar los abonos de un mes concreto
    public static void mostrarAbonosMes(int mes) {

        ArrayList<DetalleAbonadoVO> lista = DetalleAbonadoVO.obtenerAbonosAnuales();

        System.out.println("ABONOS QUE CADUCAN EN EL MES " + mes);

        for (DetalleAbonadoVO detalleAbonadoVO : lista) {

            if ((detalleAbonadoVO.getFecFinAbono().getMonthValue() == mes)) {

                System.out.println(detalleAbonadoVO.toString());

            }

        }

    }

    // Método para mostrar los abonos que caducan en 10 dias
    public static void abonosCaducanDiezDias() {

        ArrayList<DetalleAbonadoVO> lista = DetalleAbonadoVO.obtenerAbonosAnuales();
        
        for (DetalleAbonadoVO detalleAbonadoVO : lista) {
            
            if((detalleAbonadoVO.getFecFinAbono().isAfter(LocalDate.now())
                    && detalleAbonadoVO.getFecFinAbono().isBefore(LocalDate.now().plusDays(10)))){
                
                System.out.println(detalleAbonadoVO.toString());
                
            }
            
                
        }
        
    }

    // Getters y setters
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

    // hashCode y Equals
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

    // Método toString
    @Override
    public String toString() {
        return "DetalleAbonadoVO{" + "matricula=" + matricula + ", codPlaza=" + codPlaza + ", tipoAbono=" + tipoAbono + ", fecIniAbono=" + fecIniAbono + ", fecFinAbono=" + fecFinAbono + '}';
    }

}
