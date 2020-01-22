## POSTWORK

### OBJETIVO

- Implementar una transición vista en el ejemplo 3 para la tienda

#### REQUISITOS

1. Haber terminado el [Ejemplo 3](../Ejemplo-03) y el [Reto 3](../Reto-03)

2. Es recomendable haber finalizado el  [Postwork](../../Sesion-02/Postwork) de la [Sesión 2](../../Sesion-02), para implementar la pantalla de lista de productos y detalles del producto.

#### DESARROLLO

Saltarse esta línea si se resolvió previamente el [Postwork 2](../../Sesion-02/Postwork), si no, crear una actividad sencilla consistente en una imagen y un botón "ir a detalles" que comunique a la actividad de Detalles y en dicha Actividad, insertar una imagen como cabecera de la pantalla. En el Postwork 2 el comportamiento descrito abajo será implementado en la lista de productos y en su respectivo detalle.

Desarrollar cualquiera o las dos tareas listadas a continuación, Al dar click en algún producto de la lista:

* Deberemos crear una transición similar a esta con la imagen del producto:

<img src="../Ejemplo-03/Images/expandable-view.gif" width="30%">

* Animar la entrada y salida de nuevos elementos con este tipo de instrucción (tomar ejemplo del [Reto 3](../Reto-03) ):

```kotlin
window.enterTransition = Slide() 
```



