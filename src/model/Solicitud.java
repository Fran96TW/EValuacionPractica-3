package model;

import java.util.Date;

public class Solicitud {
    private Date fechaRegistro;
    private String descripcion;
    private String estado;
    private Colaborador responsable;
    private Area areaSolicitante;

    public Solicitud(Date fechaRegistro, String descripcion, Colaborador responsable, Area areaSolicitante) {
        this.fechaRegistro = fechaRegistro;
        this.descripcion = descripcion;
        this.estado = "Pendiente";
        this.responsable = responsable;
        this.areaSolicitante = areaSolicitante;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Colaborador getResponsable() {
        return responsable;
    }

    public Area getAreaSolicitante() {
        return areaSolicitante;
    }
}