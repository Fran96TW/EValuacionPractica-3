package model;

public class ColaboradorTransformacion extends Colaborador {
    private int mejorasImplementadas;
    private int proyectosFinalizados;

    public ColaboradorTransformacion(String nombre, String apellido, String id, String correo, int extension, int mejorasImplementadas, int proyectosFinalizados) {
        super(nombre, apellido, id, correo, extension);
        this.mejorasImplementadas = mejorasImplementadas;
        this.proyectosFinalizados = proyectosFinalizados;
    }

    public int getMejorasImplementadas() {
        return mejorasImplementadas;
    }

    public void setMejorasImplementadas(int mejorasImplementadas) {
        this.mejorasImplementadas = mejorasImplementadas;
    }

    public int getProyectosFinalizados() {
        return proyectosFinalizados;
    }

    public void setProyectosFinalizados(int proyectosFinalizados) {
        this.proyectosFinalizados = proyectosFinalizados;
    }
}


