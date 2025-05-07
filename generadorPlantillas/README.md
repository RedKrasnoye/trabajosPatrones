# Estudiante:
* Milovan Veroisa - Patrones de Diseño (Sección 2)

## Objetivos del proyecto

Editar plantillas clonadas para su mantenciones y luego poder listar todas. Además de permitir la manteción de información a través de un Singleton evitando más copias de la misma. Aplicandolo tal y como se vio en los Patrones de Diseños. Todo esto siguiendo un UML creado.

## Como ejecutar

En cualquier carpeta que usted quiera instalar esto. De esta manera se clona, se entra a la carpeta, para despues compilarlo y ejecutar el programa.
```git
git clone https://github.com/RedKrasnoye/trabajosPatrones.git
cd trabajosPatrones/generadorPlantillas/src

javac App.java
java App.java
```

## Las carpetas y archivos

Las carpetas y archivos incluidos son los siguientes

* trabajosPatrones
    * generadorPlantillas
      * bin
        - App.class
        - configuracionEvento.class
        - credencialPlantilla.class
      * src
        - App.java
        - configuracionEvento.java
        - credencialPlantilla.java
      - README.md
    - README.md

Aunque tiene los archivos class, si se usa `App.java` por consola, no funcionara, y estan separados debido al programa que use que fue `Visual Studio Code`. Funcionara si se hace lo de [arriba](#como-ejecutar).

## Patrón Prototype - Aplicación

El archivo `credencialPlantilla.java` implementa el `Cloneable` lo cual le permite ser clonado, con el siguiente fragmento.
```java
@Override
    public credencialPlantilla clone() throws CloneNotSupportedException {
        credencialPlantilla clonado = (credencialPlantilla) super.clone();
        clonado.nombre = this.nombre;
        clonado.cargo = this.cargo;
        clonado.rut = this.rut;
        return clonado;
    }
```

Además de contener los siguientes atributos. Que le permite tomar y además guardar información.
```java
public List<String> nombresLista = new ArrayList<>();
public List<String> cargosLista = new ArrayList<>();
public List<String> rutLista = new ArrayList<>();
private String nombre;
private String cargo;
private String rut;
```

Lo cual le permite ser clonado de la siguiente manera en `App.java`
```java
credencialPlantilla CEPlan = new credencialPlantilla("Nombre no Asignado", "Cargo no Asignado", "Rut no Asignado");
        credencialPlantilla CEBase = CEPlan.clone();
```

Y ser usado de la siguientes maneras en `App.java`
```java
System.out.println("Ingrese nombre:");
String nombreInp = scanner.nextLine();
CEBase.agregarNombre(nombreInp);
System.out.println("Ingrese cargo:");
String cargoInp = scanner.nextLine();
CEBase.agregarCargo(cargoInp);
System.out.println("Ingrese rut:");
String rutInp = scanner.nextLine();
CEBase.agregarRut(rutInp);
```

```java
System.out.println("Credenciales creadas:");
for (int y=0; y < CEBase.conseguirLargo(); y++) {
    System.out.println("Credencial {"+y+"} {Nombre: "+CEBase.nombresLista.get(y)+" / Cargo: "+CEBase.cargosLista.get(y)+" / Rut: "+CEBase.rutLista.get(y)+"}");
}
if (CEBase.conseguirLargo() == 0) {
    System.out.println("No hay credenciales disponibles");
}
```

## Patrón Singleton - Aplicación

El archivo `configuracionEvento.java` contiene el `Singleton` con los siguientes atributos.
```java
private static configuracionEvento instancia;
public String nombreEvento = "No asignado";
public String horasEvento = "0";
public String idiomaEvento = "Sin idioma";
```

Que se declaro como `Singleton` de la siguiente manera como se ha aprendido.
```java
public static configuracionEvento getInstancia() {
        if (instancia == null) {
            instancia = new configuracionEvento();
        }
        return instancia;
    }
```

En `App.java` se le es llamado de la siguiente manera para poder ser usada de forma correcta en la apliación.
```java
configuracionEvento evento = configuracionEvento.getInstancia();
```
De esta manera me permito usarlo de una forma más fácil cuando se le es llamada en ciertos punto del codigo, evitando repetir un codigo largo.
Se repite en diversos puntos como los siguientes.
```java
System.out.println("Nuevo nombre:");
String nomEvento = scanner.nextLine();
evento.cambiarEvento(nomEvento);
```
_Lo de arriba es utilizado un par de veces cambiando los metodos para cambiar la hora y el idioma pero en escencia es lo mismo._
```java
evento.mostrarInfo();
```

## Menú por consola

Lo siguiente es lo que se puede ver al ejecutar `App.java` en la consola, lo cual permitira elgeguir lo que uno requiera.
```
==== MENÚ ====
1. Agregar nueva credencial
2. Ver credenciales creadas
3. Configurar evento       
4. Ver detalles de evento  
5. Salir
Respuesta menú principal:
█
```

## Diagrama de clases (UML)

Se puede ver aquí la simplesa del programa, debido a que la `App` llama al `Prototype` llamado `credencialPlantilla` y al `Singleton` llamado `configuraciónEvento`.
La `App` llama a los metodos de los demás permitiendole poder modificarlos además de poder clonar el `Prototype` para agregar infromación necesario al clon de este.

![Imagén de el diagrama de clases](https://files.catbox.moe/vkgp0s.jpg)

## Captura del sistema funcionando

Se puede ver acá ua screenshot del programa siendo usado en la aplicación que fue creado, en este caso fue `Visual Studio Code` debido a su fácilidad y comodidad de uso para mi.

![Screenshot de la terminal](https://files.catbox.moe/wcnpc2.PNG)

Si le es más fácil aquí en texto.
```
==== MENÚ ====
1. Agregar nueva credencial
2. Ver credenciales creadas
3. Configurar evento
4. Ver detalles de evento
5. Salir
Respuesta menú principal:
1
Ingrese nombre:
NombreTest1
Ingrese cargo:
CargoTest1
Ingrese rut:
RutTest1
Respuesta menú principal:
2
Credenciales creadas:
Credencial {0} {Nombre: NombreTest1 / Cargo: CargoTest1 / Rut: RutTest1}
Respuesta menú principal:
3
=== Menú evento ===   
1. Cambiar nombre     
2. Cambiar hora       
3. Cambiar idioma     
4. Atras
Respuesta menú evento:
1
Nuevo nombre:
Evento de la Programación
Respuesta menú evento:
2
Nueva hora:
21:40
Respuesta menú evento:
3
Nuevo idioma:
Esperanto
Respuesta menú evento:
4
Hacia atras
Respuesta menú principal:
4
Nombre de evento: Evento de la Programaci¢n
Horas de evento: 21:40
Idioma de evento: Esperanto
Respuesta menú principal:
5
Adios
```
