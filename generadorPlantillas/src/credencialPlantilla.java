import java.util.ArrayList;
import java.util.List;

public class credencialPlantilla implements Cloneable {
    public List<String> nombresLista = new ArrayList<>();
    public List<String> cargosLista = new ArrayList<>();
    public List<String> rutLista = new ArrayList<>();
    private String nombre;
    private String cargo;
    private String rut;

    public credencialPlantilla(String nombre, String cargo, String rut) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.rut = rut;
    }
    
    public void agregarNombre(String nombre) {
        nombresLista.add(nombre);
    }

    public void agregarCargo(String cargo) {
        cargosLista.add(cargo);
    }

    public void agregarRut(String rut) {
        rutLista.add(rut);
    }

    public int conseguirLargo() {
        int largo = nombresLista.size();
        return largo;
    }
    
    @Override
    public credencialPlantilla clone() throws CloneNotSupportedException {
        credencialPlantilla clonado = (credencialPlantilla) super.clone();
        clonado.nombre = this.nombre;
        clonado.cargo = this.cargo;
        clonado.rut = this.rut;
        return clonado;
    }
}
