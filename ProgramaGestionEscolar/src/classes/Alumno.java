package classes;

import java.util.ArrayList;

public class Alumno {

    private int ncuenta;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private int edad;
    private String direccion;
    private ArrayList<Asignatura> asignaturas;
    private double numero_inscripcion;

    public Alumno() {
        this.asignaturas = new ArrayList<>();
    }

    public int getNcuenta() {
        return ncuenta;
    }

    public void setNcuenta(int ncuenta) {
        this.ncuenta = ncuenta;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getNumero_inscripcion() {
        return numero_inscripcion;
    }

    public void setNumero_inscripcion(double numero_inscripcion) {
        this.numero_inscripcion = numero_inscripcion;
    }

    public void calcular_numero_inscripcion() {
        int cont = 0, creditos_aprobados = 0, creditos_total = 0;
        double promedio = 0, escolaridad, velocidad;
        for (Asignatura asignatura : asignaturas) {
            creditos_total += asignatura.getCreditos();
            if (asignatura.getNota() >= 5 && asignatura.getNota() <= 10) {
                creditos_aprobados += asignatura.getCreditos();
                promedio += asignatura.getNota();
                cont++;
            }
        }
        promedio = promedio / cont;
        escolaridad = (cont / asignaturas.size()) * 100;
        velocidad = (creditos_aprobados / creditos_total) * 100;
        this.numero_inscripcion = promedio * escolaridad * velocidad;
    }

    public String toFile() {
        return ncuenta + "," + nombre + "," + ap_paterno + "," + ap_materno + ","
                + edad + "," + numero_inscripcion + "," + direccion;
    }

    public void mostrar_asignaturas() {
        System.out.println("\n\tAsignaturas");
        for (Asignatura asignatura : asignaturas) {
            System.out.println("\t- " + asignatura.toString());
        }
    }

    @Override
    public String toString() {
        return "Alumno{"
                + "\n\tNúmero de cuenta: " + ncuenta
                + "\n\tNombre: " + nombre
                + "\n\tApellido paterno: " + ap_paterno
                + "\n\tApellido materno: " + ap_materno
                + "\n\tEdad: " + edad
                + "\n\tNúmero_inscripcion: " + numero_inscripcion
                + "\n\tDirección: " + direccion
                + "\n}";
    }

}
