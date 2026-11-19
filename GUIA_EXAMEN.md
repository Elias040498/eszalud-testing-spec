# Guía: Cómo subir a GITHUB la solución de tu examen

## 1. Introducción

El proceso completo incluye 3 fases:

**Fork + Branch + Pull Request (PR)**

Este es el flujo estándar de colaboración en proyectos Open Source. No necesitas permisos de escritura sobre el repositorio original y es el que utilizaremos para la entrega de tu solución al examen.

## 2. Flujo de entrega del examen

El proceso general es el siguiente:

1. **Repositorio original:** identificar el repo del examen (ya estás aquí).
2. **Fork:** creas una copia del repositorio en tu cuenta de GitHub.
3. **Branch:** creas una rama para desarrollar tu propuesta.
4. **Commits:** implementas y registras tus cambios.
5. **Pull Request:** solicitas incorporar tus cambios al repositorio original.
6. **Revisión y aprobación:** yo revisaré tu solución y se te asignará el puntaje alcanzado.

## 3. Procedimiento paso a paso

### Paso 1. Identificar el repositorio

Ingresa al repositorio público que deseas mejorar.

Por ejemplo:

```text
https://github.com/alexmarinmendez/eszalud-testing-spec
```

### Paso 2. Crear un Fork

1. Haz clic en el botón **Fork**.
2. Selecciona tu cuenta de GitHub.
3. GitHub creará una copia del repositorio en tu cuenta.

Ahora tendrás tu propia versión:

```text
https://github.com/tu-usuario/eszalud-testing-spec
```

### Paso 3. Clonar tu Fork

En tu computadora, abre una terminal y ejecuta:

```bash
git clone https://github.com/tu-usuario/eszalud-testing-spec.git

cd eszalud-testing-spec
```

Esto descargará tu copia del repositorio a tu computadora.

### Paso 4. Crear una rama para tu propuesta

No es recomendable trabajar directamente sobre la rama `main`.

Crea una nueva rama cuyo nombre _DEBE_ tener el siguiente formato: `tdd/ApellidoPaternoApellidoMaterno_PrimerNombre`.
Por ejemplo:

```bash
git checkout -b tdd/MarinMendez_Alex
```

### Paso 5. Implementar los cambios

Implementa [los test obligatorios indicados en la Especificación Formal de Pruebas](EFP_Pruebas_Unitarias_EsZalud.md).

Registra cada paso del proceso TDD con `git add`, `git commit` y `git push`.

Esto actualizará tu repositorio personal en GitHub con los cambios realizados.

### Paso 7. Crear el Pull Request

Ingresa al repositorio original y selecciona la opción **Pull request** y luego busca el botón verde **New pull request**.

Verifica que los repositorios y las ramas estén correctamente seleccionados:

**Base repository (destino):**

```text
alexmarinmendez/eszalud-testing-spec
```

**Base branch**: `main`

**Head repository (origen):**

```text
tu-usuario/eszalud-testing-spec
```

Rama: `tdd/ApellidoPaternoApellidoMaterno_PrimerNombre`

Estás proponiendo incorporar los cambios de tu rama al repositorio original.

Escribe un título y una descripción detallando:

- Apellidos y nombres completos.
- Código de matrícula.

Finalmente, selecciona **Create Pull Request**.
