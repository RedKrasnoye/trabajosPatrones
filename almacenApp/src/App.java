import java.text.MessageFormat;
import java.util.Enumeration;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        almacenGlobal almacen = almacenGlobal.getInstancia();
        itemDulce stockDulce = new itemDulce("Golpe", "Arcor", 350, 120);
        itemDulce stockCopia = (itemDulce)stockDulce.clone();
        System.out.println(MessageFormat.format("Dulce: [{0}] ha sido registrado", stockCopia.getNombre()));
        String dulce = "{Nombre: "+stockCopia.getNombre()+" / Marca: "+stockCopia.getMarca()+" / Precio: "+stockCopia.getPrecio()+" / Calorias: "+stockCopia.getCalorias()+"}";
        almacen.agregarLista(stockCopia.getNombre(), dulce);
        stockCopia.setNombre("Golazo");
        almacen.agregarLista(stockCopia.getNombre(), dulce);
        Enumeration<String> listarItems = almacen.items.keys();
        while (listarItems.hasMoreElements()) {
            String llave = listarItems.nextElement();
            String valor = almacen.items.get(llave);
            System.out.println("Llave: "+llave+", valor: "+valor);
        }
        System.out.println("===========");
        String testRemove = "Golpe";
        almacen.items.remove(testRemove);
        Enumeration<String> listarItems2 = almacen.items.keys();
        while (listarItems2.hasMoreElements()) {
            String llave = listarItems2.nextElement();
            String valor = almacen.items.get(llave);
            System.out.println("Llave: "+llave+", valor: "+valor);
        }

    }
}
