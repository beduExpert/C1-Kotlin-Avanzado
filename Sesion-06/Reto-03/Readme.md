## Notificaciones y FCM

### OBJETIVO 

- Enriquecer lo visto en el [Ejemplo 3](../Ejemplo-03)

#### REQUISITOS 

1. Haber cursado el ejemplo 3

#### DESARROLLO

Utilizaremos como base el proyecto del [Ejemplo 3](../Ejemplo-03).

- Correr la aplicación, mantenerla en primer plano y enviar otro mensaje de prueba por medio de la consola ¿Qué sucedió? No se recibe ningún mensaje porque se necesita habilitar un servicio que gestione la notificación en primer plano (la clase vacía que creamos en el [Ejemplo 3](../Ejemplo-03) y que la declaramos como servicio en el Manifiesto).


En nuestra clase *FirebaseMessaging*, haremos un *override* del método onMessageReceived para gestionar el mensaaje arrivante

```kotlin
override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification != null) {
            sendNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)
        }
    }
```


**Ejercicio 1:** En el *MainActivity*, declarar el canal de notificación a utilizar, como vimos en ejercicios anteriores.

<details>
	<summary>Solucion</summary>	
	
```kotlin
companion object{
        const val CHANNEL_ID = "CANAL_GENERICO"
    }

...

override fun onCreate(savedInstanceState: Bundle?) {
...
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setNotificationChannel()
        }
...
}

...
private fun setNotificationChannel(){
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Canal Generico",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "CANAL GENERICO"
        }

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(channel)
    }
```
</details>



**Ejercicio 2:** Declarar la función *sendNotification* en *FirebaseMessaging*, de forma que se cree una notificación simple con los parámetros *title* y *body*.

<details>
	<summary>Solucion</summary>	
	
```kotlin
private fun sendNotification(title: String?, body: String?){
        Log.d("FCM_MESSAGE", "Cuerpo de la notificación: $body")

        val notificationBuilder = NotificationCompat.Builder(this,MainActivity.CHANNEL_ID)
            .setSmallIcon(R.drawable.bedu_icon)
            .setContentTitle(title)
            .setContentText(body)


        //lanzamos la notificación
        with(NotificationManagerCompat.from(this)) {
            notify(0, notificationBuilder.build()) //en este caso pusimos un id genérico
        }
    }
```
</details>

