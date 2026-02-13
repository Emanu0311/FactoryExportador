

public class Main {
    private static GeneradorReportes generador;

    public static void main(String[] args) {
        // Simulamos la elección del usuario en la UI
        String seleccionUsuario = "PDF";
        String datosVentas = "Ventas Q1: $500,000 USD";


        if (seleccionUsuario.equals("PDF")) {
            generador = new GeneradorPDF();
        } else if (seleccionUsuario.equals("EXCEL")) {
            generador = new GeneradorExcel();
        }


        generador.iniciarProcesoExportacion(datosVentas);
    }
}