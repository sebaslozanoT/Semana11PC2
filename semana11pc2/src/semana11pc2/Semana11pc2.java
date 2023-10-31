package semana11pc2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Estudiante {
    int codigo;
    String nombres;
    String apellidos;
    int ciclo;
    double pension;

    public Estudiante(int codigo, String nombres, String apellidos, int ciclo, double pension) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ciclo = ciclo;
        this.pension = pension;
    }
}

public class Semana11pc2 {
    private static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("****** BIENVENIDOS AL SISTEMA DE GESTION DE ESTUDIANTES ********");
            System.out.println("1-NUEVO ESTUDIANTE");
            System.out.println("2-BUSCAR ESTUDIANTE");
            System.out.println("3-ELIMINAR ESTUDIANTE");
            System.out.println("4-MODIFICAR ESTUDIANTE");
            System.out.println("5-MODIFICAR APELLIDOS EN MINÚSCULAS.");
            System.out.println("6-VER TODOS LOS ESTUDIANTES");
            System.out.println("7-VER TODOS LOS ESTUDIANTE POR APELLIDOS");
            System.out.println("8-VER TODOS LOS ESTUDIANTE POR PENSIÓN");
            System.out.println("9-TOTAL DE PENSIONES");
            System.out.println("10-SALIR");
            System.out.print("¿QUÉ ACTIVIDAD DESEA EJECUTAR? ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    eliminarEstudiante();
                    break;
                case 4:
                    modificarEstudiante();
                    break;
                case 5:
                    modificarApellidosMinusc();
                    break;
                case 6:
                    verTodosEstudiantes();
                    break;
                case 7:
                    verEstudiantesPorApellidos();
                    break;
                case 8:
                    verEstudiantesPorPension();
                    break;
                case 9:
                    calcularTotalPensiones();
                    break;
                case 10:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

        } while (opcion != 10);
    }

   // Agregar un nuevo estudiante al registro
private static void agregarEstudiante() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("****** REGISTRAR A UN NUEVO ESTUDIANTE ********");
    System.out.print("INGRESE NOMBRES: ");
    String nombres = scanner.next();
    System.out.print("INGRESE APELLIDOS: ");
    String apellidos = scanner.next();
    System.out.print("INGRESE CICLO: ");
    int ciclo = scanner.nextInt();
    System.out.print("INGRESE PENSION: ");
    double pension = scanner.nextDouble();

    // Generar un nuevo código para el estudiante y crear una instancia de Estudiante
    int codigo = listaEstudiantes.size() + 101;
    Estudiante nuevoEstudiante = new Estudiante(codigo, nombres, apellidos, ciclo, pension);
    listaEstudiantes.add(nuevoEstudiante);
    System.out.println("¡Se añadió con éxito!");
}


    private static void buscarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** BUSCAR A UN ESTUDIANTE ********");
        System.out.println("PUEDE BUSCAR POR NOMBRE O CODIGO. ELEGIR UNA OPCIÓN:");
        System.out.println("A – APELLIDO");
        System.out.println("B – CODIGO");

        String opcion = scanner.next();

        if (opcion.equalsIgnoreCase("A")) {
            System.out.print("INGRESE EL APELLIDO DEL ALUMNO: ");
            String apellido = scanner.next();
            boolean encontrado = false;

            for (Estudiante estudiante : listaEstudiantes) {
                if (estudiante.apellidos.equalsIgnoreCase(apellido)) {
                    System.out.println("El alumno es: " + estudiante.nombres + " " + estudiante.apellidos);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El alumno no está registrado.");
            }
        } else if (opcion.equalsIgnoreCase("B")) {
            System.out.print("INGRESE EL CÓDIGO DEL ALUMNO: ");
            int codigo = scanner.nextInt();
            boolean encontrado = false;

            for (Estudiante estudiante : listaEstudiantes) {
                if (estudiante.codigo == codigo) {
                    System.out.println("El alumno es: " + estudiante.nombres + " " + estudiante.apellidos);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El alumno no está registrado.");
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static void eliminarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** ELIMINACIÓN DEL ESTUDIANTE ********");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
        System.out.println("------------------------------------------------------------------------------");

        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.print("INDIQUE EL CODIGO DEL ESTUDIANTE A ELIMINAR: ");
        int codigo = scanner.nextInt();
        Estudiante estudianteAEliminar = null;

        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.codigo == codigo) {
                estudianteAEliminar = estudiante;
                break;
            }
        }

        if (estudianteAEliminar != null) {
            listaEstudiantes.remove(estudianteAEliminar);
            System.out.println("¡Se eliminó con éxito!");
        } else {
            System.out.println("El alumno no está registrado.");
        }
    }

    private static void modificarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** MODIFICACIÓN ESTUDIANTE ********");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
        System.out.println("------------------------------------------------------------------------------");

        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.print("INDIQUE EL CODIGO DEL ESTUDIANTE A MODIFICAR: ");
        int codigo = scanner.nextInt();
        Estudiante estudianteAModificar = null;

        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.codigo == codigo) {
                estudianteAModificar = estudiante;
                break;
            }
        }

        if (estudianteAModificar != null) {
            System.out.print("INGRESE NOMBRES: ");
            estudianteAModificar.nombres = scanner.next();
            System.out.print("INGRESE APELLIDOS: ");
            estudianteAModificar.apellidos = scanner.next();
            System.out.print("INGRESE CICLO: ");
            estudianteAModificar.ciclo = scanner.nextInt();
            System.out.print("INGRESE PENSION: ");
            estudianteAModificar.pension = scanner.nextDouble();

            System.out.println("¡Se modificó con éxito!");
        } else {
            System.out.println("El alumno no está registrado.");
        }
    }

    private static void modificarApellidosMinusc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** MODIFICACIÓN ESTUDIANTE MINÚSCULA ********");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
        System.out.println("------------------------------------------------------------------------------");

        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("LA NUEVA LISTA:");
        System.out.println("------------------------------------------------------------------------------");

        for (Estudiante estudiante : listaEstudiantes) {
            String[] partes = estudiante.apellidos.split(" ");
            StringBuilder apellidosModificados = new StringBuilder();
            for (String parte : partes) {
                apellidosModificados.append(parte.substring(0, 1).toUpperCase()).append(parte.substring(1)).append(" ");
            }
            estudiante.apellidos = apellidosModificados.toString().trim();
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("¿DESEA INGRESAR OTRA OPCIÓN?");
    }

    private static void verTodosEstudiantes() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
        System.out.println("------------------------------------------------------------------------------");

        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
    }

    private static void verEstudiantesPorApellidos() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
        System.out.println("------------------------------------------------------------------------------");

        Collections.sort(listaEstudiantes, Comparator.comparing(o -> o.apellidos));
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
    }

    private static void verEstudiantesPorPension() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
        System.out.println("------------------------------------------------------------------------------");

        Collections.sort(listaEstudiantes, Comparator.comparingDouble(o -> o.pension));
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
    }

    private static void calcularTotalPensiones() {
        double sumaTotal = 0;
        for (Estudiante estudiante : listaEstudiantes) {
            sumaTotal += estudiante.pension;
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("CODIGO DE ESTUDIANTE NOMBRE Y APELLIDOS CICLO PENSION");
        System.out.println("------------------------------------------------------------------------------");

        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.codigo + " " + estudiante.nombres + " " + estudiante.apellidos + " " + estudiante.ciclo + " " + estudiante.pension);
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("LA SUMA TOTAL ES: S/ " + sumaTotal);
        System.out.println("------------------------------------------------------------------------------");
    }
}
