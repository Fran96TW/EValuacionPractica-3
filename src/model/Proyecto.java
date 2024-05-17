package model;

import java.util.Date;

public class Proyecto {
    private String codigo;
    private String nombre;
    private String estado;
    private Date fechaAsignacion;
    private String prioridad;
    private Colaborador lider;
    private Date fechaEstimadaCierre;
    private Date fechaCierreReal;

    public Proyecto(String codigo, String nombre, String prioridad, Colaborador lider, Date fechaEstimadaCierre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = "Activo";
        this.fechaAsignacion = new Date();
        this.prioridad = prioridad;
        this.lider = lider;
        this.fechaEstimadaCierre = fechaEstimadaCierre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public Colaborador getLider() {
        return lider;
    }

    public Date getFechaEstimadaCierre() {
        return fechaEstimadaCierre;
    }

    public Date getFechaCierreReal() {
        return fechaCierreReal;
    }

    public void setFechaCierreReal(Date fechaCierreReal) {
        this.fechaCierreReal = fechaCierreReal;
    }

    public void setEstado(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEstado'");
    }

    public Object getIdProyecto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdProyecto'");
    }
}