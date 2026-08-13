# Sistema de Matricula Academica

**Estudiantes:**
- Genesis Rodriguez Arcos
- Duban Salas Napan
- Luis Rivas Rojas

## Captura de Pantalla - Tests en Verde

![Pruebas ejecutadas](image.png)

## Explicacion de Cambios

El codigo original tenia todo mezclado en una sola clase, los metodos calculaban cosas y a la vez imprimian en consola, eso hacia imposible hacer pruebas porque no retornaban ningun valor. Ademas la validacion de creditos estaba copiada en dos metodos distintos, si se cambiaba el limite habia que modificarlo en dos lugares.

Lo que hicimos fue separar todo en clases distintas. ValidadorCreditos se encarga solo de verificar si los creditos son validos, CalculadorPromedio solo calcula y retorna el resultado, ServicioMatricula maneja el proceso de matricula y ResultadoMatricula guarda el resultado para poder revisarlo despues. El Main es el unico lugar donde se imprime en consola.

Con eso ya pudimos escribir las pruebas unitarias porque cada metodo retorna algo concreto que se puede comparar con assertEquals o assertTrue. En el codigo original eso no era posible porque los metodos no retornaban nada, solo imprimian.
