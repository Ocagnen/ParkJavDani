package daw.parking.javdan.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    // Constructor parametrizado
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

    // Constructor por defecto
    public TicketVO() {

    }

    // Método para generar un ticket con los datos del usuario
    public static TicketVO generarTicket(String matricula, int tipoVehi, int codPlaz) {

        TicketVO tick = new TicketVO();

        tick.setCodTicket(generarPKTick());
        tick.setCodPlaza(codPlaz);
        tick.setCosteEstancia(0);
        tick.setFecIngreso(LocalDate.now());
        tick.setFecSalida(LocalDate.now().plusYears(600));
        tick.setHoraIngreso(LocalTime.now());
        tick.setHoraSalida(LocalTime.MIDNIGHT);
        tick.setMatricula(matricula);
        tick.setPin(generarPin());
        tick.setTipoVehi(tipoVehi);

        try {

            TicketDAO daoTicket = new TicketDAO();
            System.out.println("No lo hago");
            daoTicket.insertTicket(tick);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return tick;

    }

    // Método para generar la PK del ticket
    public static int generarPKTick() {

        TicketDAO daoTicket = new TicketDAO();
        ArrayList<TicketVO> tickAux = new ArrayList<>();
        int contador = 0;

        try {

            tickAux = (ArrayList<TicketVO>) daoTicket.getAll();

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        for (TicketVO ticketVO : tickAux) {
            contador++;
        }

        return contador + 1;

    }

    // Método para generar un PIN aleatorio
    public static int generarPin() {

        Random alt = new Random();

        return alt.nextInt(999998 - 100000 + 1) + 100000;

    }

    // Método para obtener el codigo del ticket al sacar el coche mediante
    // los datos del usuario
    public static int obtenerCodTickSalida(String matricula, int plaza, int pin) {

        TicketDAO daoTicket = new TicketDAO();

        try {
            ArrayList<TicketVO> lista = (ArrayList<TicketVO>) daoTicket.getAll();
            for (TicketVO ticket : lista) {

                if (ticket.getMatricula().equals(matricula) && ticket.getCodPlaza() == plaza
                        && ticket.getPin() == pin) {

                    return ticket.codTicket;

                }

            }

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return -1;
    }

    // Método para obtener el ticket de la bbdd mediante su pk
    public static TicketVO obtenerTicket(int pk) throws SQLException {

        TicketDAO daoTicket = new TicketDAO();

        return daoTicket.findByCod(pk);

    }

    // Método para cerrar el ticket una vez salga el cliente
    public static void cerrarTicket(TicketVO ticket) {

        TicketDAO daoTicket = new TicketDAO();

        try {

            daoTicket.updateTicket(ticket.codTicket, ticket);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

    }

    // Método para actualizar el ticket al salir el coche
    public void actualizarTicketSalida() {

        this.fecSalida = LocalDate.now();
        this.horaSalida = LocalTime.now();
        this.costeEstancia = this.calcularTarifa();

        TicketDAO daoTicket = new TicketDAO();

        try {

            daoTicket.updateTicket(this.getCodTicket(), this);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

    }

    // Método para calcular el número de dias que el coche estuvo dentro
    public int calcularDias() {

        long diferenciaDias = ChronoUnit.DAYS.between(this.fecIngreso, this.fecSalida);

        return (int) diferenciaDias;

    }

    // Método pra calcular el número de minutos en base al número de dias
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
                numMin = (int) minutosEnMismoDia + (int) minutosDiaDespues;
                break;
            default:
                minutosEnMismoDia = ChronoUnit.MINUTES.between(this.horaIngreso, LocalTime.MIDNIGHT);
                minutosDiaDespues = ChronoUnit.MINUTES.between(LocalTime.MIDNIGHT, this.horaSalida);
                numMin = (int) minutosEnMismoDia + (int) minutosDiaDespues + ((dias - 1) * 1440);
                break;
        }

        return numMin;

    }

    // Método para calcular el importe que debe pagar el cliente
    public double calcularTarifa() {

        PlazaDAO daoPlaza = new PlazaDAO();
        PlazaVO plazaAux = new PlazaVO();

        try {
            plazaAux = daoPlaza.findByCod(this.codPlaza);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        return calcularMinutos(calcularDias()) * plazaAux.getCoste();

    }

    // Método para obtener los tickets entre dos fechas
    public static ArrayList<TicketVO> obtenerTicketsFechas(LocalDate finIni, LocalDate fecFin) {

        TicketDAO daoTicket = new TicketDAO();

        ArrayList<TicketVO> listaAux = new ArrayList<>();
        ArrayList<TicketVO> listaDevolver = new ArrayList<>();

        try {

            listaAux = (ArrayList<TicketVO>) daoTicket.getAll();

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }

        for (TicketVO ticketVO : listaAux) {

            if (ticketVO.getFecSalida().isAfter(finIni)
                    && ticketVO.getFecSalida().isBefore(fecFin)) {

                listaDevolver.add(ticketVO);

            }

        }

        return listaDevolver;
    }

    // Métodos para obtener los tickets entre unas horas determinadas
    public static ArrayList<TicketVO> obtenerTicketHoras(ArrayList<TicketVO> lista, LocalTime horaIni, LocalTime horaFin) {

        ArrayList<TicketVO> listaDevolver = new ArrayList<>();

        for (TicketVO ticketVO : lista) {

            if (ticketVO.getHoraIngreso().isAfter(horaIni)
                    && ticketVO.getHoraSalida().isBefore(horaFin)) {

                listaDevolver.add(ticketVO);

            }

        }

        return listaDevolver;
    }

    // Método para mostrar los cobros realizados mediante una lista de tickets
    public static void mostrarCobros(ArrayList<TicketVO> lista) {

        System.out.println("COBROS");
        double costeEst = 0;

        for (TicketVO ticketVO : lista) {

            System.out.println(ticketVO.getCosteEstancia() + "€");
            costeEst = costeEst + ticketVO.getCosteEstancia();

        }

        System.out.println("IMPORTE FINAL");
        System.out.println(costeEst + "€");

    }

    // Getters y setters
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

    // hashCode y equals
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

    //Método toString
    @Override
    public String toString() {
        return "TicketVO{" + "codTicket=" + codTicket + ", tipoVehi=" + tipoVehi + ", matricula=" + matricula + ", codPlaza=" + codPlaza + ", fecIngreso=" + fecIngreso + ", fecSalida=" + fecSalida + ", horaIngreso=" + horaIngreso + ", horaSalida=" + horaSalida + ", pin=" + pin + ", costeEstancia=" + costeEstancia + '}';
    }

    // Método toString para mostrar a los clientes
    public String toStringParaClientes() {
        return "TicketVO{" + " matricula=" + matricula + ", codPlaza=" + codPlaza + ", fecIngreso=" + fecIngreso + ", horaIngreso=" + horaIngreso + ", pin=" + pin + '}';

    }

}
