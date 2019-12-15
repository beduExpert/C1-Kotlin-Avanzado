## Reproducción de audio

### OBJETIVO 

- Expandir el conocimiento de la clase MediaPlayer
- Implementar el View SeekBar

#### REQUISITOS 

1. Haber finalizado el [Ejemplo 03](/../../tree/master/Sesion-04/Ejemplo-03) de esta sesión.
2. 

#### DESARROLLO

Tomando el código del [ejemplo 03](/../../tree/master/Sesion-04/Ejemplo-03), se agregará una barra de progreso (SeekBar) capaz de mostrar el progreso de reproducción del audio y poder cambiar el segundo de reproducción.

1.- Implementar el View ***SeekBar*** en el layout de la actividad principal.

*Opcional*: agregarle el siguiente atributo (para darle mejor estética a este) 
>style="@style/Widget.AppCompat.SeekBar.Discrete"

2.- 



##### Apéndice 

| Método | Descripción  | return type  |
| :-----:| :----------: | :----------: |
| isLooping() | informa si el MediaPlayer está en loop o no | boolean |
| seekTo(int msec) | regresa el MediaPlayer al tiempo especificado | void | 
| pause() | pausa la reproducción | void |
| getCurrentPosition() | Obtiene la posición en tiempo actual de la reproducción | int | 
|isPlaying() | informa si el MediaPlayer se está reproduciendo | boolean |
| getDuration | obtiene la duración del archivo en milisegundos, (-1 si no se pudo obtener) | int |
