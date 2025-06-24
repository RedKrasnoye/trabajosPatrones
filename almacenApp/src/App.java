import java.text.MessageFormat;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        almacenGlobal almacen = almacenGlobal.getInstancia();

        System.out.println("== Menu ==");
        System.out.println("1. Añadir item");
        System.out.println("2. Ver items");

        //Prototype
        itemDulce stockDulce = new itemDulce("Golpe", "Arcor", 350, 120);
        itemDulce stockCopia = (itemDulce)stockDulce.clone();
        System.out.println(MessageFormat.format("Dulce: [{0}] ha sido registrado", stockCopia.getNombre()));
        String dulce = "{Nombre: "+stockCopia.getNombre()+" / Marca: "+stockCopia.getMarca()+" / Precio: "+stockCopia.getPrecio()+" / Calorias: "+stockCopia.getCalorias()+"}";
        almacen.agregarLista(dulce);

    }
}
