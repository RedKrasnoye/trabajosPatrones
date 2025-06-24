public abstract class itemPrototype implements Cloneable {
    private String nombre;
    private String marca;
    private int precio;

    public itemPrototype(String nombre, String marca, int precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public itemPrototype clone() {
        try {
            return (itemPrototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();;
        }
        return null;
    }
}
