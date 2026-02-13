import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DocumentoPDF implements Documento {
    @Override
    public void exportar(String datos, String ruta) {
        System.out.println("SISTEMA PDF: Renderizando fuentes y tablas...");

        // Escapar paréntesis y backslashes para el formato string de PDF
        String datosSeguros = datos.replace("\\", "\\\\").replace("(", "\\(").replace(")", "\\)");

        // Contenido del PDF (Comandos de texto)
        String content = "BT /F1 24 Tf 50 700 Td (" + datosSeguros + ") Tj ET";
        
        // Usamos StringBuilder para construir el archivo PDF byte a byte (asumiendo ISO-8859-1)
        StringBuilder sb = new StringBuilder();

        // Header
        sb.append("%PDF-1.4\n");

        // Object 1: Catalog
        long offset1 = sb.length();
        sb.append("1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n");

        // Object 2: Pages
        long offset2 = sb.length();
        sb.append("2 0 obj\n<< /Type /Pages /Kids [3 0 R] /Count 1 >>\nendobj\n");

        // Object 3: Page
        long offset3 = sb.length();
        sb.append("3 0 obj\n<< /Type /Page /Parent 2 0 R /Resources << /Font << /F1 << /Type /Font /Subtype /Type1 /BaseFont /Helvetica >> >> >> /MediaBox [0 0 595 842] /Contents 4 0 R >>\nendobj\n");

        // Object 4: Content Stream
        long offset4 = sb.length();
        sb.append("4 0 obj\n<< /Length " + content.length() + " >>\nstream\n");
        sb.append(content);
        sb.append("\nendstream\nendobj\n");

        // Xref Table
        long xrefOffset = sb.length();
        sb.append("xref\n");
        sb.append("0 5\n");
        sb.append("0000000000 65535 f \n");
        sb.append(String.format("%010d 00000 n \n", offset1));
        sb.append(String.format("%010d 00000 n \n", offset2));
        sb.append(String.format("%010d 00000 n \n", offset3));
        sb.append(String.format("%010d 00000 n \n", offset4));

        // Trailer
        sb.append("trailer\n<< /Size 5 /Root 1 0 R >>\n");
        sb.append("startxref\n");
        sb.append(xrefOffset + "\n");
        sb.append("%%EOF");

        try (FileOutputStream fos = new FileOutputStream(ruta)) {
            fos.write(sb.toString().getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Archivo generado: [" + ruta + "] con contenido: " + datos);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo PDF: " + e.getMessage());
        }
    }
}