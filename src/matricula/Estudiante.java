package matricula;

// guarda los datos basicos de un estudiante
public class Estudiante {

    private String nombre;
    private String tipo; // REGULAR o AVANZADO

    public Estudiante(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
