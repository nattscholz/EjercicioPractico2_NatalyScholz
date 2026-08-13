# MediCare

Aplicación web desarrollada para administrar usuarios, roles y citas médicas de un centro de salud.

El sistema implementa autenticación y autorización mediante Spring Security, consultas avanzadas con Spring Data JPA y envío automático de correos de bienvenida utilizando Spring Mail.

## Autor

Nataly Scholz Peraza

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.0
- Maven
- Spring Web
- Spring Data JPA
- Spring Security
- Spring Mail
- Thymeleaf
- Bootstrap 5
- MySQL
- NetBeans

## Funcionalidades

### Usuarios

- Listar usuarios.
- Crear usuarios.
- Editar usuarios.
- Eliminar usuarios.
- Mostrar el detalle de un usuario.
- Asignar un rol.
- Codificar contraseñas con BCrypt.
- Enviar un correo de bienvenida.

### Roles

- Listar roles.
- Crear roles.
- Editar roles.
- Eliminar roles.
- Mostrar el detalle de un rol.

Roles requeridos:

- ADMIN
- MEDICO
- PACIENTE

### Citas médicas

- Listar citas.
- Crear citas.
- Editar citas.
- Eliminar citas.
- Mostrar el detalle de una cita.
- Administrar el estado activo o inactivo.

### Consultas avanzadas

- Buscar citas por estado.
- Buscar citas dentro de un rango de fechas.
- Buscar citas por coincidencia parcial en la especialidad.


## Requisitos

Antes de ejecutar el proyecto se necesita:

- Java 21.
- NetBeans.
- Maven.
- MySQL Server.
- MySQL Workbench.
- Una cuenta Gmail con verificación en dos pasos y contraseña de aplicación, para probar el envío de correos.

## Configuración de la base de datos

El script se encuentra en:

```text
MediCare/medicare.sql
```

Para crear la base de datos:

1. Abrir MySQL Workbench.
2. Abrir `medicare.sql`.
3. Ejecutar todo el script.
4. Verificar que se cree la base de datos `medicare`.
5. Confirmar que existan las tablas `rol`, `usuario` y `cita_medica`.

El script crea los roles, usuarios y citas médicas necesarios para probar la aplicación.

## Variables de entorno

La aplicación utiliza variables de entorno para evitar publicar credenciales.

Crear las siguientes variables:

```text
MEDICARE_DB_USERNAME
MEDICARE_DB_PASSWORD
MEDICARE_MAIL_USERNAME
MEDICARE_MAIL_PASSWORD
```

Descripción:

| Variable | Descripción |
|---|---|
| `MEDICARE_DB_USERNAME` | Usuario de MySQL |
| `MEDICARE_DB_PASSWORD` | Contraseña de MySQL |
| `MEDICARE_MAIL_USERNAME` | Dirección completa de Gmail |
| `MEDICARE_MAIL_PASSWORD` | Contraseña de aplicación de Gmail |

Después de crear o modificar las variables, se debe cerrar y abrir nuevamente NetBeans.

No se debe utilizar la contraseña personal de Gmail. Debe utilizarse una contraseña de aplicación.

## Ejecución

1. Clonar el repositorio.
2. Ejecutar `MediCare/medicare.sql` en MySQL Workbench.
3. Configurar las cuatro variables de entorno.
4. Abrir la carpeta `MediCare` como proyecto Maven en NetBeans.
5. Ejecutar `Clean and Build`.
6. Ejecutar el proyecto.
7. Abrir en el navegador:

```text
http://localhost:78
```

## Usuarios de prueba

### Administrador

```text
Correo: admin@medicare.com
Contraseña: 12345
```

### Médico

```text
Correo: medico@medicare.com
Contraseña: 12345
```

### Paciente

```text
Correo: paciente@medicare.com
Contraseña: 12345
```

## Registro público

Desde la página de login se puede crear una cuenta nueva.

Toda cuenta creada mediante el registro público recibe automáticamente:

- Rol PACIENTE.
- Estado activo.
- Contraseña codificada.
- Correo de bienvenida.

## Puerto

La aplicación se ejecuta en:

```text
78
```

Configuración utilizada:

```properties
server.port=78
```
