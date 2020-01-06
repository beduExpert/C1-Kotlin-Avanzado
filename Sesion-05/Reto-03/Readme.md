## Reto 03

### OBJETIVO 

- Un sencillo ejercicio para desactivar la configuración automática de Crashlytics

#### REQUISITOS 

1. Haber terminado los ejercicios anteriores

#### DESARROLLO

- Para no admitir la configuración automática, poner las siguientes líneas de código en el *AndroidManifest.xml*

```xml
<meta-data
    android:name="firebase_crashlytics_collection_enabled"
    android:value="false" />
```

- Probar con cualquier ejercicio de la sesiónpara comprobar que deja de funcionar el servicio de Crashlytics.


- En este modo, nosotros somos responsables de activar el servicio en cada Activity, por medio de este método:

```kotlin
Fabric.with(this, Crashlytics())
```

