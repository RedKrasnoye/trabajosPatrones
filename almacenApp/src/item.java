public class item implements itemPrototype {
    private String nombre;
    private String marca;
    private int precio;

    public item(String nombre, String marca, int precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    @Override
    public itemPrototype clone() {
        return new item(this.nombre, this.marca, this.precio);
    }

    @Override
    public void verCompra() {
        System.out.println("{ Nombre: "+nombre+" / Marca: "+marca+" / Precio: "+precio+" }");
        
    }
}
