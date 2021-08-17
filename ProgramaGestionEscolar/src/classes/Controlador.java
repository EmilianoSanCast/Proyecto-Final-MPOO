package classes;

import static classes.Principal.*;

public class Controlador {

    public int ingresar_numero(String text) {
        System.out.print(text);
        return Integer.parseInt(sc.nextLine());
    }

    public String ingresar_texto(String text) {
        System.out.print(text);
        return sc.nextLine();
    }

    public int get_random(int min, int max) {
        return (int) Math.floor(Math.random() * (min - max + 1) + max);
    }

    public int existe_alumno(int ncuenta) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNcuenta() == ncuenta) {
                return i;
            }
        }
        System.out.println("\nEl alumno con número de cuenta " + ncuenta + " no existe\n");
        return -1;
    }

    public int generar_codigo() {
        if (alumnos.isEmpty()) {
            return 1000000000;
        }
        return alumnos.get(alumnos.size() - 1).getNcuenta() + 1;
    }

    public Alumno crear_alumno() {
        Alumno alumno = new Alumno();
        alumno.setNcuenta(generar_codigo());
        alumno.setNombre(nombres[get_random(0, nombres.length - 1)]);
        do {
            alumno.setAp_paterno(apellidos[get_random(0, apellidos.length - 1)]);
            alumno.setAp_materno(apellidos[get_random(0, apellidos.length - 1)]);
        } while (alumno.getAp_materno().equals(alumno.getAp_paterno()));
        alumno.setEdad(get_random(18, 27));
        alumno.setDireccion(direcciones.get(get_random(0, direcciones.size() - 1)));

        int cant_asignaturas = get_random(5, asignaturas.size());
        for (int i = 0; i < cant_asignaturas; i++) {
            Asignatura a = new Asignatura();
            a.setCodigo(asignaturas.get(i).getCodigo());
            a.setCreditos(asignaturas.get(i).getCreditos());
            a.setNombre(asignaturas.get(i).getNombre());
            a.setSemestre(asignaturas.get(i).getSemestre());
            a.setNota(get_random(5, 10));
            alumno.getAsignaturas().add(a);
        }
        alumno.calcular_numero_inscripcion();
        return alumno;
    }

    public void generar_alumnos() {
        System.out.println("\nGENERANDO ALUMNOS\n");
        int n = ingresar_numero("Cantidad de alumnos a generar: ");
        for (int i = 0; i < n; i++) {
            alumnos.add(crear_alumno());
        }
        System.out.println("\n" + n + " generados correctamente\n");
    }

    public void listar_alumnos() {
        System.out.println("\nLISTA DE ALUMNOS\n");
        alumnos.sort((o1, o2) -> String.valueOf(o2.getNumero_inscripcion()).compareTo(
                String.valueOf(o1.getNumero_inscripcion())));
        for (Alumno item : alumnos) {
            System.out.println("* " + item.toString());
        }
    }

    public int existe_asignatura(int codigo, int index) {
        for (int i = 0; i < alumnos.get(index).getAsignaturas().size(); i++) {
            if (alumnos.get(index).getAsignaturas().get(i).getCodigo() == codigo) {
                return i;
            }
        }
        System.out.println("\nLa asignatura con código " + codigo + " no existe\n");
        return -1;
    }

    public void administrar_asignaturas(int index) {
        int opcion = 0, codigo, pos;
        double nota = 0;
        while (opcion != 5) {
            System.out.println("\nAdministrando asignaturas del alumno con número de cuenta: " + alumnos.get(index).getNcuenta()
                    + "\n1. Agregar asignatura a alumno"
                    + "\n2. Eliminar asigntura a alumno"
                    + "\n3. Modificar nota de asignatura"
                    + "\n4. Ver asignaturas"
                    + "\n5. Salir");
            opcion = ingresar_numero("Tu opción: ");
            switch (opcion) {
                case 1:
                    codigo = ingresar_numero("Código de asignatura: ");
                    pos = existe_asignatura(codigo, index);
                    if (pos >= 0) {
                        alumnos.get(index).getAsignaturas().add(asignaturas.get(pos));
                        System.out.println("\nAsignatura agregada\n");
                    }
                    break;
                case 2:
                    codigo = ingresar_numero("Código de asignatura: ");
                    pos = existe_asignatura(codigo, index);
                    if (pos >= 0) {
                        alumnos.get(index).getAsignaturas().remove(pos);
                        System.out.println("\nAsignatura eliminada\n");
                    }
                    break;
                case 3:
                    codigo = ingresar_numero("Código de asignatura: ");
                    pos = existe_asignatura(codigo, index);
                    if (pos >= 0) {
                        do {
                            System.out.print("Nota: ");
                            nota = Double.parseDouble(sc.nextLine());
                        } while (nota < 0 || nota > 10);
                        alumnos.get(index).getAsignaturas().get(pos).setNota(nota);
                        System.out.println("\nNota actualizada de asignatura\n");
                    }
                    break;
                case 4:
                    alumnos.get(index).mostrar_asignaturas();
                    break;
                case 5:
                    alumnos.get(index).calcular_numero_inscripcion();
                    break;
                default:
                    System.out.println("\nOpción no válida\n");
                    break;
            }
        }
    }

    public void editar_alumno() {
        System.out.println("\nACTUALIZANDO DATOS DEL ALUMNO");
        int ncuenta, index, edad;
        ncuenta = ingresar_numero("Número de cuenta: ");
        index = existe_alumno(ncuenta);
        if (index >= 0) {
            int opcion = 0;
            while (opcion != 7) {
                System.out.println("\nOpciones de actualización"
                        + "\n1. Nombre"
                        + "\n2. Apellido paterno"
                        + "\n3. Apellido materno"
                        + "\n4. Edad"
                        + "\n5. Dirección"
                        + "\n6. Asignaturas"
                        + "\n7. Terminar");
                opcion = ingresar_numero("Tu opción: ");
                switch (opcion) {
                    case 1:
                        alumnos.get(index).setNombre(ingresar_texto("Nuevo nombre: "));
                        break;
                    case 2:
                        alumnos.get(index).setAp_paterno(ingresar_texto("Nuevo apellido paterno: "));
                        break;
                    case 3:
                        alumnos.get(index).setAp_materno(ingresar_texto("Nuevo apellido materno: "));
                        break;
                    case 4:
                        do {
                            edad = ingresar_numero("Nuevo edad: ");
                            if (edad < 18 || edad > 27) {
                                System.out.println("La edad debe estar en el rango de [18 - 27]");
                            }
                        } while (edad < 18 || edad > 27);
                        alumnos.get(index).setEdad(edad);
                        break;
                    case 5:
                        alumnos.get(index).setDireccion(ingresar_texto("Nueva dirección: "));
                        break;
                    case 6:
                        administrar_asignaturas(index);
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("\nOpción no válida...\n");
                        break;
                }
            }

        }
    }

    public void eliminar_alumno() {
        System.out.println("\nELIMINANDO DATOS DEL ALUMNO\n");
        int ncuenta = ingresar_numero("Número de cuenta: ");
        int index = existe_alumno(ncuenta);
        if (index >= 0) {
            alumnos.remove(index);
            System.out.println("\nEl alumno con número de cuenta: " + ncuenta + " ha sido eliminado\n");
        }
    }

    public void buscar() {
        System.out.println("\nBUSCANDO DATOS DEL ALUMNO\n");
        int ncuenta = ingresar_numero("Número de cuenta: ");
        int index = existe_alumno(ncuenta);
        if (index >= 0) {
            System.out.println(alumnos.get(index));
            System.out.println("Asignaturas del alumno");
            alumnos.get(index).mostrar_asignaturas();
        }
    }

    public void mostrar_asignaturas() {
        System.out.println("\nMOSTRANDO ASIGNATURAS\n");
        for (Asignatura item : asignaturas) {
            System.out.println("- " + item.toString());
        }
    }
}
