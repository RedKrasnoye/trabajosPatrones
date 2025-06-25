import java.text.MessageFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        almacenGlobal almacen = almacenGlobal.getInstancia();
        while (loop==true) {
            clearScreen();
            System.out.println("== Menu ==");
            System.out.println("1. Añadir dulce");
            System.out.println("2. Ver items");
            System.out.println("3. Eliminar item");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.print("Nombe del producto: ");
                    String nombreItem = scanner.nextLine();
                    System.out.print("Marca del producto: ");
                    String marcaItem = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    int precioProducto = scanner.nextInt();
                    System.out.print("Calorias del producto: ");
                    int caloriasProducto = scanner.nextInt();
                    itemDulce stockDulce = new itemDulce(nombreItem, marcaItem, precioProducto, caloriasProducto);
                    itemDulce stockCopia = (itemDulce)stockDulce.clone();
                    System.out.println(MessageFormat.format("Dulce [{0}] ha sido registrado", stockCopia.getNombre()));
                    String dulce = "{Nombre: "+stockCopia.getNombre()+" / Marca: "+stockCopia.getMarca()+" / Precio: "+stockCopia.getPrecio()+" / Calorias: "+stockCopia.getCalorias()+"}";
                    almacen.agregarLista(stockCopia.getNombre(), dulce);
                    System.out.println("Presione (<┘) para continuar");
                    System.in.read();
                    break;
                case "2":
                    almacen.verStock();
                    System.out.println("Presione (<┘) para continuar");
                    System.in.read();
                    break;
                case "3":
                    System.out.println("¿Que item quiere eliminar? Utilize el codigo");
                    String eliminarStock = scanner.nextLine();
                    almacen.eliminarStock(eliminarStock);
                    System.out.println("Presione (<┘) para continuar");
                    System.in.read();
                    break;
                default:
                    System.out.println("Ninguna opción elegida.");
                    break;
                }
        }
        scanner.close();
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
