package matricula;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorCreditosTest {

    @Test
    void estudianteRegularDentroDelLimite_debeSerValido() {
        // Arrange
        ValidadorCreditos validador = new ValidadorCreditos();
        String tipo = "REGULAR";
        int totalCreditos = 14;

        // Act
        boolean resultado = validador.esValido(tipo, totalCreditos);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void estudianteRegularSuperaElLimite_debeSerInvalido() {
        // Arrange
        ValidadorCreditos validador = new ValidadorCreditos();
        String tipo = "REGULAR";
        int totalCreditos = 20;

        // Act
        boolean resultado = validador.esValido(tipo, totalCreditos);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void estudianteRegularEnLimiteExacto_debeSerValido() {
        // Arrange
        ValidadorCreditos validador = new ValidadorCreditos();
        String tipo = "REGULAR";
        int totalCreditos = 18;

        // Act
        boolean resultado = validador.esValido(tipo, totalCreditos);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void estudianteAvanzadoDentroDelLimite_debeSerValido() {
        // Arrange
        ValidadorCreditos validador = new ValidadorCreditos();
        String tipo = "AVANZADO";
        int totalCreditos = 21;

        // Act
        boolean resultado = validador.esValido(tipo, totalCreditos);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void estudianteAvanzadoSuperaElLimite_debeSerInvalido() {
        // Arrange
        ValidadorCreditos validador = new ValidadorCreditos();
        String tipo = "AVANZADO";
        int totalCreditos = 22;

        // Act
        boolean resultado = validador.esValido(tipo, totalCreditos);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void obtenerLimiteParaRegular_debeRetornar18() {
        // Arrange
        ValidadorCreditos validador = new ValidadorCreditos();

        // Act
        int limite = validador.obtenerLimite("REGULAR");

        // Assert
        assertEquals(18, limite);
    }

    @Test
    void obtenerLimiteParaAvanzado_debeRetornar21() {
        // Arrange
        ValidadorCreditos validador = new ValidadorCreditos();

        // Act
        int limite = validador.obtenerLimite("AVANZADO");

        // Assert
        assertEquals(21, limite);
    }
}
