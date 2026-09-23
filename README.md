# Servicio de Autenticación - GA7-220501096-AA5-EV01

Servicio web REST desarrollado con Spring Boot para registrar usuarios y validar el inicio de sesión.

## Tecnologías

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Git y GitHub

## Ejecución

Desde la carpeta del proyecto ejecutar:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación estará disponible en `http://localhost:8081`.

## Endpoints

### Registrar usuario

`POST http://localhost:8081/api/auth/registro`

Body JSON:

```json
{
  "nombre": "Carol",
  "correo": "carol@email.com",
  "contrasena": "123456"
}
```

Respuesta esperada:

```json
{
  "mensaje": "Usuario registrado correctamente",
  "id": 1
}
```

### Iniciar sesión

`POST http://localhost:8081/api/auth/login`

Body JSON:

```json
{
  "correo": "carol@email.com",
  "contrasena": "123456"
}
```

Respuesta correcta:

```json
{
  "mensaje": "Autenticación satisfactoria"
}
```

Respuesta incorrecta:

```json
{
  "error": "Error en la autenticación"
}
```

## Propósito

La API permite registrar usuarios y validar sus credenciales mediante servicios web REST. El código contiene comentarios para facilitar su comprensión y será probado con Postman en la evidencia AA5-EV02.
