# ESPECIFICACIÓN FORMAL DE PRUEBAS UNITARIAS

**Proyecto Java: EsZalud – Gestión de Consultas Médicas**

**Enfoque de desarrollo:** Test Driven Development (TDD)

---

## IDENTIFICACIÓN DEL DOCUMENTO

| Identificación        | Detalle                                           |
| --------------------- | ------------------------------------------------- |
| Proyecto              | EsZalud – Sistema de gestión de consultas médicas |
| Componente            | Capa de modelos (Model)                           |
| Tecnología            | Java 25, Gradle, JUnit 6 y Mockito                |
| Base de datos         | MongoDB                                           |
| Versión del documento | 1.0                                               |
| Fecha                 | 13 de noviembre de 2026                           |

_Documento técnico para orientar la implementación incremental de los modelos mediante pruebas unitarias._

---

# 1. Propósito

Este documento define los escenarios de prueba que deben guiar la implementación de los modelos de la aplicación `EsZalud` mediante el enfoque Test Driven Development (TDD).

El objetivo es que los estudiantes desarrollen los modelos de la aplicación a partir de pruebas unitarias automatizadas, utilizando JUnit 6 y Mockito.

La especificación contempla los siguientes modelos:

- Paciente.
- Doctor.
- Especialidad.
- Cita médica.

Las pruebas permitirán verificar que los modelos:

- Se construyan correctamente cuando reciben información válida.
- Rechacen los datos obligatorios que no cumplen las condiciones establecidas.
- Mantengan correctamente los valores de sus atributos.
- Cumplan las reglas de validación definidas para el dominio.

El propósito no es implementar primero todos los modelos y comprobarlos al final, sino convertir cada comportamiento esperado en una prueba ejecutable antes de implementar o modificar el código de producción.

**Importante:** Cuando una regla de negocio no esté definida expresamente en la aplicación o en este documento, deberá acordarse antes de implementarla y dejarla por escrito en el repositorio.

# 2. Alcance de las pruebas

Las pruebas de este documento corresponden exclusivamente a la capa Model.

Se consideran dentro del alcance:

- Constructores de las clases.
- Validaciones de atributos.
- Comportamiento de getters y setters, si existen.
- Valores predeterminados definidos por el dominio.
- Representación de estados mediante `enum`, si se implementan.

No forman parte de esta especificación:

- Consultas y operaciones contra MongoDB.
- Operaciones CRUD.
- Validaciones que requieran consultar otros registros.
- Reglas implementadas en servicios de negocio.
- Componentes visuales JavaFX.
- Pruebas de integración.

Estas funcionalidades deberán contar con especificaciones de pruebas independientes.

# 3. Modelos de la aplicación

## 3.1. Modelo Paciente

Representa a una persona registrada en el establecimiento de salud.

| Atributo  | Descripción                                    |
| --------- | ---------------------------------------------- |
| documento | Número de documento de identidad del paciente. |
| nombres   | Nombres del paciente.                          |
| apellidos | Apellidos del paciente.                        |
| telefono  | Número telefónico de contacto.                 |
| correo    | Dirección de correo electrónico.               |

## 3.2. Modelo Doctor

Representa a un profesional médico registrado en el establecimiento de salud.

| Atributo     | Descripción                                       |
| ------------ | ------------------------------------------------- |
| documento    | Número de documento de identidad del doctor.      |
| nombres      | Nombres del doctor.                               |
| apellidos    | Apellidos del doctor.                             |
| colegiatura  | Número de colegiatura profesional.                |
| especialidad | Identificador de la especialidad médica asociada. |

## 3.3. Modelo Especialidad

Representa una especialidad médica disponible en el establecimiento de salud.

| Atributo    | Descripción                       |
| ----------- | --------------------------------- |
| nombre      | Nombre de la especialidad médica. |
| descripcion | Descripción de la especialidad.   |

## 3.4. Modelo Cita médica

Representa una cita programada entre un paciente y un doctor.

| Atributo     | Descripción                              |
| ------------ | ---------------------------------------- |
| paciente     | Identificador del paciente asociado.     |
| doctor       | Identificador del doctor asociado.       |
| especialidad | Identificador de la especialidad médica. |
| fechaHora    | Fecha y hora programada para la cita.    |
| motivo       | Motivo de la consulta médica.            |
| estado       | Estado actual de la cita.                |

Los estados utilizados actualmente por la aplicación son:

- `PROGRAMADA`.
- `ATENDIDA`.
- `CANCELADA`.

Se recomienda representar estos estados mediante un `enum`, en lugar de utilizar cadenas de texto directamente.

---

# 4. Enfoque de trabajo: ciclo TDD

El proyecto deberán desarrollarse obligatoriamente siguiendo el ciclo TDD.

| Fase          | Actividad                                                                                | Criterio de avance                                                                    |
| ------------- | ---------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| RED (Rojo)    | Escribir una prueba que describa un comportamiento todavía no implementado y ejecutarla. | La prueba falla por la razón esperada, no por errores de compilación o configuración. |
| GREEN (Verde) | Implementar el mínimo código necesario para satisfacer la prueba.                        | La nueva prueba pasa y las pruebas anteriores siguen pasando.                         |
| REFACTOR      | Mejorar el diseño del código sin cambiar el comportamiento observable.                   | Toda la suite de pruebas continúa pasando.                                            |

Cada caso de prueba debe desarrollarse de forma incremental.

No se debe implementar primero toda la lógica de validación de los modelos para después escribir las pruebas.

La secuencia de ejecución de los tests tampoco debe utilizarse como mecanismo de dependencia entre pruebas. Cada prueba debe ser independiente y producir el mismo resultado aunque JUnit la ejecute en otro orden.

---

# 5. Convenciones de commits durante el desarrollo TDD

Durante el proceso de desarrollo se deberá utilizar Git para registrar incrementalmente los cambios realizados, siguiendo el enfoque Test Driven Development (TDD).

Cada commit debe representar un cambio pequeño, coherente y verificable. Se deberán utilizar mensajes en inglés siguiendo las convenciones de **Conventional Commits**.

## 5.1. Formato de los mensajes

Se utilizará la siguiente estructura:

`<type>(<scope>): <description>`

Donde:

| Elemento    | Descripción                                                         |
| ----------- | ------------------------------------------------------------------- |
| type        | Tipo de cambio realizado.                                           |
| scope       | Componente o funcionalidad afectada.                                |
| description | Descripción breve del cambio en inglés, utilizando tiempo presente. |

Los tipos principales que se utilizarán son:

| Tipo       | Uso                                                               |
| ---------- | ----------------------------------------------------------------- |
| `test`     | Incorporar o modificar pruebas unitarias.                         |
| `feat`     | Implementar una nueva funcionalidad o comportamiento.             |
| `fix`      | Corregir un comportamiento que no funciona correctamente.         |
| `refactor` | Mejorar la estructura del código sin modificar su comportamiento. |
| `build`    | Modificar dependencias o configuración de Gradle.                 |
| `docs`     | Incorporar o actualizar documentación.                            |

## 5.2. Commits durante el ciclo RED–GREEN–REFACTOR

Cada comportamiento desarrollado mediante TDD deberá registrarse, preferentemente, mediante tres commits independientes.

| Fase TDD | Acción                                                   | Tipo de commit |
| -------- | -------------------------------------------------------- | -------------- |
| RED      | Incorporar una prueba que inicialmente falla.            | `test`         |
| GREEN    | Implementar el código mínimo para hacer pasar la prueba. | `feat` o `fix` |
| REFACTOR | Mejorar el código manteniendo las pruebas en verde.      | `refactor`     |

**Importante:** cada commit debe dejar el repositorio en un estado coherente. No se deben subir cambios que no compilen o que dejen la suite de pruebas en un estado inconsistente. Durante RED, la prueba puede estar fallando intencionalmente antes de su implementación, pero el commit debe contener una prueba válida y ejecutable, no errores de compilación.

## 5.3. Ejemplos de mensajes de commit

### A. Configuración inicial del proyecto

| ID      | Cambio                                         | Commit message                                            |
| ------- | ---------------------------------------------- | --------------------------------------------------------- |
| COM-001 | Configurar JUnit 6 y Mockito en Gradle.        | `build(test): configure JUnit 6 and Mockito dependencies` |
| COM-002 | Crear estructura de paquetes para los modelos. | `feat(model): create model package structure`             |
| COM-003 | Crear estructura de paquetes para las pruebas. | `test(model): create model test package structure`        |

### B. Desarrollo del modelo Paciente

| ID      | Fase     | Cambio                                          | Commit message                                           |
| ------- | -------- | ----------------------------------------------- | -------------------------------------------------------- |
| PAC-C01 | RED      | Crear prueba para construir un paciente válido. | `test(patient): add test for valid patient creation`     |
| PAC-C02 | GREEN    | Implementar constructor de Paciente.            | `feat(patient): implement patient constructor`           |
| PAC-C03 | REFACTOR | Mejorar la implementación del constructor.      | `refactor(patient): simplify patient initialization`     |
| PAC-C04 | RED      | Crear prueba para rechazar documento null.      | `test(patient): add test for null document validation`   |
| PAC-C05 | GREEN    | Implementar validación del documento.           | `feat(patient): validate required document`              |
| PAC-C06 | REFACTOR | Mejorar las validaciones del modelo.            | `refactor(patient): improve patient input validation`    |
| PAC-C07 | RED      | Crear prueba para rechazar nombres null.        | `test(patient): add test for null first name validation` |
| PAC-C08 | GREEN    | Implementar validación de nombres.              | `feat(patient): validate required first name`            |
| PAC-C09 | RED      | Crear prueba para rechazar apellidos null.      | `test(patient): add test for null last name validation`  |
| PAC-C10 | GREEN    | Implementar validación de apellidos.            | `feat(patient): validate required last name`             |

### C. Desarrollo del modelo Doctor

| ID      | Fase     | Cambio                                             | Commit message                                            |
| ------- | -------- | -------------------------------------------------- | --------------------------------------------------------- |
| DOC-C01 | RED      | Crear prueba para construir un doctor válido.      | `test(doctor): add test for valid doctor creation`        |
| DOC-C02 | GREEN    | Implementar constructor de Doctor.                 | `feat(doctor): implement doctor constructor`              |
| DOC-C03 | RED      | Crear prueba para validar documento obligatorio.   | `test(doctor): add test for required document validation` |
| DOC-C04 | GREEN    | Implementar validación del documento.              | `feat(doctor): validate required document`                |
| DOC-C05 | RED      | Crear prueba para validar colegiatura obligatoria. | `test(doctor): add test for required license validation`  |
| DOC-C06 | GREEN    | Implementar validación de colegiatura.             | `feat(doctor): validate required medical license`         |
| DOC-C07 | REFACTOR | Mejorar validaciones del modelo.                   | `refactor(doctor): improve doctor validation logic`       |

### D. Desarrollo del modelo Especialidad

| ID      | Fase     | Cambio                                               | Commit message                                           |
| ------- | -------- | ---------------------------------------------------- | -------------------------------------------------------- |
| ESP-C01 | RED      | Crear prueba para construir una especialidad válida. | `test(specialty): add test for valid specialty creation` |
| ESP-C02 | GREEN    | Implementar constructor de Especialidad.             | `feat(specialty): implement specialty constructor`       |
| ESP-C03 | RED      | Crear prueba para validar nombre obligatorio.        | `test(specialty): add test for required name validation` |
| ESP-C04 | GREEN    | Implementar validación del nombre.                   | `feat(specialty): validate required specialty name`      |
| ESP-C05 | REFACTOR | Mejorar implementación del modelo.                   | `refactor(specialty): improve specialty initialization`  |

### E. Desarrollo del modelo CitaMedica

| ID      | Fase     | Cambio                                          | Commit message                                                         |
| ------- | -------- | ----------------------------------------------- | ---------------------------------------------------------------------- |
| CIT-C01 | RED      | Crear prueba para construir una cita válida.    | `test(appointment): add test for valid appointment creation`           |
| CIT-C02 | GREEN    | Implementar constructor de CitaMedica.          | `feat(appointment): implement appointment constructor`                 |
| CIT-C03 | RED      | Crear prueba para validar paciente obligatorio. | `test(appointment): add test for required patient validation`          |
| CIT-C04 | GREEN    | Implementar validación del paciente.            | `feat(appointment): validate required patient reference`               |
| CIT-C05 | RED      | Crear prueba para validar doctor obligatorio.   | `test(appointment): add test for required doctor validation`           |
| CIT-C06 | GREEN    | Implementar validación del doctor.              | `feat(appointment): validate required doctor reference`                |
| CIT-C07 | RED      | Crear prueba para validar fecha y hora.         | `test(appointment): add test for required appointment date validation` |
| CIT-C08 | GREEN    | Implementar validación de fecha y hora.         | `feat(appointment): validate required appointment date`                |
| CIT-C09 | RED      | Crear pruebas para los estados de la cita.      | `test(appointment): add tests for appointment status values`           |
| CIT-C10 | GREEN    | Implementar enumerado de estados.               | `feat(appointment): implement appointment status enum`                 |
| CIT-C11 | REFACTOR | Mejorar la implementación del modelo.           | `refactor(appointment): improve appointment validation logic`          |

### F. Finalización y documentación

| ID      | Cambio                                        | Commit message                                       |
| ------- | --------------------------------------------- | ---------------------------------------------------- |
| FIN-001 | Completar las pruebas unitarias obligatorias. | `test(model): complete mandatory model unit tests`   |
| FIN-002 | Incorporar pruebas adicionales recomendadas.  | `test(model): add additional model validation tests` |
| FIN-003 | Refactorizar los modelos.                     | `refactor(model): improve model implementation`      |
| FIN-004 | Actualizar la documentación técnica.          | `docs(test): document model testing specifications`  |

Los mensajes anteriores son ejemplos orientativos. Los desarrolladores deberán adaptar cada mensaje al cambio que realmente hayan realizado.

## 5.4. Reglas para realizar los commits

Los desarrolladores deberán respetar las siguientes reglas:

1. Cada commit debe representar un cambio lógico y específico.
2. Los mensajes deben estar redactados en inglés.
3. Se debe utilizar el formato `type(scope): description`.
4. La descripción debe comenzar con un verbo en presente.
5. No utilizar mensajes genéricos como `update`, `changes`, `fixes` o `final version`.
6. No agrupar pruebas de diferentes modelos en un mismo commit cuando puedan registrarse de manera independiente.
7. Antes de registrar un commit GREEN, verificar que la prueba correspondiente pase.
8. Antes de registrar un commit REFACTOR, ejecutar nuevamente la suite completa.
9. No registrar archivos generados innecesarios, como los contenidos de la carpeta `build/`.
10. Subir periódicamente los commits al repositorio remoto para mantener actualizado el historial del proyecto.

## 5.5. Flujo de trabajo recomendado

Para cada comportamiento implementado, se recomienda seguir esta secuencia:

```text
1. Escribir la prueba unitaria.
         |
         v
2. Ejecutar la prueba.
         |
         v
3. Confirmar que falla por la razón esperada.
         |
         v
4. Registrar commit RED.
   test(model): add test for expected behavior
         |
         v
5. Implementar el código mínimo necesario.
         |
         v
6. Ejecutar la prueba nuevamente.
         |
         v
7. Confirmar que pasa.
         |
         v
8. Registrar commit GREEN.
   feat(model): implement expected behavior
         |
         v
9. Refactorizar el código.
         |
         v
10. Ejecutar toda la suite de pruebas.
         |
         v
11. Registrar commit REFACTOR.
    refactor(model): improve implementation
         |
         v
12. Subir los commits al repositorio remoto.
```

## 5.6. Comandos Git de referencia

Desde la terminal de IntelliJ IDEA (o Power Shell, o Command Prompt - cmd):

Consultar los cambios:

```bash
git status
```

Agregar los archivos modificados:

```bash
git add src/test/java
```

Registrar una prueba:

```bash
git commit -m "test(patient): add test for valid patient creation"
```

Agregar la implementación:

```bash
git add src/main/java
```

Registrar la implementación:

```bash
git commit -m "feat(patient): implement patient constructor"
```

Subir los commits al repositorio remoto:

```bash
git push origin main
```

Si el repositorio utiliza otra rama principal, se deberá reemplazar `main` por el nombre correspondiente.

## 5.7. Criterio de aceptación del historial Git

El historial del repositorio remoto deberá permitir identificar claramente:

- La incorporación de las pruebas unitarias.
- La implementación realizada para satisfacer cada prueba.
- Las mejoras de código realizadas durante la refactorización.
- La evolución incremental de cada modelo.
- La relación entre el desarrollo del software y el ciclo RED–GREEN–REFACTOR.

Se valorará positivamente que los commits permitan reconstruir el proceso de desarrollo y no solamente observar el resultado final.

**El historial Git debe constituir una evidencia del proceso TDD aplicado por los desarrolladores.**

---

# 6. Catálogo de pruebas unitarias obligatorias

Los siguientes casos constituyen el conjunto mínimo de pruebas que los desarrolladores deben implementar.

## 6.1. Pruebas del modelo Paciente

| ID      | Prueba / comportamiento                                 | Resultado esperado                                                        |
| ------- | ------------------------------------------------------- | ------------------------------------------------------------------------- |
| PAC-001 | Crear paciente con datos válidos.                       | Instancia creada correctamente y getters devuelven los valores recibidos. |
| PAC-002 | Crear paciente sin documento (`null`).                  | Lanzar `IllegalArgumentException`.                                        |
| PAC-003 | Crear paciente sin nombres (`null`).                    | Lanzar `IllegalArgumentException`.                                        |
| PAC-004 | Crear paciente sin apellidos (`null`).                  | Lanzar `IllegalArgumentException`.                                        |
| PAC-005 | Verificar los atributos después de construir el objeto. | Cada getter devuelve el dato correspondiente.                             |

## 6.2. Pruebas del modelo Doctor

| ID      | Prueba / comportamiento                                 | Resultado esperado                                                        |
| ------- | ------------------------------------------------------- | ------------------------------------------------------------------------- |
| DOC-001 | Crear doctor con datos válidos.                         | Instancia creada correctamente y getters devuelven los valores recibidos. |
| DOC-002 | Crear doctor sin documento (`null`).                    | Lanzar `IllegalArgumentException`.                                        |
| DOC-003 | Crear doctor sin nombres (`null`).                      | Lanzar `IllegalArgumentException`.                                        |
| DOC-004 | Crear doctor sin apellidos (`null`).                    | Lanzar `IllegalArgumentException`.                                        |
| DOC-005 | Crear doctor sin colegiatura (`null`).                  | Lanzar `IllegalArgumentException`.                                        |
| DOC-006 | Verificar los atributos después de construir el objeto. | Cada getter devuelve el dato correspondiente.                             |

## 6.3. Pruebas del modelo Especialidad

| ID      | Prueba / comportamiento                                 | Resultado esperado                                                        |
| ------- | ------------------------------------------------------- | ------------------------------------------------------------------------- |
| ESP-001 | Crear especialidad con datos válidos.                   | Instancia creada correctamente y getters devuelven los valores recibidos. |
| ESP-002 | Crear especialidad sin nombre (`null`).                 | Lanzar `IllegalArgumentException`.                                        |
| ESP-003 | Verificar los atributos después de construir el objeto. | Cada getter devuelve el dato correspondiente.                             |

## 6.4. Pruebas del modelo CitaMedica

| ID      | Prueba / comportamiento                                 | Resultado esperado                                                                                          |
| ------- | ------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| CIT-001 | Crear cita médica con datos válidos.                    | Instancia creada correctamente y getters devuelven los valores recibidos.                                   |
| CIT-002 | Crear cita sin identificador de paciente (`null`).      | Lanzar `IllegalArgumentException`.                                                                          |
| CIT-003 | Crear cita sin identificador de doctor (`null`).        | Lanzar `IllegalArgumentException`.                                                                          |
| CIT-004 | Crear cita sin identificador de especialidad (`null`).  | Lanzar `IllegalArgumentException`.                                                                          |
| CIT-005 | Crear cita sin fecha y hora (`null`).                   | Lanzar `IllegalArgumentException`.                                                                          |
| CIT-006 | Crear cita con estado `null`.                           | Aplicar el comportamiento predeterminado definido para el dominio o rechazarlo, según decisión documentada. |
| CIT-007 | Crear cita con un estado válido.                        | Conservar correctamente el estado recibido.                                                                 |
| CIT-008 | Verificar los atributos después de construir el objeto. | Cada getter devuelve el dato correspondiente.                                                               |

**Observación sobre CIT-006:** la aplicación utiliza actualmente el estado PROGRAMADA como uno de sus estados disponibles, pero no se ha establecido expresamente que deba asignarse automáticamente cuando el estado recibido sea `null`. Los desarrolladores deberán definir esa regla antes de implementar la prueba.

---

# 7. Catálogo de pruebas unitarias recomendadas

Los siguientes escenarios amplían la cobertura de los modelos. No forman parte del mínimo obligatorio, pero se recomienda implementarlos para mejorar la calidad del software.

## 7.1. Pruebas adicionales del modelo Paciente

| ID      | Escenario                                    | Resultado esperado                                                         |
| ------- | -------------------------------------------- | -------------------------------------------------------------------------- |
| PAC-006 | Documento vacío (`""`).                      | Rechazar con `IllegalArgumentException`.                                   |
| PAC-007 | Documento compuesto únicamente por espacios. | Rechazar con `IllegalArgumentException`.                                   |
| PAC-008 | Nombres vacíos.                              | Rechazar con `IllegalArgumentException`.                                   |
| PAC-009 | Apellidos vacíos.                            | Rechazar con `IllegalArgumentException`.                                   |
| PAC-010 | Correo con formato inválido.                 | Rechazar si se establece que el modelo debe validar el formato del correo. |
| PAC-011 | Teléfono con formato inválido.               | Rechazar si se establece una regla de formato para el teléfono.            |
| PAC-012 | Correo opcional con valor `null`.            | Aceptar si el correo se define como opcional.                              |

## 7.2. Pruebas adicionales del modelo Doctor

| ID      | Escenario                             | Resultado esperado                               |
| ------- | ------------------------------------- | ------------------------------------------------ |
| DOC-007 | Documento vacío (`""`).               | Rechazar con `IllegalArgumentException`.         |
| DOC-008 | Nombres o apellidos vacíos.           | Rechazar con `IllegalArgumentException`.         |
| DOC-009 | Colegiatura vacía.                    | Rechazar con `IllegalArgumentException`.         |
| DOC-010 | Colegiatura con formato inválido.     | Rechazar si se establece un formato obligatorio. |
| DOC-011 | Identificador de especialidad vacío.  | Rechazar si se establece como obligatorio.       |
| DOC-012 | Identificador de especialidad `null`. | Rechazar si se establece como obligatorio.       |

## 7.3. Pruebas adicionales del modelo Especialidad

| ID      | Escenario                                 | Resultado esperado                                   |
| ------- | ----------------------------------------- | ---------------------------------------------------- |
| ESP-004 | Nombre vacío (`""`).                      | Rechazar con `IllegalArgumentException`.             |
| ESP-005 | Nombre compuesto únicamente por espacios. | Rechazar con `IllegalArgumentException`.             |
| ESP-006 | Descripción vacía.                        | Aceptar o rechazar según la obligatoriedad definida. |
| ESP-007 | Descripción con valor `null`.             | Aceptar si la descripción es opcional.               |

## 7.4. Pruebas adicionales del modelo CitaMedica

| ID      | Escenario                                                | Resultado esperado                                   |
| ------- | -------------------------------------------------------- | ---------------------------------------------------- |
| CIT-009 | Crear cita con motivo vacío.                             | Rechazar si el motivo se establece como obligatorio. |
| CIT-010 | Crear cita con fecha y hora inválidas.                   | Rechazar con una excepción controlada.               |
| CIT-011 | Crear cita con fecha pasada.                             | Rechazar si se establece como regla del dominio.     |
| CIT-012 | Crear cita con estado PROGRAMADA.                        | Conservar el estado PROGRAMADA.                      |
| CIT-013 | Crear cita con estado ATENDIDA.                          | Conservar el estado ATENDIDA.                        |
| CIT-014 | Crear cita con estado CANCELADA.                         | Conservar el estado CANCELADA.                       |
| CIT-015 | Crear cita con estado no reconocido.                     | Rechazar el estado inválido.                         |
| CIT-016 | Crear cita con motivo compuesto únicamente por espacios. | Rechazar si el motivo es obligatorio.                |

## 7.5. Pruebas adicionales generales

| ID      | Escenario                                                              | Resultado esperado                                        |
| ------- | ---------------------------------------------------------------------- | --------------------------------------------------------- |
| GEN-001 | Verificar que los getters devuelvan correctamente todos los atributos. | Cada atributo conserva su valor original.                 |
| GEN-002 | Modificar atributos mediante setters, si existen.                      | Los atributos reflejan los nuevos valores.                |
| GEN-003 | Crear dos objetos con información diferente.                           | Cada objeto conserva sus propios datos sin interferencia. |
| GEN-004 | Verificar `equals()` y `hashCode()`, si están implementados.           | Cumplen el contrato de igualdad definido para el modelo.  |

---

# 8. Decisiones de negocio pendientes

Antes de implementar las pruebas adicionales, los desarrolladores deberán documentar las siguientes decisiones:

| Elemento                    | Decisión que debe establecerse                                                                  |
| --------------------------- | ----------------------------------------------------------------------------------------------- |
| Documento                   | Longitud y caracteres permitidos.                                                               |
| Teléfono                    | Formato y longitud permitida.                                                                   |
| Correo                      | Si es obligatorio y qué formato debe aceptar.                                                   |
| Colegiatura                 | Formato y longitud permitida.                                                                   |
| Descripción de especialidad | Si es obligatoria u opcional.                                                                   |
| Motivo de la cita           | Si es obligatorio y cuál es su longitud máxima.                                                 |
| Fecha de cita               | Si se permiten fechas pasadas o solamente futuras.                                              |
| Estado de la cita           | Si se asigna PROGRAMADA automáticamente cuando se recibe `null`.                                |
| Identificadores             | Tipo de dato utilizado para representar las referencias a pacientes, doctores y especialidades. |

Estas decisiones deben ser consistentes con los requerimientos de la aplicación.

No se deben inventar restricciones, como una longitud específica de documento o teléfono, sin que exista una regla de negocio que las justifique.

---

# 9. Ejemplo de implementación de una prueba unitaria

A continuación se muestra un ejemplo de cómo implementar una prueba para el modelo Paciente.

El ejemplo corresponde al caso PAC-001.

**Escenario:** crear un paciente con datos válidos.

**Resultado esperado:** el objeto se construye correctamente y conserva los valores recibidos.

```java
@Test
@DisplayName("Crear un paciente con datos válidos")
void shouldCreatePatientWithValidData() {

    Paciente paciente = new Paciente(
        "12345678",
        "Ana",
        "Pérez",
        "987654321",
        "ana@mail.com"
    );

    assertNotNull(paciente);

    assertEquals("12345678", paciente.getDocumento());
    assertEquals("Ana", paciente.getNombres());
    assertEquals("Pérez", paciente.getApellidos());
    assertEquals("987654321", paciente.getTelefono());
    assertEquals("ana@mail.com", paciente.getCorreo());
}
```

Ejemplo de una prueba de validación.

**Escenario:** intentar crear un paciente sin documento.

**Resultado esperado:** el constructor debe lanzar `IllegalArgumentException`.

```java
@Test
@DisplayName("Rechazar la creación de un paciente sin documento")
void shouldRejectPatientWithoutDocument() {

    assertThrows(
        IllegalArgumentException.class,
        () -> new Paciente(
            null,
            "Ana",
            "Pérez",
            "987654321",
            "ana@mail.com"
        )
    );
}
```

Los ejemplos muestran el comportamiento esperado, pero los desarrolladores deberán implementar primero las pruebas y luego desarrollar el código de producción que permita satisfacerlas.

---

# 10. Organización sugerida del proyecto

Se recomienda mantener separados el código de producción y el código de pruebas.

```text
salud-publica/
│
├── src/
│   │
│   ├── main/
│   │   └── java/
│   │       └── pe/
│   │           └── saludpublica/
│   │               └── model/
│   │                   ├── Paciente.java
│   │                   ├── Doctor.java
│   │                   ├── Especialidad.java
│   │                   ├── CitaMedica.java
│   │                   └── EstadoCita.java
│   │
│   └── test/
│       └── java/
│           └── pe/
│               └── saludpublica/
│                   └── model/
│                       ├── PacienteTest.java
│                       ├── DoctorTest.java
│                       ├── EspecialidadTest.java
│                       └── CitaMedicaTest.java
│
├── build.gradle
└── settings.gradle
```

La estructura es referencial. Los nombres definitivos de las clases podrán ajustarse a la implementación, siempre que se mantenga la correspondencia entre cada modelo y su clase de pruebas.

---

# 11. Criterios de calidad para cada prueba

Cada prueba unitaria deberá cumplir las siguientes condiciones:

1. Verificar un comportamiento observable y una regla concreta.
2. Ser independiente y ejecutable de forma aislada.
3. Tener un nombre descriptivo mediante `@DisplayName`, redactado en español.
4. Utilizar datos explícitos y fáciles de comprender.
5. Comprobar el resultado esperado y, cuando corresponda, el tipo de excepción.
6. Evitar dependencias con otras pruebas.
7. No depender de una conexión real a MongoDB.
8. No depender de la interfaz gráfica.
9. Ejecutarse correctamente junto con el resto de la suite.
10. Aplicar el ciclo RED–GREEN–REFACTOR durante el desarrollo.

Se recomienda que los nombres de los métodos de prueba utilicen la convención:

`shouldExpectedBehaviorWhenCondition`

Por ejemplo:

- `shouldCreatePatientWithValidData`
- `shouldRejectPatientWithoutDocument`
- `shouldRejectDoctorWithoutLicense`
- `shouldCreateAppointmentWithValidData`

---

# 12. Condiciones de aceptación

La capa Model de la aplicación `EsZalud` se considerará cubierta respecto de esta especificación cuando se cumplan las siguientes condiciones:

- Todos los casos definidos como obligatorios estén automatizados y pasen correctamente.
- Las pruebas de los cuatro modelos se ejecuten utilizando JUnit 6.
- Las validaciones produzcan excepciones controladas cuando se reciban datos inválidos.
- Los atributos de cada modelo conserven correctamente los valores recibidos.
- Las decisiones de negocio pendientes estén documentadas.
- Las pruebas unitarias no dependan de MongoDB ni de la librería utilizada para la UI.
- Mockito se utilice cuando exista una dependencia real que deba aislarse.
- Los cambios de implementación se hayan realizado siguiendo el ciclo RED–GREEN–REFACTOR.

---

# 13. Ejecución de las pruebas

Desde la raíz del proyecto, los estudiantes deberán ejecutar la suite completa utilizando Gradle Wrapper.

En Windows:

```powershell
.\gradlew.bat test
```

También podrán ejecutar las pruebas desde IntelliJ IDEA mediante las clases:

- `PacienteTest`
- `DoctorTest`
- `EspecialidadTest`
- `CitaMedicaTest`

El reporte HTML de Gradle se genera normalmente en:

```text
build/reports/tests/test/index.html
```

La ejecución debe finalizar sin pruebas fallidas.

---

# 14. Consideraciones finales

La presente especificación establece el contrato de pruebas unitarias para los modelos de `EsZalud`.

Los desarrolladores deberán utilizarla como guía durante el desarrollo de la aplicación, aplicando TDD desde el primer modelo.

Se espera que cada comportamiento sea implementado mediante pequeñas iteraciones:

1. Definir el comportamiento esperado.
2. Escribir la prueba unitaria.
3. Ejecutar la prueba y comprobar que falle.
4. Implementar el código mínimo necesario.
5. Ejecutar nuevamente la prueba y comprobar que pase.
6. Refactorizar el código si es necesario.
7. Ejecutar toda la suite de pruebas.

**El objetivo no es solamente conseguir que las pruebas pasen, sino desarrollar modelos confiables a partir de comportamientos previamente especificados y verificados.**

---

_Alex Marín Méndez | Documento de trabajo técnico | Especificación formal de pruebas unitarias – EsZalud | Versión 1.0_
