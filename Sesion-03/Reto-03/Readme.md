 ## Retrofit - Pte 2

### OBJETIVO 

- Implementar HttpLogging 
- Notificar al usuario si algo salió mal

#### REQUISITOS 

1. Haber terminado TODOS los ejercicios anteriores.

#### DESARROLLO

Para terminar con nuestro pokedex, debemos ser capaces de notificar al usuario cuando un pokemon no existe, y de rastrear detalles del tráfico.
 
 1. Instalar la siguiente dependencia
 
 ```kotlin
 implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'
 ```
 
 2.- Vamos a agregar el cliente okHttp a nuestro build de retrofit, para eso hay que definir antes el cliente por medio de esta líneas de código:
 
 ```kotlin
 val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(TIMEOUT_CALL_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_CALL_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_CALL_SECONDS, TimeUnit.SECONDS)
                .build()
 ```
 
 El reto es donde suscribir al cliente para que tome efecto (**Hint:** es algo que ya se vio).
 
 3.- Agregar un mensaje (puede ser un Toast) que le notifique al usuario cuando el pokemon que ingresó es inexistente o hay un problema de comunicación. (**Hint:** es en los callbacks de retrofit).
 

