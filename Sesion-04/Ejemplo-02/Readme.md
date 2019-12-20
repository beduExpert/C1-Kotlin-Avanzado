## Aplicación básica de Realm 

### OBJETIVO

- Que el alumno aprenda a instalar, configurar y utilizar Realm como motor de base de datos

#### REQUISITOS

1. Tener conocimiento básico de SQL
2. Haber Cursado la clase de Realm de la Sesión 04

#### DESARROLLO

1. Instalar Realm en nuestro proyecto la dependencia

esto se agrega en *build.gradle* dentro de la carpeta raíz
```kotlin
buildscript {
    ...      
    }
    dependencies {
        ...
        classpath "io.realm:realm-gradle-plugin:6.0.2"
    }
}

```

También hay que aplicar el plugin dentro de *app/build.gradle*, en la cabeza del archivo

```kotlin
apply plugin: 'kotlin-android-extensions'

apply plugin: 'kotlin-kapt'

apply plugin: 'realm-android'  // Este es el plugin a aplicar, el anterior sólo está por referencia
```

Sincronizar el proyecto 

**NOTA:** es importante que realm android baja después de 'kotlin-android-extensions' y 'kotlin-kapt' (agregar este último si no está agregado), ya que aunque no esté documentado en el sitio web oficial, hay versiones de kotlin que tienen problemas con su aplicación

2. Crear una carpeta **assets** dentro de la carpeta main, y guardar el recurso *data.json* en él

3. Crear el objeto Contact, que es el Modelo de datos donde se mapearán los datos.

```kotlin
package org.bedu.realmexample

import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

//Se escribe open para poder heredar
open public class Contact: RealmObject() {
        //con la anotación @PrimaryKey se indica que este es la llave primaria
    @PrimaryKey
    var id: Int? = null

    var name: String? = null

    var job: String? = null

    var company: String? = null

    var city: String? = null

}
```

4. Crear extensión de *Application*, e inicializar datos de realm ahí, lo nombraremos *MainApp*

```kotlin
class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()
        
        //Aquí pondremos nuesto código para inicializar Realm
    }

```

en el *androidManifest.mxl* debemos declarar nuestra extensión de la Application

```xml
<application
        android:name=".MainApp"
             ...
```

5. Dentro del *MainApp*, seteamos el siguiente método para obtener el json en formato String:
```kotlin
fun getJsonFile(): String{

        return applicationContext
            .assets
            .open("data.json").bufferedReader().use {it.readText()}
    }
```

6. Con esto, ya podemos obtener nuestros datos y setearlos como datos de inicio en la base de datos, el siguiente código describe la descripción de la configuración, importante leer los comentarios.

```kotlin
//inicializamos Realm
        Realm.init(this)

        //guardar nuestro json en un JSON array
        val array = JSONArray(getJsonFile())

        //configuraciónn de nuestra base de datos
        val config = RealmConfiguration
            .Builder()
                //Aquí inicializamos los datos iterando cada objeto JSON
            .initialData { realm ->
                for ( i in 0 until array.length() ) {
                    //Seteando nuestros valores en Realm
                    val c = realm.createObject(Contact::class.java, i)
                    c.name = array.getJSONObject(i).getString("name")
                    c.job = array.getJSONObject(i).getString("title")
                    c.city = array.getJSONObject(i).getString("city")
                    c.company = array.getJSONObject(i).getString("company")
                }
            }
            .deleteRealmIfMigrationNeeded()
            .name("realmDB.realm") //seteando el nombre de la DB
            .build() 

        //Seteamos los datos de configuración en nuestra clase 
        Realm.setDefaultConfiguration(config) 
```
7. En el *onCreate()* del *MainActivity*, obtenemos los datos de la DB:

```kotlin
val realm = Realm.getDefaultInstance()
contacts = realm.where(Contact::class.java).findAll()

Log.d("Respuesta","$contacts")
```

¡Observa que se impriman los valores del JSON!






