public class itemDulce extends itemPrototype {
    private int calorias;

    public itemDulce(String nombre, String marca, int precio, int calorias) {
        super(nombre, marca, precio);
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
