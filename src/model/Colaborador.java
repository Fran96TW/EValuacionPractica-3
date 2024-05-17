package model;

public class Colaborador {
    private String nombre;
    private String apellido;
    private String id;
    private String correo;
    private int extension;

    public Colaborador(String nombre, String apellido, String id, String correo, int extension) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.correo = correo;
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public double calcularEficiencia(int asignados, int completados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularEficiencia'");
    }

    public String getProyectosDeMejora() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProyectosDeMejora'");
    }
}
