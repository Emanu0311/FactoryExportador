import java.util.Scanner;

public class Main {
    private static GeneradorReportes generador;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String datosVentas = "Ventas Q1: $500,000 USD";
        String rutaArchivo = "";

        System.out.println("Seleccione el formato de reporte a exportar:");
        System.out.println("1. PDF");
        System.out.println("2. CSV");
        System.out.println("3. JSON");
        System.out.println("4. XLSX");
        System.out.print("Ingrese su opción: ");

        String seleccionUsuario = scanner.nextLine().trim().toUpperCase();

        if (seleccionUsuario.equals("1") || seleccionUsuario.equals("PDF")) {
            generador = new GeneradorPDF();
            rutaArchivo = "reporte.pdf";
        } else if (seleccionUsuario.equals("2") || seleccionUsuario.equals("CSV")) {
            generador = new GeneradorCSV();
            rutaArchivo = "reporte.csv";
        } else if (seleccionUsuario.equals("3") || seleccionUsuario.equals("JSON")) {
            generador = new GeneradorJSON();
            rutaArchivo = "reporte.json";
        } else if (seleccionUsuario.equals("4") || seleccionUsuario.equals("XLSX")) {
            generador = new GeneradorXLSX();
            rutaArchivo = "reporte.xlsx";
        } else {
            System.out.println("Opción no válida.");
            return;
        }

        if (generador != null) {
            generador.iniciarProcesoExportacion(datosVentas, rutaArchivo);
        }
        
        scanner.close();
    }
}