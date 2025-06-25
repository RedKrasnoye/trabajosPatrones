import java.io.FileWriter;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class archivadero {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardarDatos(HashMap <String, String> items, String nombre) {
        String jsonOutput = gson.toJson(items);
        try (FileWriter file = new FileWriter(nombre+".json")) {
            file.write(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
