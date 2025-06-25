import java.util.HashMap;

public class almacenGlobal {
    private static almacenGlobal instancia;
    private HashMap<String, String> items = new HashMap<>();

    public static almacenGlobal getInstancia() {
        if (instancia == null) {
            instancia = new almacenGlobal();
        }
        return instancia;
    }

    public void agregarLista (String llave, String stock) {
        items.put(llave, stock);
    }

    public void verStock(){
        for(String i: items.keySet()) {
            System.out.println("Codigo: "+i+" / "+items.get(i));
        }
    }

    public HashMap<String, String> getStock(){
        return items;
    }

    public void eliminarStock(String stock) {
        System.out.println("Se elimino: ["+stock+"]");
        items.remove(stock);
    }
}
