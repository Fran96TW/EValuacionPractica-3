package model;

import java.util.Date;

public class ProyectoTransformacionMejora extends Proyecto {
    private String codigoProceso;

    public ProyectoTransformacionMejora(String codigo, String nombre, String prioridad, Colaborador lider, Date fechaEstimadaCierre, String codigoProceso) {
        super(codigo, nombre, prioridad, lider, fechaEstimadaCierre);
        this.codigoProceso = codigoProceso;
    }

    public String getCodigoProceso() {
        return codigoProceso;
    }
}
