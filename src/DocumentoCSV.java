import java.io.FileWriter;
import java.io.IOException;

public class DocumentoCSV implements Documento {
    @Override
    public void exportar(String datos, String ruta) {
        System.out.println("SISTEMA CSV: Generando archivo separado por comas...");
        try (FileWriter writer = new FileWriter(ruta)) {
            writer.write("Header,Columna1,Columna2\n");
            writer.write("Data," + datos + ",0\n");
            System.out.println("Archivo generado: [" + ruta + "] con contenido: " + datos);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}