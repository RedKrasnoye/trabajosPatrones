import java.util.Dictionary;
import java.util.Hashtable;

public class almacenGlobal {
    private static almacenGlobal instancia;
    public Dictionary<String, String> items = new Hashtable<>();
    
    private almacenGlobal() {}

    public static almacenGlobal getInstancia() {
        if (instancia == null) {
            instancia = new almacenGlobal();
        }
        return instancia;
    }

    public void agregarLista (String nombre, String stock) {
        items.put(nombre, stock);
    }
}
