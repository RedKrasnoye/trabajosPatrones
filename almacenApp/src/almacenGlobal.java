import java.util.ArrayList;
import java.util.List;

public class almacenGlobal {
    private static almacenGlobal instancia;
    public List<String> items = new ArrayList<>();
    
    private almacenGlobal() {}

    public static almacenGlobal getInstancia() {
        if (instancia == null) {
            instancia = new almacenGlobal();
        }
        return instancia;
    }

    public void agregarLista (String stock) {
        items.add(stock);
    }

    public List<String> getItems() {
        return items;
    }
}
