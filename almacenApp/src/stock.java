public class stock {
    private itemPrototype itemCompra;

    public stock(itemPrototype itemCompra) {
        this.itemCompra = itemCompra;
    }

    public itemPrototype crearItem() {
        return itemCompra.clone();
    }
}
