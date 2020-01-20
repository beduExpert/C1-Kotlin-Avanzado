
## Postwork

### OBJETIVO

- Guardar en persistencia datos recurrentes en la app

#### REQUISITOS

1. Haber cursado toso los ejemplos y retos de esta sesión

#### DESARROLLO

En el desarrollo de apps, usualmente guardamos datos para luego desplegarlos o utilizarlos para una transacción.

1. En nuestro caso, guardaremos el dato obtenido en el login por medio de SharedPreferences (visto en el [Ejemplo 1](../Ejemplo-01) ). Si ocuparon ReqRes, guardar los datos obtenidos del login, y con un botón de cerrar sesión, borrarlos y eliminar también todo lo relacionado con persistencia (datos descritos abajo). Al abrir la app, guardados, la app debe abrir el menú principal si existen datos almacenados y si no, abrir la *Activity* de login. Guardar también la información de perfil en SharedPreferences.

2. Utilizaremos la librería Realm para que la lista de productos creados en el postwork de las [Sesión 2](../../Sesion-02/Postwork) vivan en una base de datos.

3. Crear el carrito de compras, guardando en Realm todo elemento guardado ahí.

