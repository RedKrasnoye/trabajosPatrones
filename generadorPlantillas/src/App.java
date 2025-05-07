import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Se declaran lo necesario para hacer el codigo funcionar
        Scanner scanner = new Scanner(System.in);
        boolean respuestaFin = false;
        boolean eventoWhile = false;

        credencialPlantilla CEPlan = new credencialPlantilla("Nombre no Asignado", "Cargo no Asignado", "Rut no Asignado");
        credencialPlantilla CEBase = CEPlan.clone();
        configuracionEvento evento = configuracionEvento.getInstancia();
        //Fin de las declaraciones

        //Se imprime el menú
        System.out.println("==== MENÚ ====");
        System.out.println("1. Agregar nueva credencial");
        System.out.println("2. Ver credenciales creadas");
        System.out.println("3. Configurar evento");
        System.out.println("4. Ver detalles de evento");
        System.out.println("5. Salir");
        //Termino del menú

        //Se crea un while para poder elegir opciones sin parar hasta que se eliga el 5
        while (respuestaFin == false) {
            //Se pide la opcion que quiere
            System.out.println("Respuesta menú principal:");
            String respuesta = scanner.nextLine();

            //Un switch case para poder elegir bien
            switch (respuesta) {
                case "1":
                    //Se empieza el hecho de que se debe elegir toda la info a insertar
                    System.out.println("Ingrese nombre:");
                    String nombreInp = scanner.nextLine();
                    CEBase.agregarNombre(nombreInp);
                    System.out.println("Ingrese cargo:");
                    String cargoInp = scanner.nextLine();
                    CEBase.agregarCargo(cargoInp);
                    System.out.println("Ingrese rut:");
                    String rutInp = scanner.nextLine();
                    CEBase.agregarRut(rutInp);
                    break;

                case "2":
                    //Se hace un for para poder repetir e imprimir toda la info que se tiene disponible
                    System.out.println("Credenciales creadas:");
                    for (int y=0; y < CEBase.conseguirLargo(); y++) {
                        System.out.println("Credencial {"+y+"} {Nombre: "+CEBase.nombresLista.get(y)+" / Cargo: "+CEBase.cargosLista.get(y)+" / Rut: "+CEBase.rutLista.get(y)+"}");
                    }
                    if (CEBase.conseguirLargo() == 0) {
                        System.out.println("No hay credenciales disponibles");
                    }
                    break;

                case "3":  
                    //Otro menu para cambiar singularmente datos del singleton
                    eventoWhile = true;
                    System.out.println("=== Menú evento ===");
                    System.out.println("1. Cambiar nombre");
                    System.out.println("2. Cambiar hora");
                    System.out.println("3. Cambiar idioma");
                    System.out.println("4. Atras");

                    //Un while para poder elegir vrias opciones sin que se salga
                    while (eventoWhile == true) {
                        //Se pide elegir una de las opciones
                        System.out.println("Respuesta menú evento:");
                        String respuestaEvento = scanner.nextLine();

                        switch (respuestaEvento) {
                            case "1":
                                //Un nuevo nombre para el evento
                                System.out.println("Nuevo nombre:");
                                String nomEvento = scanner.nextLine();
                                evento.cambiarEvento(nomEvento);
                                break;

                            case "2":
                                //Una nueva hora para ele vento
                                System.out.println("Nueva hora:");
                                String nomHora = scanner.nextLine();
                                evento.cambiarHora(nomHora);
                                break;

                            case "3":
                                //Un nuevo idioma para el evento
                                System.out.println("Nuevo idioma:");
                                String nomIdioma = scanner.nextLine();
                                evento.cambiarIdioma(nomIdioma);
                                break;

                            case "4":
                                //se devuelve al sacar poner el boolean como falso
                                System.out.println("Hacia atras");
                                eventoWhile = false;
                                break;

                            default:
                                //por si se elige una opcion no existente
                                System.out.println("Eso no funciona.");
                                break;
                        }
                    }
                    break;

                case "4":
                    //Se muestra info del evento llamando una funcion en el singleton
                    evento.mostrarInfo();
                    break;

                case "5":
                    //Have que el programa termine
                    System.out.println("Adios");
                    respuestaFin = true;
                    break;

                default:
                    //Evitar errores al no elegir una opcion disponible
                    System.out.println("Eso no funciona.");
                    break;
            }
        }
        //Para evitar que diga que tiene un error al no cerrar el scaner
        scanner.close();
    }
}
