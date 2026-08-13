package matricula;

// maneja la logica del proceso de matricula
public class ServicioMatricula {

    private final ValidadorCreditos validador;

    public ServicioMatricula() {
        this.validador = new ValidadorCreditos();
    }

    // segundo constructor para poder pasar el validador desde afuera (util en pruebas)
    public ServicioMatricula(ValidadorCreditos validador) {
        this.validador = validador;
    }

    // procesa la matricula y retorna el resultado
    public ResultadoMatricula matricular(Estudiante estudiante, int[] creditos) {
        int total = calcularTotalCreditos(creditos);

        if (!validador.esValido(estudiante.getTipo(), total)) {
            int limite = validador.obtenerLimite(estudiante.getTipo());
            return new ResultadoMatricula(
                false,
                "Matricula RECHAZADA: " + estudiante.getNombre() +
                " supera el limite de " + limite + " creditos.",
                total
            );
        }

        return new ResultadoMatricula(
            true,
            "Matricula APROBADA para " + estudiante.getNombre() +
            ". Total creditos: " + total,
            total
        );
    }

    // verifica si el estudiante puede agregar un curso mas sin pasarse del limite
    public boolean puedoAgregarCursoExtra(Estudiante estudiante, int creditosActuales, int creditosNuevos) {
        int total = creditosActuales + creditosNuevos;
        return validador.esValido(estudiante.getTipo(), total);
    }

    // suma todos los creditos del arreglo
    private int calcularTotalCreditos(int[] creditos) {
        int total = 0;
        for (int c : creditos) {
            total += c;
        }
        return total;
    }
}
