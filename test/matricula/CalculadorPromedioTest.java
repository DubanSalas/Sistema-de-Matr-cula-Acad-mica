package matricula;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadorPromedioTest {

    @Test
    void calcularPromedio_conNotasVariadas_debeRetornarPromedioCorreecto() {
        // Arrange
        CalculadorPromedio calculador = new CalculadorPromedio();
        int[] notas = {85, 90, 78, 92};

        // Act
        double resultado = calculador.calcular(notas);

        // Assert
        assertEquals(86.25, resultado, 0.01);
    }

    @Test
    void calcularPromedio_conUnaSolaNota_debeRetornarEsaNota() {
        // Arrange
        CalculadorPromedio calculador = new CalculadorPromedio();
        int[] notas = {75};

        // Act
        double resultado = calculador.calcular(notas);

        // Assert
        assertEquals(75.0, resultado, 0.01);
    }

    @Test
    void calcularPromedio_conNotasIguales_debeRetornarEsaNota() {
        // Arrange
        CalculadorPromedio calculador = new CalculadorPromedio();
        int[] notas = {80, 80, 80};

        // Act
        double resultado = calculador.calcular(notas);

        // Assert
        assertEquals(80.0, resultado, 0.01);
    }

    @Test
    void calcularPromedio_conArregloVacio_debeRetornarCero() {
        // Arrange
        CalculadorPromedio calculador = new CalculadorPromedio();
        int[] notas = {};

        // Act
        double resultado = calculador.calcular(notas);

        // Assert
        assertEquals(0.0, resultado, 0.01);
    }

    @Test
    void calcularPromedio_conNotaPerfecta_debeRetornar100() {
        // Arrange
        CalculadorPromedio calculador = new CalculadorPromedio();
        int[] notas = {100, 100, 100};

        // Act
        double resultado = calculador.calcular(notas);

        // Assert
        assertEquals(100.0, resultado, 0.01);
    }
}
