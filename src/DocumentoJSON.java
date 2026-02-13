import java.io.FileWriter;
import java.io.IOException;

public class DocumentoJSON implements Documento {
    @Override
    public void exportar(String datos, String ruta) {
        System.out.println("SISTEMA JSON: Serializando datos...");
        try (FileWriter writer = new FileWriter(ruta)) {
            writer.write("{\n");
            writer.write("  \"data\": \"" + datos + "\",\n");
            writer.write("  \"status\": \"success\"\n");
            writer.write("}");
            System.out.println("Archivo generado: [" + ruta + "]");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }
}