## Configuración de MongoDB

Antes de ejecutar EsZalud, es necesario configurar la variable de entorno `MONGODB_URI`, que contiene la cadena de conexión a MongoDB.

La aplicación utiliza esta variable para conectarse a la base de datos `salud_publica`.

### 1. Crear la variable de entorno en PowerShell

1. Abre una ventana de **Windows PowerShell**.
2. Ejecuta el siguiente comando, reemplazando `MiClave123` por la contraseña real del usuario de MongoDB:

```powershell
$env:MONGODB_URI="mongodb://admin:MiClave123@localhost:27017/salud_publica?authSource=admin"
```

3. La variable estará disponible en esa sesión de PowerShell.

### 2. Crear la variable de entorno en Command Prompt (CMD)

1. Abre una ventana del **Símbolo del sistema (Command Prompt)**.
2. Ejecuta el siguiente comando:

```cmd
set MONGODB_URI=mongodb://admin:MiClave123@localhost:27017/salud_publica?authSource=admin
```

3. La variable estará disponible en esa sesión de CMD.

### 3. Consideraciones importantes

- Reemplacen `MiClave123` por la contraseña correspondiente al usuario `admin` de MongoDB.
- Verifiquen que el servicio de MongoDB esté iniciado.
- No compartan públicamente cadenas de conexión que contengan contraseñas reales.
- La variable creada con `$env:` o `set` desaparece al cerrar la ventana de la consola.

## Crear la base de datos en MongoDB Compass

Para preparar la base de datos, utilizaremos **MongoDB Compass**.

1. Abre MongoDB Compass.
2. Conéctate a tu servidor local de MongoDB utilizando las credenciales correspondientes.
3. En la sección de bases de datos, selecciona **Create Database**.
4. Completa los siguientes datos:
   - **Database Name:** `salud_publica`
   - **Collection Name:** `patients`

5. Selecciona **Create Database**.

Con esto se creará la base de datos `salud_publica` y su primera colección, `patients`.

## Importar los archivos JSON

En este repositorio encontrarás cuatro archivos JSON con los documentos necesarios para trabajar con EsZalud.

Los archivos corresponden a las siguientes colecciones:

| Archivo JSON                                                                    | Colección      |
| ------------------------------------------------------------------------------- | -------------- |
| [`salud_publica.patients.json`](./database/salud_publica.patients.json)         | `patients`     |
| [`salud_publica.doctors.json`](./database/salud_publica.doctors.json)           | `doctors`      |
| [`salud_publica.specialties.json`](./database/salud_publica.specialties.json)   | `specialties`  |
| [`salud_publica.appointments.json`](./database/salud_publica.appointments.json) | `appointments` |

### 3.1. Importar los pacientes

1. En MongoDB Compass, selecciona la base de datos `salud_publica`.
2. Abre la colección `patients`.
3. Selecciona **Add Data → Import JSON or CSV file**.
4. Busca el archivo `salud_publica.patients.json` dentro del repositorio.
5. Selecciona el formato **JSON**.
6. Haz clic en **Import**.

### 3.2. Crear e importar las demás colecciones

Para cada una de las colecciones restantes:

1. Dentro de la base de datos `salud_publica`, selecciona **Create Collection**.
2. Escribe el nombre de la colección correspondiente.
3. Selecciona **Create Collection**.
4. Abre la colección recién creada.
5. Selecciona **Add Data → Import JSON or CSV file**.
6. Busca el archivo JSON correspondiente dentro del repositorio.
7. Selecciona el formato **JSON** y haz clic en **Import**.

Repite estos pasos para:

- `salud_publica.doctors.json`
- `salud_publica.specialties.json`
- `salud_publica.appointments.json`

Al finalizar, tendrás las cuatro colecciones con sus respectivos documentos.

## 4. Verificar la base de datos

En MongoDB Compass, verifica que la base de datos `salud_publica` contenga las siguientes colecciones:

- `patients`
- `doctors`
- `specialties`
- `appointments`

Abre cada colección y comprueba que los documentos se hayan importado correctamente.

## 5. Consideraciones importantes

- Verifica que el servicio de MongoDB esté iniciado antes de realizar la conexión.
- Reemplaza `MiClave123` por la contraseña correspondiente al usuario `admin` de MongoDB.
- Importa los archivos JSON utilizando los datos originales del repositorio. No modifiques los valores de los campos `_id`, ya que pueden existir referencias entre las colecciones.
- Si las colecciones ya contienen documentos, evita importar nuevamente los mismos archivos para no generar registros duplicados.
- No compartas públicamente cadenas de conexión que contengan contraseñas reales.
- La variable creada con `$env:` o `set` desaparece al cerrar la ventana de la consola.

## 6. Ejecutar la aplicación EsZalud

Una vez configurada la variable de entorno y preparada la base de datos, abre una terminal en la carpeta del proyecto y ejecuta:

```powershell
java -jar ./salud-publica-all.jar
```

**¡Listo!** Ya tienes el entorno preparado para ejecutar EsZalud.
