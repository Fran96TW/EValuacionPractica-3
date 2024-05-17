package model;

public class ColaboradorExterno extends Colaborador {
    private int numCertificaciones;

    public ColaboradorExterno(String nombre, String apellido, String id, String correo, int extension, int numCertificaciones) {
        super(nombre, apellido, id, correo, extension);
        this.numCertificaciones = numCertificaciones;
    }

    public void addCertificacion() {
        numCertificaciones++;
    }

    public double calcularBonus(int horasTrabajadas) {
        double recargo = 0;
        if (numCertificaciones >= 3 && numCertificaciones <= 5) {
            recargo = 0.10;
        } else if (numCertificaciones > 5) {
            recargo = 0.20;
        }
        return horasTrabajadas * recargo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Certificaciones: " + numCertificaciones;
    }
}

