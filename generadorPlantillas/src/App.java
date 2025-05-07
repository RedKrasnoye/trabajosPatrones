import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean respuestaFin = false;
        boolean eventoWhile = false;

        credencialPlantilla CEPlan = new credencialPlantilla("Nombre no Asignado", "Cargo no Asignado", "Rut no Asignado");
        credencialPlantilla CEBase = CEPlan.clone();
        configuracionEvento evento = configuracionEvento.getInstancia();

        System.out.println("==== MENÚ ====");
        System.out.println("1. Agregar nueva credencial");
        System.out.println("2. Ver credenciales creadas");
        System.out.println("3. Configurar evento");
        System.out.println("4. Ver detalles de evento");
        System.out.println("5. Salir");
        while (respuestaFin == false) {
            System.out.println("Respuesta menú principal:");
            String respuesta = scanner.nextLine();
            switch (respuesta) {
                case "1":
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
                    System.out.println("Credenciales creadas:");
                    for (int y=0; y < CEBase.conseguirLargo(); y++) {
                        System.out.println("Credencial {"+y+"} {Nombre: "+CEBase.nombresLista.get(y)+" / Cargo: "+CEBase.cargosLista.get(y)+" / Rut: "+CEBase.rutLista.get(y)+"}");
                    }
                    if (CEBase.conseguirLargo() == 0) {
                        System.out.println("No hay credenciales disponibles");
                    }
                    break;
                case "3":  
                    eventoWhile = true;
                    System.out.println("=== Menú evento ===");
                    System.out.println("1. Cambiar nombre");
                    System.out.println("2. Cambiar hora");
                    System.out.println("3. Cambiar idioma");
                    System.out.println("4. Atras");
                    while (eventoWhile == true) {
                        System.out.println("Respuesta menú evento:");
                        String respuestaEvento = scanner.nextLine();
                        switch (respuestaEvento) {
                            case "1":
                                System.out.println("Nuevo nombre:");
                                String nomEvento = scanner.nextLine();
                                evento.cambiarEvento(nomEvento);
                                break;
                            case "2":
                                System.out.println("Nueva hora:");
                                String nomHora = scanner.nextLine();
                                evento.cambiarHora(nomHora);
                                break;
                            case "3":
                                System.out.println("Nuevo idioma:");
                                String nomIdioma = scanner.nextLine();
                                evento.cambiarIdioma(nomIdioma);
                                break;
                            case "4":
                                System.out.println("Hacia atras");
                                eventoWhile = false;
                                break;
                            default:
                                System.out.println("Eso no funciona.");
                                break;
                        }
                    }
                    break;
                case "4":
                    evento.mostrarInfo();
                    break;
                case "5":
                    System.out.println("Adios");
                    respuestaFin = true;
                    break;
                default:
                    System.out.println("Eso no funciona.");
                    break;
            }
        }
        scanner.close();
    }
}
