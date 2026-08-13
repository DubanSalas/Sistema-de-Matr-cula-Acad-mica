package matricula;

// valida si los creditos estan dentro del limite segun el tipo de estudiante
public class ValidadorCreditos {

    public static final int MAX_CREDITOS_REGULAR  = 18;
    public static final int MAX_CREDITOS_AVANZADO = 21;

    // retorna el limite segun el tipo
    public int obtenerLimite(String tipoEstudiante) {
        if ("AVANZADO".equals(tipoEstudiante)) {
            return MAX_CREDITOS_AVANZADO;
        }
        return MAX_CREDITOS_REGULAR;
    }

    // retorna true si el total no supera el limite permitido
    public boolean esValido(String tipoEstudiante, int totalCreditos) {
        int limite = obtenerLimite(tipoEstudiante);
        return totalCreditos <= limite;
    }
}
