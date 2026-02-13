public class DocumentoExcel implements Documento {
    @Override
    public void exportar(String datos) {
        System.out.println("SISTEMA EXCEL: Creando hojas y celdas...");
        System.out.println("Archivo generado: [reporte.xlsx] con contenido: " + datos);
    }
}