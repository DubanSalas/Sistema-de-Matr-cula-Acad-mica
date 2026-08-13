package matricula;

// punto de entrada, aqui es donde se imprime en consola
public class Main {

    public static void main(String[] args) {

        ServicioMatricula servicio    = new ServicioMatricula();
        CalculadorPromedio calculador = new CalculadorPromedio();

        // estudiante regular dentro del limite
        Estudiante juan = new Estudiante("Juan Perez", "REGULAR");
        int[] creditos1 = {4, 4, 6};
        ResultadoMatricula r1 = servicio.matricular(juan, creditos1);
        System.out.println(r1.getMensaje());

        // estudiante regular en el limite exacto
        Estudiante maria = new Estudiante("Maria Lopez", "REGULAR");
        int[] creditos2  = {6, 6, 6};
        ResultadoMatricula r2 = servicio.matricular(maria, creditos2);
        System.out.println(r2.getMensaje());

        // estudiante regular que supera el limite
        Estudiante pedro = new Estudiante("Pedro Soto", "REGULAR");
        int[] creditos3  = {6, 6, 8};
        ResultadoMatricula r3 = servicio.matricular(pedro, creditos3);
        System.out.println(r3.getMensaje());

        // estudiante avanzado con su limite mayor
        Estudiante ana  = new Estudiante("Ana Torres", "AVANZADO");
        int[] creditos4 = {6, 6, 9};
        ResultadoMatricula r4 = servicio.matricular(ana, creditos4);
        System.out.println(r4.getMensaje());

        // verificar si puede agregar un curso extra
        boolean puedeAgregar = servicio.puedoAgregarCursoExtra(juan, 14, 5);
        System.out.println("Juan puede agregar curso de 5 creditos: " + puedeAgregar);

        // calcular promedio de notas
        int[] notas     = {85, 90, 78, 92};
        double promedio = calculador.calcular(notas);
        System.out.println("Promedio de Juan: " + promedio);
    }
}
