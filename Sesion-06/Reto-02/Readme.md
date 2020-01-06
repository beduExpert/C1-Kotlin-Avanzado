## Notificaciones Avanzadas

### OBJETIVO 

- Poner a prueba y enriquecer el conocimiento adquirido en el [Ejemplo 2](../Ejemplo-02)

#### REQUISITOS 

1. Haber finalizado el [Ejemplo 2](../Ejemplo-02)

#### DESARROLLO

Utilizaremos como base el proyecto del [Ejemplo 2](../Ejemplo-02)

1. Modificar el método ***touchNotification*** de tal forma que cada que se ejecute, la notificcación tenga un id diferente al anterior y se puedan acumular varias de ellas. ¿Qué sucede cuando son muchas? Comentar con el grupo

2. Modificar el método ***cancelNotifications*** para que elimine únicamente las notificaciones expansibles, probar código.

<details>
	<summary>Solucion</summary>
	
Reemplazar el método ***cancelAll()*** por:
```kotlin
cancel(<id_de_la_notificación>)
```

3. Cambiar la prioridad de la notificación expandable por PRIORITY_MAX y luego por PRIORITY_LOW ¿Qué diferencias notas? Experimentar con los otros niveles.
