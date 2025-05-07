## Estudiante:
* Milovan Veroisa - Patrones de Diseño (Sección 2)

### Objetivos del proyecto

Editar plantillas clonadas para su mantenciones y luego poder listar todas. Además de permitir la manteción de información a través de un Singleton evitando más copias de la misma. Aplicandolo tal y como se vio en los Patrones de Diseños. Todo esto siguiendo un UML creado.

### Como ejecutar

En cualquier carpeta que usted quiera instalar esto. De esta manera se clona, se entra a la carpeta, para despues compilarlo y ejecutar el programa.
```git
git clone https://github.com/RedKrasnoye/trabajosPatrones.git
cd trabajosPatrones/generadorPlantillas/src

javac App.java
java App.java
```

### Patrón Prototype - Aplicación
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

### Patrón Singleton - Aplicación

El archivo `configuracionEvento.java` contiene el singletob
