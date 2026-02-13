public class Main {
    private static GeneradorReportes generador;

    public static void main(String[] args) {
        // Simulamos la elección del usuario en la UI
        String seleccionUsuario = "PDF";
        String datosVentas = "Ventas Q1: $500,000 USD";
        String rutaArchivo = "";

        if (seleccionUsuario.equals("PDF")) {
            generador = new GeneradorPDF();
            rutaArchivo = "reporte.pdf";
        } else if (seleccionUsuario.equals("EXCEL")) {
            generador = new GeneradorExcel();
            rutaArchivo = "reporte.csv"; // Usamos CSV para simular Excel en texto plano
        }

        if (generador != null) {
            generador.iniciarProcesoExportacion(datosVentas, rutaArchivo);
        }
    }
}