package aed;

import java.util.ArrayList;
import java.util.Vector;

public class Agenda {
    private Fecha fechaActual;
    private ArrayList<Recordatorio> recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
        this.recordatorios = new ArrayList<Recordatorio>();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.add(recordatorio);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recordatorios para la fecha ").append(fechaActual).append(":\n");
        for (Recordatorio recordatorio : recordatorios) {
            if (recordatorio.getFecha().equals(fechaActual)) {
                sb.append(" - ").append(recordatorio.getMensaje()).append("\n");
            }
        }
        return sb.toString();
    }

    public void incrementarDia() {
        fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return fechaActual;
    }

}
