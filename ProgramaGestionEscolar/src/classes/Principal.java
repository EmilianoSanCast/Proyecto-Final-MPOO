package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Alumno> alumnos = new ArrayList<>();
    public static ArrayList<String> direcciones = new ArrayList<>();
    public static int length = 20;

    public static String[] nombres = {
        "Jesus", "Anna", "Jose", "Maria", "Pepe", 
        "Sofia", "Rosa", "Roberto", "Juan", "Rosalia",
        "Pancracio", "Joaquin", "Valeria", "Angela", "Gina",
        "Sandy", "Pedro", "Jorge", "Lucia", "Stefany" 
    };
    public static String[] apellidos = {
        "Hernandez", "Gonzalez", "Gutierrez", "Carrillo", "Perez",
        "Cruz", "Sanchez", "Zamora", "Morales", "Lopez",
        "Ayala", "Zavala", "Ramirez", "Castellanos", "Juarez",
        "Rodriguez", "Cortez", "Ruiz", "Martinez", "Gomez"
    };
    

    public static ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public static void inicializar_asignaturas() {
        asignaturas.add(new Asignatura(1, "Calculo Diferencial", 3, 1));
        asignaturas.add(new Asignatura(2, "Algebra", 3, 1));
        asignaturas.add(new Asignatura(3, "Fundamentos de programacion", 3, 1));
        asignaturas.add(new Asignatura(4, "Quimica", 3, 1));
        asignaturas.add(new Asignatura(5, "Redaccion", 3, 1));

        asignaturas.add(new Asignatura(6, "Calculo Integral", 3, 2));
        asignaturas.add(new Asignatura(7, "Algebra Lineal", 3, 2));
        asignaturas.add(new Asignatura(8, "Mecanica", 3, 2));
        asignaturas.add(new Asignatura(9, "Cultura", 3, 2));
        asignaturas.add(new Asignatura(10, "Estructura de Datos y algoritmos", 3, 2));

        asignaturas.add(new Asignatura(11, "Calculo Vectorial", 3, 3));
        asignaturas.add(new Asignatura(12, "Termodinamica", 3, 3));
        asignaturas.add(new Asignatura(13, "Ecuaciones diferenciales", 3, 3));
        asignaturas.add(new Asignatura(14, "Modelos de Programacion Orientada a Objetos", 3, 3));
        asignaturas.add(new Asignatura(15, "Optativa de ciencias sociales", 3, 3));

        asignaturas.add(new Asignatura(16, "Probabilidad", 3, 4));
        asignaturas.add(new Asignatura(17, "Electricidad y Magnetismo", 3, 4));
        asignaturas.add(new Asignatura(18, "Analisis Numerico", 3, 4));
        asignaturas.add(new Asignatura(19, "Analisis de Sistemas", 3, 4));
        asignaturas.add(new Asignatura(20, "Costos y evaluacion de proyectos", 3, 4));

        asignaturas.add(new Asignatura(21, "Estadistica", 3, 5));
        asignaturas.add(new Asignatura(22, "Acustica y optica", 3, 5));
        asignaturas.add(new Asignatura(23, "Dinamica de sistemas", 3, 5));
        asignaturas.add(new Asignatura(24, "Analisis de circuitos", 3, 5));
        asignaturas.add(new Asignatura(25, "Fisica de semiconductores", 3, 5));

        asignaturas.add(new Asignatura(26, "Introduccion a la economia", 3, 6));
        asignaturas.add(new Asignatura(27, "Teoria electromagnetica", 3, 6));
        asignaturas.add(new Asignatura(28, "Fundamentos de control", 3, 6));
        asignaturas.add(new Asignatura(29, "Dispositivos y circuitos", 3, 6));
        asignaturas.add(new Asignatura(30, "Maquinas electricas 1", 3, 6));

        asignaturas.add(new Asignatura(31, "Medicion e instrumentacion", 3, 7));
        asignaturas.add(new Asignatura(32, "Diseño digital", 3, 7));
        asignaturas.add(new Asignatura(33, "Sistemas de comunicaciones", 3, 7));
        asignaturas.add(new Asignatura(34, "Amplificadores", 3, 7));
        asignaturas.add(new Asignatura(35, "Sistemas electricos de potencia", 3, 7));

        asignaturas.add(new Asignatura(36, "Automatizacion", 3, 8));
        asignaturas.add(new Asignatura(37, "Microprocesadores y micro controladores ", 3, 8));
        asignaturas.add(new Asignatura(39, "Procesamiento digital de señales", 3, 8));
        asignaturas.add(new Asignatura(39, "Instalaciones electricas", 3, 8));
        asignaturas.add(new Asignatura(40, "Circuitos integrados analogicos", 3, 8));

        asignaturas.add(new Asignatura(41, "Asignatura del campo de profundizacion", 3, 9));
        asignaturas.add(new Asignatura(42, "Asignatura del campo de profundizacion", 3, 9));
        asignaturas.add(new Asignatura(43, "Asignatura del campo de profundizacion", 3, 9));
        asignaturas.add(new Asignatura(44, "Subestaciones electricas", 3, 9));
        asignaturas.add(new Asignatura(45, "Electronica de potencia", 3, 9));

        asignaturas.add(new Asignatura(46, "Asignatura del campo de profundizacion", 3, 10));
        asignaturas.add(new Asignatura(47, "Asignatura del campo de profundizacion", 3, 10));
        asignaturas.add(new Asignatura(48, "Asignatura del campo de profundizacion", 3, 10));
        asignaturas.add(new Asignatura(49, "Plantas generadoras", 3, 10));
        asignaturas.add(new Asignatura(50, "Recursos y necesidades de Mexico", 3, 10));
    }
 
    public static int ingresar_numero(String text) {
        System.out.print(text);
        return Integer.parseInt(sc.nextLine());
    }
/**
 *
 * @author Emiliano SC
 */
    public static void main(String[] args) {
        direcciones = Archivo.leer_archivo_csv("Direcciones CdMx.csv");
        
        inicializar_asignaturas();
        Controlador controlador = new Controlador();
        
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("\nSistema de gestión escolar"
                    + "\n1. Generar N alumnos"
                    + "\n2. Listar alumnos"
                    + "\n3. Editar alumno"
                    + "\n4. Eliminar alumno"
                    + "\n5. Buscar alumno"
                    + "\n6. Exportar a .CSV"
                    + "\n7. Mostrar asignaturas"
                    + "\n8. Salir");
            opcion = ingresar_numero("Tu opción: ");
            switch (opcion) {
                case 1:
                    controlador.generar_alumnos();
                    break;
                case 2:
                    controlador.listar_alumnos();
                    break;
                case 3:
                    controlador.editar_alumno();
                    break;
                case 4:
                    controlador.eliminar_alumno();
                    break;
                case 5:
                    controlador.buscar();
                    break;
                case 6:
                    System.out.print("Nombre del archivo: ");
                    Archivo.escribir_archivo_csv(sc.nextLine() + ".csv");
                    break;
                case 7:
                    controlador.mostrar_asignaturas();
                    break;
                case 8:
                    System.out.println("\nSaliendo...\n");
                    break;
                default:
                    System.out.println("\nOpción no válida!!!\n");
                    break;
            }

        }

    }
}
