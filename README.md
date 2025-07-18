# 🍽️ Sistema de Gestión del Comedor Universitario - UNFV

Este proyecto es una aplicación web desarrollada con **Spring Boot** y base de datos **Oracle** para gestionar reservas de comida en un comedor universitario. Permite a los estudiantes registrarse, realizar reservas según turnos y horarios, y a los administradores configurar límites, turnos y horarios desde una interfaz web.

---

## 🎯 Objetivo

Facilitar la gestión de turnos, raciones y reservas en un comedor universitario, brindando:

- Reservas únicas por turno por día
- Control de raciones por escuela, facultad y turno
- Interfaz de administración para actualizar límites y horarios

---

## 🧱 Tecnologías Utilizadas

- ⚙️ **Backend**: Spring Boot 3
- 💾 **Base de Datos**: Oracle 21c (XEPDB1)
- 🔐 **Seguridad**: JWT con filtros personalizados
- 🌐 **Frontend**: HTML + CSS + JavaScript puro (sin frameworks)
- ☕ **Java**: 17+ (compatible con Java 21+)
- 🐘 **Maven**: 3.8+

---

## 📦 Instalación y Ejecución

### 🛠️ Requisitos Previos

- Java 17+ (Java 21 recomendado)
- Maven 3.8+
- Oracle SQL Developer
- Base de datos Oracle (XEPDB1)

### 🔃 Clonar el Repositorio

```bash
git clone https://github.com/ReZherk/springboot-comedor-api.git
cd springboot-comedor-api
```

### 📂 Configurar la Base de Datos

1. Ejecuta el script SQL incluido (`Script de base de datos de Oracle.txt`) en Oracle SQL Developer
2. Asegúrate de usar el contenedor `XEPDB1`

### ⚙️ Configurar `application.properties`

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=USUARIO
spring.datasource.password=CONTRASEÑA
spring.jpa.hibernate.ddl-auto=none
```

### 🚀 Ejecutar el Backend

```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

---

## 🖥️ Frontend

Los archivos HTML se encuentran en la carpeta `frontend`. Puedes abrirlos directamente con tu navegador o servirlos con **Live Server** en VSCode.

### Páginas Disponibles

- `index_login.html`: Página de inicio de sesión
- `reservar.html`: Interfaz para estudiantes (realizar reservas)
- `admin.html`: Registro y mantenimiento de estudiantes
- `admin_config.html`: Configuración de turnos, límites y horarios

---

## 📌 Funcionalidades Principales

- ✅ **Autenticación**: Inicio de sesión con JWT
- ✅ **Reservas controladas**: Validación para una sola reserva por turno por estudiante
- ✅ **Control de raciones**: Límites por turno, facultad y escuela
- ✅ **Configuración dinámica**: Panel de administrador para ajustar parámetros
- ✅ **API REST**: Respuestas del backend en formato `camelCase`
- ✅ **Seguridad personalizada**: Implementación con `WebSecurityConfigurer`

---

## 🔧 Estructura del Proyecto

```
comedor-universitario/
├── src/
│   ├── main/
│   │   ├── java/com/universidad/comedor/
│   │   │   ├── config/ → WebConfig, CORS
│   │   │   ├── controller/ → Controladores REST
│   │   │   ├── dto/ → Objetos de transferencia (DTOs)
│   │   │   ├── model/ → Entidades JPA (Estudiante, Turno, Reserva, etc.)
│   │   │   ├── repository/ → Interfaces JpaRepository
│   │   │   ├── security/ → Seguridad JWT
│   │   │   └── service/ → Lógica de negocio (ReservaService)
│   │   └── resources/
│   │       └── application.properties → Configuración de conexión Oracle
├── frontend/
│   ├── admin.html
│   ├── admin_config.html
│   ├── reservar.html
│   └── index_login.html
└── README.md
```

---

## 🚀 Uso del Sistema

### Para Estudiantes

1. Inicia sesión con tus credenciales
2. Selecciona el turno deseado
3. Realiza tu reserva (una por turno por día)

### Para Administradores

1. Accede al panel de administración
2. Registra nuevos estudiantes
3. Configura límites de raciones por facultad/escuela
4. Ajusta horarios y turnos disponibles

---

## 📄 Licencia

Este proyecto es de uso académico, desarrollado como parte del curso electivo **Proyecto de Sistemas** en la **Universidad Nacional Federico Villarreal (UNFV)**. Libre para uso educativo.

---

## 👨‍💻 Autor

**Patrick Alexander Alcántara Sedano**  
Estudiante de Ingeniería de Sistemas - UNFV  
📧 Contacto: [GitHub](https://github.com/ReZherk)

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Haz fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

---

## 📞 Soporte

Si encuentras algún problema o tienes preguntas, puedes:

- Crear un issue en el repositorio
- Contactar al autor a través de GitHub
