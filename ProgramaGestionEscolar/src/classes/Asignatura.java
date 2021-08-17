package classes;

public class Asignatura {

    private int codigo;
    private String nombre;
    private int creditos;
    private int semestre;
    private double nota;

    public Asignatura() {
        this.nota = 0;
    }

    public Asignatura(int codigo, String nombre, int creditos, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
        this.nota = 0;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Nota: " + nota
                + ", Créditos: " + creditos + ", Semestre: " + semestre;
    }

}
