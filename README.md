# Proyecto Ciclillos | CVDS | 2022-1

## Profesor
- Julian Mauricio Velasco Briceño (Stakeholder)

## Integrantes
- Santiago Andrés Bayona Cardenas (Back)
- Juan Carlos Acosta López (Front)
- Julian Esteban Torres Díaz (Back)
- Jaime Nicolás Castro Acuña (Front)
- David Alejandro Leon (UX)
## Descripcion del producto
- **Descripción general:** Esta página está diseñada para la gestión y reserva de recursos de la biblioteca de la Escuela Colombiana de Ingeniería Julio Garavito, cuenta con interfaces para administradores y estudiantes que la utilicen. Para los estudiantes es posible tanto reservar recursos como consultar reservas, para los administradores es posible registrar recursos, cambiar el estado de los recursos, ver las reservas activas y el reporte de ocupación.
    
- **Manual de usuario:**
- En nuestro aplicativo contamos actualmente con dos tipos de usuarios: Administrador, y Comunidad. Y una consulta rápida para el catálogo de los recursos como se muestra en la siguiente pantalla:
![image](https://user-images.githubusercontent.com/25957863/168954167-08e2314b-665a-4e6c-ba8c-bd037089358a.png)
- Iniciaremos explicando el apartado de "Catálogo de Biblioteca"; para esto damos click en el primer recuadro que aparece en la pantalla de inicio:
![image](https://user-images.githubusercontent.com/25957863/168954945-08788029-69c6-449d-b1e9-c331b2f6d0e1.png)
- Veremos la siguiente página en donde podemos hacer la consulta de los recursos sin necesidad de **Iniciar Sesión**:
![image](https://user-images.githubusercontent.com/25957863/168955710-5813c625-c478-4c29-8c83-cfe13fa06e98.png)
- Esta busqueda puede ser filtrada seleccionando el combo box que aparece en la parte media izquierda de la vista:
![image](https://user-images.githubusercontent.com/25957863/168952637-b5c3292d-9e85-40d2-b9ea-5ae025493bf6.png)
- Seguido de esto explicaremos cada una de las funcionalidades que se tienen en el rol de Comunidad. Para esto damos click sobre el primer recuadro como veremos a continuación:
![image](https://user-images.githubusercontent.com/25957863/168954409-f55675e6-df88-4054-82a1-cc58e8ff0beb.png)
- Luego de dar click se nos desplegará la siguiente pantalla:
![image](https://user-images.githubusercontent.com/25957863/168930793-d2fe20ab-7e62-4fd5-997d-e3f159396d6c.png)
- Allí haremos login con las siguientes credenciales:
![image](https://user-images.githubusercontent.com/25957863/168931190-5c4c4341-cf23-4e00-85d5-1179223af694.png)
- Esta vista cuenta con varias funcionalidades que detallaremos aquí:
- **Cerrar Sesión:** Nos dirigirá a nuestra pantalla principal de elección de usuario (Administrador, Comunidad).
![image](https://user-images.githubusercontent.com/25957863/168936807-57fc7a49-c7a4-4f3e-b70e-6a01157aa065.png)
- **Reservar:** En este apartado prodemos hacer la búsqueda y posterior reserva de un recurso disponible.
![image](https://user-images.githubusercontent.com/25957863/168936919-fa442891-566a-4a47-8a6b-321869a4ab6c.png)
- Esta busqueda puede ser filtrada seleccionando el combo box que aparece en la parte media izquierda de la vista:
![image](https://user-images.githubusercontent.com/25957863/168952637-b5c3292d-9e85-40d2-b9ea-5ae025493bf6.png)
- En nuestro caso de prueba primero debemos hacer la busqueda de el volúmen: "Cálculo diferencial". Damos click en buscar como se muestra a continuación:
![image](https://user-images.githubusercontent.com/25957863/168932807-51e699aa-f033-4c75-8320-59f2a6c36bb3.png)
- Nos saldrán los siguientes recursos disponibles:
![image](https://user-images.githubusercontent.com/25957863/168933111-db246be4-0db9-4ea9-b62c-d8472f3868d6.png)
- Seleccionamos el volúmen como se muestra a continuación:
![image](https://user-images.githubusercontent.com/25957863/168934416-f2ed6a75-0261-4c4f-abcb-39d083712142.png)
- Seleccionamos el día en el que deseamos reservar el recurso, en esta oportunidad lo reservaremos para el día 18/15/2022, como se muestra:
![image](https://user-images.githubusercontent.com/25957863/168936123-7288c111-8e8b-4d81-ba77-fa2decd93d9a.png)
- Posteriormente selecionamos la hora, y procedemos a realizar la reserva.
![image](https://user-images.githubusercontent.com/25957863/168936230-ea013d38-c21d-4735-81cc-d7e17e56bb2e.png)
- Todo esto lo realizamos en caso de querer una reserva sin recurrencia; en el caso de querer que esta sea recurrente hacemos todos los pasos anteriores pero agregamos lo siguiente:
  1. Seleccionamos el check box como se muestra a continuación:
![image](https://user-images.githubusercontent.com/25957863/168945645-4686d33e-8275-4671-b015-5b3c6d00314b.png)
  2. Desplegamos el combo box y seleccionamos la periodicidad con que queremos realizar la reserva:
![image](https://user-images.githubusercontent.com/25957863/168946907-7bcdbd2a-2694-48dd-9d77-b49ee2d66081.png)
  3. Damos click por último en "Realizar reserva":
![image](https://user-images.githubusercontent.com/25957863/168947779-f8f8ed94-1c98-49ad-a8b1-cf52fd2e2737.png)
- Si la reserva es exitosa en cualquier de los dos casos (Recurrente o no recurrente) veremos un mensaje de confirmación en la parte superior derecha como vemos a continuación:
![image](https://user-images.githubusercontent.com/25957863/168936429-95a8bed1-3e29-42a3-a323-12384c0d8ba9.png)
- **Mis reservas:** Otra funcionalidad que posee un usario de la comunidad es el de consultar cada una de las reservas realizadas.
![image](https://user-images.githubusercontent.com/25957863/168938034-39340a23-2bca-4e3a-84ec-d1ab787ec395.png)
- A continuación vemos un combo box en el cual podemos filtrar la busqueda de las reservas. (Activas, Pasadas y Canceladas)
![image](https://user-images.githubusercontent.com/25957863/168939340-3ad91794-137a-48fe-a767-8b918ff7b926.png)
- En la sección de reservas activas evidenciamos la reserva echa anteriormente al recurso: "Cálculo Diferencial"
![image](https://user-images.githubusercontent.com/25957863/168938741-fbdb9603-f9ab-4c09-a9fa-1b6340624492.png)
- En las reservas pasadas vemos aquellas echas con fechas anteriores:
![image](https://user-images.githubusercontent.com/25957863/168939557-d58ff8a2-9750-45ef-b30e-039c9be9f030.png)
- En el filtro de reservas canceladas evidenciamos aquellas reservas pasadas que fueron anuladas por el usuario:  
![image](https://user-images.githubusercontent.com/25957863/168939736-66031776-9706-44cf-8137-03f007cc1aa2.png).
- ¿Cómo podemos cancelar las reservas?
- Si la reserva es de tipo NO recurrente:
  1. Damos click sobre la lupa de color azul que aparece en la parte derecha de cada una de las reservas (Activas).
  2. Damos click en cancelar: 
![image](https://user-images.githubusercontent.com/25957863/168952100-8cad813c-8fdb-423c-a17a-0685c3bcc8d4.png)
- Si la reserva es de tipo recurrente:
1. Damos click sobre la lupa de color azul que aparece en la parte derecha de cada una de las reservas (Activas).
2. Damos click en cancelar: 
3. Damos click aquí si queremos que todas las reservas sean canceladas.
4. Damos click aquí si queremos queremos cancelar algún evento en particular.
5. Damos click aquí si queremos cancelar eventos desde una fecha especificada.
6. Confirmamos cual haya sido nuestra selección.
![image](https://user-images.githubusercontent.com/25957863/168960400-fa68e1d1-de26-446f-8f61-6ffe1a88f564.png)
- Vamos a revisar ahora el perfil del adiministrador, primero seleccionamos entonces **Cerar Sesión** y damos click en el perfil de adiministrador:
![image](https://user-images.githubusercontent.com/25957863/168959704-2b7813fe-d378-4eb5-ac51-342896b956a5.png)
- Una vez en nuestro perfil de administrador ingresamos nuestras credenciales y damos click en **Iniciar Sesión**:
![image](https://user-images.githubusercontent.com/25957863/168953290-2323b6e1-f719-4849-8ac0-c8e76fd72ef6.png)
- Luego del inicio de sesión se abrirá la siguiente página:
![image](https://user-images.githubusercontent.com/25957863/168966401-697290c4-ab1b-4935-8fec-8fb2533e0617.png)
- Allí tenemos cuatro opciones entre las cuales encontramos:
![image](https://user-images.githubusercontent.com/25957863/168966660-cd22b4d1-66ef-490b-976d-5a53ae92727c.png)
- **Agregar recurso:** Allí podremos gestionar los nuevos recursos que deseemos añadir a nuestro portal web. Para añadir un recurso bastará con diligenciar cada uno de los datos que vemos en la pantalla anterior.
![image](https://user-images.githubusercontent.com/25957863/168968508-56af2396-5243-4143-ad99-af6acea157f5.png)
- Para nuestro ejemplo agregaremos un nuevo recurso así:
![image](https://user-images.githubusercontent.com/25957863/168968550-2b879ce6-e97d-4d91-a148-457fb473bf72.png)
- Damos click en agregar:  
![image](https://user-images.githubusercontent.com/25957863/168968609-fbcc80b6-f40d-4a4d-8ba9-8db15f426ce2.png)
- Al finalizar el registro veremos una pantalla con la confirmación del recurso agregado como la siguiente:  
![image](https://user-images.githubusercontent.com/25957863/168968655-f1940c94-99e6-4b21-a7a8-6b62d0c313ca.png)
- Procederemos a usar la segunda funcionalidad que tiene el administrador dentro de nuestro aplicativo:
![image](https://user-images.githubusercontent.com/25957863/168968838-9f77390a-bdf3-4432-a9ce-e555b66151f9.png)
- **Editar recurso:** Allí podremos gestionar la disponibilidad de los recursos dentro de nuestro portal web. 
- Para modificar la disponibilidad de un recurso bastará con:
1. Buscar el recurso.
2. Seleccionar el recurso al que desea cambiar la disponibilidad.
3. Dar click en **cambiar disponibilidad**
![image](https://user-images.githubusercontent.com/25957863/168969623-b7fd00fb-71e3-4f33-a8da-92e598cfb46c.png)
- Procederemos a usar la tercerta funcionalidad que tiene el administrador dentro de nuestro aplicativo:
![image](https://user-images.githubusercontent.com/25957863/168970288-3c5ebed2-e71c-477b-8c04-f086b54a6e9b.png)
- **Consultar reservas:** Aquí podremos consultar la reservas de los recursos por usuario. 
![image](https://user-images.githubusercontent.com/25957863/168970777-160fec89-c6f9-4ffc-a79f-2a5de73f2bf7.png)
- Para este caso vamos a consultar las reservas del usuario **julian@gmail.com**:
![image](https://user-images.githubusercontent.com/25957863/168972422-b05f185d-b9bd-4f43-a776-733e919bac58.png)
- Podemos consultar el detalle de la reserva dando click en la lupa que aparece en la parte derecha:
![image](https://user-images.githubusercontent.com/25957863/168975228-94f4d764-d5cc-4bc9-a1cc-53faa70584b2.png)
- Procederemos a usar la cuarta funcionalidad que tiene el administrador dentro de nuestro aplicativo:
![image](https://user-images.githubusercontent.com/25957863/168975410-8ea7754f-a948-4f57-b82e-a781f5e4d67b.png)
- **Reportes de ocupación:** Aquí podremos consultar los reportes de ocupación. 
![image](https://user-images.githubusercontent.com/25957863/168975569-4cc3c3be-7540-43b7-9e68-e81dbdd2809d.png)
- Además de las funcionalidades anteriormente descritas también tenemos la posibilidad de generar una representación gráfica tanto de las reservas recurrentes como de las reservas canceladas.
![image](https://user-images.githubusercontent.com/25957863/168976329-bf1f960a-5f77-4104-b450-c7cfe9305ee4.png)
- A continuación evidenciamos un gráfico de dona con las reservas recurrentes y las reservas canceladas:
![image](https://user-images.githubusercontent.com/25957863/168976850-7c3993bc-df4d-4c18-8c59-ae870ba1b46e.png)

## Arquitectura y Diseño detallado
- **Modelo E-R:**
\
            ![image](https://user-images.githubusercontent.com/98216838/168507698-701ce664-f965-4a23-8689-383a172ff774.png)
- **Diagrama de clases:**
- ![image](https://user-images.githubusercontent.com/98216838/168897746-a1a01c44-f122-492d-ad97-246a27f29dfa.png)

- **Descripción de la arquitectura y del Stack:**
En este proyecto se usan las siguientes tecnologías: 	
1. PrimeFaces: Se utiliza para representar y gestionar componentes de la intefaz de usuario.
2. Guice: Se usa para la inyección de dependencias, permitiendo un mejor manejo de los objetos.
3. PostgreSQL: Es el sistema de gestión de bases de datos implementado en este proyecto.
4. Heroku: Heroku es una plataforma como servicio de computación en la Nube, acá está montado el proyecto para el despliegue continuo.
5. CircleCI: Es una plataforma de integración continua que también se utiliza en el proyecto.
6. Apache Shiro: Es un marco de seguridad de software de código abierto que realiza autenticación, autorización, criptografía y gestión de sesiones. Es usado en la autenticación del inicio de sesión.

- **Aplicación en Heroku**
    - https://dashboard.heroku.com/apps/proyectociclos2022
- **Despliegue continuo**
    - https://proyectociclos2022.herokuapp.com/
## Descripción del proceso
- **Metodologia:**
- **Taiga:**
    - https://tree.taiga.io/project/estebananot-gestion-de-recursos-biblioteca/timeline
- **release-burndown chart**
- **Sprint 1:**
- Descripcion del sprint 1 : En este sprint se llevaron a cabo 3 historias de usuario las cuales fueron:
   - Iniciar Sesion (Terminada)
   - Registrar Un Recurso (Terminada)
   - Cambiar estado de un recuso (Terminada)
- Sprint-backlog
 ![image](https://user-images.githubusercontent.com/98216838/168508554-f477b635-c22e-42e5-85c4-bf765a373401.png)
- Sprint-burndown chart
 ![image](https://user-images.githubusercontent.com/98216838/168881077-e07087df-d58d-4b8e-b5af-3460a5f4fa2c.png)

- **Sprint 2:**
- Descripcion del sprint 2 : En este sprint se llevaron a cabo 4 historias de usuario las cuales fueron:
   - Consultar Recursos (Terminada)
   - Reservar Recurso (Terminada)
   - Visualizar horario de reserva de recursos (Terminada)
   - Consultar Reserva (Terminada)
- Sprint-backlog
 ![image](https://user-images.githubusercontent.com/98216838/168880785-e1f58247-6f04-431a-9c41-2fee2020236c.png)
            
- Sprint-burndown chart
 ![image](https://user-images.githubusercontent.com/98216838/168881016-d45f21a4-4fc2-4d1c-9b73-3f76fe46ee50.png)

- **Sprint 3:**
- Descripcion del sprint 2 : En este sprint se llevaron a cabo 3 historias de usuario las cuales fueron:
   - Cancelar Reserva (Terminada)
   - Reporte De Ocupacion (Terminada)
   - Visualizar Reservas (Terminada)
- Sprint-backlog
 ![image](https://user-images.githubusercontent.com/87088730/168972560-d4eb195a-e1c6-4e0f-9651-02dc311669e0.png)

- Sprint-burndown chart
 ![image](https://user-images.githubusercontent.com/87088730/168972341-3ec136da-0f27-4a3a-861f-989ed9d966e2.png)

 ## Reporte de pruebas
-  **Codacy Badge:**\
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/0677f1d86193467e9d40545af3c84020)](https://www.codacy.com/gh/ProyectoCVDS2022/Proyecto2022/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ProyectoCVDS2022/Proyecto2022&amp;utm_campaign=Badge_Grade)
- **CircleCI Badge:**\
[![CircleCI](https://circleci.com/gh/ProyectoCVDS2022/Proyecto2022/tree/main.svg?style=svg)](https://circleci.com/gh/ProyectoCVDS2022/Proyecto2022/tree/main)
