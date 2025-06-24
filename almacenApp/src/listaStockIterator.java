import java.util.ArrayList;
import java.util.List;

public class listaStockIterator implements listarIterator {
    private listaAgregarStock iteratorStock;
    private List<stockList> stockLista = new ArrayList<>();
    private int posiscion = 0;

    public listaStockIterator(listaAgregarStock iteratorStock, List<stockList> stockLista, int posiscion) {
        this.iteratorStock = iteratorStock;
        this.stockLista = stockLista;
        this.posiscion = posiscion;
    }

    public listaStockIterator(listaAgregarStock listaAgregarStock, String listaStock) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean hasNext() {
        return posiscion < stockLista.size();
    }

    @Override
    public stockList getNext() {
        if (!hasNext()) {
            return null;
        }

        stockList stockIt =  stockLista.get(posiscion);
        if (stockIt == null) {
            stockIt = iteratorStock.conseguirStockItem(stockIt);
            stockLista.set(posiscion, stockIt);
        }
        posiscion++;
        return stockIt;
    }

    @Override
    public void reset() {
        posiscion = 0;
    }

    
}
