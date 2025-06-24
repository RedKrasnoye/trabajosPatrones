public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Test");
        itemPrototype itemTest = new item("Golpe", "Arcor", 350);
        stock itemStock = new stock(itemTest);
        itemPrototype newItem =  itemStock.crearItem();

        newItem.verCompra();
    }
}
