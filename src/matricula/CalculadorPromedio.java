package matricula;

// calcula el promedio de un arreglo de notas y lo retorna
public class CalculadorPromedio {

    public double calcular(int[] notas) {
        if (notas == null || notas.length == 0) {
            return 0.0;
        }
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return (double) suma / notas.length;
    }
}
