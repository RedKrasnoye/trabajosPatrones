public final class configuracionEvento {
    private static configuracionEvento instancia;
    public String nombreEvento = "No asignado";
    public String horasEvento = "0";
    public String idiomaEvento = "Sin idioma";

    private configuracionEvento() {

    }
    
    public static configuracionEvento getInstancia() {
        if (instancia == null) {
            instancia = new configuracionEvento();
        }
        return instancia;
    }

    public void cambiarEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void cambiarHora(String horasEvento) {
        this.horasEvento = horasEvento;
    }

    public void cambiarIdioma(String idiomaEvento) {
        this.idiomaEvento = idiomaEvento;
    }

    public void mostrarInfo() {
        System.out.println("Nombre de evento: "+nombreEvento);
        System.out.println("Horas de evento: "+horasEvento);
        System.out.println("Idioma de evento: "+idiomaEvento);
    }
    
}
