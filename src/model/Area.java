package model;

public class Area {
    private String nombre;
    private String codigo;
    private Colaborador responsable;

    public Area(String nombre, String codigo, Colaborador responsable) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.responsable = responsable;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public Colaborador getResponsable() {
        return responsable;
    }
}
