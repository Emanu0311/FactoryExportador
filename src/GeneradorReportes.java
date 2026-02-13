public abstract class GeneradorReportes {

    // Este es el Factory Method
    public abstract Documento crearDocumento();

    // Lógica de negocio común a todos los reportes
    public void iniciarProcesoExportacion(String datos, String ruta) {
        System.out.println("--- Iniciando Generación de Reporte ---");

        // Llamamos al factory method para obtener el objeto
        Documento doc = crearDocumento();

        // Usamos el objeto (polimorfismo)
        doc.exportar(datos, ruta);

        System.out.println("--- Reporte finalizado con éxito ---\n");
    }
}