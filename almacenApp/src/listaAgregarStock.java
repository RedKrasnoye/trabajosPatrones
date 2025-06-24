import java.util.ArrayList;
import java.util.List;

public class listaAgregarStock implements agregarIterator {
    private List<stockList> itemsIterator;

    public listaAgregarStock(List<stockList> cache) {
        if (cache != null) {
            this.itemsIterator = cache;
        } else {
            this.itemsIterator = new ArrayList<>();
        }
    }

    public stockList conseguirStockItem(stockList stockItem) {
        System.out.println("Stock: "+stockItem);
        return encontrarStock(stockItem);
    }

    private stockList encontrarStock(stockList itemStock) {
        for (stockList stockList : itemsIterator) {
            if (stockList.getStockLista().equals(itemStock)) {
                return stockList;
            }
        }
        return null;
    }

    @Override
    public listarIterator crearStockIterator(String listaStock) {
        return new listaStockIterator(this, listaStock);
    }
}
