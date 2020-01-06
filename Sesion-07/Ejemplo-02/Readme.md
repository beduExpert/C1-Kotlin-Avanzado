## Inyección de dependencias

### OBJETIVO

- Que el usuario comprenda a través de este ejemplo el concepto de DI y sus implicaciones

#### REQUISITOS

1. Leer el enlace al tema homónimo y de Dagger en el Prework

#### DESARROLLO


1. Instalamos Dagger 2

```kotlin
 implementation 'com.google.dagger:dagger:2.25.2'
    api 'com.google.dagger:dagger-android-support:2.25.2'
    kapt 'com.google.dagger:dagger-compiler:2.25.2'
```

2. Ponemos en el layout un textView con id *textView* y un ImageView con id *chest*, agregamos la imagen ***chest.png*** que está en este proyecto
