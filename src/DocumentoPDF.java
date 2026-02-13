public class DocumentoPDF implements Documento {
    @Override
    public void exportar(String datos) {
        System.out.println("SISTEMA PDF: Renderizando fuentes y tablas...");
        System.out.println("Archivo generado: [reporte.pdf] con contenido: " + datos);
    }
}