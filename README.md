# Proyecto Ciclillos | CVDS | 2022-1
## Integrantes
  - Santiago Andrés Bayona Cardenas 
  - Juan Carlos Acosta López
  - Julian Esteban Torres Díaz
  - Jaime Nicolás Castro Acuña
  - David Alejandro Leon
## Descripcion del producto
  - **Descripción general:**
  - **Manual de usuario:**
  - En nuestro aplicativo contamos actualmente con dos tipos de usuarios: Administrador, y Comunidad. Como se muestra en la siguiente pantalla:

![image](https://user-images.githubusercontent.com/25957863/168929734-ab34471a-8cf4-44be-9b5f-7f1e78627e03.png)

  - Inicaremos explicando cada una de las funcionalidades que se tienen en el rol de Comunidad. Para esto damos click sobre el primer recuadro como veremos a continuación:

![image](https://user-images.githubusercontent.com/25957863/168930683-9f70deda-d7af-476c-8033-d9d0fae208f4.png)

- Luego de dar click se nos desplegará la siguiente pantalla:

![image](https://user-images.githubusercontent.com/25957863/168930793-d2fe20ab-7e62-4fd5-997d-e3f159396d6c.png)

- Allí haremos login con las siguientes credenciales:

![image](https://user-images.githubusercontent.com/25957863/168931190-5c4c4341-cf23-4e00-85d5-1179223af694.png)

- Esta vista cuenta con varias funcionalidades que detallaremos aquí:

- **Cerrar Sesión:** Nos dirigirá a nuestra pantalla principal de elección de usuario (Administrador, Comunidad).

![image](https://user-images.githubusercontent.com/25957863/168936807-57fc7a49-c7a4-4f3e-b70e-6a01157aa065.png)

- **Reservar:** En este apartado prodemos hacer la búsqueda y posterior reserva de un recurso disponible.

![image](https://user-images.githubusercontent.com/25957863/168936919-fa442891-566a-4a47-8a6b-321869a4ab6c.png)


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



  - **Imágenes y descripción de las funcionalidades más importantes:**
## Arquitectura y Diseño detallado
  - **Modelo E-R:**
\
            ![image](https://user-images.githubusercontent.com/98216838/168507698-701ce664-f965-4a23-8689-383a172ff774.png)
 - **Diagrama de clases:**
    - ![image](https://user-images.githubusercontent.com/98216838/168897746-a1a01c44-f122-492d-ad97-246a27f29dfa.png)

 - **Descripción de la arquitectura y del Stack:**
 - **Aplicaion en heroku**
    - https://dashboard.heroku.com/apps/proyectociclos2022
 - **Despliegue continuo**
    - https://proyectociclos2022.herokuapp.com/
## Descripción del proceso
 - **Metodologia:**
 - **Taiga:**
    - https://tree.taiga.io/project/estebananot-gestion-de-recursos-biblioteca/timeline
 - **release-burndown chart**
 - **Sprint 1:**
   - Sprint-backlog
            ![image](https://user-images.githubusercontent.com/98216838/168508554-f477b635-c22e-42e5-85c4-bf765a373401.png)
   - Sprint-burndown chart
            ![image](https://user-images.githubusercontent.com/98216838/168881077-e07087df-d58d-4b8e-b5af-3460a5f4fa2c.png)

 - **Sprint 2:**
    -Sprint-backlog
            ![image](https://user-images.githubusercontent.com/98216838/168880785-e1f58247-6f04-431a-9c41-2fee2020236c.png)
            
    - Sprint-burndown chart
            ![image](https://user-images.githubusercontent.com/98216838/168881016-d45f21a4-4fc2-4d1c-9b73-3f76fe46ee50.png)

 - **Sprint 3:**
    - Sprint-backlog
    - Sprint-burndown chart
 ## Reporte de pruebas
 -  **Codacy Badge:**\
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/0677f1d86193467e9d40545af3c84020)](https://www.codacy.com/gh/ProyectoCVDS2022/Proyecto2022/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ProyectoCVDS2022/Proyecto2022&amp;utm_campaign=Badge_Grade)
 - **CircleCI Badge:**\
[![CircleCI](https://circleci.com/gh/ProyectoCVDS2022/Proyecto2022/tree/main.svg?style=svg)](https://circleci.com/gh/ProyectoCVDS2022/Proyecto2022/tree/main)
