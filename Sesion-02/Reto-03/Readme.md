 ## Agregando Items al RecyclerView

### OBJETIVO 

- Que el programador aprenda a actualizar el RecyclerView cuando se le agregue un nuevo elemento

#### REQUISITOS 

1. Haber terminado el [Ejemplo 03](../Ejemplo-03)

#### DESARROLLO
Continuando con el proyecto del ejemplo 3, vamos a crear la interfaz para agregar nuevos usuarios, hay que contemplar que por ahorro de tiempo no pondremos ningún filtro en el nombre, ni en el teléfono de cada contacto agregado.

Utilizaremos el botón redondo llamado FAB (Floating Action Button) para ir a la pantalla de agregar contacto nuevo.

No olvidar utilizar *startActivityForResult* para obtener el resultado del contacto de regreso a la pantalla principal.

```kotlin 
 val intent = Intent(this,AddContactActivity::class.java)
 startActivityForResult(intent,1)
```
<img src="01.png" width="30%">

Hay que implementar en la Actividad detonante la función *onActivityResult*, para recibir la info una vez haya sido envidada. 

```kotlin
 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

               //ToDo: aquí va el código para actualizar el RecyclerView


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
```

y en la cclase AddContactActivity():

```kotlin

```

El diseño de esa página lo dejararemos a criterio propio.
