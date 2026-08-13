package original;

// Codigo original con problemas de diseno (codigo espagueti)
public class SistemaMatricula {

    // limites de creditos por tipo de estudiante
    static int MAX_CREDITOS = 18;
    static int MAX_CREDITOS_EXTRA = 21;

    // metodo principal que hace demasiadas cosas a la vez
    public static void matricularEstudiante(String nombre, String tipo, String[] cursos, int[] creditos) {
        System.out.println("=== SISTEMA DE MATRICULA ===");
        System.out.println("Procesando matricula de: " + nombre);

        int totalCreditos = 0;
        for (int i = 0; i < creditos.length; i++) {
            totalCreditos = totalCreditos + creditos[i];
        }

        // validacion mezclada con impresion en consola
        if (tipo.equals("REGULAR")) {
            if (totalCreditos > MAX_CREDITOS) {
                System.out.println("ERROR: " + nombre + " supera el limite de creditos (" + MAX_CREDITOS + ")");
                System.out.println("Matricula RECHAZADA");
                return;
            } else {
                System.out.println("Creditos totales: " + totalCreditos + " - OK");
                System.out.println("Matricula APROBADA para " + nombre);
                System.out.println("Cursos matriculados: " + cursos.length);
            }
        } else if (tipo.equals("AVANZADO")) {
            // misma validacion repetida para el tipo avanzado
            if (totalCreditos > MAX_CREDITOS_EXTRA) {
                System.out.println("ERROR: " + nombre + " supera el limite de creditos extra (" + MAX_CREDITOS_EXTRA + ")");
                System.out.println("Matricula RECHAZADA");
                return;
            } else {
                System.out.println("Creditos totales: " + totalCreditos + " - OK (estudiante avanzado)");
                System.out.println("Matricula APROBADA para " + nombre);
                System.out.println("Cursos matriculados: " + cursos.length);
            }
        } else {
            System.out.println("Tipo de estudiante desconocido");
        }
    }

    // logica de validacion duplicada respecto al metodo anterior
    public static void agregarCursoExtra(String nombre, String tipo, int creditosActuales, int creditosCursoNuevo) {
        int total = creditosActuales + creditosCursoNuevo;
        System.out.println("Intentando agregar curso extra a: " + nombre);

        if (tipo.equals("REGULAR")) {
            if (total > MAX_CREDITOS) {
                System.out.println("No se puede agregar. Limite alcanzado.");
            } else {
                System.out.println("Curso extra agregado. Total creditos: " + total);
            }
        } else if (tipo.equals("AVANZADO")) {
            if (total > MAX_CREDITOS_EXTRA) {
                System.out.println("No se puede agregar. Limite alcanzado.");
            } else {
                System.out.println("Curso extra agregado. Total creditos: " + total);
            }
        }
    }

    // calcula el promedio pero no retorna nada, imposible de testear
    public static void calcularPromedio(int[] notas) {
        System.out.println("Calculando promedio...");
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        double promedio = (double) suma / notas.length;
        System.out.println("Promedio del estudiante: " + promedio);
    }

    public static void main(String[] args) {
        String[] cursos = {"Matematicas", "Fisica", "Programacion"};
        int[] creditos = {4, 4, 6};
        matricularEstudiante("Juan Perez", "REGULAR", cursos, creditos);

        System.out.println();
        agregarCursoExtra("Juan Perez", "REGULAR", 14, 6);

        System.out.println();
        int[] notas = {85, 90, 78, 92};
        calcularPromedio(notas);
    }
}
