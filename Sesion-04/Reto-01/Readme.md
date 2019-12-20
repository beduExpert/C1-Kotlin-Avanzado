## SharedPreferences

### OBJETIVO 

- Aplicar SharedPreferences a través de un ejemplo

#### REQUISITOS 

1. Haber tomado el primer tema de la sesión 1
2. Haber cursado el [Ejemplo 01](../Ejemplo-01)

#### DESARROLLO

- Vamos a hacer un ejemplo de login con SharedPreferences, tomaremos un booleano como bandera para saber si se está loggeado o no. ***Nota: desaconsejamos utilizar una bandera para identificar que un usuario ha iniciado sesión, existen mecanismos más seguros y sofisticados*

1. Seteamos este login en el layout del MainActivity

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    android:background="@color/colorPrimaryDark"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginTop="24dp"
        android:src="@drawable/bedu"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="36dp"
        android:ems="10"
        android:inputType="textEmailAddress"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="36dp"
        android:ems="10"
        android:inputType="textPassword"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />

    <Button
        android:id="@+id/btnLogin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="Login"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText2" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

2. Guardamos el archivo adjunto ***bedu.png*** en la carpeta drawable, dentro de res. 


3.- Para cambiar de pantalla sin poder regresar a la anterior con el botón back, aquí está el siguiente código.

```kotlin
val i = Intent(this, LoggedActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
```
