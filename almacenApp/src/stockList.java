import java.util.List;

public class stockList {
    private List<String> stockLista;

    public stockList(List<String> stockLista) {
        this.stockLista = almacenGlobal.getInstancia().getItems();
    }

    public List<String> getStockLista() {
        return stockLista;
    }

    public void setStockLista(List<String> stockLista) {
        this.stockLista = stockLista;
    }

    
    
}
