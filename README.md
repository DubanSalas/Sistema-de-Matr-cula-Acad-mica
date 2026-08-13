# Sistema de Matrícula Académica
**Pruebas de Software — S03 | M03 | Análisis de Sistemas — 5.º Semestre**

---

## Objetivo
Refactorizar código espagueti aplicando principios de diseño limpio y verificar el comportamiento mediante pruebas unitarias con el patrón AAA.

---

## Parte 1 — Diagnóstico: Problemas Encontrados en el Código Original

El archivo `src/original/SistemaMatricula.java` contiene el código espagueti con los siguientes **5 problemas documentados**:

| # | Problema | Descripción | Ubicación |
|---|----------|-------------|-----------|
| 1 | **Responsabilidades Mezcladas** | Los métodos mezclan lógica de negocio con `System.out.println`, lo que impide probarlos de forma aislada. | `matricularEstudiante()`, `calcularPromedio()` |
| 2 | **Métodos Extensos** | `matricularEstudiante()` valida, calcula, registra y muestra resultados todo en un bloque gigante. | `matricularEstudiante()` |
| 3 | **Código Repetido** | La validación de créditos máximos está duplicada en `matricularEstudiante()` y en `agregarCursoExtra()`. | Líneas ~35 y ~58 |
| 4 | **Condicionales Innecesarios** | `if-else` anidados para verificar tipo de estudiante aumentan la complejidad ciclomática innecesariamente. | Bloque if-else en `matricularEstudiante()` |
| 5 | **Apalancamiento Impedido para Pruebas** | `calcularPromedio()` no retorna ningún valor, lo que hace imposible usar `assertEquals` para verificarlo. | `calcularPromedio()` |

---

## Parte 2 — Refactorización: Estructura del Código Limpio

```
src/
└── matricula/
    ├── Estudiante.java          → Almacena datos del estudiante
    ├── ValidadorCreditos.java   → Valida si los créditos están dentro del límite
    ├── CalculadorPromedio.java  → Calcula el promedio de notas
    ├── ResultadoMatricula.java  → Transporta el resultado de una matrícula
    ├── ServicioMatricula.java   → Orquesta el proceso de matrícula
    └── Main.java                → Muestra resultados en consola (única clase con println)
```

### Mejoras aplicadas
- **Separación de responsabilidades**: cada clase tiene una sola razón para cambiar.
- **Sin código duplicado**: `ValidadorCreditos.esValido()` es el único lugar donde se validan créditos.
- **Métodos pequeños y enfocados**: ningún método hace más de una cosa.
- **Métodos que retornan valores**: permiten usar `assertEquals`, `assertTrue`, `assertFalse` en las pruebas.
- **Sin `System.out.println` en la lógica**: solo `Main.java` imprime en consola.

---

## Parte 3 — Pruebas Unitarias (Patrón AAA)

Cada prueba sigue la estructura **Arrange → Act → Assert**:

```
test/
└── matricula/
    ├── ValidadorCreditosTest.java    → 7 pruebas
    ├── CalculadorPromedioTest.java   → 5 pruebas
    └── ServicioMatriculaTest.java    → 7 pruebas
```

**Total: 19 pruebas unitarias** (mínimo requerido: 3)

### Ejemplo de prueba con patrón AAA

```java
@Test
void estudianteRegularDentroDelLimite_debeSerValido() {
    // ARRANGE - preparar los datos
    ValidadorCreditos validador = new ValidadorCreditos();
    String tipo = "REGULAR";
    int totalCreditos = 14;

    // ACT - ejecutar el método
    boolean resultado = validador.esValido(tipo, totalCreditos);

    // ASSERT - verificar el resultado
    assertTrue(resultado);
}
```

---

## Parte 4 — Cómo Ejecutar las Pruebas

### Requisitos
- Java 11 o superior
- Maven 3.6 o superior

### Comando para ejecutar todas las pruebas

```bash
mvn test
```

### Resultado esperado
```
[INFO] Tests run: 19, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## Preguntas de Reflexión

**1. Diagnóstico Inicial**
El código original mezclaba responsabilidades en métodos gigantes, usaba `System.out.println` dentro de la lógica de negocio y duplicaba la misma validación en múltiples lugares. Esto dificultaba leer el flujo real del programa y hacía imposible probar métodos de forma aislada.

**2. Decisiones de Diseño**
Se separó cada responsabilidad en una clase propia. La validación de créditos vive solo en `ValidadorCreditos`, el cálculo de promedio en `CalculadorPromedio`, y la orquestación en `ServicioMatricula`. Estas decisiones aplican el Principio de Responsabilidad Única (SRP) y eliminan la duplicación.

**3. Impacto en la Testabilidad**
El código refactorizado es fácil de probar porque los métodos retornan valores concretos (`boolean`, `double`, `ResultadoMatricula`) en lugar de imprimir en consola. Esto permite usar `assertEquals`, `assertTrue` y `assertFalse` directamente sobre los resultados.

**4. Calidad de Software**
Aprendimos que la estructura interna del código determina directamente qué tan difícil es escribir pruebas. Un método que mezcla lógica con salida en consola no puede probarse sin efectos secundarios. Separar responsabilidades no es solo una cuestión de orden, sino de poder verificar el comportamiento de forma confiable y automática.

---

## Lista de Verificación Final

- [x] Código refactorizado completo y funcional
- [x] 19 pruebas unitarias implementadas (mínimo 3)
- [x] Uso explícito del patrón AAA en cada prueba
- [x] Pruebas ejecutadas correctamente (suite en verde)
- [x] Captura de evidencia de la ejecución adjunta
- [x] Respuestas a las 4 preguntas de reflexión incluidas
