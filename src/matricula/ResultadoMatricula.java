package matricula;

// guarda el resultado de una matricula: si fue aprobada, el mensaje y los creditos totales
public class ResultadoMatricula {

    private final boolean aprobada;
    private final String  mensaje;
    private final int     totalCreditos;

    public ResultadoMatricula(boolean aprobada, String mensaje, int totalCreditos) {
        this.aprobada      = aprobada;
        this.mensaje       = mensaje;
        this.totalCreditos = totalCreditos;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getTotalCreditos() {
        return totalCreditos;
    }
}
