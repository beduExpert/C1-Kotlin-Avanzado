## Realm avanzado

### OBJETIVO 

- Aprender más operaciones en la recuperación de datos de un Realm

#### REQUISITOS 

1. Haber finalizado el [Ejemplo 3](../Ejemplo-03)

#### DESARROLLO

Tomaremos como base el [Ejemplo 2](../Ejemplo-02) nuevamente y para consultar las modificaciones, lo haaremos desde [ESTA PÁGINA](https://realm.io/docs/java/latest/#queries)

Recuerden previamente desinstalar la app ***RealmExample*** para restablecer nuestra información 

Vamos a ver los siguientes casos:  

- Mostrar sólo id's mayores a 4


<details>
	<summary>Solucion</summary>
	
```kotlin
contacts = realm
            .where(Contact::class.java)
            .greaterThan("id",4)
            .findAll()
```
	
</details> 

- Que no terminen con n

<details>
	<summary>Solucion</summary>
	
```kotlin
contacts = realm
            .where(Contact::class.java)
            .not()
            .endsWith("name","n")
            .findAll()

```
	
</details> 

- Que sean de Xinquiao o 
- Que su nombre comience con K y contenga alguna e donde sea

<details>
	<summary>Solucion</summary>
	
```kotlin
contacts = realm
            .where(Contact::class.java)
            .beginGroup()
                .beginsWith("name","K")
                .and()
                .contains("name","e")
                .or()
                .equalTo("city","Xinqiao")
            .endGroup()
            .findAll()

```

</details> 

- Mostrar sólo 4 resultados

<details>
	<summary>Solucion</summary>
	
```kotlin
contacts = realm
            .where(Contact::class.java)
            .limit(4)
            .findAll()
```

</details> 

- Ordenar lista por orden alfabético INVERTIDO (el nombre)

<details>
	<summary>Solucion</summary>
	
```kotlin
contacts = realm
            .where(Contact::class.java)
            .sort("name",Sort.DESCENDING)
            .findAll()
```

</details> 


