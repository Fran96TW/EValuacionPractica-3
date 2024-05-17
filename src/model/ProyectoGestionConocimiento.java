package model;

import java.util.Date;

public class ProyectoGestionConocimiento extends Proyecto {
    private String nombreProceso;
    private String comunidadImpactada;
    private String tipo;

    public ProyectoGestionConocimiento(String codigo, String nombre, String prioridad, Colaborador lider, Date fechaEstimadaCierre, String nombreProceso, String comunidadImpactada, String tipo) {
        super(codigo, nombre, prioridad, lider, fechaEstimadaCierre);
        this.nombreProceso = nombreProceso;
        this.comunidadImpactada = comunidadImpactada;
        this.tipo = tipo;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public String getComunidadImpactada() {
        return comunidadImpactada;
    }

    public String getTipo() {
        return tipo;
    }
}
