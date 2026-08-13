package matricula;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioMatriculaTest {

    @Test
    void matricular_estudianteRegularDentroDelLimite_debeRetornarAprobada() {
        // Arrange
        ServicioMatricula servicio = new ServicioMatricula();
        Estudiante estudiante      = new Estudiante("Juan Perez", "REGULAR");
        int[] creditos             = {4, 4, 6};

        // Act
        ResultadoMatricula resultado = servicio.matricular(estudiante, creditos);

        // Assert
        assertTrue(resultado.isAprobada());
        assertEquals(14, resultado.getTotalCreditos());
    }

    @Test
    void matricular_estudianteRegularSuperaLimite_debeRetornarRechazada() {
        // Arrange
        ServicioMatricula servicio = new ServicioMatricula();
        Estudiante estudiante      = new Estudiante("Pedro Soto", "REGULAR");
        int[] creditos             = {6, 6, 8};

        // Act
        ResultadoMatricula resultado = servicio.matricular(estudiante, creditos);

        // Assert
        assertFalse(resultado.isAprobada());
        assertEquals(20, resultado.getTotalCreditos());
    }

    @Test
    void matricular_estudianteAvanzadoConCreditosPermitidos_debeRetornarAprobada() {
        // Arrange
        ServicioMatricula servicio = new ServicioMatricula();
        Estudiante estudiante      = new Estudiante("Ana Torres", "AVANZADO");
        int[] creditos             = {6, 6, 9};

        // Act
        ResultadoMatricula resultado = servicio.matricular(estudiante, creditos);

        // Assert
        assertTrue(resultado.isAprobada());
    }

    @Test
    void matricular_aprobada_mensajeDebeContenerNombreDelEstudiante() {
        // Arrange
        ServicioMatricula servicio = new ServicioMatricula();
        Estudiante estudiante      = new Estudiante("Lucia Ramos", "REGULAR");
        int[] creditos             = {3, 3, 3};

        // Act
        ResultadoMatricula resultado = servicio.matricular(estudiante, creditos);

        // Assert
        assertTrue(resultado.getMensaje().contains("Lucia Ramos"));
    }

    @Test
    void puedoAgregarCursoExtra_sinSuperarLimite_debeRetornarTrue() {
        // Arrange
        ServicioMatricula servicio = new ServicioMatricula();
        Estudiante estudiante      = new Estudiante("Juan Perez", "REGULAR");
        int creditosActuales       = 12;
        int creditosNuevos         = 4;

        // Act
        boolean resultado = servicio.puedoAgregarCursoExtra(estudiante, creditosActuales, creditosNuevos);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void puedoAgregarCursoExtra_superandoLimite_debeRetornarFalse() {
        // Arrange
        ServicioMatricula servicio = new ServicioMatricula();
        Estudiante estudiante      = new Estudiante("Juan Perez", "REGULAR");
        int creditosActuales       = 16;
        int creditosNuevos         = 4;

        // Act
        boolean resultado = servicio.puedoAgregarCursoExtra(estudiante, creditosActuales, creditosNuevos);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void matricular_debeCalcularCorrectamenteElTotalDeCreditos() {
        // Arrange
        ServicioMatricula servicio = new ServicioMatricula();
        Estudiante estudiante      = new Estudiante("Carlos Diaz", "REGULAR");
        int[] creditos             = {3, 6, 4};

        // Act
        ResultadoMatricula resultado = servicio.matricular(estudiante, creditos);

        // Assert
        assertEquals(13, resultado.getTotalCreditos());
    }
}
